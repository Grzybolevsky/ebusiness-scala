package models

import play.api.libs.json.{Json, OFormat}
import repository.dto.CarSellOfferDbItem

import java.time.LocalDate

case class CarSellOffer(
                         id: Int,
                         car: Car,
                         date: LocalDate,
                         price: BigDecimal
                       ) extends ApiModel[CarSellOfferDbItem] {
  override def toDbItem: CarSellOfferDbItem = CarSellOfferDbItem(id, car.id, date, price)
}

object CarSellOffer {
  implicit val fmt: OFormat[CarSellOffer] = Json.format[CarSellOffer]
}