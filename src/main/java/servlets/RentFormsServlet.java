package servlets;

import Util.DbException;
import dao.CarDao;
import dao.UserDao;
import entity.Car;
import entity.User;
import service.CarService;
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

@WebServlet("/car/forms")
public class RentFormsServlet extends HttpServlet {
    private CarDao carDao;
    private UserService userService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        carDao = (CarDao) getServletContext().getAttribute("carDao");
        userService = (UserService) getServletContext().getAttribute("userService");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/WEB-INF/view/cars/forms.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String rentDay = req.getParameter("date_of_rent");
        CarService carService = new CarService();

            Car car = new Car(rentDay);
            try {
                carService.save(car);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        getServletContext().getRequestDispatcher("/WEB-INF/view/cars/forms.jsp").forward(req, resp);
    }
}
