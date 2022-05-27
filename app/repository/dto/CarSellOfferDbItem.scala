package repository.dto

import java.time.LocalDate

case class CarSellOfferDbItem(
                         id: Int,
                         carId: Int,
                         date: LocalDate,
                         price: BigDecimal
                       ) extends DbItem
