package com.example.wishsystem.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.wishsystem.entity.SystemConfig;
import com.example.wishsystem.service.SystemConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;
import java.util.HashMap;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private SystemConfigService configService;


    @PostMapping("/verify")
    public Map<String,Object> verify(@RequestBody Map<String,String> body){
        String inputPwd = body.get("adminPwd");
        LambdaQueryWrapper<SystemConfig> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(SystemConfig::getConfigKey,"admin_pwd");
        SystemConfig cfg = configService.getOne(wrapper);
        Map<String,Object> res = new HashMap<>();
        if(cfg != null && cfg.getConfigValue().equals(inputPwd)){
            res.put("code",200);
            res.put("msg","验证通过");
        }else{
            res.put("code",500);
            res.put("msg","管理员密码错误");
        }
        return res;
    }
}
