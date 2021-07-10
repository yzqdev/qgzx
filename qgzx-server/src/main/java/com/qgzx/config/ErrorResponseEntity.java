package com.qgzx.config;

import lombok.Data;

@Data
public class ErrorResponseEntity {

    private int code;
    private String message;

    public ErrorResponseEntity(int value, String parmFailed) {
        System.out.println("发现错误");
    }
    // 省略 get set
}