package cn.itcast.info.service;

import java.util.List;

import cn.itcast.info.pojo.User;

public interface UserService {
    List findAll();

    List queryUserByName(String name);

    // 调用使用UserMapper.xml的Mapper
    List queryAll();

    // 使用通用Mapper和分页助手
    List queryUserByPage(Integer page, Integer rows);
}
