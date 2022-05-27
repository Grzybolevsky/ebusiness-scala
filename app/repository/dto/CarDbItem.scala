package repository.dto

import play.api.libs.json.{Json, OFormat}

case class CarDbItem(
                id: Int,
                carModelId: Int,
                year: Int,
                mileage: Int,
                horsePower: Int
              ) extends DbItem

object CarDbItem {
  implicit val fmt: OFormat[CarDbItem] = Json.format[CarDbItem]
}