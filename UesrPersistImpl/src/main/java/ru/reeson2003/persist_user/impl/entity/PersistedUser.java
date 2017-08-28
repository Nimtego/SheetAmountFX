package ru.reeson2003.persist_user.impl.entity;

import ru.reeson2003.persist_user.api.domain.User;
import javax.persistence.*;
import java.util.Date;

/**
 * Date: 27.08.2017.
 * Time: 18:06.
 *
 * @author Pavel Gavrilov.
 */
@Entity
@Table(name = "user")
@Access(AccessType.PROPERTY)
public class PersistedUser extends User {
    public PersistedUser() {
        super();
    }

    public PersistedUser(User user) {
        this.setId(user.getId());
        this.setFirstName(user.getFirstName());
        this.setMiddleName(user.getMiddleName());
        this.setLastName(user.getLastName());
        this.setBirthDate(user.getBirthDate());
        this.setEmail(user.getEmail());
        this.setLogin(user.getLogin());
        this.setPassword(user.getPassword());
        this.setRegisterDate(user.getRegisterDate());
        this.setUpdateDate(user.getUpdateDate());
        this.setLoggedIn(user.isLoggedIn());
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    @Override
    public long getId() {
        return super.getId();
    }

    @Override
    public void setId(long id) {
        super.setId(id);
    }

    @Column(name = "first_name")
    @Override
    public String getFirstName() {
        return super.getFirstName();
    }

    @Override
    public void setFirstName(String firstName) {
        super.setFirstName(firstName);
    }

    @Column(name = "middle_name")
    @Override
    public String getMiddleName() {
        return super.getMiddleName();
    }

    @Override
    public void setMiddleName(String middleName) {
        super.setMiddleName(middleName);
    }

    @Column(name = "last_name")
    @Override
    public String getLastName() {
        return super.getLastName();
    }

    @Override
    public void setLastName(String lastName) {
        super.setLastName(lastName);
    }

    @Column(name = "birth_date")
    @Override
    public Date getBirthDate() {
        return super.getBirthDate();
    }

    @Override
    public void setBirthDate(Date birthDate) {
        super.setBirthDate(birthDate);
    }

    @Column(name = "email", nullable = false, unique = true)
    @Override
    public String getEmail() {
        return super.getEmail();
    }

    @Override
    public void setEmail(String email) {
        super.setEmail(email);
    }

    @Column(name = "login", nullable = false, unique = true)
    @Override
    public String getLogin() {
        return super.getLogin();
    }

    @Override
    public void setLogin(String login) {
        super.setLogin(login);
    }

    @Column(name = "password", nullable = false)
    @Override
    public String getPassword() {
        return super.getPassword();
    }

    @Override
    public void setPassword(String password) {
        super.setPassword(password);
    }

    @Column(name = "register_date")
    @Override
    public Date getRegisterDate() {
        return super.getRegisterDate();
    }

    @Override
    public void setRegisterDate(Date registerDate) {
        super.setRegisterDate(registerDate);
    }

    @Column(name = "update_date")
    @Override
    public Date getUpdateDate() {
        return super.getUpdateDate();
    }

    @Override
    public void setUpdateDate(Date updateDate) {
        super.setUpdateDate(updateDate);
    }

    @Column(name = "logged_in")
    @Override
    public boolean isLoggedIn() {
        return super.isLoggedIn();
    }

    @Override
    public void setLoggedIn(boolean loggedIn) {
        super.setLoggedIn(loggedIn);
    }
}
