package com.lyf.common.entity;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class LfyUsrLgn {

    private Long lfyLgnNbr;
    private String lfyUsrNbr;
    private String lfyUsrTok;
    private LocalDateTime lfyLgnTim;
    private LocalDateTime lfyExpTim;
    private String lfyLgnSts;

}
