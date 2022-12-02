package Util;

import Util.ConnectionProvider;
import Util.DbException;
import dao.CarDao;
import dao.UserDao;
import entity.User;
import service.UserService;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.*;
import java.util.Optional;

@WebListener
public class InitListener implements ServletContextListener, HttpSessionListener, HttpSessionAttributeListener {

    private static HttpSession session;

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        try {
            ConnectionProvider connectionProvider = ConnectionProvider.getInstance();
            servletContextEvent.getServletContext().setAttribute("carDao",new CarDao(connectionProvider));
            servletContextEvent.getServletContext().setAttribute("userDao", new UserDao(connectionProvider));
            servletContextEvent.getServletContext().setAttribute("userService", new UserService());
        } catch (DbException e) {
            throw new RuntimeException(e);
        }
    }
    public static Optional<User> getAuthUser() {
        User user = (User) session.getAttribute("authUser");
        if (user != null) {
            return Optional.of(user);
        } else {
            return Optional.empty();
        }
    }
    @Override
    public void sessionCreated(HttpSessionEvent se) {
        session = se.getSession();
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        /* Session is destroyed. */
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {}

    @Override
    public void attributeAdded(HttpSessionBindingEvent httpSessionBindingEvent) {

    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent httpSessionBindingEvent) {

    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent httpSessionBindingEvent) {

    }
}
