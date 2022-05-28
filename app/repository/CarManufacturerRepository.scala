package repository

import repository.dto.CarManufacturerDbItem

import javax.inject.Singleton

@Singleton
class CarManufacturerRepository
  extends CrudRepository[CarManufacturerDbItem] {

  var db_collection: List[CarManufacturerDbItem] = List(
    CarManufacturerDbItem(1, "Mercedes"),
    CarManufacturerDbItem(2, "BMW"),
    CarManufacturerDbItem(3, "Opel")
  )
}
