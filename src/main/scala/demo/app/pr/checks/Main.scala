package demo.app.pr.checks

import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.stream.ActorMaterializer
import com.typesafe.config.{Config, ConfigFactory}
import demo.app.pr.checks.server.Api

import scala.concurrent.ExecutionContext

object Main extends App {
  val config: Config = ConfigFactory.load
  implicit val actorSystem: ActorSystem = ActorSystem("api", config)
  implicit val materializer: ActorMaterializer = ActorMaterializer()
  implicit val executionContext: ExecutionContext = actorSystem.dispatcher

  val restPaths = new Api()
  val interface = "0.0.0.0"
  val serverPort = 80
  println(s"Starting HTTP server at $interface:$serverPort")
  val bindingFuture = Http()
    .newServerAt(interface, serverPort)
    .bindFlow(restPaths.routes)
  sys.addShutdownHook {
    bindingFuture
      .flatMap(_.unbind())
      .onComplete(_ => actorSystem.terminate())
  }
}
