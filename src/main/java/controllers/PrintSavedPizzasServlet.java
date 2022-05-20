package controllers;

import model.Pizza;
import services.PizzaManagementService;
import services.impl.PizzaManagementServiceImp;
import utils.ServletUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet(name = "PrintSavedPizzasServletController", value = "/savedPizzas")
public class PrintSavedPizzasServlet extends HttpServlet {

    private PizzaManagementService pizzaService;


    @Override
    public void init() throws ServletException{
        pizzaService = new PizzaManagementServiceImp();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String currentUserMail = ServletUtils.getCurrentUserEmailFromSession(request);
        List<Pizza> pizzas = pizzaService.getAll(currentUserMail) ;

        request.setAttribute("pizzas_list", pizzas);

        request.getRequestDispatcher("view_all_pizzas.jsp").forward(request, response);

    }
}
