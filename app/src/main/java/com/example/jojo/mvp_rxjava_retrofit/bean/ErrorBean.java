package com.example.jojo.mvp_rxjava_retrofit.bean;

/**
 * author : JOJO
 * e-mail : 18510829974@163.com
 * date   : 2018/11/21 PM
 * desc   : 异常bean类
 */

public class ErrorBean {
    private int status;
    private String msg;
    private String code;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMsg() {
        return msg == null ? "" : msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "ErrorBean{" +
                "status=" + status +
                ", msg='" + msg + '\'' +
                ", code='" + code + '\'' +
                '}';
    }
}
