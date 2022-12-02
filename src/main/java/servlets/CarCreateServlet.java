package servlets;

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

@WebServlet("/create")
public class CarCreateServlet extends HttpServlet {
    private CarDao carDao;
    private CarService carService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        carDao = (CarDao) getServletContext().getAttribute("carDao");
        carService = (CarService) getServletContext().getAttribute("carService");
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/createCar.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String brand = req.getParameter("brand");
        String model = req.getParameter("model");
        String price = req.getParameter("price_for_day");
        CarService carService = new CarService();
//        Car car = Car.builder().brand(brand).model(model).price(Integer.parseInt(price)).build();
        try {
            carService.save(new Car(brand,model,price));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        getServletContext().getRequestDispatcher("/WEB-INF/createCar.jsp").forward(req, resp);
            resp.sendRedirect("/car/list");

        }
    }

