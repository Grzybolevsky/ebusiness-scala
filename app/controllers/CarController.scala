package controllers

import models.{Car, CarManufacturer}
import play.api.libs.json._
import play.api.mvc._
import repository.dto.CarDbItem
import services.CarService

import javax.inject.{Inject, Singleton}


@Singleton
class CarController @Inject()(val controllerComponents: ControllerComponents,
                              val service: CarService)
  extends CrudController[Car, CarDbItem](service) {
  override def add(): Action[AnyContent] = ???

  override def update(): Action[AnyContent] = ???

}
