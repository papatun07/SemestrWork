//package servlets;
//
//import entity.User;
//import service.UserService;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.sql.SQLException;
//import java.util.List;
//
//@WebServlet("/auth")
//public class AuthServlet extends HttpServlet {
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        request.getRequestDispatcher("/WEB-INF/auth.jsp").forward(request, response);
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String login = request.getParameter("email");
//        String password = (request.getParameter("password"));
//        UserService userService = new UserService();
//        List<User> allUsers = null;
//        try {
//            allUsers = userService.getAllUsers();
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//        try {
//            allUsers = userService.getAllUsers();
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//
//        for (User user : allUsers) {
//            if (user.getUsername().equals(login)) {
//                if (user.getPassword().equals(password)) {
//                    request.getSession().setAttribute("authUser", user);
//                    response.sendRedirect("/home");
//                    return;
//                }
//            }
//        }
//
//        response.sendRedirect("/auth");
//    }
//}
