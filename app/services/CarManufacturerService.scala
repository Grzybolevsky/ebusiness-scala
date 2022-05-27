package services

import models.CarManufacturer
import repository.CarManufacturerRepository

import javax.inject.{Inject, Singleton}

@Singleton
class CarManufacturerService @Inject()
  (manufacturerRepository: CarManufacturerRepository)
  extends BaseService[CarManufacturer] {
  
}
