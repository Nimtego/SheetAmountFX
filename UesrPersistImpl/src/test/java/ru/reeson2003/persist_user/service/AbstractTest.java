package ru.reeson2003.persist_user.service;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ru.reeson2003.persist_user.api.UserPersistException;
import ru.reeson2003.persist_user.api.domain.User;
import ru.reeson2003.persist_user.api.service.UserService;

import java.util.Date;
import java.util.List;

/**
 * Date: 26.08.2017.
 * Time: 18:12.
 *
 * @author Pavel Gavrilov.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:test-context.xml")
public abstract class AbstractTest extends Assert {
    private static final Logger LOGGER = LoggerFactory.getLogger(AbstractTest.class);

    public long ID = 0;
    public static final String FIRST_NAME = "Ivan";
    public static final String MIDDLE_NAME = "Ivanovich";
    public static final String LAST_NAME = "Ivanov";
    public static final Date BIRTH_DATE = new Date(2000, 01, 01);
    public static final String EMAIL = "ivanonov@mail.ru";
    public static final String LOGIN = "ivanov.i.i";
    public static final String PASSWORD = "12345678";
    public static final Date REGISTER_DATE = new Date(2010, 10, 10);
    public static final Date UPDATE_DATE = new Date(2015, 10, 20);
    public static final boolean LOGGED_IN = true;

    public long ID_2 = 0;
    public static final String FIRST_NAME_2 = "Vasya";
    public static final String MIDDLE_NAME_2 = "Petrovich";
    public static final String LAST_NAME_2 = "Pupkin";
    public static final Date BIRTH_DATE_2 = new Date(2010, 01, 01);
    public static final String EMAIL_2 = "petrovich@mail.ru";
    public static final String LOGIN_2 = "pupkin.v.p";
    public static final String PASSWORD_2 = "87654321";
    public static final Date REGISTER_DATE_2 = new Date(2020, 10, 10);
    public static final Date UPDATE_DATE_2 = new Date(2025, 10, 20);
    public static final boolean LOGGED_IN_2 = false;

    @Autowired
    private UserService userService;

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @After
    public void clearDataBase() {
        try {
            List<User> users = userService.getUsers();
            for (User u : users)
                userService.deleteUser(u.getId());
        } catch (Exception e) {
            /*do nothing*/
        }
    }

    @Test
    public void serviceNotNullTest() {
        assertNotNull("UserService is null", userService);
        LOGGER.info("ServiceNotNullTest ...PASS");
    }

    public User getTestUser() {
        User user = new User();
        user.setFirstName(AbstractTest.FIRST_NAME);
        user.setMiddleName(AbstractTest.MIDDLE_NAME);
        user.setLastName(AbstractTest.LAST_NAME);
        user.setBirthDate(AbstractTest.BIRTH_DATE);
        user.setEmail(AbstractTest.EMAIL);
        user.setLogin(AbstractTest.LOGIN);
        user.setPassword(AbstractTest.PASSWORD);
        user.setRegisterDate(AbstractTest.REGISTER_DATE);
        user.setUpdateDate(AbstractTest.UPDATE_DATE);
        user.setLoggedIn(AbstractTest.LOGGED_IN);
        return user;
    }

    public User getTestUser2() {
        User user = new User();
        user.setFirstName(UserServiceTest.FIRST_NAME_2);
        user.setMiddleName(UserServiceTest.MIDDLE_NAME_2);
        user.setLastName(UserServiceTest.LAST_NAME_2);
        user.setBirthDate(UserServiceTest.BIRTH_DATE_2);
        user.setEmail(UserServiceTest.EMAIL_2);
        user.setLogin(UserServiceTest.LOGIN_2);
        user.setPassword(UserServiceTest.PASSWORD_2);
        user.setRegisterDate(UserServiceTest.REGISTER_DATE_2);
        user.setUpdateDate(UserServiceTest.UPDATE_DATE_2);
        user.setLoggedIn(UserServiceTest.LOGGED_IN_2);
        return user;
    }
}
