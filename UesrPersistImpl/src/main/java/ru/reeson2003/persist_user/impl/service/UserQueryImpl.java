package ru.reeson2003.persist_user.impl.service;

import ru.reeson2003.persist_user.api.UserPersistException;
import ru.reeson2003.persist_user.api.domain.User;
import ru.reeson2003.persist_user.api.service.DateQuery;
import ru.reeson2003.persist_user.api.service.UserQuery;

import java.util.List;

/**
 * Date: 26.08.2017.
 * Time: 18:08.
 *
 * @author Pavel Gavrilov.
 */
public class UserQueryImpl implements UserQuery{
    public UserQuery firstName(String s) {
        return null;
    }

    public UserQuery firstNameLike(String s) {
        return null;
    }

    public UserQuery middleName(String s) {
        return null;
    }

    public UserQuery middleNameLike(String s) {
        return null;
    }

    public UserQuery lastName(String s) {
        return null;
    }

    public UserQuery lastNameLike(String s) {
        return null;
    }

    public UserQuery email(String s) {
        return null;
    }

    public UserQuery emailLike(String s) {
        return null;
    }

    public UserQuery login(String s) {
        return null;
    }

    public UserQuery loginLike(String s) {
        return null;
    }

    public UserQuery loggedIn(boolean b) {
        return null;
    }

    public UserQuery orderBy(String s) {
        return null;
    }

    public DateQuery birthDate() {
        return null;
    }

    public DateQuery registerDate() {
        return null;
    }

    public DateQuery updateDate() {
        return null;
    }

    public List<User> user() throws UserPersistException {
        return null;
    }

    public User singleResult() throws UserPersistException {
        return null;
    }
}
