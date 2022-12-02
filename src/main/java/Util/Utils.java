package Util;

import entity.User;
import service.UserService;

import java.sql.SQLException;

public class Utils {
    public static boolean isPostBelongsToUser(Long userID) {
        return UserService.isAuth() && UserService.getAuthUser().getId().equals(userID);
    }
    public static String getUsername(Long userID) throws SQLException {
        UserService service = new UserService();
        for (User user : service.getAllUsers()) {
            if (user.getId().equals(userID)) {
                return user.getUsername();
            }
        }
        return "";
    }
}
