package com.mobai.manager.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mobai.manager.mapper.UserMapper;
import com.mobai.manager.model.MailPO;
import com.mobai.manager.model.User;
import com.mobai.manager.model.UserVO;
import com.mobai.manager.service.MailService;
import com.mobai.manager.service.UserService;
import com.mobai.manager.utils.SnowFlakeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * 实现类
 *
 * @author li.nan
 * @date 2022/9/13
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    private MailService mailService;

    @Override
    public User getUserById(long id) {
        return this.getById(id);
    }

    @Override
    public User getUserByUniqueId(long uniqueId) {
        return this.baseMapper.selectOne(new QueryWrapper<User>()
                .eq("unique_id", uniqueId));
    }

    @Override
    public List<User> getUserList() {
        return this.baseMapper.selectList(new QueryWrapper<User>());
    }

    @Override
    @Transactional
    public void createUser(UserVO userVO) throws Exception {
        List<User> userList = new ArrayList<>();
        userVO.getUsers().forEach(userBO -> {
            User user = new User();
            //TODO 如果分布式流量并发都特别大的情况可以把生成ID作为单独一个服务预生成ID来分配使用
            //雪花算法生成全局唯一用户ID（已解决时钟回拨问题）
            user.setUniqueId(SnowFlakeUtil.getDefaultSnowFlakeId());
            user.setName(userBO.getName());
            user.setPhone(userBO.getPhone());
            user.setEmail(userBO.getEmail());
            userList.add(user);
        });
        this.saveBatch(userList);

        userList.forEach(user -> {
            //发送邮件
            MailPO mailPO = new MailPO();
            mailPO.setSubject("注册通知");
            mailPO.setMessage(String.format("欢迎注册Manager,%s,请确认邮件信息！", user.getName()));
            mailPO.setTo(new String[]{user.getEmail()});
            mailService.SendMail(mailPO);
        });

    }

    @Override
    @Transactional
    public void deleteUser(long[] id) throws Exception {
        UpdateWrapper<User> updateWrapper = new UpdateWrapper<>();
        updateWrapper.set("delete", 1).in("id", id);
        this.baseMapper.update(null, updateWrapper);
    }


    //TODO 这里可以优化成批量SQL生成写入
    @Override
    @Transactional
    public void updateUser(UserVO userVO) throws Exception {
        userVO.getUsers().forEach(userBO -> {
            UpdateWrapper<User> updateWrapper = new UpdateWrapper<>();
            updateWrapper.eq("id", userBO.getId())
                    .set("name", userBO.getName())
                    .set("phone", userBO.getPhone())
                    .set("email", userBO.getEmail());
            this.baseMapper.update(null, updateWrapper);
        });
    }

}
