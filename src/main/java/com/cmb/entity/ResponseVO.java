package com.cmb.entity;

public class ResponseVO<T> {
    boolean success;
    String msg;
    T t;

    public ResponseVO(boolean success, String msg, T t) {
        this.success = success;
        this.msg = msg;
        this.t = t;
    }

    public ResponseVO(){}

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }
}
