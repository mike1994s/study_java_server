package main;

import accounts.AccountService;
import dbService.DBService;
import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.HandlerList;
import org.eclipse.jetty.server.handler.ResourceHandler;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import servlets.MirrorServlet;
import servlets.SignInServlet;
import servlets.SignUpServlet;
import websockets.chat.WebSocketChatServlet;

/**
 * Created by misha on 06.12.16.
 */
public class Main {
    public static void main(String argv[])throws Exception {
        Server server = new Server(8080);
        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);

        context.addServlet(new ServletHolder(new WebSocketChatServlet()), "/chat");

        ResourceHandler resource_handler = new ResourceHandler();
        resource_handler.setDirectoriesListed(true);
        resource_handler.setResourceBase("public_html");

        HandlerList handlers = new HandlerList();
        handlers.setHandlers(new Handler[]{resource_handler, context});
        server.setHandler(handlers);


        server.start();
        java.util.logging.Logger.getGlobal().info("Server started");
        server.join();

    }
}
