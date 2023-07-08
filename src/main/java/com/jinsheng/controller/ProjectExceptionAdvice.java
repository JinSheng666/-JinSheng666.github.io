
package com.jinsheng.controller;

import com.jinsheng.exception.BusinessException;
import com.jinsheng.exception.SystemException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
/**
 * 项目异常通知
 * 使用spring提供的异常处理写法
 *
 * */
//Rest风格开发方式，
@RestControllerAdvice
public class ProjectExceptionAdvice {
    //业务异常处理
    @ExceptionHandler(BusinessException.class)
    public Result doBusinessException(BusinessException ex){
        return new Result(Code.BUSINESS_ERR,null, ex.getMessage());
    }

    //系统异常处理
    @ExceptionHandler(SystemException.class)
    public Result doSystemException(SystemException ex){
        //记录日志
        //通知运维进行维护
        //发送邮件给开发人员，ex对象发送给开发人员
        System.out.println("系统异常哪里跑！！！！");
        return new Result(Code.SYSTEM_ERR,null, ex.getMessage());
    }

    //异常拦截，’Exception‘ 对所有的异常拦截
    @ExceptionHandler(Exception.class)
    public Result doException(Exception ex){  //当我们拦截到异常参数的时候，异常对象就可以通过Exception ex传递到方法中
        //记录日志
        //通知运维进行维护
        //发送邮件给开发人员，ex对象发送给开发人员
        System.out.println("其他异常哪里跑！！！！");
        return new Result(Code.UNKNOWN_ERR,null, "内容超过20位！！！");
    }
}

