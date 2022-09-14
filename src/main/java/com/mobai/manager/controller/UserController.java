package com.mobai.manager.controller;


import com.mobai.manager.common.BaseResponse;
import com.mobai.manager.model.UserVO;
import com.mobai.manager.service.UserService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * User控制器
 *
 * @author li.nan
 * @date 2022/9/13
 */

//TODO
// * 优化点：
// * 1、开启AOP可以记录Access log
// * 2、结合SpringCloud Gateway和sentinel做限流规则

@RestController
@RequestMapping("manager/api/user")
@Slf4j
@RefreshScope
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/create")
    @ApiOperation("创建用户(组)")
    public BaseResponse createUser(@Validated @RequestBody UserVO userVO,
                                   @RequestParam(required = false) BindingResult result) throws Exception {
        //检查参数，校验手机号，邮箱格式
        List<FieldError> fieldErrors = result.getFieldErrors();
        if (!fieldErrors.isEmpty()) {
            return BaseResponse.resultError(fieldErrors.get(0).getDefaultMessage());
        }
        userService.createUser(userVO);
        return BaseResponse.resultSuccess(true);
    }

    @DeleteMapping("/delete")
    @ApiOperation("删除用户(列表)")
    public BaseResponse deleteUser(@RequestParam(name = "id") long[] ids) throws Exception {
        userService.deleteUser(ids);
        return BaseResponse.resultSuccess(true);
    }

    @PutMapping("/update")
    @ApiOperation("更新用户(组)")
    public BaseResponse updateUser(@Validated @RequestBody UserVO userVO,
                                   @RequestParam(required = false) BindingResult result) throws Exception {
        //检查参数，校验手机号，邮箱格式
        List<FieldError> fieldErrors = result.getFieldErrors();
        if (!fieldErrors.isEmpty()) {
            return BaseResponse.resultError(fieldErrors.get(0).getDefaultMessage());
        }
        userService.updateUser(userVO);
        return BaseResponse.resultSuccess(true);
    }


    @GetMapping("/get")
    @ApiOperation("通过主键id获取用户")
    public BaseResponse getUser(@RequestParam(name = "id") long id) {
        return BaseResponse.resultSuccess(userService.getUserById(id));
    }

    @GetMapping("/getUnique")
    @ApiOperation("通过UniqueId获取用户")
    public BaseResponse getUserByUnique(@RequestParam(name = "uniqueId") long uniqueId) {
        return BaseResponse.resultSuccess(userService.getUserByUniqueId(uniqueId));
    }

    //TODO 优化点：可以设计复杂的筛选用户接口及方法，demo目前显示全部
    @GetMapping("/list")
    @ApiOperation("获取用户列表")
    public BaseResponse getUserList() throws Exception {
        return BaseResponse.resultSuccess(userService.getUserList());
    }
}
