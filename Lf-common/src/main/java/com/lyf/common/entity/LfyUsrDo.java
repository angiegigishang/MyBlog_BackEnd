package com.lyf.common.entity;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class LfyUsrDo {

    @NotNull
    private String lfyUsrNbr;
    @NotNull
    private String lfyUsrNam;
    private String lfyUsrAdr;
    private String lfyUsrPhe;
    @NotNull
    private String lfyUsrPwd;
    private String lfyAdmFlg;
    private Integer lfyMntDat;
    private Integer lfyMntTim;
    private String lfyExtC60;
    private String lfyRcdSts;
    private Integer lfyRcdVer;

}
