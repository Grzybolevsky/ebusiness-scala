package models

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
