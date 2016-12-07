package main;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import servlets.MirrorServlet;

/**
 * Created by misha on 06.12.16.
 */
public class Main {
    public static void main(String argv[])throws Exception {
        MirrorServlet mirrorServlet = new MirrorServlet();

        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.addServlet(new ServletHolder(mirrorServlet), "/mirror");

        Server server = new Server(8080);
        server.setHandler(context);

        server.start();
        java.util.logging.Logger.getGlobal().info("Server started");
        server.join();

    }
}
