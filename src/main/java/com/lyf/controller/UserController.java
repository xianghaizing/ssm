package com.lyf.controller;

import com.github.pagehelper.PageInfo;
import com.lyf.base.BaseController;
import com.lyf.base.BaseQuery;
import com.lyf.exception.ParamsException;
import com.lyf.po.User;
import com.lyf.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by xlf on 2019/7/12.
 */
@Controller
@RequestMapping("user")
public class UserController extends BaseController{

    @Autowired
    private UserService userService;

    @RequestMapping("addUser")
    @ResponseBody
    public String addUser(User user) throws Exception {
        userService.insert(user);
        return "添加成功";
    }

    @RequestMapping("delUser")
    @ResponseBody
    public String delUser(Integer id) throws Exception {
        userService.delete(id);
        return "删除成功";
    }

    @RequestMapping("updateUser")
    @ResponseBody
    public String updateUser(User user) throws Exception {
        userService.update(user);
        return "更新成功";
    }

    @RequestMapping("queryUserList")
    @ResponseBody
    public PageInfo<User> queryUserList(BaseQuery query) throws Exception {
        return userService.queryForPage(query);
    }

    @RequestMapping("queryUserById/{id}")
    @ResponseBody
    public User queryUserById(@PathVariable Integer id ) throws Exception {
       return userService.queryById(id);
    }

}
