import scala.concurrent.duration._
import play.api.libs.concurrent.Execution.Implicits._

import play.api.ApplicationLoader.Context
import play.api.BuiltInComponentsFromContext
import play.api.routing.Router

import play.api.libs.ws.ahc.AhcWSComponents
import play.filters.cors.CORSComponents
import play.filters.headers.SecurityHeadersComponents
import play.filters.gzip.GzipFilterComponents

import controllers._
import router.Routes
import services._, impl._

class AppComponents(context: Context) extends BuiltInComponentsFromContext(context)
    with AhcWSComponents
    with CORSComponents
    with SecurityHeadersComponents
    with GzipFilterComponents {

  override lazy val httpFilters = Seq(securityHeadersFilter, corsFilter, gzipFilter)

  val sampleService: SampleService = new SampleServiceImpl(wsClient)

  val applicationController = new Application(sampleService)
  val router: Router = new Routes(httpErrorHandler, applicationController)
}