package com.lyf.service;

import com.lyf.base.BaseService;
import com.lyf.dao.UserMapper;
import com.lyf.po.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by xlf on 2019/7/12.
 */
@Service
public class UserService extends BaseService<User> {
    @Autowired
    private UserMapper userMapper;
}
