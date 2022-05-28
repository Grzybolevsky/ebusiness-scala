package controllers

import models.CarModel
import play.api.libs.json.{Json, OFormat}
import play.api.mvc.{Action, AnyContent, ControllerComponents}
import repository.dto.CarModelDbItem
import services.CarModelService

import javax.inject.{Inject, Singleton}

@Singleton
class CarModelController @Inject()(val controllerComponents: ControllerComponents,
                                   val service: CarModelService)
  extends CrudController[CarModel, CarModelDbItem](service) {
  override def add(): Action[AnyContent] = ???

  override def update(): Action[AnyContent] = ???

}
