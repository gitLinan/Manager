package com.mobai.manager.common;

import com.mobai.manager.exception.MaExpetion;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局自定义异常捕获
 *
 * @author li.nan
 * @date 2022/9/13
 */
@RestControllerAdvice
@Slf4j
public class GlobExceptionHandle {
    @ExceptionHandler(MaExpetion.class)
    public BaseResponse handleOctopusException(MaExpetion e) {
        log.error("调用的全局拦截器" + e.getMessage());
        BaseResponse<Object> baseResponse = new BaseResponse<>();
        baseResponse.setStatusCode(409);
        baseResponse.setMessage("自定义异常消息");
        return baseResponse;
    }
}