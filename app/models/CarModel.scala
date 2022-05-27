package models

import play.api.libs.json.{Json, OFormat, Reads, Writes}

object ModelType extends Enumeration {
  type Type = Value
  val Sedan, Hatchback, Wagon, Coupe, SUV = Value

  implicit val myEnumReads = Reads.enumNameReads(ModelType)
  implicit val myEnumWrites = Writes.enumNameWrites
}

import ModelType._

case class CarModel(
                     id: Int,
                     manufacturer: CarManufacturer,
                     name: String,
                     modelType: Type
                   ) extends ApiModel

object CarModel {
  implicit val fmt: OFormat[CarModel] = Json.format[CarModel]
}