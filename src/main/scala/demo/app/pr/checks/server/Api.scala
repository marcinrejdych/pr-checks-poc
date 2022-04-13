package demo.app.pr.checks.server

import akka.actor.ActorSystem
import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport
import akka.http.scaladsl.model.StatusCodes
import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.server._

import scala.concurrent.ExecutionContext

class Api()(implicit actorSystem: ActorSystem, ec: ExecutionContext)
    extends SprayJsonSupport {
  val routes: Route =
    pathPrefix("users" / JavaUUID) { userId =>
      pathPrefix("path1") {
        path("path2") {
          // GET /users/{id}/path1/path2
          get {
            val msg = s"abcdefgh"
            println(msg)
            complete(StatusCodes.OK, msg)
          }
        }
      }
    }
}
