package repository

import repository.dto.CarModelDbItem
import repository.dto.ModelType._

import javax.inject.Singleton

@Singleton
class CarModelRepository extends CrudRepository[CarModelDbItem] {
  var db_collection: List[CarModelDbItem] = List(
    dto.CarModelDbItem(1, 1, "A-class", Sedan),
    dto.CarModelDbItem(2, 1, "A-class", Hatchback),
    dto.CarModelDbItem(3, 2, "Series 7", Sedan),
    dto.CarModelDbItem(4, 2, "X5", SUV),
    dto.CarModelDbItem(5, 3, "Astra", Coupe),
    dto.CarModelDbItem(6, 3, "Astra", Wagon)
  )
}
