package com.example.hamster.mapper;

import com.example.hamster.entity.CaseTemperature;
import com.example.hamster.entity.CaseTemperatureExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CaseTemperatureMapper {
    long countByExample(CaseTemperatureExample example);

    int deleteByExample(CaseTemperatureExample example);

    int insert(CaseTemperature record);

    int insertSelective(CaseTemperature record);

    List<CaseTemperature> selectByExample(CaseTemperatureExample example);

    int updateByExampleSelective(@Param("record") CaseTemperature record, @Param("example") CaseTemperatureExample example);

    int updateByExample(@Param("record") CaseTemperature record, @Param("example") CaseTemperatureExample example);
}