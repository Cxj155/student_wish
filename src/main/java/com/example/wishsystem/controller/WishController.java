package com.example.wishsystem.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.wishsystem.entity.StudentWish;
import com.example.wishsystem.service.OllamaService;
import com.example.wishsystem.service.StudentWishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/wish")
public class WishController {
    @Autowired
    private StudentWishService wishService;
    @Autowired
    private OllamaService ollamaService;

    @PostMapping("/submit")
    public Map<String,Object> submit(@RequestBody StudentWish wish){
        String classify = ollamaService.classifyWish(wish.getWishContent());
        wish.setAiClassifyResult(classify);
        wishService.save(wish);
        Map<String,Object> res = new HashMap<>();
        res.put("code",200);
        res.put("msg","提交成功，AI分类完成");
        res.put("classify",classify);
        return res;
    }

    @GetMapping("/page")
    public Map<String,Object> page(@RequestParam(defaultValue = "1") Long pageNum){
        Page<StudentWish> page = new Page<>(pageNum,10);
        IPage<StudentWish> pageData = wishService.page(page);
        Map<String,Object> res = new HashMap<>();
        res.put("code",200);
        res.put("records",pageData.getRecords());
        res.put("total",pageData.getTotal());
        return res;
    }

    @DeleteMapping("/{id}")
    public Map<String,Object> del(@PathVariable Long id){
        wishService.removeById(id);
        Map<String,Object> res = new HashMap<>();
        res.put("code",200);
        res.put("msg","删除成功");
        return res;
    }
}
