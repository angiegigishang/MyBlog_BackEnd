package com.lyf.common.mapper;

import com.lyf.common.entity.LfyUsrLgn;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface LoginMapper {

    void insert(LfyUsrLgn login);

    void logout(String lfyUsrNbr);

    @ResultMap("loginResultMap")
    @Select("select * from lyf_usr_lgn where LFY_USR_NBR = #{lfyUsrNbr} and LFY_LGN_STS = 'A'")
    LfyUsrLgn select(String lfyUsrNbr);

    @Select("select LFY_USR_NBR from lyf_usr_lgn where LFY_LGN_TOK = #{token} and LFY_LGN_STS = 'A'")
    String selectByToken(String token);

}
