enablePlugins(JavaServerAppPackaging)
enablePlugins(DockerPlugin)

name := "demo_app"
scalaVersion := "2.13.4"

val akkaHttpVersion = "10.2.9"
val akkaVersion = "2.6.19"

libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-slf4j" % akkaVersion,
  "com.typesafe.akka" %% "akka-http" % akkaHttpVersion,
  "com.typesafe.akka" %% "akka-http-spray-json" % akkaHttpVersion,
  "com.typesafe.akka" %% "akka-stream" % akkaVersion
)

dependencyCheckFailBuildOnCVSS := 3
