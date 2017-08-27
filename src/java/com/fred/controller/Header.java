package com.fred.controller;

import com.fred.service.UserController;
import com.fred.service.UserServicesStandard;
import com.fred.mock.MockUserService;
import com.fred.view.MainWindow;

/**
 * Created by myasnikov
 * on 26.07.2017.
 */
public class Header {
    private UserController userController;
    public Header() {
        new UserServicesStandard(new MockUserService());
        this.userController = new UserController();
    }
    public void running() {
        MainWindow.run();
    }

    public UserController getUserController() {
        return userController;
    }

    public void setUserController(UserController userController) {
        this.userController = userController;
    }
}
