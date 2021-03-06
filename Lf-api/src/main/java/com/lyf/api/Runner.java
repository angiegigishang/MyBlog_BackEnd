package com.lyf.api;

import com.lyf.common.properties.LfSettings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class Runner implements ApplicationRunner {

    @Autowired
    private LfSettings lfSettings;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println(lfSettings.getAddr());
    }
}

