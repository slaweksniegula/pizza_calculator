package services.impl;

import dao.PizzaDao;
import dao.imp.PizzaDaoImp;
import model.Pizza;
import services.PizzaManagementService;

import java.util.HashSet;
import java.util.List;

public class PizzaManagementServiceImp implements PizzaManagementService {

  private PizzaDao pizzaDao;
    public PizzaManagementServiceImp() {
        pizzaDao = new PizzaDaoImp();
    }

    @Override
    public void addPizza(Pizza pizza) {

        pizzaDao.savePizza(pizza);
    }

    @Override
    public List<Pizza> getAll(String userEmail) {
        List<Pizza> currentUserPizzas;
        currentUserPizzas = pizzaDao.getUserPizzas(userEmail);

        return currentUserPizzas;
    }

    @Override
    public void deletePizza(long id) {
        pizzaDao.deletePizza(id);
    }
}
