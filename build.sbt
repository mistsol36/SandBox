lazy val root = (project in file(".")).
  settings(
    name := "hello-scala",
    version := "1.0",
    scalaVersion := "2.11.5",
    libraryDependencies ++= Seq(
      "org.scalatest" %% "scalatest" % "2.2.4" % "test",
      "net.databinder.dispatch" %% "dispatch-core" % "0.11.2",
      "org.slf4j" % "slf4j-simple" % "1.6.4",
      "org.specs2" %% "specs2-core" % "2.4.17" % "test",
      "org.json4s" %% "json4s-native" % "3.2.11",
      "com.typesafe.slick" % "slick_2.10" % "3.0.0",
      "org.xerial" % "sqlite-jdbc" % "3.7.2"
    )
  )