package controllers

import play.api.libs.json._
import play.api.mvc._
import repository.CarRepository
import repository.dto.CarDbItem

import javax.inject.{Inject, Singleton}

@Singleton
class CarController @Inject()(val controllerComponents: ControllerComponents,
                              val carService: CarRepository)
  extends CrudController[CarDbItem] {

  def add(car: CarDbItem): Action[AnyContent] = Action { implicit request: Request[AnyContent] =>
    Ok(Json.toJson(carService.add(car)))
  }

  def showAll(): Action[AnyContent] = Action { implicit request: Request[AnyContent] =>
    Ok(carService.findAll()
      .map(x => Json.toJson(x))
      .foldLeft(JsArray())({case (acc, json) => acc :+ json}))
  }

  def showById(): Action[AnyContent] = Action { implicit request: Request[AnyContent] =>
    Ok(views.html.index())
  }

  def update(): Action[AnyContent] = Action { implicit request: Request[AnyContent] =>
    Ok(views.html.index())
  }

  def delete(): Action[AnyContent] = Action { implicit request: Request[AnyContent] =>
    Ok(views.html.index())
  }
}
