package com.mobai.manager.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

/**
 * User实体对象
 *
 * @author li.nan
 * @date 2022/9/13
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value = "User", description = "用户表")
public class User {
    @ApiModelProperty(value = "主键id")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "user唯一id")
    private Long uniqueId;

    @ApiModelProperty(value = "用户昵称")
    private String name;

    @ApiModelProperty(value = "手机号")
    private String phone;

    @ApiModelProperty(value = "邮箱")
    private String email;

    @ApiModelProperty(value = "用户删除标记 0(FALSE)：用户启用 1(TRUE)：用户禁用 默认 0(FALSE)")
    private boolean delete;

    @ApiModelProperty(value = "用户创建时间")
    private LocalDateTime insert;

    @ApiModelProperty(value = "用户修改时间")
    private LocalDateTime update;

}
