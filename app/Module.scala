import com.google.inject.AbstractModule
import services.{ApplicationTimer, AtomicCounter, Counter}

import java.time.Clock

class Module extends AbstractModule {

  override def configure(): Unit = {
    bind(classOf[Clock]).toInstance(Clock.systemDefaultZone)
    bind(classOf[ApplicationTimer]).asEagerSingleton()
    bind(classOf[Counter]).to(classOf[AtomicCounter])
  }
}
