package com.zhangyu.config;

import lombok.Getter;
import lombok.Setter;

public class ApiResponse<T> {
    @Getter
    @Setter
    private int code;

    @Getter
    @Setter
    private T data;

    @Getter
    @Setter
    private String msg;

    public ApiResponse(int code, T data, String msg) {
        this.code = code;
        this.data = data;
        this.msg = msg;
    }

    public static <T> ApiResponse<T> success (T data) {
        return new ApiResponse<>(200, data, "成功");
    }

    public static <T> ApiResponse<T> fail (int code, String msg) {
        return new ApiResponse<>(code, null, msg);
    }
}
