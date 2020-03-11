package com.lyf.common.service;

import com.lyf.common.entity.LfyUsrDo;
import com.lyf.common.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public List<Map<String, Object>> getList() {
        return userMapper.getList();
    }

}
