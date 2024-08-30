package com.zhangyu.mapper;

import com.zhangyu.enums.UserSexEnum;
import com.zhangyu.model.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

//如果启动文件加了@MapperScan("com.zhangyu.mapper")这里就不用加@Mapper了
//@Mapper
public interface UserMapper {
//    明确的标识把数据库中的user_sex字段映射到代码中的userSex字段上，当然如果你定义的一样就不需要写Results进行映射了，但是有了更清楚
    @Select("SELECT * FROM users")
    @Results({
            @Result(property = "userSex",  column = "user_sex", javaType = UserSexEnum.class),
            @Result(property = "nickName", column = "nick_name")
    })
    List<User> getAll();

    @Select("SELECT * FROM users WHERE id = #{id}")
    @Results({
            @Result(property = "userSex",  column = "user_sex", javaType = UserSexEnum.class),
            @Result(property = "nickName", column = "nick_name")
    })
    User getOne(Long id);

    @Insert("INSERT INTO users(userName,passWord,user_sex) VALUES(#{userName}, #{passWord}, #{userSex})")
    void insert(User user);

    @Update("UPDATE users SET userName=#{userName},nick_name=#{nickName} WHERE id =#{id}")
    void update(User user);

    @Delete("DELETE FROM users WHERE id =#{id}")
    void delete(Long id);

}
