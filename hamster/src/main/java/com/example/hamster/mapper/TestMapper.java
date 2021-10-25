package com.example.hamster.mapper;

import com.example.hamster.entity.Test;
import com.example.hamster.entity.TestExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TestMapper {
    long countByExample(TestExample example);

    int deleteByExample(TestExample example);

    int deleteByPrimaryKey(Integer activeId);

    int insert(Test record);

    int insertSelective(Test record);

    List<Test> selectByExample(TestExample example);

    Test selectByPrimaryKey(Integer activeId);

    int updateByExampleSelective(@Param("record") Test record, @Param("example") TestExample example);

    int updateByExample(@Param("record") Test record, @Param("example") TestExample example);

    int updateByPrimaryKeySelective(Test record);

    int updateByPrimaryKey(Test record);
}