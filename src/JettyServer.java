import org.eclipse.jetty.server.Connector;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.nio.SelectChannelConnector;
import org.eclipse.jetty.webapp.WebAppContext;

public class JettyServer {
public static void main(String[] args) throws Exception {
		int port = 8083; // 端口号
		String contextPath = "/preserve"; // 上下文路径
		System.out.println(contextPath + " running");
		//String resourceBase = "I:\\ekp\\ekp"; // web工程目录
		String resourceBase = "H:\\github_home\\preserve_n\\WebContent"; // web工程目录
		long max_age = 3600 * 24 * 365 * 10;
		try {
			Server server = new Server();
			Connector connector = new SelectChannelConnector();
			connector.setPort(port);
			server.setConnectors(new Connector[] { connector });
			WebAppContext context = new WebAppContext();
			context.setContextPath(contextPath);
			context.setResourceBase(resourceBase); 
			context.setMaxFormContentSize(10000000);
			// 设置gzip压缩
			// FilterHolder gzipFilterHolder = new
			// FilterHolder(GzipFilter.class);
			// gzipFilterHolder.setInitParameter("mimeTypes",
			// "text/javascript,application/x-javascript,"
			// + "application/jsonp,text/html,text/css");
			// gzipFilterHolder.setInitParameter("excludedAgents",
			// "gozilla, traviata");
			// context.addFilter(gzipFilterHolder, "/*", 1);
			server.setHandler(context);
			server.start();
			server.join();
			System.out.println("ok");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
