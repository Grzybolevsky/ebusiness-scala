package repository

import repository.dto.CarDbItem

import javax.inject.Singleton

@Singleton
class CarRepository
  extends CrudRepository[CarDbItem] {
  protected var db_collection: List[CarDbItem] = List(
    CarDbItem(1, 1, 2020, 50_000, 370),
    CarDbItem(2, 2, 2008, 250_000, 110),
    CarDbItem(3, 3, 2020, 180_000, 330),
    CarDbItem(4, 4, 2022, 30_000, 650),
    CarDbItem(5, 5, 2002, 200_000, 150),
    CarDbItem(6, 6, 2000, 350_000, 75)
  )
}
