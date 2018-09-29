import org.eclipse.jetty.server.Server
import org.eclipse.jetty.webapp.WebAppContext
import org.scalatra.servlet.ScalatraListener

/**
  * @Author: zhangjixu
  * @CreateDate: 2018/9/29
  * @Description:
  * @Version: 1.0.0
  */
object JettyLauncher {

  def main(args: Array[String]): Unit = {
    val port = if(System.getenv("PORT") != null) System.getenv("PORT").toInt else 8080

    val server = new Server(port)
    val context = new WebAppContext()
    context setContextPath "/"
    context.setResourceBase("src/main/webapp")
    context.setInitParameter(ScalatraListener.LifeCycleKey, "MyScalatraBootstrap")
    context.addEventListener(new ScalatraListener)

    server.setHandler(context)
    server.start
    server.join
  }

}
