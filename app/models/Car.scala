package models

import repository.dto.CarDbItem

case class Car(
                id: Int,
                carModel: CarModel,
                year: Int,
                mileage: Int,
                horsePower: Int
              ) extends ApiModel[CarDbItem] {
  override def toDbItem: CarDbItem = CarDbItem(id = id,
    carModelId = carModel.id,
    year = year,
    mileage = mileage,
    horsePower = horsePower)
}