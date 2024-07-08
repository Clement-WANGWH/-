package com.neusoft.ysu.nepmserve.util.common;

import lombok.Data;

@Data
public class CommonResult<T> {
    private int code=200;
    private String msg="成功";
    private T result;

    public CommonResult(){}

    public CommonResult(T result){
        this.result=result;
    }

    public CommonResult(String msg, T result) {
        this.msg = msg;
        this.result = result;
    }

    public CommonResult(int code, String msg, T result) {
        this.code = code;
        this.msg = msg;
        this.result = result;
    }

    /**
     * 操作成功
     * @param result
     * @return
     * @param <T>
     */
    public static<T> CommonResult<T> success(T result){
        return new CommonResult<T>(ResultCode.SUCCESS.getCode(),ResultCode.SUCCESS.getMsg(),result);
    }

    /**
     * 失败返回结果
     * @param message 提示信息
     */
    public static<T> CommonResult<T> failed(String message) {
        return new CommonResult<T>(ResultCode.FAILED.getCode(), message, null);
    }

    public static<T> CommonResult<T> usernameExist(T result){
        return new CommonResult<T>(ResultCode.usernameExist.getCode(),ResultCode.usernameExist.getMsg(), result);
    }

    public static<T> CommonResult<T> phoneExist(T result){
        return new CommonResult<>(ResultCode.telephoneExist.getCode(), ResultCode.telephoneExist.getMsg(), result);
    }

    public void setOK(T result){
        this.code=200;
        this.msg="成功";
        this.result=result;
    }

    public void setNotFound() {
        this.code = 100;
        this.msg = "请求的资源不存在";
    }

    public void setNotInserted(){
        this.code = 101;
        this.msg = "插入失败";
    }

    public void setNotDelete(){
        this.code = 102;
        this.msg = "删除失败";
    }

    public void setNotUpdate(){
        this.code = 103;
        this.msg = "修改失败";
    }

    public void usernameExist(){
        this.code=104;
        this.msg="用户名已存在";
    }

    public void phoneExist(){
        this.code=105;
        this.msg="手机号已被注册";
    }

    public void pswError(){
        this.code=106;
        this.msg="密码错误！";
    }

    public void wrongAvatar(){
        this.code=107;
        this.msg="保存头像失败！";
    }

    public void set1(T result){
        this.code=111;
        this.msg="系统管理员";
        this.result=result;
    }

    public void set2(T result){
        this.code=222;
        this.msg="网格员";
        this.result=result;
    }

    public void set3(T result){
        this.code=333;
        this.msg="公众监督员";
        this.result=result;
    }

    public void getNoUser(){
        this.code = 210;
        this.msg = "用户不存在";
    }

}
