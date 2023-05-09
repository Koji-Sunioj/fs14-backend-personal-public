package com.rest_api.fs14backend.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public List<User> getUsers()
    {
        return userRepository.findAll();
    }

    public User getUser(UUID userId)
    {
        return userRepository.findById(userId).orElse(null);
    }

    public User createUser(User newUser)
    {
        return userRepository.save(newUser);
    }
}
