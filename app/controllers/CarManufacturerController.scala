package controllers

import models.{Car, CarManufacturer}
import play.api.libs.json.{Json, OFormat}
import play.api.mvc.{Action, AnyContent, ControllerComponents}
import repository.dto.CarManufacturerDbItem
import services.CarManufacturerService

import javax.inject.{Inject, Singleton}

@Singleton
class CarManufacturerController @Inject()(val controllerComponents: ControllerComponents,
                                          val service: CarManufacturerService)
  extends CrudController[CarManufacturer, CarManufacturerDbItem](service) {
  override def add(): Action[AnyContent] = ???

  override def update(): Action[AnyContent] = ???

}
