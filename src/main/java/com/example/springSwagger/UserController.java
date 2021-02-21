package com.example.springSwagger;

import org.springframework.web.bind.annotation.*;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

@RestController
@RequestMapping("/api")
public class UserController
{
    ConcurrentMap<String,User> userr=new ConcurrentHashMap<>();

    @PostMapping(value = "/")
    public User addUser(@RequestBody User user)
    {
        userr.put(String.valueOf(user.getId()),user);
        return user;
    }

    @GetMapping(value="/")
    public List<User> getDetails()
    {
        return new ArrayList<User>(userr.values());
    }

    @GetMapping(value = "/{id}")
    public User getUser(@PathVariable String id){
        return userr.get(id);
    }
}
