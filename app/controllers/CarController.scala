package controllers

import models.Car
import play.api.libs.json._
import play.api.mvc._
import repository.dto.CarDbItem
import services.CarService

import javax.inject.{Inject, Singleton}


@Singleton
class CarController @Inject()(val controllerComponents: ControllerComponents,
                              val service: CarService)
  extends CrudController[Car, CarDbItem](service) {

  override def add(): Action[AnyContent] = Action(implicit request =>
    if (service.add(extractBody(request))) Created else BadRequest("Cannot create"))

  override def showAll(): Action[AnyContent] = Action(implicit request => {
    Ok(service.findAll()
      .map(x => Json.toJson(x))
      .foldLeft(JsArray())({ case (acc, json) => acc :+ json }))
  })

  override def showById(id: Int): Action[AnyContent] = Action(implicit request =>
    Ok(service.find(id).map(x => Json.toJson(x)).orNull))

  override def update(): Action[AnyContent] = Action(implicit request =>
    if (service.update(extractBody(request))) Ok("Updated") else BadRequest("Cannot update"))

  private def extractBody(request: Request[AnyContent]): CarDbItem = request.body.asJson.map(json => {
    CarDbItem((json \ "id").as[Int],
      (json \ "carModelId").as[Int],
      (json \ "year").as[Int],
      (json \ "mileage").as[Int],
      (json \ "horsePower").as[Int]
    )
  }).get
}
