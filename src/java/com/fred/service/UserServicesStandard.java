package com.fred.service;

import ru.reeson2003.persist_user.api.service.UserService;
import ru.reeson2003.persist_user.api.service.UserServices;

/**
 * Created by nimtego_loc on 27.08.2017.
 */
public class UserServicesStandard extends UserServices {
    public UserServicesStandard(UserService userService) {
        setService(userService);
    }
}
