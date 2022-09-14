package com.mobai.manager;

import com.mobai.manager.service.UserService;
import javafx.application.Application;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void getUserByIdTest() {
        userService.getUserById(1);
        Assert.assertTrue(true);
    }

    @Test
    public void getUserByUniqueIdTest() {

    }

    @Test
    public void getUserListTest() {

    }

    @Test
    public void createUserTest() {

    }

    @Test
    public void deleteUserTest() {

    }

    @Test
    public void updateUserTest() {

    }
}

