package com.example.wishsystem.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.wishsystem.entity.StudentWish;
import com.example.wishsystem.mapper.StudentWishMapper;
import org.springframework.stereotype.Service;

@Service
public class StudentWishService extends ServiceImpl<StudentWishMapper, StudentWish> {
}
