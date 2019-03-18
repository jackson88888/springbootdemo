package cn.itcast.info.pojo;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity  /*reids步实现序列化*/
public class User implements Serializable {
@Id
private Long id;
private String userName;
private String password;
private String name;
//添加 get 和set方法

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
