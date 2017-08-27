package com.fred.service;

import com.fred.exception.ErrorMessageException;
import ru.reeson2003.persist_user.api.UserPersistException;
import ru.reeson2003.persist_user.api.domain.User;
import ru.reeson2003.persist_user.api.service.UserServices;


/**
 * Created by myasnikov
 * on 25.08.2017.
 */
public class UserController {
    public User current;

    public void logInUser(String logIn, String password) throws ErrorMessageException, UserPersistException {
        if (logIn.isEmpty() || password.isEmpty()) {
            throw new ErrorMessageException(logIn.isEmpty() ? "Login empty" : "Password empty");
        }
        User user = UserServices.getService().findByLogin(logIn);
        if (!user.getPassword().equals(password)) {
            throw new ErrorMessageException("Не верный пароль");
        }
        current = user;
    }

    public boolean singUpUser(String logIn, String password) throws ErrorMessageException, UserPersistException {
        if (logIn.isEmpty() || password.isEmpty()) {
            throw new ErrorMessageException(logIn.isEmpty() ? "Login empty" : "Password empty");
        }
        User user = new User();
        user.setPassword(password);
        user.setLogin(logIn);
        UserServices.getService().addUser(user);

        return true;
    }
}
