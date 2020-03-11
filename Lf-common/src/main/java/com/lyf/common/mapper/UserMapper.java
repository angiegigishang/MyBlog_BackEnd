package com.lyf.common.mapper;

import com.lyf.common.entity.LfyUsrDo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper {

    @ResultMap("userResultMap")
    @Select("select LFY_USR_NBR, LFY_USR_NAM, LFY_USR_ADR, LFY_USR_PHE, LFY_ADM_FLG from LFY_USR_INF")
    List<LfyUsrDo> getList();

    void addUser(LfyUsrDo usrDo);


}
