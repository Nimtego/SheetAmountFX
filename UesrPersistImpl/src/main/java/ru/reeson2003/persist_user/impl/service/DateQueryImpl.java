package ru.reeson2003.persist_user.impl.service;

import ru.reeson2003.persist_user.api.service.DateQuery;
import ru.reeson2003.persist_user.api.service.UserQuery;

import java.util.Date;

/**
 * Date: 26.08.2017.
 * Time: 18:09.
 *
 * @author Pavel Gavrilov.
 */
public class DateQueryImpl implements DateQuery {
    public UserQuery before(Date date) {
        return null;
    }

    public UserQuery after(Date date) {
        return null;
    }

    public UserQuery at(Date date) {
        return null;
    }
}
