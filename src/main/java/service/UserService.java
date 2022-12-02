package service;

import Util.InitListener;
import dao.UserDao;
import entity.User;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class UserService {
    private static final UserDao userDao = new UserDao();

    public static User getAuthUser() {
        Optional<User> user = InitListener.getAuthUser();
        if (user.isPresent()) {
            return user.get();
        } else {
            throw new IllegalArgumentException("Auth error");
        }
    }
    public static boolean isAuth() {
        return InitListener.getAuthUser().isPresent();
    }

    public void auth(User user, HttpServletRequest request, HttpServletResponse response){
        request.getSession().setAttribute("user", user);
    }
    public boolean isNoAnonymous(HttpServletRequest request, HttpServletResponse response){
        return request.getSession().getAttribute("user")!= null;
    }

    public User getUser(HttpServletRequest req, HttpServletResponse res) {
        return (User) req.getSession().getAttribute("user");
    }
    public void save(User user) throws SQLException {
        userDao.save(user);
    }
    public List<User> getAllUsers() throws SQLException {
        return userDao.findAll();
    }
}
