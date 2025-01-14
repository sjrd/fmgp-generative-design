package app.fmgp.geo

import typings.three.loaderMod.Loader
import typings.three.mod.{Shape => _, _}
import typings.three.anon.{X => AnonX}
import typings.three.webGLRendererMod.WebGLRendererParameters
import typings.statsJs.mod.{^ => Stats}
import app.fmgp.threejs.extras.{FirstPersonControls, FlyControls, OrbitControls}
import app.fmgp.Websocket

import app.fmgp.Log

object WebGLGlobal {
  val masterWorld = DynamicWorldWarp()
  var websocket = Websocket.AutoReconnect("ws://127.0.0.1:8888/browser", Log, masterWorld)
  val debugUI = false
  var scene: Scene = _
  var sceneUI: Scene = _
  var animateFrameId: Option[Int] = None
  var modelToAnimate: () => Option[Object3D] = () => None
  var camera: Option[Camera] = None
  var cameraUI: Option[Camera] = None
  var controls: Option[FlyControls] = None
  var stats: Stats = new Stats()

  stats.showPanel(0); // 0: fps, 1: ms, 2: mb, 3+: custom
  stats.dom.style.right = "0px"
  stats.dom.style.left = null
  org.scalajs.dom.document.body.appendChild(stats.dom) //FIXME Not the best place ...

  val uiElements: scala.collection.mutable.HashMap[Int, InteractiveMesh] = scala.collection.mutable.HashMap.empty
  def addUiElement(o: InteractiveMesh) = {
    uiElements.put(o.id.toInt, o)
    sceneUI.add(o.mesh); if (debugUI) scene.add(o.mesh.clone(true))
  }

  val raycaster = new Raycaster()
  var uiEvent: Option[AnonX] = None

  // Text
  var textFont: typings.three.fontMod.Font = _
  val loader = new FontLoader()
  def init = Log.info(s"### Global.init ###")
  loader.load(
    "https://raw.githubusercontent.com/mrdoob/three.js/dev/examples/fonts/gentilis_regular.typeface.json", //"fonts/helvetiker_bold.typeface.json",
    (f: typings.three.fontMod.Font) => textFont = f
  )

}
