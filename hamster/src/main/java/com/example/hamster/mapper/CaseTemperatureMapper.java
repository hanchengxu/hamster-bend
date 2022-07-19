package com.example.hamster.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.example.hamster.entity.CaseTemperature;
import com.example.hamster.entity.CaseTemperatureExample;

public interface CaseTemperatureMapper {
    long countByExample(CaseTemperatureExample example);

    int deleteByExample(CaseTemperatureExample example);

    int insert(CaseTemperature record);

    int insertSelective(CaseTemperature record);

    List<CaseTemperature> selectByExample(CaseTemperatureExample example);

    int updateByExampleSelective(@Param("record") CaseTemperature record, @Param("example") CaseTemperatureExample example);

    int updateByExample(@Param("record") CaseTemperature record, @Param("example") CaseTemperatureExample example);
    
    @Select("select "
    		+ "CAST(avg(temper.ct) as DECIMAL(18,1)) avg_temper "
    		+ "from "
    		+ "lap_count_dayly dayly_lap "
    		+ "left join "
    		+ "case_temperature temper "
    		+ "on "
    		+ "dayly_lap.hamster_id =temper.hamster_id "
    		+ "and "
    		+ "dayly_lap.target_date =temper.ct_time::date "
    		+ "where "
    		+ "dayly_lap.hamster_id =#{hamsterId} "
    		+ "group by dayly_lap.target_date "
    		+ "order by dayly_lap.target_date ")
    List<Float> getAvgTemperature(@Param("hamsterId") int hamsterId);
}