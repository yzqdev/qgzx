package com.qgzx.dto;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import lombok.Data;


/**
 * @author yanni
 */
@Data
public class Result<T> {
    /**
     * 请求是否成功（这个字段不需要，可以不加）
     */
    private boolean success;
    /**
     * 成功或者失败的code错误码
     */
    private T data;
    /**
     * 请求失败返回的提示信息，给前端进行页面展示的信息
     */
    private Object msg;
    /**
     * 服务器当前时间（添加该字段的原因是便于查找定位请求时间，因为实际开发过程中服务器时间可能跟本地时间不一致，加上这个时间戳便于日后定位）
     */
    private DateTime currentTime;

    public Result() {
        super();
        this.currentTime = DateUtil.date(System.currentTimeMillis());
    }


    public Result(String msg, T data) {
        super();
        this.msg = msg;
        this.data = data;
        this.currentTime = DateUtil.date(System.currentTimeMillis());
    }

    /**
     * 统一返回Rest风格的数据结构
     *
     * @param success 是否成功
     * @param data    返回数据
     * @param msg     返回错误信息
     * @author yzq
     * Created on 2018/9/22-21:47.
     */
    public Result(boolean success,  String msg, T data) {
        super();
        this.success = success;
        this.data = data;
        this.msg = msg;
        this.currentTime = DateUtil.date(System.currentTimeMillis());
    }

    @Override
    public String toString() {
        return "Result{" +
                "success=" + success +
                ", data=" + data +
                ", msg=" + msg +
                ", currentTime=" + currentTime +
                '}';
    }
}