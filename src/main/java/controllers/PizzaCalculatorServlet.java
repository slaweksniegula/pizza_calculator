package controllers;

import model.Pizza;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DecimalFormat;

import static utils.ServletUtils.*;


@WebServlet(name = "PizzaCalculatorServlet", value = "/calculate")
public class PizzaCalculatorServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String pizzaR = request.getParameter("pizzasR");
        int pizzasR = Integer.parseInt(pizzaR);
        int crustEdge = Integer.parseInt(request.getParameter("crustEdge"));
        double calculatedPercentage = Pizza.calculateIngredientsPercentage(pizzasR, crustEdge);
        DecimalFormat df = new DecimalFormat("##.##");
        
        request.setAttribute("calculatedPercentage", df.format(calculatedPercentage));
        RequestDispatcher dispatcher = request.getRequestDispatcher("resultOfPizzaCalculation.jsp");

        Cookie pizzaRCookie = new Cookie(PIZZA_R, pizzaR);
        pizzaRCookie.setMaxAge(60 * 60);
        response.addCookie(pizzaRCookie);
        Cookie crustEdgeCookie = new Cookie(CRUST_EDGE, String.valueOf(crustEdge));
        crustEdgeCookie.setMaxAge(60 * 60);
        response.addCookie(crustEdgeCookie);
        Cookie calculatedPercentageCookie = new Cookie(CALCULATED_PERCENTAGE, String.valueOf(calculatedPercentage));
        calculatedPercentageCookie.setMaxAge(60 * 60);
        response.addCookie(calculatedPercentageCookie);

        dispatcher.forward(request, response );

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



    }
}
