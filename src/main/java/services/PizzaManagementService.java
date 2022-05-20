package services;

import model.Pizza;

import java.util.List;

public interface PizzaManagementService {

    List<Pizza> getAll(String userEmail);

    void addPizza(Pizza pizza);

    void deletePizza(long id);
}
