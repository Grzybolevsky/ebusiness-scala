package controllers

import models.CarSellOffer
import play.api.libs.json.{JsArray, Json}
import play.api.mvc.{Action, AnyContent, ControllerComponents, Request}
import repository.dto.CarSellOfferDbItem
import services.CarSellOfferService

import java.time.LocalDate
import javax.inject.{Inject, Singleton}

@Singleton
class CarSellOfferController @Inject()(val controllerComponents: ControllerComponents,
                                       val service: CarSellOfferService)
  extends CrudController[CarSellOffer, CarSellOfferDbItem](service) {

  override def add(): Action[AnyContent] = Action(implicit request =>
    if (service.add(extractBody(request))) Created else BadRequest("Cannot create"))

  private def extractBody(request: Request[AnyContent]): CarSellOfferDbItem = request.body.asJson.map(json => {
    CarSellOfferDbItem((json \ "id").as[Int],
      (json \ "carId").as[Int],
      (json \ "").as[LocalDate],
      (json \ "").as[BigDecimal]
    )
  }).get

  override def showAll(): Action[AnyContent] = Action(implicit request => {
    Ok(service.findAll()
      .map(x => Json.toJson(x))
      .foldLeft(JsArray())({ case (acc, json) => acc :+ json }))
  })

  override def showById(id: Int): Action[AnyContent] = Action(implicit request => {
    Ok(service.find(id)
      .map(x => Json.toJson(x))
      .orNull)
  })

  override def update(): Action[AnyContent] = Action(implicit request =>
    if (service.update(extractBody(request))) Ok else BadRequest("Cannot update"))
}
