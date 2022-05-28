package models

import play.api.libs.json.{Json, OFormat}
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

object Car {
  implicit val fmt: OFormat[Car] = Json.format[Car]
}