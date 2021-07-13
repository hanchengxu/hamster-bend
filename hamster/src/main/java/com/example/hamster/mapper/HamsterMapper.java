package com.example.hamster.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.example.hamster.entity.Hamster;

@Mapper
public interface HamsterMapper {

    @Select("select * from hamster where hamster_id = #{id}")
    Hamster findById(@Param("id") int id);

    Hamster findByIdXML(int id);
}
