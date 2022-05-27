package models

import java.time.LocalDate

case class CarSellOffer(
                         id: Int,
                         car: Car,
                         date: LocalDate,
                         price: BigDecimal
                       ) extends ApiModel
