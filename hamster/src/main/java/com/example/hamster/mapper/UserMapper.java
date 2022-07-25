package com.example.hamster.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.example.hamster.entity.User;

@Mapper
public interface UserMapper {

	@Select("select * from users where username = #{userName}")
    User findByUserName(@Param("userName") String userName);
}
