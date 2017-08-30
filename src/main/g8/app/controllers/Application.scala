package controllers

import play.api.mvc.{ Action, Controller }
import services.SampleService

class Application(sampleService: SampleService) extends Controller {

  def index = Action {
    println(sampleService.doSomething("hello"))
    Ok("hey!")
  }

}