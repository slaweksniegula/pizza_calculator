package services.impl;

import dao.UserDao;
import dao.imp.AppUserDaoImp;
import model.AppUser;
import services.UserManagementService;

import javax.persistence.NoResultException;

public class UserManagementServiceImp implements UserManagementService {

    private UserDao dao;

    //TODO implement dependency injection
    public UserManagementServiceImp() {
        dao = new AppUserDaoImp();
    }

    @Override
    public void saveUser(AppUser appUser) {
        dao.saveUser(appUser);
    }

    @Override
    public void deleteUser(AppUser appUser) {
        dao.deleteUser(appUser.getId());
    }

    @Override
    public boolean isUserValid(String email, String password) {
        try {
            AppUser userByLogin = dao.getUserByEmail(email);
            if (userByLogin.getPassword().equals(password)) {
                return true;
            }
            return false;
        } catch (NoResultException e) {
            return false;
        }
    }

    @Override
    public boolean isEmailAvailable(String email) {
        try {
            dao.getUserByEmail(email);
            return false;
        } catch (NoResultException e) {
            return true;
        }
    }
}
