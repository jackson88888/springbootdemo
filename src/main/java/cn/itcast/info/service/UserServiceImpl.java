package cn.itcast.info.service;

import cn.itcast.info.dao.UserDao;
import cn.itcast.info.dao.UserMapper;
import cn.itcast.info.pojo.User;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Autowired
    private UserMapper userMapper;

    /*@Cacheable：添加/使用缓存
    @CacheEvict：删除缓存
    参数value是缓存的名字，在执行的时候，会找叫这个名字的缓存使用/删除
    参数key默认情况下是空串””,是Spring的一种表达式语言SpEL，我们这里可以随意指定，但是需要注意一定要加单引号*/

    @Override
    @Cacheable(value = "userCache", key = "'user.findAll'") /*添加缓存注解*/
    public List findAll() {
        List list = this.userDao.findAll();
        return list;
    }
    @Autowired     /*redis深入使用*/
    private RedisTemplate redisTemplate;
    @Override
    @CacheEvict(value = "userCache", key = "'user.findAll'")/*删除缓存*/
    public List queryUserByName(String name) {

        // 保存数据
        this.redisTemplate.boundValueOps("redis").set("Hello redis !");
        // 设置有效时间为100秒
        this.redisTemplate.boundValueOps("redis").expire(100l, TimeUnit.SECONDS);
        // 给value每次执行加一操作
        this.redisTemplate.boundValueOps("count").increment(1l);
        System.out.println("缓存清理了！");

        List list = this.userMapper.queryUserByName(name);
        return list;
    }

    // 调用使用UserMapper.xml的Mapper
    @Override
    public List queryAll() {
        List list = this.userMapper.queryAll();
        return list;
    }

    // 使用通用Mapper和分页助手
    @Override
    public List queryUserByPage(Integer page, Integer rows) {
         // 设置分页
        PageHelper.startPage(page, rows);
         // 使用通用Mapper的方法进行查询所有数据
        List<User> list = this.userMapper.select(null);
        return list;
    }
}