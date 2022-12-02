package servlets;

import Util.DbException;
import dao.CarDao;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/car/list")
public class CarListServlet extends HttpServlet {
    private CarDao carDao;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        carDao = (CarDao) getServletContext().getAttribute("carDao");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            req.setAttribute("cars", carDao.getPage());
            req.setAttribute("carCount", carDao.getCount());
        } catch (DbException e) {
            throw new ServletException(e);
        }
        getServletContext().getRequestDispatcher("/WEB-INF/view/cars/list.jsp").forward(req,resp);
    }
}
