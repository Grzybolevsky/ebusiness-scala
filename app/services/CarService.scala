package services

import models.Car
import repository.CarRepository
import repository.dto.CarDbItem

import javax.inject.{Inject, Singleton}

@Singleton
class CarService @Inject()(val repository: CarRepository,
                           val carModelService: CarModelService)
  extends BaseService[
    Car,
    CarDbItem
  ](repository) {

  override def toDomain(dbItem: CarDbItem): Car =
    Car(id = dbItem.id,
      carModel = carModelService.find(dbItem.carModelId).orNull,
      year = dbItem.year,
      mileage = dbItem.mileage,
      horsePower = dbItem.horsePower)
}
