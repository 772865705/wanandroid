package com.zy.framework.base;

public class BaseBean<TData> {

    public static final int RESULT_OK = 0;
    public static final int RESULT_NEED_LOGIN = -1001;//需要登录或登录失效

    private int errorCode;
    private String errorMsg;
    private TData data;

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }


    public TData getData() {
        return data;
    }

    public void setData(TData data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "BaseBean{" +
                "errorCode=" + errorCode +
                ", errorMsg='" + errorMsg + '\'' +
                ", data=" + data +
                '}';
    }

    public boolean isOK() {
        return errorCode == RESULT_OK;
    }


}
