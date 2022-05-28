package repository.dto

import play.api.libs.json.{Json, OFormat}

case class CarManufacturerDbItem(
                                  id: Int,
                                  name: String
                                ) extends DbItem

object CarManufacturerDbItem {
  implicit val fmt: OFormat[CarManufacturerDbItem] = Json.format[CarManufacturerDbItem]
}