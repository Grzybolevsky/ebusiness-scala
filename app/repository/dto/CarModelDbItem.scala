package repository.dto

import play.api.libs.json.{Json, OFormat, Reads, Writes}

object ModelType extends Enumeration {
  type Type = Value
  val Sedan, Hatchback, Wagon, Coupe, SUV = Value

  implicit val myEnumReads = Reads.enumNameReads(ModelType)
  implicit val myEnumWrites = Writes.enumNameWrites
}

import ModelType._

case class CarModelDbItem(
                     id: Int,
                     manufacturerId: Int,
                     name: String,
                     modelType: Type
                   ) extends DbItem

object CarModelDbItem {
  implicit val fmt: OFormat[CarModelDbItem] = Json.format[CarModelDbItem]
}