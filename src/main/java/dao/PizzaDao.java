package dao;

import model.Pizza;

import java.util.HashSet;
import java.util.List;

public interface PizzaDao {

    HashSet<Pizza> getAll();

    void savePizza(Pizza pizza);

    void deletePizza(long id);

    List<Pizza> getUserPizzas(String userEmail);


}
