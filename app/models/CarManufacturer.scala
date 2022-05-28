package models

import repository.dto.CarManufacturerDbItem

case class CarManufacturer(
                            id: Int,
                            name: String
                          ) extends ApiModel[CarManufacturerDbItem] {
  override def toDbItem: CarManufacturerDbItem = CarManufacturerDbItem(id, name)
}
