package com.arka.proyecto.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.arka.proyecto.model.User;
import com.arka.proyecto.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public User updateUser(Long id, User user) {
        Optional<User> userExist = userRepository.findById(id);
        if(userExist.isPresent()) {
            user.setId(id);
            return userRepository.save(user);
        } else {
            return null;
        }
            
    }

    public boolean deleteUser(Long id) {
        Optional<User> userExist = userRepository.findById(id);
        if(userExist.isPresent()) {
            userRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    public List<User> getUsersByName(String name) {
        return userRepository.findByName(name);
    }

    public List<User> getAllUsersSortedByName() {
        return userRepository.findAllByOrderByNameAsc();
    }

}
