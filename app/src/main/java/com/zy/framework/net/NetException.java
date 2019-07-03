package com.zy.framework.net;

public class NetException extends Exception {
    int result;
    String msg;

    public NetException(String message, int result, String msg) {
        super(message);
        this.result = result;
        this.msg = msg;
    }
}
