val akkaHttpVersion = "10.2.6"
val akkaVersion = "2.6.16"

ThisBuild / name := "demo_app"
scalaVersion := "2.13.4"
libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-slf4j" % akkaVersion,
  "com.typesafe.akka" %% "akka-http" % akkaHttpVersion,
  "com.typesafe.akka" %% "akka-http-spray-json" % akkaHttpVersion,
  "com.typesafe.akka" %% "akka-stream" % akkaVersion
)
