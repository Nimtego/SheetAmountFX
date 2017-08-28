package ru.reeson2003.persist_user.service;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.reeson2003.persist_user.api.UserPersistException;
import ru.reeson2003.persist_user.api.domain.User;

import java.util.List;


/**
 * Date: 26.08.2017.
 * Time: 18:13.
 *
 * @author Pavel Gavrilov.
 */
public class UserServiceTest extends AbstractTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceTest.class);

    @Test
    public void addUserTest() {
        User user = getTestUser();
        try {
            getUserService().addUser(user);
        } catch (UserPersistException e) {
            fail("User has not been added");
        }
        long id = user.getId();
        assertNotEquals(0, id);
        ID = id;
        LOGGER.info("AddUserTest ...PASS");
    }

    @Test
    public void getUserTest() {
        User user = getTestUser();
        try {
            getUserService().addUser(user);
        } catch (UserPersistException e) {
            fail("User has not been added");
        }
        long id = user.getId();
        assertNotEquals(0, id);
        ID = id;
        User persistedUser = null;
        try {
            persistedUser = getUserService().getUser(id);
        } catch (UserPersistException e) {
            fail("User has not been got");
        }
        assertNotNull("User is null", persistedUser);
        assertEquals(user, persistedUser);
        LOGGER.info("GetUserTest ...PASS");
    }

    @Test
    public void deleteUserTest() {
        User user = getTestUser();
        try {
            getUserService().addUser(user);
        } catch (UserPersistException e) {
            fail("User has not been added");
        }
        long id = user.getId();
        assertNotEquals(0, id);
        ID = id;
        User persistedUser = null;
        try {
            persistedUser = getUserService().getUser(id);
        } catch (UserPersistException e) {
            fail("User has not been got");
        }
        assertNotNull("User is null", persistedUser);
        try {
            getUserService().deleteUser(id);
        } catch (UserPersistException e) {
            fail("User has not been deleted");
        }
        try {
            persistedUser = getUserService().getUser(id);
        } catch (UserPersistException e) {
            assertNotNull(e);
            persistedUser = null;
        }
        assertNull(persistedUser);
        LOGGER.info("DeleteUserTest ...PASS");
    }

    @Test
    public void updateUserTest() {
        User user = getTestUser();
        try {
            getUserService().addUser(user);
        } catch (UserPersistException e) {
            fail("User has not been added");
        }
        long id = user.getId();
        assertNotEquals(0, id);
        ID = id;
        User persistedUser = null;
        try {
            persistedUser = getUserService().getUser(id);
        } catch (UserPersistException e) {
            fail("User has not been got");
        }
        assertNotNull("User is null", persistedUser);
        assertEquals(user, persistedUser);

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

        try {
            getUserService().updateUser(user);
        } catch (UserPersistException e) {
            fail("User has not been updated");
        }
        try {
            persistedUser = getUserService().getUser(id);
        } catch (UserPersistException e) {
            fail("User has not been got");
        }
        assertNotNull("User is null", persistedUser);
        assertEquals(user, persistedUser);
        LOGGER.info("UpdateUserTest ...PASS");
    }

    @Test
    public void findByLoginTest() {
        User user = getTestUser();
        try {
            getUserService().addUser(user);
        } catch (UserPersistException e) {
            fail("User has not been added");
        }
        String login = user.getLogin();
        User persistedUser = null;
        try {
            persistedUser = getUserService().findByLogin(login);
        } catch (UserPersistException e) {
            fail("User has not been got");
        }
        assertNotNull("User is null", persistedUser);
        assertEquals(user, persistedUser);
        LOGGER.info("GetUserTest ...PASS");
    }

    @Test
    public void getUserListTest() {
        User user = getTestUser();
        User user2 = getTestUser2();
        try {
            getUserService().addUser(user);
            getUserService().addUser(user2);
        } catch (UserPersistException e) {
            fail("User has not been added");
        }
        long id = user.getId();
        assertNotEquals(0, id);
        ID = id;
        long id2 = user2.getId();
        assertNotEquals(0, id2);
        ID_2 = id2;
        List<User> users = null;
        try {
            users= getUserService().getUsers();
        } catch (UserPersistException e) {
            fail("User list has not been got");
        }
        assertNotNull("User list is null", users);
        assertEquals(2, users.size());
        User persistedUser = null;
        User persistegUser2 = null;
        if (users.get(0).getId() == id) {
            persistedUser = users.get(0);
            persistegUser2 = users.get(1);
        } else {
            persistedUser = users.get(1);
            persistegUser2 = users.get(0);
        }
        assertNotNull(persistedUser);
        assertNotNull(persistegUser2);
        assertEquals(user, persistedUser);
        assertEquals(user2, persistegUser2);
        LOGGER.info("GetUserListTest ...PASS");
    }

    private void assertEquals(User u1, User u2) {
        if (u1.getId() != u2.getId() ||
                !u1.getFirstName().equals(u2.getFirstName()) ||
                !u1.getMiddleName().equals(u2.getMiddleName()) ||
                !u1.getLastName().equals(u2.getLastName()) ||
                !u1.getLogin().equals(u2.getLogin()) ||
                !u1.getPassword().equals(u2.getPassword()) ||
                !u1.getEmail().equals(u2.getEmail()) ||
                u1.isLoggedIn() != u2.isLoggedIn()
                )
            fail("Users is not equals");
    }

}
