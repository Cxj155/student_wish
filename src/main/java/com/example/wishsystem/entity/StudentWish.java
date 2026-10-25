package com.example.wishsystem.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import java.time.LocalDateTime;

@Data
public class StudentWish {
    @TableId(type = IdType.AUTO)
    private Long id;
    private String studentNo;
    private String username;
    private String wishContent;
    private String aiClassifyResult;
    private LocalDateTime createTime;
}
