package services.impl

import play.api.libs.ws.WSClient
import services.SampleService

class SampleServiceImpl(ws: WSClient) extends SampleService {

  override def doSomething(foo: String): Int = {
    1
  }

}