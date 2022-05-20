package controllers;


import model.Pizza;
import services.PizzaManagementService;
import services.impl.PizzaManagementServiceImp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static utils.ServletUtils.*;


@WebServlet(name = "SavePizzaServlet", value = "/save")
public class SavePizzaServlet extends HttpServlet {

    private PizzaManagementService service;

    @Override
    public void init() throws ServletException {
        service = new PizzaManagementServiceImp();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        redirectUserToLoginPageIfNotLoggedIn(request, response);
        String pizzaR = null;
        String crustEdge = null;
        String calculatedPercentage = null;
        String userEmailFromSession = getCurrentUserEmailFromSession(request);

        if (request.getCookies() != null) {
            for (Cookie c : request.getCookies()) {
                if (c.getName().equals(PIZZA_R)) {
                    pizzaR = c.getValue();
                } else if (c.getName().equals(CRUST_EDGE)) {
                    crustEdge = c.getValue();
                } else if (c.getName().equals(CALCULATED_PERCENTAGE)) {
                    calculatedPercentage = c.getValue();
                }
            }
            //If login and password are not null it means that client has cookies(LOGIN, PASSWORD) already saved,
            //so doPost method can be invoked with Login and Password taken from them.
            if (pizzaR != null && crustEdge != null && calculatedPercentage != null) {
                int r = Integer.parseInt(pizzaR);
                int crust = Integer.parseInt(crustEdge);
                double percentage = Double.parseDouble(calculatedPercentage);

                Pizza pizza = new Pizza(r, crust, percentage, userEmailFromSession);
                service.addPizza(pizza);
                request.getRequestDispatcher("savedPizzas").forward(request, response);
            }


        }
    }
}