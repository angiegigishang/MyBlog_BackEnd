package com.lyf.api.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class UsrLgnInn {
    @NotNull
    private String lfyUsrNbr;

    private String lfyUsrPwd;
}
