package com.example.hamster.mapper;

import com.example.hamster.entity.HeaterTemperature;
import com.example.hamster.entity.HeaterTemperatureExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface HeaterTemperatureMapper {
    long countByExample(HeaterTemperatureExample example);

    int deleteByExample(HeaterTemperatureExample example);

    int insert(HeaterTemperature record);

    int insertSelective(HeaterTemperature record);

    List<HeaterTemperature> selectByExample(HeaterTemperatureExample example);

    int updateByExampleSelective(@Param("record") HeaterTemperature record, @Param("example") HeaterTemperatureExample example);

    int updateByExample(@Param("record") HeaterTemperature record, @Param("example") HeaterTemperatureExample example);
}