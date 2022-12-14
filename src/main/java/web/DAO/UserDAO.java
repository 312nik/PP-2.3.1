package web.DAO;

import web.model.User;

import java.util.List;

public interface UserDAO {

    List<User> findAllUsers();

    User findById(Long id);

    void saveUser(User user);

    void updateUser(Long id, User updateUser);

    void deleteUser(Long id);

}
