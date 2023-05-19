package web.infrastructure.repo.user;

import java.util.List;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import web.application.authorization.user.IUserRepo;
import web.application.authorization.user.User;
import web.application.authorization.user.UserAlreadyExistsException;
import web.application.authorization.user.UserNotFoundException;

@Stateless
public class UserRepo implements IUserRepo {

    @PersistenceContext(unitName = "Postgres")
    private EntityManager entityManager;

    private boolean checkUsername(User user){
        List<EUser> users = entityManager
        .createQuery("SELECT p FROM EUser p WHERE p.username = :username", EUser.class)
        .setParameter("username", user.getUsername())
        .getResultList();
        if(users != null && !users.isEmpty()){
            return true;
        } else return false;
    }

    @Override
    public boolean add(User user) throws UserAlreadyExistsException {
        if(checkUsername(user)){
            throw new UserAlreadyExistsException("Пользователь с таким именем уже есть");
        }
        try {
            EUser eUser = new EUser();
            eUser.setAll(user);
            entityManager.persist(eUser);
            return true;
        } catch (Exception exception) {
            exception.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean check(User user) throws UserNotFoundException {
        List<EUser> users;
        try {
            users = entityManager
            .createQuery("SELECT p FROM EUser p WHERE p.username = :username AND p.password = :password", EUser.class)
            .setParameter("username", user.getUsername())
            .setParameter("password", user.getPassword())
            .getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        if(users != null && !users.isEmpty()){
            return true;
        }
        throw new UserNotFoundException("Неверный логин или пароль");
    }
}
