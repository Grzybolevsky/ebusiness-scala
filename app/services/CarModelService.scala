package services


import models.CarModel
import repository.CarModelRepository
import repository.dto.CarModelDbItem

import javax.inject.{Inject, Singleton}

@Singleton
class CarModelService @Inject()(val repository: CarModelRepository,
                                val carManufacturerService: CarManufacturerService)
  extends BaseService[
    CarModel,
    CarModelDbItem
  ](repository) {

  override protected def toDomain(dbItem: CarModelDbItem): CarModel =
    CarModel(dbItem.id,
      carManufacturerService.find(dbItem.manufacturerId).orNull,
      dbItem.name,
      dbItem.modelType)
}
