package models

import play.api.libs.json.{Json, OFormat}

case class CarManufacturer(
                            id: Int,
                            name: String
                          ) extends ApiModel

object CarManufacturer {
  implicit val fmt: OFormat[CarManufacturer] = Json.format[CarManufacturer]
}