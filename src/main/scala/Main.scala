import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.stream.SystemMaterializer
import ticker.TickerServiceHandler

object Main extends App {

  implicit val system = ActorSystem("ticker")
  implicit val mat = SystemMaterializer(system).materializer

  Http().bindAndHandleAsync(
    TickerServiceHandler(new TickerServiceImpl),
    interface = "127.0.0.1",
    port = 8080
  )
}
