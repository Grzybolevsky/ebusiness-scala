package models

import play.api.libs.json.{Json, OFormat}
import repository.dto.CarManufacturerDbItem

case class CarManufacturer(
                            id: Int,
                            name: String
                          ) extends ApiModel[CarManufacturerDbItem] {
  override def toDbItem: CarManufacturerDbItem = CarManufacturerDbItem(id, name)
}

object CarManufacturer {
  implicit val fmt: OFormat[CarManufacturer] = Json.format[CarManufacturer]
}