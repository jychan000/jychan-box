package com.jychan.box.springboot.example.persistence.dbjychan;

import com.jychan.box.springboot.example.domain.User;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author Raymond
 * @version 15/12/7 13:04
 * @E-mail:415683089@qq.com
 */
@Component
public interface UserMapper {

    final String SELECT_BY_ID = "select * from user where id = #{id}";
    final String SELECT_ALL = "select * from user ";

    @Select(SELECT_BY_ID)
    public User findById(int id);


    @Select(SELECT_ALL)
    @Results(value = {
            @Result(property = "id", column = "id"),
            @Result(property = "name", column = "name"),
            @Result(property = "age", column = "age")
    })
    public List<User> findAll();
}
