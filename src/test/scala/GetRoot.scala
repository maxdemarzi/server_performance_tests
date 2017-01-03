import io.gatling.core.Predef._
import io.gatling.core.scenario.Simulation
import io.gatling.http.Predef._

import scala.concurrent.duration._

class GetRoot extends Simulation {

  val conf = http.baseURL("http://localhost:8080")

  val scn = scenario("Get Root")
    .during(1 minutes) {
      exec(http("index").get("/"))
    }

  setUp(scn.inject(atOnceUsers(80)))
    .protocols(conf)
}
