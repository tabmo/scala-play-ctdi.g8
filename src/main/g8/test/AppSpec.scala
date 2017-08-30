import org.scalatest.{FunSpec, Matchers}
import org.scalatest.concurrent.{IntegrationPatience, ScalaFutures}

class AppSpec
    extends FunSpec
    with OneServerPerSuiteWithMyComponents
    with Matchers
    with ScalaFutures
    with IntegrationPatience {

  private lazy val ws = components.wsClient

  describe("/") {
    it("""should respond Hey!""") {
      whenReady(ws.url(s"http://localhost:\$port/").get()) { r =>
        r.body shouldBe "hey!"
      }
    }
  }

}
