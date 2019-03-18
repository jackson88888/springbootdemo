package cn.itcast.info.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import cn.itcast.info.pojo.User;
//extends com.github.abel533.mapper.Mapper:需要继承通用Mapper

/*mapper 泛型user要指定  因为有同名Mapper所以第二个要类全名com.github.abel533.mapper.Mapper指定*/
@Mapper
public interface UserMapper extends com.github.abel533.mapper.Mapper<User>{
    /*注意 list后面不注明user类型会报不支持操作异常*/
    @Select("select * from user where name like '%${value}%'")
    public List<User> queryUserByName(String name);
    // 使用UserMapper.xml配置文件  继承通用mapper
    public List queryAll();
}
