package com.mobai.manager.common;

import java.io.Serializable;

/**
 * 返回接口封装
 *
 * @author li.nan
 * @date 2022/9/13
 */
public class BaseResponse<T> implements Serializable {
    private static final long serialVersionUID = 201681369074346323L;

    private boolean success = true;

    /**
     * 返回消息
     */
    private String message = "";

    /**
     * 返回CODE
     */
    private int statusCode;

    /**
     * 返回结果封装
     */
    private T data;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    /**
     * 成功结果集
     */
    public static <T> BaseResponse<T> resultSuccess(T t) {
        BaseResponse<T> result = new BaseResponse<T>();
        result.setSuccess(true);
        result.setStatusCode(200);
        result.setData(t);
        return result;
    }

    /**
     * 成功结果集,并返回消息提示
     */
    public static <T> BaseResponse<T> resultSuccess(T t, String message) {
        BaseResponse<T> result = new BaseResponse<T>();
        result.setSuccess(true);
        result.setStatusCode(200);
        result.setData(t);
        result.setMessage(message);
        return result;
    }

    /**
     * 失败结果集
     */
    public static <T> BaseResponse<T> resultError(String errMsg) {
        BaseResponse<T> result = new BaseResponse<T>();
        result.setSuccess(false);
        result.setStatusCode(500);
        result.setMessage(errMsg);
        return result;
    }
}
