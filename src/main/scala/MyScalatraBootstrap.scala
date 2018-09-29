import com.example.app._
import org.scalatra._
import javax.servlet.ServletContext

class MyScalatraBootstrap extends LifeCycle {
  override def init(context: ServletContext) {
    context.mount(new MyServlet, "/*")
    context.mount(new SecondServlet, "/path/*")
  }
}
