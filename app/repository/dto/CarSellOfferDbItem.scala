package repository.dto

import play.api.libs.json.{Json, OFormat}

import java.time.LocalDate

case class CarSellOfferDbItem(
                               id: Int,
                               carId: Int,
                               date: LocalDate,
                               price: BigDecimal
                             ) extends DbItem

object CarSellOfferDbItem {
  implicit val fmt: OFormat[CarSellOfferDbItem] = Json.format[CarSellOfferDbItem]
}