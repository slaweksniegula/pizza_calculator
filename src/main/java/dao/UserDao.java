package dao;

import model.AppUser;

import java.util.HashSet;

public interface UserDao {

    HashSet<AppUser> getAll();

    void saveUser(AppUser user);

    void deleteUser(long id);

    AppUser getUserByEmail(String email);

    HashSet<AppUser> getUsersByName(String name);

    Boolean isLogAllowed(String login, String password);

}
