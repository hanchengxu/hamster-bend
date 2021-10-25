package com.example.hamster.mapper;

import com.example.hamster.entity.CaseHumidity;
import com.example.hamster.entity.CaseHumidityExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CaseHumidityMapper {
    long countByExample(CaseHumidityExample example);

    int deleteByExample(CaseHumidityExample example);

    int insert(CaseHumidity record);

    int insertSelective(CaseHumidity record);

    List<CaseHumidity> selectByExample(CaseHumidityExample example);

    int updateByExampleSelective(@Param("record") CaseHumidity record, @Param("example") CaseHumidityExample example);

    int updateByExample(@Param("record") CaseHumidity record, @Param("example") CaseHumidityExample example);
}