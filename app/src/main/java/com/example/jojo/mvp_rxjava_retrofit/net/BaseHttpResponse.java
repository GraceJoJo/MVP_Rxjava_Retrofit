package com.example.jojo.mvp_rxjava_retrofit.net;

/**
 * author : JOJO
 * e-mail : 18510829974@163.com
 * date   : 2018/11/21 3:19 PM
 * desc   : json解析对应的实体的统一格式封装
 */
public class BaseHttpResponse<T> {
    public int status;
    public String message;
    public T data;
}
