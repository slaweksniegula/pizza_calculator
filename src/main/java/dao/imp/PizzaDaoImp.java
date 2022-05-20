package dao.imp;

import dao.AbstractDao;
import dao.PizzaDao;
import model.Pizza;

import javax.persistence.TypedQuery;
import java.util.HashSet;
import java.util.List;

public class PizzaDaoImp extends AbstractDao implements PizzaDao {


    @Override
    public HashSet<Pizza> getAll() {
        TypedQuery selectAllQuery = entityManager.createQuery("select u from AppUser u", Pizza.class);

        return new HashSet<Pizza>(selectAllQuery.getResultList());
    }

    @Override
    public void savePizza(Pizza pizza) {
        hibernateUtil.save(pizza);
    }

    @Override
    public void deletePizza(long id) {
        hibernateUtil.delete(Pizza.class, id);
    }


    @Override
    public List<Pizza> getUserPizzas(String userEmail) {
        TypedQuery<Pizza> query = entityManager.createQuery("select u from Pizza u where u.userEmail = :userEmail", Pizza.class);
        return query.setParameter("userEmail", userEmail).getResultList();
    }

}
