package web.DAO;

import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
@Repository
public class UserDAOImpl implements UserDAO{

    @PersistenceContext
    private final EntityManager entityManager;

    public UserDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<User> findAllUsers() {
        return entityManager.createQuery("select u from User u",User.class).getResultList();
    }

    @Override
    public User findById(Long id) {
        return entityManager.find(User.class,id);
    }

    @Override
    public void saveUser(User user) {

        entityManager.persist(user);

    }

    @Override
    public void updateUser(Long id, User updateUser) {
        updateUser.setId(id);
        entityManager.merge(updateUser);


    }

    @Override
    public void deleteUser(Long id) {
        entityManager.remove(findById(id));
    }
}
