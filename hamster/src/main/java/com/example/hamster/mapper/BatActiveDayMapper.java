package com.example.hamster.mapper;

import com.example.hamster.entity.BatActiveDay;
import com.example.hamster.entity.BatActiveDayExample;
import java.util.Date;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BatActiveDayMapper {
    long countByExample(BatActiveDayExample example);

    int deleteByExample(BatActiveDayExample example);

    int deleteByPrimaryKey(@Param("hamsterId") Short hamsterId, @Param("activeDate") Date activeDate);

    int insert(BatActiveDay record);

    int insertSelective(BatActiveDay record);

    List<BatActiveDay> selectByExample(BatActiveDayExample example);

    BatActiveDay selectByPrimaryKey(@Param("hamsterId") Short hamsterId, @Param("activeDate") Date activeDate);

    int updateByExampleSelective(@Param("record") BatActiveDay record, @Param("example") BatActiveDayExample example);

    int updateByExample(@Param("record") BatActiveDay record, @Param("example") BatActiveDayExample example);

    int updateByPrimaryKeySelective(BatActiveDay record);

    int updateByPrimaryKey(BatActiveDay record);
}