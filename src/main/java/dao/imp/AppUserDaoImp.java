package dao.imp;

import dao.AbstractDao;
import dao.UserDao;
import model.AppUser;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import java.util.HashSet;

public class AppUserDaoImp extends AbstractDao implements UserDao {


    @Override
    public HashSet<AppUser> getAll() {
        TypedQuery selectAllQuery = entityManager.createQuery("select u from AppUser u", AppUser.class);

        return new HashSet<>(selectAllQuery.getResultList());
    }

    @Override
    public void saveUser(AppUser user) {
        hibernateUtil.save(user);
    }

    @Override
    public void deleteUser(long id) {
        hibernateUtil.delete(AppUser.class, id);
    }

    @Override
    public AppUser getUserByEmail(String email) {
        TypedQuery<AppUser> selectByEmailQuery =
                entityManager.createQuery("select u from AppUser u where u.email = :email", AppUser.class);
        return selectByEmailQuery.setParameter("email", email).getSingleResult();
    }

    //clear cashe after this operation

    @Override
    public HashSet<AppUser> getUsersByName(String name) {
        TypedQuery<AppUser> selectByNameQuery = entityManager.createQuery("select u from AppUser u where u.name = :name", AppUser.class);
        return new HashSet<>(selectByNameQuery.setParameter("name", name).getResultList());
    }

    @Override
    public Boolean isLogAllowed(String email, String password) {
        try {
            AppUser userByLogin = getUserByEmail(email);
            if (userByLogin.getPassword().equals(password)) {
                return true;
            }
            return false;
        } catch (NoResultException e) {
            return false;
        }
    }
}
