package com.example.hamster.mapper;

import com.example.hamster.entity.AutoFeed;
import com.example.hamster.entity.AutoFeedExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AutoFeedMapper {
    long countByExample(AutoFeedExample example);

    int deleteByExample(AutoFeedExample example);

    int insert(AutoFeed record);

    int insertSelective(AutoFeed record);

    List<AutoFeed> selectByExample(AutoFeedExample example);

    int updateByExampleSelective(@Param("record") AutoFeed record, @Param("example") AutoFeedExample example);

    int updateByExample(@Param("record") AutoFeed record, @Param("example") AutoFeedExample example);
}