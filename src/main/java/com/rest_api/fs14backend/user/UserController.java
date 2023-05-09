package com.rest_api.fs14backend.user;


import com.rest_api.fs14backend.artist.Artist;
import com.rest_api.fs14backend.artist.ArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public HashMap<String,Object> getAllUsers()
    {
        HashMap<String,Object> response = new HashMap<String,Object>();
        List<User> users = userService.getUsers();
        response.put("users",users);
        return response;
    }

    @PostMapping(value="/",consumes = {"application/json"})
    public HashMap<String,Object> createUser(@RequestBody User newUser)
    {
        User createdUser = userService.createUser(newUser);
        HashMap<String,Object> response = new HashMap<String,Object>();
        response.put("message",String.format("successfull created user %s",createdUser.getEmail()));
        response.put("user",createdUser);
        return response;
    }
}
