package repository.dto

import models.ModelType.Type
import play.api.libs.json.{Json, OFormat}

case class CarModelDbItem(
                           id: Int,
                           manufacturerId: Int,
                           name: String,
                           modelType: Type
                         ) extends DbItem

object CarModelDbItem {
  implicit val fmt: OFormat[CarModelDbItem] = Json.format[CarModelDbItem]
}