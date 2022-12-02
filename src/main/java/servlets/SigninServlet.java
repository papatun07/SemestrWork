package servlets;

import Util.DbException;
import dao.CarDao;
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

@WebServlet("/signin")
public class SigninServlet extends HttpServlet {
    private UserDao userDao;
    private UserService userSevice;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        userDao = (UserDao) getServletContext().getAttribute("userDao");
        userSevice = (UserService) getServletContext().getAttribute("userService");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/WEB-INF/view/security/signin.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        if(username != null && password != null ){
            try {
                User user = userDao.geUserByUsernameAndPassword(username, password);
                if(user == null){
                    req.setAttribute("message", "Error");
                }else{
                    userSevice.auth(user, req, resp);
//                    resp.sendRedirect(getServletContext().getContextPath() + "/");
                }
            } catch (DbException e) {
                throw new ServletException(e);
            }
        }
        getServletContext().getRequestDispatcher("/WEB-INF/view/cars/list.jsp").forward(req, resp);
    }
}
