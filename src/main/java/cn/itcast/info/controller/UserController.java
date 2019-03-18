package cn.itcast.info.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import cn.itcast.info.pojo.User;
import cn.itcast.info.service.UserService;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("list")
    public List queryUserAll() {
        List list = this.userService.findAll();
        return list;
    }

    @RequestMapping("list/{name}")
    public List queryUserAll(@PathVariable String name) {
        List list = this.userService.queryUserByName(name);
        return list;
    }

    @RequestMapping("list/query")
    public List queryUserAll2() {
        List list = this.userService.queryAll();
        return list;
    }

    @RequestMapping("list/{page}/{rows}")
    public List queryUserAll(@PathVariable Integer page, @PathVariable Integer rows) {
        List list = this.userService.queryUserByPage(page, rows);
        return list;
    }
}