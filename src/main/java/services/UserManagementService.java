package services;

import model.AppUser;

public interface UserManagementService {

    void saveUser(AppUser appUser);
    void deleteUser(AppUser appUser);
    boolean isUserValid(String email, String password);
    boolean isEmailAvailable (String email);
}
