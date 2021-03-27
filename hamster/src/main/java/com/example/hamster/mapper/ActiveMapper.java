package com.example.hamster.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;

import com.example.hamster.entity.Active;

@Mapper
public interface ActiveMapper {

    @Insert("insert into active(hamster_id,lap_count,insert_date_time,insert_user) "
            + "values(#{hamster_id},#{lap_count},#{insert_date_time},#{insert_user})")
    @Options(useGeneratedKeys = true, keyColumn = "active_id", keyProperty = "active_id")
     public void insertOne(Active active);
}
