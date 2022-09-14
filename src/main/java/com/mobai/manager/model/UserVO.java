package com.mobai.manager.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * User View Object
 *
 * @author li.nan
 * @date 2022/9/13
 */
@Setter
@Getter
public class UserVO {

    private List<UserBO> users;

}
