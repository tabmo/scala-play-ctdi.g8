import play.api._
import play.api.ApplicationLoader.Context

class AppLoader extends ApplicationLoader {
  override def load(context: Context): Application = {
    LoggerConfigurator(context.environment.classLoader).foreach {
      _.configure(context.environment)
    }
    new AppComponents(context).application
  }
}


