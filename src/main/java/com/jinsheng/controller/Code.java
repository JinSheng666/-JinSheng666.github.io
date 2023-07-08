package com.jinsheng.controller;

/**
* 封装状态编码
* */
public class Code {

    //末尾为1则表示成功，为0则是错误
    public static final Integer INSERT_OK = 20011;
    public static final Integer DELETE_OK = 20021;
    public static final Integer UPDATE_OK = 20031;
    public static final Integer SELECT_OK = 20041;
    public static final Integer SELECT_ALL_OK = 20051;
    public static final Integer BRAND_PAGE_OK = 20061;
    public static final Integer DELETE_ALL_OK = 20071;
    public static final Integer PAGE_CONDITION_OK = 20081;

    public static final Integer INSERT_ERR = 20010;
    public static final Integer DELETE_ERR = 20020;
    public static final Integer UPDATE_ERR = 20030;
    public static final Integer SELECT_ERR = 20040;
    public static final Integer SELECT_ALL_REE = 20050;
    public static final Integer BRAND_PAGE_REE = 20060;
    public static final Integer DELETE_ALL_ERR = 20070;
    public static final Integer PAGE_CONDITION_REE = 20080;

    //系统异常
    public static final Integer SYSTEM_ERR = 50001;
    //业务异常
    public static final Integer BUSINESS_ERR = 50002;
    //未知异常
    public static final Integer UNKNOWN_ERR = 50003;



}
