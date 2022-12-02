package servlets;

import dao.UserDao;
import entity.User;
import service.UserService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/registration")
public class RegistrationServlet extends HttpServlet {
    private UserDao userDao;
    private UserService userSevice;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        userDao = (UserDao) getServletContext().getAttribute("userDao");
        userSevice = (UserService) getServletContext().getAttribute("userService");
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/view/cars/reg.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        UserService userService = new UserService();
        List<User> allUsers = null;
        try {
            allUsers = userService.getAllUsers();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        boolean alreadyExists = allUsers.stream()
                .anyMatch(user -> user.getUsername().equals(username));

        if (!alreadyExists) {
            User user = User.builder().username(username).password(password).build();
            try {
                userService.save(user);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } else {
            resp.sendRedirect("/signin");
        }
        resp.sendRedirect("car/list");
    }
}
