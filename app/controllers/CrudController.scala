package controllers

import models.ApiModel
import play.api.mvc.{Action, AnyContent, BaseController}
import repository.dto.DbItem
import services.BaseService

abstract class CrudController[T <: ApiModel[Y], Y <: DbItem](service: BaseService[T, Y])
  extends BaseController {

  def add(): Action[AnyContent]

  def showAll(): Action[AnyContent]

  def showById(id: Int): Action[AnyContent]

  def update(): Action[AnyContent]

  def delete(id: Int): Action[AnyContent] = Action(implicit request =>
    if (service.delete(id)) Ok("Removed sucessfully") else NotFound("Resource not found"))
}
