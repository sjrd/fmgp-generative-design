package app.fmgp.experiments

import akka.actor.{Actor, ActorSystem, Props}
import akka.http.scaladsl.Http
import akka.http.scaladsl.model.StatusCodes
import akka.http.scaladsl.model.ws.{BinaryMessage, Message, TextMessage, WebSocketRequest}
import akka.http.scaladsl.server.Directives.{path, _}
import akka.stream.scaladsl.GraphDSL.Implicits._
import akka.stream.scaladsl.{Flow, GraphDSL, Keep, Sink, Source}
import akka.stream.{Materializer, FlowShape, OverflowStrategy}
import akka.{Done, NotUsed}

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.{Future, Await}
import scala.concurrent.duration._
import scala.util.{Failure, Success}
import scala.io._

object Main extends com.typesafe.scalalogging.LazyLogging {

  given actorSystem: ActorSystem = ActorSystem(
    "akka-system",
    config = None,
    classLoader = Some(this.getClass.getClassLoader),
    defaultExecutionContext = None
  )

  var server: Option[LocalAkkaServer] = None
  def myAkkaServer: LocalAkkaServer = server.get

  def start(interface: String, port: Int) = {
    if (server.isEmpty) {
      //FIXME server = Some(app.fmgp.MyAkkaServer(interface = interface, port = port))
      server = Some(new LocalAkkaServer)
      server.map(_.start)
      logger.info("Main starting")
    } else {
      logger.info("Main is alredy started")
    }
  }

  def stop = {
    //import actorSystem.dispatcher
    logger.info("Main stoping")
    server.map { s =>
      val a = Await.result(s.stop, 10.seconds)
      logger.info(a.toString())
    }
    val b = Await.result(actorSystem.terminate(), 10.seconds)
    logger.info(b.toString())
    logger.info("Main in now STOP")
  }

  def main(args: Array[String]): Unit = {
    start(interface = "127.0.0.1", port = 8888)
    StdIn.readLine()
    stop
  }

}
