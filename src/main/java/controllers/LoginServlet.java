package controllers;

import controllers.validation.ValidationError;
import services.UserManagementService;
import services.impl.UserManagementServiceImp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static utils.ServletUtils.*;

@WebServlet(name = "LoginServlet", urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {

    private UserManagementService service;



    @Override
    public void init() throws ServletException {
        service = new UserManagementServiceImp();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = null;
        String password= null;

        if (req.getCookies() != null){
            for (Cookie c : req.getCookies()){
                if (c.getName().equals(EMAIL)){
                    email = c.getValue();
                } else if (c.getName().equals(PASSWORD)) {
                    password = c.getValue();
                }
            }
        }
        //If login and password are not null it means that client has cookies(LOGIN, PASSWORD) already saved,
        //so doPost method can be invoked with Login and Password taken from them.
        if (email != null && password != null){
            req.setAttribute(EMAIL, email);
            req.setAttribute(PASSWORD, password);
            doPost(req, resp);
            return;
        }

//in the other case Login.jsp id served to get Login and Password from user form as parameters
        req.getRequestDispatcher("/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String email = req.getParameter(EMAIL);
        String password = req.getParameter(PASSWORD);
        boolean isRememberChecked = (COOKIE_CHECKED).equals(req.getParameter(REMEMBER));

        //if login and password are nulls it means that doPost was invoked in doGet method with values from cookies
        //because parameters can be set only by filling form by user in login page.
        if (email==null && password==null){
            email = (String)req.getAttribute(EMAIL);
            password = (String)req.getAttribute(PASSWORD);
        }

        if (!service.isUserValid(email, password)) {
            List<ValidationError> errors = new ArrayList<>();
            errors.add(new ValidationError(ERROR_EMAIL_HEADER, ERROR_EMAIL_REG_MESSAGE));
            req.setAttribute(ERRORS, errors);
            req.getRequestDispatcher("/login.jsp").forward(req, resp);
            return;
        }

        req.getSession().setAttribute(EMAIL, email);

        if (isRememberChecked) {
            Cookie loginCookie = new Cookie(EMAIL, email);
            loginCookie.setMaxAge(60 * 60);
            resp.addCookie(loginCookie);
            Cookie passwordCookie = new Cookie(PASSWORD, password);
            passwordCookie.setMaxAge(60 * 60);
            resp.addCookie(passwordCookie);
        }
        req.getRequestDispatcher("pizza_param.jsp").forward(req, resp);
    }
}
