package com.example.hamster.mapper;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.example.hamster.entity.Active;

@Mapper
public interface ActiveMapper {

    @Insert("insert into active(hamster_id,lap_count,insert_date_time,insert_user) "
            + "values(#{hamster_id},#{lap_count},#{insert_date_time},#{insert_user})")
    @Options(useGeneratedKeys = true, keyColumn = "active_id", keyProperty = "active_id")
     public void insertOne(Active active);

	@Select("select * from active where insert_date_time BETWEEN #{startTime} AND #{endTime}  and hamster_id =#{hamsterId} order by insert_date_time desc")
	public List<Active> selectLapCountByDate(@Param("hamsterId") int hamsterId, @Param("startTime") Date startTime, @Param("endTime") Date endTime);

	@Select("select * from active where  hamster_id =#{hamsterId} order by lap_count desc limit 1")
	public Active selectMapLapCount(@Param("hamsterId") int hamsterId);

	public List<Map<String, Object>> selectLapCountByMonth(int id);

	public List<Map<String, Object>> selectLapCountByDay(int id);

	public List<Map<String, Object>> selectScatterByHour();
}
