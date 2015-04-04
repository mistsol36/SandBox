name := "hello-scala"

version := "1.0"

scalaVersion := "2.11.5"

libraryDependencies += "org.scalatest" %% "scalatest" % "2.2.4" % "test"

libraryDependencies ++= Seq(
  "net.databinder.dispatch" %% "dispatch-core" % "0.11.0",
  "org.scalatest" %% "scalatest" % "2.0" % "test"
)

libraryDependencies += "org.slf4j" % "slf4j-simple" % "1.6.4"