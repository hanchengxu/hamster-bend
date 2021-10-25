package com.example.hamster.mapper;

import com.example.hamster.entity.Hamster;
import com.example.hamster.entity.HamsterExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface HamsterMapper {
    long countByExample(HamsterExample example);

    int deleteByExample(HamsterExample example);

    int deleteByPrimaryKey(Integer hamsterId);

    int insert(Hamster record);

    int insertSelective(Hamster record);

    List<Hamster> selectByExample(HamsterExample example);

    Hamster selectByPrimaryKey(Integer hamsterId);

    int updateByExampleSelective(@Param("record") Hamster record, @Param("example") HamsterExample example);

    int updateByExample(@Param("record") Hamster record, @Param("example") HamsterExample example);

    int updateByPrimaryKeySelective(Hamster record);

    int updateByPrimaryKey(Hamster record);
}