package controllers

import models.{CarModel, ModelType}
import play.api.libs.json.{JsArray, Json}
import play.api.mvc.{Action, AnyContent, ControllerComponents, Request}
import repository.dto.CarModelDbItem
import services.CarModelService

import javax.inject.{Inject, Singleton}

@Singleton
class CarModelController @Inject()(val controllerComponents: ControllerComponents,
                                   val service: CarModelService)
  extends CrudController[CarModel, CarModelDbItem](service) {
  override def add(): Action[AnyContent] = Action { implicit request =>
    if (service.add(extractBody(request))) Created else BadRequest("Cannot create")
  }

  private def extractBody(request: Request[AnyContent]): CarModelDbItem = request.body.asJson.map(json => {
    CarModelDbItem((json \ "id").as[Int],
      (json \ "manufacturerId").as[Int],
      (json \ "name").as[String],
      (json \ "modelType").as[ModelType.Type]
    )
  }).get

  override def showAll(): Action[AnyContent] = Action { implicit request =>
    Ok(service.findAll()
      .map(x => Json.toJson(x))
      .foldLeft(JsArray())({ case (acc, json) => acc :+ json }))
  }

  override def showById(id: Int): Action[AnyContent] = Action { implicit request =>
    Ok(service.find(id)
      .map(x => Json.toJson(x))
      .orNull)
  }

  override def update(): Action[AnyContent] = Action { implicit request =>
    if (service.update(extractBody(request))) Ok("Updated") else BadRequest("Cannot update")
  }
}
