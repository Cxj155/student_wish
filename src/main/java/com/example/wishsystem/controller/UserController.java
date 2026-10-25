package com.example.wishsystem.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.wishsystem.entity.StudentUser;
import com.example.wishsystem.service.StudentUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired

    private StudentUserService userService;

    @PostMapping("/register")
    public Map<String,Object> register(@RequestBody StudentUser user){
        LambdaQueryWrapper<StudentUser> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(StudentUser::getUsername,user.getUsername());
        StudentUser exist = userService.getOne(wrapper);
        Map<String,Object> res = new HashMap<>();
        if(exist != null){
            res.put("code",500);
            res.put("msg","账号已存在");
            return res;
        }
        boolean ok = userService.save(user);
        if(ok){
            res.put("code",200);
            res.put("msg","注册成功");
        }else{
            res.put("code",500);
            res.put("msg","注册失败");
        }
        return res;
    }

    @PostMapping("/login")
    public Map<String,Object> login(@RequestBody StudentUser user){
        LambdaQueryWrapper<StudentUser> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(StudentUser::getUsername,user.getUsername())
                .eq(StudentUser::getPassword,user.getPassword());
        StudentUser one = userService.getOne(wrapper);
        Map<String,Object> res = new HashMap<>();
        if(one != null){
            res.put("code",200);
            res.put("msg","登录成功");
        }else{
            res.put("code",500);
            res.put("msg","账号或密码错误");
        }
        return res;
    }
}
