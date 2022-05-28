package controllers

import models.CarSellOffer
import play.api.mvc.{Action, AnyContent, ControllerComponents}
import repository.dto.CarSellOfferDbItem
import services.CarSellOfferService

import javax.inject.{Inject, Singleton}

@Singleton
class CarSellOfferController @Inject()(val controllerComponents: ControllerComponents,
                                       val service: CarSellOfferService)
  extends CrudController[CarSellOffer, CarSellOfferDbItem](service) {
  override def add(): Action[AnyContent] = ???

  override def update(): Action[AnyContent] = ???

}
