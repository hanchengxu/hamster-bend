package com.example.hamster.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.hamster.entity.AttendanceMaster;

public interface AttendanceMasterMapper {



	@Insert("INSERT INTO public.attendance_master(item_name,item_value,item_desc) "
			+ "VALUES(#{master.itemName},#{master.itemValue},#{master.itemDesc})")
	int insertMaster(@Param("master") AttendanceMaster master);


	@Update("UPDATE public.attendance_master "
			+ "SET item_value = #{master.itemValue} ,item_desc = #{master.itemDesc},update_datetime = #{master.updateDatetime} "
			+ "where item_name = #{master.itemName}")
	int updateMaster(@Param("master") AttendanceMaster master);

	@Delete("DELETE FROM public.attendance_master " +
			"WHERE item_name=#{master.itemName} " )
	int deleteMaster(@Param("master") AttendanceMaster master);

	@Select("SELECT * from public.attendance_master order by id")
	List<AttendanceMaster> selectAllMaster();

	@Select("SELECT * from public.attendance_master where item_name = #{itemName}")
	AttendanceMaster selectMasterByItemName(@Param("itemName") String itemName);
}
