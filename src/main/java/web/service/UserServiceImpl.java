package web.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.DAO.UserDAO;
import web.model.User;

import java.util.List;
@Service
@Transactional (readOnly = true)
public class UserServiceImpl implements UserService{

    private final UserDAO userDAO;

    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public List<User> findAllUsers() {
        return userDAO.findAllUsers();
    }

    @Override
    public User findById(Long id) {
        return userDAO.findById(id);
    }
    @Transactional
    @Override
    public void saveUser(User user) {
        userDAO.saveUser(user);

    }
    @Transactional
    @Override
    public void updateUser(Long id, User updateUser) {
        userDAO.updateUser(id,updateUser);
    }
    @Transactional
    @Override
    public void deleteUser(Long id) {
        userDAO.deleteUser(id);
    }
}
