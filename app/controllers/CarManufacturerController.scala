package controllers

import play.api.mvc.ControllerComponents
import repository.CarManufacturerRepository
import repository.dto.CarManufacturerDbItem

import javax.inject.{Inject, Singleton}

@Singleton
class CarManufacturerController @Inject()(val controllerComponents: ControllerComponents,
                                          val carManufacturerService: CarManufacturerRepository)
  extends CrudController[CarManufacturerDbItem] {

}
