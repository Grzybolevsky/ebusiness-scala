package models

import play.api.libs.json.{Json, OFormat, Reads, Writes}
import repository.dto.CarModelDbItem

object ModelType extends Enumeration {
  type Type = Value
  val Sedan, Hatchback, Wagon, Coupe, SUV = Value

  implicit val myEnumReads = Reads.enumNameReads(ModelType)
  implicit val myEnumWrites = Writes.enumNameWrites
}

import models.ModelType._

case class CarModel(
                     id: Int,
                     manufacturer: CarManufacturer,
                     name: String,
                     modelType: Type
                   ) extends ApiModel[CarModelDbItem] {
  override def toDbItem: CarModelDbItem = CarModelDbItem(id = id,
    manufacturerId = manufacturer.id,
    name = name,
    modelType = modelType)
}

object CarModel {
  implicit val fmt: OFormat[CarModel] = Json.format[CarModel]
}