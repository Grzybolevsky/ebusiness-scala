package routers

import controllers.CarSellOfferController
import io.lemonlabs.uri.typesafe.dsl.pathPartToUrlDsl
import play.api.routing.Router.Routes
import play.api.routing.SimpleRouter
import play.api.routing.sird._

import javax.inject.Inject

class OffersRouter @Inject()(controller: CarSellOfferController) extends SimpleRouter {
  val prefix = "/offers"

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
