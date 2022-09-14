package com.mobai.manager.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mobai.manager.model.User;
import com.mobai.manager.model.UserVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface UserMapper extends BaseMapper<User> {

}
