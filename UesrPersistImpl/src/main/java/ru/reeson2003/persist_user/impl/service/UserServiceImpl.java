package ru.reeson2003.persist_user.impl.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import ru.reeson2003.persist_user.api.UserPersistException;
import ru.reeson2003.persist_user.api.domain.User;
import ru.reeson2003.persist_user.api.service.UserQuery;
import ru.reeson2003.persist_user.api.service.UserService;
import ru.reeson2003.persist_user.impl.entity.PersistedUser;
import ru.reeson2003.persist_user.impl.repository.UserJpaRepository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

/**
 * Date: 26.08.2017.
 * Time: 18:08.
 *
 * @author Pavel Gavrilov.
 */
@Service
public class UserServiceImpl implements UserService {
    private static UserService service;

    private final UserJpaRepository repository;

    @Autowired
    public UserServiceImpl(UserJpaRepository repository) {
        this.repository = repository;
    }

    public static UserService getService() {
        new ClassPathXmlApplicationContext("user-persist-context.xml");
        return service;
    }

    @PostConstruct
    public void init() {
        UserServiceImpl.service = this;
    }

    public void addUser(User user) throws UserPersistException {
        if (user.getId() != 0)
            throw new UserPersistException(/*"User's Id is not 0"*/);
        PersistedUser u = repository.save(new PersistedUser(user));
        user.setId(u.getId());
    }

    public User getUser(long l) throws UserPersistException {
        User result;
        try {
            result = repository.getOne(l);
            result.getFirstName();
        } catch (Exception e) {
            throw new UserPersistException(/*MessageFormat.format("User with id {0} not found.", l)*/);
        }
        return result;
    }

    public void updateUser(User user) throws UserPersistException {
        if (user.getId() == 0)
            throw new UserPersistException(/*"User does not exist."*/);
        repository.save(new PersistedUser(user));
    }

    public void deleteUser(long id) throws UserPersistException {
        try {
            repository.delete(id);
        } catch (Exception e) {
            throw new UserPersistException(/*"User does not exist."*/);
        }
    }

    public User findByLogin(String s) throws UserPersistException {
        User result = repository.findByLogin(s);
        if (result == null)
            throw new UserPersistException(/*MessageFormat.format("User with login {0} does not exist.", s)*/);
        return result;
    }

    public List<User> getUsers() throws UserPersistException {
        return new ArrayList<>(repository.findAll());
    }

    public UserQuery createUserQuery() {
        return null;
    }

}
