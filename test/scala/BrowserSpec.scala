package scala

import org.scalatestplus.play._
import org.scalatestplus.play.guice.GuiceOneServerPerTest

class BrowserSpec extends PlaySpec
  with OneBrowserPerTest
  with GuiceOneServerPerTest
  with HtmlUnitFactory
  with ServerProvider {

  "Application" should {
    "work from within a browser" in {
      go to ("http://localhost:" + port)
      pageSource must include("Your new application is ready.")
    }
  }
}
