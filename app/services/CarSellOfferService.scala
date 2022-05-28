package services

import models.CarSellOffer
import repository.CarSellOfferRepository
import repository.dto.CarSellOfferDbItem

import javax.inject.{Inject, Singleton}

@Singleton
class CarSellOfferService @Inject()(repository: CarSellOfferRepository,
                                    carService: CarService)
  extends BaseService[
    CarSellOffer,
    CarSellOfferDbItem
  ](repository) {

  protected def toDomain(dbItem: CarSellOfferDbItem): CarSellOffer =
    CarSellOffer(dbItem.id,
      carService.find(dbItem.carId).orNull,
      dbItem.date,
      dbItem.price)
}
