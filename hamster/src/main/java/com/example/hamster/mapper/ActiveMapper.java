package com.example.hamster.mapper;

import com.example.hamster.entity.Active;
import com.example.hamster.entity.ActiveExample;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface ActiveMapper {
    long countByExample(ActiveExample example);

    int deleteByExample(ActiveExample example);

    int deleteByPrimaryKey(Integer activeId);

    int insert(Active record);

    int insertSelective(Active record);

    List<Active> selectByExample(ActiveExample example);

    Active selectByPrimaryKey(Integer activeId);

    int updateByExampleSelective(@Param("record") Active record, @Param("example") ActiveExample example);

    int updateByExample(@Param("record") Active record, @Param("example") ActiveExample example);

    int updateByPrimaryKeySelective(Active record);

    int updateByPrimaryKey(Active record);

    @Select("select * from active where insert_date_time BETWEEN #{startTime} AND #{endTime}  and hamster_id =#{hamsterId} order by insert_date_time desc")
   	public List<Active> selectLapCountByDate(@Param("hamsterId") int hamsterId, @Param("startTime") Date startTime, @Param("endTime") Date endTime);

    @Select("select * from active where hamster_id =#{hamsterId} order by lap_count desc limit 1")
   	public Active selectMapLapCount(@Param("hamsterId") int hamsterId);

   	public List<Map<String, Object>> selectLapCountByMonth(int id);

   	public List<Map<String, Object>> selectLapCountByDay(int id);

   	public List<Map<String, Object>> selectScatterByHour();
}