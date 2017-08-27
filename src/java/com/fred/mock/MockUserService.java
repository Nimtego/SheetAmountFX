package com.fred.mock;

import ru.reeson2003.persist_user.api.UserPersistException;
import ru.reeson2003.persist_user.api.domain.User;
import ru.reeson2003.persist_user.api.service.UserQuery;
import ru.reeson2003.persist_user.api.service.UserService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Date: 27.08.2017.
 * Time: 12:26.
 *
 * @author Pavel Gavrilov.
 */
public class MockUserService implements UserService {
    private Map<Long, User> userMap = new HashMap<>();
    private long idGenerator = 1L;

    @Override
    public void addUser(User user) throws UserPersistException {
        try {
            findByLogin(user.getLogin());
            throw new UserPersistException("Логин уже существует");
        } catch (UserPersistException e) {
            if (user.getId() == 0) {
                user.setId(idGenerator++);
                userMap.put(user.getId(), user);

            } else
                throw new UserPersistException("");
        }
    }

    @Override
    public User getUser(long userId) throws UserPersistException {
        if (userMap.containsKey(userId))
            return userMap.get(userId);
        else
            throw new UserPersistException("Test get");
    }

    @Override
    public void updateUser(User user) throws UserPersistException {
        if (userMap.containsKey(user.getId()))
            userMap.put(user.getId(), user);
        else
            throw new UserPersistException("Test upDate");
    }

    @Override
    public void deleteUser(long id) throws UserPersistException {
        if (userMap.containsKey(id))
            userMap.remove(id);
        else
            throw new UserPersistException("");
    }

    @Override
    public User findByLogin(String login) throws UserPersistException {
        List<User> users = new ArrayList<>(userMap.values());
        User user = null;
        for (User u: users)
            if (u.getLogin().equals(login))
                return u;
        throw new UserPersistException("Пользователя не существует");
    }

    @Override
    public List<User> getUsers() throws UserPersistException {
        return new ArrayList<>(userMap.values());
    }

    @Override
    public UserQuery createUserQuery() {
        return null;
    }
}
