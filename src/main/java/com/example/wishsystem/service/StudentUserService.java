package com.example.wishsystem.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.wishsystem.entity.StudentUser;
import com.example.wishsystem.mapper.StudentUserMapper;
import org.springframework.stereotype.Service;

@Service
public class StudentUserService extends ServiceImpl<StudentUserMapper, StudentUser> {
}
