package services

import play.api.inject.ApplicationLifecycle

import java.time.{Clock, Instant}
import javax.inject._
import scala.concurrent.Future

@Singleton
class ApplicationTimer @Inject()(clock: Clock, appLifecycle: ApplicationLifecycle) {

  private val logger = org.slf4j.LoggerFactory.getLogger(classOf[ApplicationTimer])

  private val start: Instant = clock.instant
  logger.info(s"ApplicationTimer demo: Starting application at $start.")

  appLifecycle.addStopHook { () =>
    val stop: Instant = clock.instant
    val runningTime: Long = stop.getEpochSecond - start.getEpochSecond
    logger.info(s"ApplicationTimer demo: Stopping application at ${clock.instant} after ${runningTime}s.")
    Future.successful(())
  }
}
