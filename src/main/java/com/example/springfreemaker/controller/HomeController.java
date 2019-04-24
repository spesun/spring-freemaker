package com.example.springfreemaker.controller;

import com.alibaba.fastjson.JSON;
import com.example.springfreemaker.entity.User;
import com.example.springfreemaker.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    UserRepository userRepository;

    @RequestMapping(value = "/")
    public String index(){
        return "index";
    }

  /*  @RequestMapping(value = "/welcome")
    public ModelAndView home(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("welcome");
        modelAndView.addObject("name", "张三");
        return modelAndView;
    }*/

    @RequestMapping(value = "/login")
    public ModelAndView login(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");
        return modelAndView;
    }

    @RequestMapping(value = "/register")
    public ModelAndView register(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("register");
        return modelAndView;
    }

    @PostMapping(value = "/saveRegister")
    public ModelAndView saveRegister(User user){
        User user1 = userRepository.save(user);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");
        return modelAndView;
    }


    @PostMapping(value = "/checkLogin")
    public ModelAndView checkLogin(User user) {
        Example<User> example = Example.of(user);
        List<User> users = userRepository.findAll(example);
        if (CollectionUtils.isEmpty(users)) {
            //TODO 不能返回中文否则乱码
            throw new RuntimeException("login err");
        }

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("welcome");
        modelAndView.addObject(users.get(0));
        return modelAndView;
    }
}

