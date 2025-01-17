# fmgp-generative-design

Is a Scala/ScalaJS library for Generative Design.
The visualizer run on any Browser with JS.
Scala's RELP can be used to interact with the visualizer via WS to develop your designs.

The project is also a ScalaJs facade for [threejs](https://threejs.org/)

[![Build Status](https://travis-ci.com/FabioPinheiro/fmgp-threejs.svg?branch=master)](https://travis-ci.com/FabioPinheiro/fmgp-threejs)

## Doc & Demo

[README](https://fabiopinheiro.github.io/fmgp-generative-design/)

[Live Demo](docs/index.html)

## Use

If you want to try I recommend to checkout this repository and run it yourself with SBT.

In the future I will publish the Scala3 version and with a lot more stuff!

The old version in publish on:
https://repo1.maven.org/maven2/app/fmgp/scala-threejs_sjs1.0-RC2_2.13/

```scala
libraryDependencies += "app.fmgp" % "fmgp-threejs_2.13" % "0.1-M1"
```

## Run via sbt

```scala
fastOptJS::webpack

controller/console

> :load script.sc
```

Open `file:///.../modules/02-core/index-dev.html` on your browser.

## TODO LIST / Roadmap / Ideas

- Threejs:
  - Draft initial support for light[16h]
  - Draft initial support for materials [1w]
- Interface improvements:
  - Support for scene resizing[8h]
    - [Example from webglfundamentals](https://webglfundamentals.org/webgl/lessons/webgl-resizing-the-canvas.html)
  - Write Interface with our API [?d]
  - Make interface with 3D obj (could be used for mobile and be very useful for VR)
- Publish version 0.1 to Maven
  - Fix build.sbt for publish [16h]
  - Make documentation [2w]
  - Cleanup code
  - Rename Github repository, project name in Maven and modelos in SBT
    - Chaos theory; Butterfly effect; FMGP; Scala; Geometry
  - Make a Docker Container with everything ready to use.
    - Serve the FE's javascript file via HTTP from the BE. [4h]
    - Draft DocketFile [16h]
    - https://www.acervera.com/blog/2020/04/sbt-docker-buildx-multi-arch/
- Draft support for real-time collaborative work on algorithmic design.
  - The system has 3 Components:
    - FE - A browser here the models is viewed. Most of the mesh of the models are generated on the FE!
    - BE - Server that is connected with the FE via websocket and receive commands from a client.
    - Client - Simple API / lib where algorithmic design are specified on the scala RELP or Worksheet. Connects with the BE server
- HList for Coordinate (use shapeless or wait for dotty?)
  - Implemente a Coordinate system with a HList (Heterogeneous lists).
    I imagine HList having really nice properties to support an arbitrary number of dimensions.
    Implement specialized support for 2D and 3D. In top of HList.
- Try to integrate with KHEPRI again
- Support for Constructive Geometry - union; intersection; subtraction (This is not supported on threejs)
  - Constructive Solid Geometry - basic implementation (with Quadtrees)
    Have a look and get inspiration from:
    https://github.com/dzufferey/scadla
    https://github.com/dzufferey/scadla-oce-backend
    https://stemkoski.github.io/Three.js/CSG.html
    https://github.com/stemkoski/stemkoski.github.com/blob/master/Three.js/CSG.html
    https://github.com/chandlerprall/ThreeCSplatformG

### TODO list that Probably never will happen

- Algorithmic design examples
  - Bamboo house
  - Transformer house - Single room multi configurations
- Experiments:
  - Input controller: GamePad; VR; Ray Tracing Pixel-select
  - 3 Dimensional Vector graphics
  - Game idia: make an empty city or a shopping mall.
    Give each team of players a place to remodel.
    Would be like an Architecture (algorithmic design) hackathon.
  - Game idia:
    - Make a 3d maze, where you can only choose between left and right paths and control the velocity.
    - Then make a 3d sandbox with weird gravity.
  - Use Node.js as the JavaScript runtime system. (We can try also the [Electron](https://www.electronjs.org/)
  - Compile code on the backend as a module and dynamically load it on the FE.
  - Try WebGPU and try to implemente some machine learning algorithms!
  - FPV Drone Simulator! How hard can it be?
- Optimizations: 
  - Experiment with webgl shaders for optimizations.
    - Learn [WebGL Shaders](
      https://developer.mozilla.org/en-US/docs/Web/API/WebGL_API/Tutorial/Getting_started_with_WebGL)

## Copyright and License

This project is licensed under the MIT license, available at
[http://opensource.org/licenses/mit-license.php](http://opensource.org/licenses/mit-license.php)
and also in the [LICENSE](LICENSE) file.

Copyright the Fabio Pinheiro, 2021.

[cats-badge]: https://typelevel.org/cats/img/cats-badge-tiny.png
[cats-infographic]: https://github.com/tpolecat/cats-infographic
[underscore-scala-book]: https://underscore.io/books/advanced-scala
[sbt]: http://scala-sbt.org
[shapeless]: https://github.com/milessabin/shapeless
