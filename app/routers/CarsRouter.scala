package routers

import controllers.CarController
import io.lemonlabs.uri.typesafe.dsl.pathPartToUrlDsl
import play.api.routing.Router.Routes
import play.api.routing.SimpleRouter
import play.api.routing.sird._

import javax.inject.Inject

class CarsRouter @Inject()(controller: CarController) extends SimpleRouter {
  val prefix = "/cars"

  def link(id: Int): String = {
    val url = prefix / id.toString
    url.toString()
  }

  override def routes: Routes = {
    case POST(p"/") =>
      controller.add()

    case GET(p"/") =>
      controller.showAll()

    case GET(p"/$id") =>
      controller.showById(id.toInt)

    case PUT(p"/") =>
      controller.update()

    case DELETE(p"/$id") =>
      controller.delete(id.toInt)
  }
}
