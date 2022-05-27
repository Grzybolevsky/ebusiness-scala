package models

import play.api.libs.json.{Json, OFormat}

case class Car(
                id: Int,
                carModel: CarModel,
                year: Int,
                mileage: Int,
                horsePower: Int
              ) extends ApiModel

object Car {
  implicit val fmt: OFormat[Car] = Json.format[Car]
}