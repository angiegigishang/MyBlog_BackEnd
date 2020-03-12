package com.lyf.api.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class UsrPwdChg {

    @NotNull
    private String lfyUsrNbr;
    @NotNull
    private String lfyNewPwd;
    @NotNull
    private String lfyUsrPwd;


}
