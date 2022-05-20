package utils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ServletUtils {

    public static final String LOGIN = "login";
    public static final String NAME = "name";
    public static final String EMAIL = "email";
    public static final String PASSWORD = "password";
    public static final String ERRORS = "errors";
    public static final String REMEMBER = "remember";
    public static final String COOKIE_CHECKED = "on";
    public static final String ERROR_EMAIL_HEADER = "Email error";
    public static final String ERROR_EMAIL_REG_MESSAGE = "Typed email is already used";
    public static final String ERROR_LOGIN_MESSAGE = "Login or password is invalid";
    public static final String PIZZA_R = "pizzaR";
    public static final String CRUST_EDGE = "crustEdge";
    public static final String CALCULATED_PERCENTAGE = "calculatedPercentage";




    public static void redirectUserToLoginPageIfNotLoggedIn(
            HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (ServletUtils.isUserLoggedIn(req) != true) {
            req.getRequestDispatcher("/login.jsp").forward(req, resp);
            return;
        }
    }

    public static boolean isUserLoggedIn(HttpServletRequest req) {
        return getCurrentUserEmailFromSession(req) != null;
    }

    public static String getCurrentUserEmailFromSession(HttpServletRequest req) {
        return (String) req.getSession().getAttribute(EMAIL);
    }

}
