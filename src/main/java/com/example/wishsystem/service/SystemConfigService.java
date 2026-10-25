package com.example.wishsystem.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.wishsystem.entity.SystemConfig;
import com.example.wishsystem.mapper.SystemConfigMapper;
import org.springframework.stereotype.Service;

@Service
public class SystemConfigService extends ServiceImpl<SystemConfigMapper, SystemConfig> {
}
