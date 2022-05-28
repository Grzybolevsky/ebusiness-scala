package controllers

import models.CarManufacturer
import play.api.libs.json.{JsArray, Json}
import play.api.mvc.{Action, AnyContent, ControllerComponents, Request}
import repository.dto.CarManufacturerDbItem
import services.CarManufacturerService

import javax.inject.{Inject, Singleton}

@Singleton
class CarManufacturerController @Inject()(val controllerComponents: ControllerComponents,
                                          val service: CarManufacturerService)
  extends CrudController[CarManufacturer, CarManufacturerDbItem](service) {
  override def add(): Action[AnyContent] = Action(implicit request =>
    if (service.add(extractBody(request))) Created else BadRequest("Cannot create"))

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
    if (service.update(extractBody(request))) Ok("Updated") else BadRequest("Cannot update"))

  private def extractBody(request: Request[AnyContent]): CarManufacturerDbItem = request.body.asJson.map(json => {
    CarManufacturerDbItem((json \ "id").as[Int],
      (json \ "name").as[String]
    )
  }).get
}
