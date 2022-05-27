package controllers

import play.api.mvc.{BaseController, ControllerComponents}
import repository.CarSellOfferRepository

import javax.inject.{Inject, Singleton}

@Singleton
class CarSellOfferController @Inject()(val controllerComponents: ControllerComponents,
                                       val carSellOfferService: CarSellOfferRepository)
  extends BaseController {

}
