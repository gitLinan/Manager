package com.mobai.manager.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * User Business Object
 *
 * @author li.nan
 * @date 2022/9/13
 */
@Setter
@Getter
public class UserBO {
    private Long Id;

    private Long uniqueId;

    @NotNull(message = "用户名不能为空")
    private String name;

    @Pattern(regexp = "^1(3\\d|4[5-9]|5[0-35-9]|6[567]|7[0-8]|8\\d|9[0-35-9])\\d{8}$", message = "手机号格式不正确")
    private String phone;

    @Pattern(regexp = "^[A-Za-z0-9\\u4e00-\\u9fa5]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$", message = "邮箱格式不正确")
    private String email;
}
