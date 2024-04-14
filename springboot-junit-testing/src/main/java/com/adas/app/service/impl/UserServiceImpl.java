package com.adas.app.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adas.app.dao.UserRepository;
import com.adas.app.model.User;
import com.adas.app.service.UserService;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findById(int id) {
        Optional<User> user = userRepository.findById(id);
        return user.orElse(null);
    }

    @Override
    public User save(User user) {
        if (user.getId() != 0) {
            return null;
        }
        return userRepository.save(user);
    }

    @Override
    public User deleteById(int id) {
        User user = findById(id);
        if (user == null) {
            return null;
        }
        userRepository.deleteById(id);
        return user;
    }

    @Override
    public User update(User user) {
        User existingUser = findById(user.getId());
        if (existingUser == null) {
            return null;
        }
        return userRepository.save(user);
    }
}
