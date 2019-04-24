package com.example.springfreemaker.controller;

import com.example.springfreemaker.entity.User;
import com.example.springfreemaker.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController()
@RequestMapping(value = "/user")
public class UserController {


    @Autowired
    UserRepository userRepository;

    public static String SUC = "success";


    @PostMapping("/save")
    public String save(@RequestBody User user) {
        userRepository.save(user);
        return SUC;
    }

    @GetMapping("/get")
    public User save(Long id) {
        return userRepository.findById(id).get();
    }

    @GetMapping("/findName")
    public List<User> findName(String name) {
        return userRepository.findName(name);
    }

    @GetMapping("/findByName")
    public List<User> findByName(String name) {
        return userRepository.findByName(name);
    }

    @GetMapping("/findNameNative")
    public List<User> findNameNative(String name) {
        return userRepository.findNameNative(name);
    }

    @GetMapping("/findOne")
    public User findOne(Long id) {
        User user = new User();
        user.setId(id);
        Example<User> userExample = Example.of(user);
        return userRepository.findOne(userExample).orElse(new User());
    }
}
