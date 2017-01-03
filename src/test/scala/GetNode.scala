import io.gatling.core.Predef._
import io.gatling.core.scenario.Simulation
import io.gatling.http.Predef._

import scala.concurrent.duration._

class GetNode extends Simulation {

  val conf = http.baseURL("http://localhost:8080")

  val scn = scenario("Get Node")
    .during(1 minutes) {
      exec(http("get node")
        .get("/db/node/max")
        .check(
          jsonPath("$.name").is("Max"),
          status.is(200))
      )
    }

  setUp(scn.inject(atOnceUsers(80)))
    .protocols(conf)
}
