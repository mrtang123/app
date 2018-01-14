package com.example.dto;

import lombok.Data;
import lombok.Setter;

@Data
public class AppDto {
    private long id;
    private Long updateTime;
    private Long insertTime;
    private String content;
}
