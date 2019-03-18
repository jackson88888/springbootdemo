package cn.itcast.info.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import cn.itcast.info.pojo.User;

/*注意JpaRepository后面的对象和主键类型必须声明否则会报对象无法识别问题 使用spring data jdbc*/
public interface UserDao extends JpaRepository<User,Long> {

}