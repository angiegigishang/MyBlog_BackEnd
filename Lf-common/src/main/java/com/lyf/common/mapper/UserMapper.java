package com.lyf.common.mapper;

import com.lyf.common.entity.LfyUsrDo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface UserMapper {

    @Select("select * from LFY_USR_INF")
    List<Map<String, Object>> getList();

}
