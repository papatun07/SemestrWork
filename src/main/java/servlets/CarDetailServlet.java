package servlets;

import Util.DbException;
import dao.CarDao;
import entity.Car;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/car/detail")
public class CarDetailServlet extends HttpServlet {
    private CarDao carDao;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        carDao = (CarDao) getServletContext().getAttribute("carDao");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String id = req.getParameter("id");
            if (id == null) {
                resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                resp.getWriter().println("Bad request, no id");
            }
            Car car =  carDao.getDetail(Integer.parseInt(id));
            if(car == null){
                resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
                getServletContext().getRequestDispatcher("/WEB-INF/view/errors/notfound.jsp").forward(req, resp);
            }

            req.setAttribute("car", car);
            getServletContext().getRequestDispatcher("/WEB-INF/view/cars/detail.jsp").forward(req,resp);
        }catch (DbException e){
            throw new ServletException(e);
        }
    }
}
