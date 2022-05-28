package controllers

import models.ApiModel
import play.api.libs.json.{JsArray, Json}
import play.api.mvc.{Action, AnyContent, BaseController, Request}
import repository.dto.DbItem
import services.BaseService

abstract class CrudController[T <: ApiModel[Y], Y <: DbItem](service: BaseService[T, Y])
  extends BaseController {

  def add(): Action[AnyContent] = Action { implicit request: Request[AnyContent] =>
    Ok(views.html.index())
  }

  def showAll(): Action[AnyContent] = Action { implicit request: Request[AnyContent] =>
    Ok(service.findAll()
      .map(x => Json.toJson(x))
      .foldLeft(JsArray())({ case (acc, json) => acc :+ json }))
  }

  def showById(id: Int): Action[AnyContent] = Action { implicit request: Request[AnyContent] =>
    Ok(service.find(id)
      .map(x => Json.toJson(x))
      .orNull)
  }

  def update(): Action[AnyContent] = Action { implicit request: Request[AnyContent] =>
    Ok(views.html.index())
  }

  def delete(id: Int): Action[AnyContent] = Action { implicit request: Request[AnyContent] =>
    if (service.delete(id)) {
      Ok("Removed sucessfully")
    } else {
      NotFound("Resource not found")
    }
  }
}
