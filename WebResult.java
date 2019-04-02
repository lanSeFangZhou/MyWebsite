package com.example.demo;

public class WebResult {
    private int code;
    private String msg;
    private Object data;

    public static WebResult successResult(Object data){
        WebResult result = new WebResult();
        result.setCode(0);
        result.setData(data);
        result.setMsg("succ");
        return result;
    }

    public static WebResult failResult(String errMsg){
        return failResult(-1,errMsg,null);
    }

    public static WebResult failResult(int code,String errMsg){
        return failResult(code,errMsg,null);
    }

    public static  WebResult failResult(int code,String errMsg,Object data){
        WebResult result = new WebResult();
        result.setCode(code);
        result.setData(data);
        result.setMsg(errMsg);
        return result;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
