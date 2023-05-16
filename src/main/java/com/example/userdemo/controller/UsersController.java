package com.example.userdemo.controller;

import com.example.userdemo.model.dto.UserDetailVoRequest;
import com.example.userdemo.model.entity.Users;
import com.example.userdemo.model.service.JwtService;
import com.example.userdemo.model.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UsersController {

    @Autowired
    JwtService jwtService;

    @Autowired
    private UserServiceImpl userService;


    // 搜尋所有users
    @GetMapping("/selectallusers")
    @ResponseBody
    public List<Users> selectAllUsers() {
        return userService.selectAll();
    }

    // 依id來搜尋單筆產品
    @GetMapping("/selectbyid/{id}")
    @ResponseBody
    public Users selectByid(@PathVariable int id) {
        return userService.selectById(id);
    }


    // 依id來調整權限
    @PutMapping("/updateaccountlocked/{id}")
    @ResponseBody
    public String updateaccountlocked(@PathVariable int id, Boolean accountlocked) {

        userService.updateaccountlocked(id, accountlocked);
        return "更新成功!";
    }

    // 依Pdid來修改單筆產品
    @PutMapping("/updateByPdid")
    @ResponseBody
    public String updateByPdid(@RequestBody UserDetailVoRequest users) {
        userService.updateById(users);
        return "修改成功!";
    }
}