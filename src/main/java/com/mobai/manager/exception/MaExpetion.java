package com.mobai.manager.exception;

/**
 * 自定义Exception
 *
 *
 * @author li.nan
 * @date 2022/9/13
 */
public class MaExpetion extends Exception {
    private String retCode;

    private String retMessage;

    public MaExpetion() {
        super();
    }

    public MaExpetion(String retCode, String retMessage) {
        this.retCode = retCode;
        this.retMessage = retMessage;
    }

    public String getRetCode() {
        return retCode;
    }

    public String getRetMessage() {
        return retMessage;
    }
}
