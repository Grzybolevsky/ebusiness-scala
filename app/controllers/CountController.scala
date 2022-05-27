package controllers

import play.api.mvc._
import services.Counter

import javax.inject._


@Singleton
class CountController @Inject()(cc: ControllerComponents,
                                counter: Counter) extends AbstractController(cc) {

  def count: Action[AnyContent] = Action {
    Ok(counter.nextCount().toString)
  }
}
