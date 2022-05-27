package controllers

import play.api.mvc.{BaseController, ControllerComponents}
import repository.CarModelRepository

import javax.inject.{Inject, Singleton}

@Singleton
class CarModelController @Inject()(val controllerComponents: ControllerComponents,
                                   val carModelService: CarModelRepository)
  extends BaseController {

}
