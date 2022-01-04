package com.example.springfreemaker.controller;

import com.example.springfreemaker.entity.User;
import com.example.springfreemaker.model.SwaggerResultData;
import com.example.springfreemaker.repository.UserRepository;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController()
@RequestMapping(value = "/user")
@Api("用户测试")
public class UserController {


    @Autowired
    UserRepository userRepository;

    public static String SUC = "success";


    @ApiOperation(value = "保存", notes = "保存的notes")
    @PostMapping("/save")
    public String save(@RequestBody User user) {
        userRepository.save(user);
        return SUC;
    }

    @ApiOperation("查询")
    @GetMapping("/get")
    public User save(Long id) {
        return userRepository.findById(id).get();
    }

    @ApiOperation("批量查询")
    @GetMapping("/selectList")
    public SwaggerResultData<List<User>> selectList() {
        return SwaggerResultData.createSuccess(userRepository.findAll());
    }


    @ApiOperation("根据名称查询")
    @ApiImplicitParam(paramType="query", name = "name", value = "用户名", required = true, dataType = "String")
/*  或 @ApiImplicitParams({
        @ApiImplicitParam(paramType="query", name = "name", value = "用户名", required = true, dataType = "String"),
    })*/
    @ApiResponse(code = 200, message = "ok", response = SwaggerResultData.class)
    @GetMapping("/findName")
    public SwaggerResultData<List<User>> findName(String name) {
        return SwaggerResultData.createSuccess(userRepository.findName(name));
    }

    @ApiOperation("根据名称查询,jpa自动生成代码")
    @GetMapping("/findByName")
    public List<User> findByName(String name) {
        return userRepository.findByName(name);
    }

    @ApiOperation("根据名称查询,自定义sql文")
    @GetMapping("/findNameNative")
    public List<User> findNameNative(String name) {
        return userRepository.findNameNative(name);
    }

    @ApiOperation("调用findOne方法")
    @GetMapping("/findOne")
    @ApiResponse(code = 1, message = "ok", response = SwaggerResultData.class)
    public User findOne(Long id) {
        User user = new User();
        user.setId(id);
        Example<User> userExample = Example.of(user);
        return userRepository.findOne(userExample).orElse(new User());
    }
}
