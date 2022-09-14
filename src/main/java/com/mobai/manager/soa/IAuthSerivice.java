package com.mobai.manager.soa;

import com.mobai.manager.common.BaseResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

/**
 * Feign客户端其他微服务
 *
 * @author li.nan
 * @date 2022/9/13
 */

@FeignClient(name = "Auth")
public interface IAuthSerivice {

    //demo
    @RequestMapping(value = "/oauth/api/check", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    BaseResponse check(@RequestBody Map map);
}
