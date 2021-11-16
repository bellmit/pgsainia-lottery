package com.pgsainia.lottery.common;

import java.io.Serializable;
import java.util.jar.JarEntry;

/**
 * @author nifujia
 * @description
 * @date 2021/11/15
 */
public class Result implements Serializable {

    private static final long serialVersionUID = 7361534267744918659L;

    private String code;
    private String info;

    public Result(String code, String info) {
        this.code = code;
        this.info = info;
    }

    /**
     * 返回成功
     *
     * @return
     */
    public static Result buildSuccess() {
        return new Result(Constants.ResponseCode.SUCCESS.getCode(), Constants.ResponseCode.SUCCESS.getInfo());
    }

    /**
     * 返回失败
     *
     * @return
     */
    public static Result buildError() {
        return new Result(Constants.ResponseCode.UN_ERROR.getCode(), Constants.ResponseCode.UN_ERROR.getInfo());
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
