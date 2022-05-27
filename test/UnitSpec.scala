import akka.actor.ActorSystem
import controllers.{AsyncController, CountController}
import org.scalatestplus.play._
import play.api.test.FakeRequest
import play.api.test.Helpers._
import services.Counter

import scala.concurrent.ExecutionContextExecutor

class UnitSpec extends PlaySpec {

  "CountController" should {
    "return a valid result with action" in {
      val counter: Counter = () => 49
      val controller = new CountController(stubControllerComponents(), counter)
      val result = controller.count(FakeRequest())
      contentAsString(result) must equal("49")
    }
  }

  "AsyncController" should {
    "return a valid result on action.async" in {
      val actorSystem = ActorSystem("test")
      try {
        implicit val ec: ExecutionContextExecutor = actorSystem.dispatcher
        val controller = new AsyncController(stubControllerComponents(), actorSystem)
        val resultFuture = controller.message(FakeRequest())
        contentAsString(resultFuture) must be("Hi!")
      } finally {
        actorSystem.terminate()
      }
    }
  }
}
