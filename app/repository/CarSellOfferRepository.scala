package repository

import repository.dto.CarSellOfferDbItem

import java.time.LocalDate
import javax.inject.Singleton

@Singleton
class CarSellOfferRepository extends CrudRepository[CarSellOfferDbItem] {
  var db_collection: List[CarSellOfferDbItem] = List(
    CarSellOfferDbItem(1, 1, LocalDate.of(2020, 11, 10), BigDecimal(100)),
    CarSellOfferDbItem(2, 2, LocalDate.of(2022, 7, 6), BigDecimal(800))
  )
}
