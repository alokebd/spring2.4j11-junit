package com.adas.app.initializer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.adas.app.model.User;
import com.adas.app.service.UserService;

@Component
public class UserInitializer implements CommandLineRunner {

    @Autowired
    private UserService userService;

    @Autowired
    private UserConfig userConfig;

    @Override
    public void run(String... args) {
        userConfig.getData().forEach((alias, name) -> {
            User user = new User();
            user.setAlias(alias);
            user.setName(name);
            userService.save(user);
        });
    }
}
