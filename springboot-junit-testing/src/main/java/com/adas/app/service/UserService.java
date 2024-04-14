package com.adas.app.service;

import java.util.List;

import com.adas.app.model.User;

public interface UserService {

    List<User> findAll();

    User findById(int id);

    User save(User user);

    User deleteById(int id);

    User update(User user);
}