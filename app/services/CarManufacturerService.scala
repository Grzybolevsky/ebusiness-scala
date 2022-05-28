package services

import models.CarManufacturer
import repository.CarManufacturerRepository
import repository.dto.CarManufacturerDbItem

import javax.inject.{Inject, Singleton}

@Singleton
class CarManufacturerService @Inject()(repository: CarManufacturerRepository)
  extends BaseService[
    CarManufacturer,
    CarManufacturerDbItem
  ](repository) {

  override protected def toDomain(dbItem: CarManufacturerDbItem): CarManufacturer =
    CarManufacturer(dbItem.id, dbItem.name)
}
