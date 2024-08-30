package com.zhangyu.config;

import lombok.Data;

@Data
public class ApiResponse<T> {
    private int code;

    private T data;

    private String msg;

    private Boolean success;

    public ApiResponse(int code, T data, String msg, Boolean success) {
        this.code = code;
        this.data = data;
        this.msg = msg;
        this.success = success;
    }

    public static <T> ApiResponse<T> success (T data) {
        return new ApiResponse<>(200, data, "成功", true);
    }

    public static <T> ApiResponse<T> fail (int code, String msg) {
        return new ApiResponse<>(code, null, msg, false);
    }
}
