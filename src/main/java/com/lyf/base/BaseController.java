package com.lyf.base;

import com.lyf.exception.BusinessException;
import com.lyf.exception.ParamsException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BaseController {

    @ExceptionHandler
    public ModelAndView resolveException(HttpServletRequest request,
                                         HttpServletResponse response,
                                          Exception ex) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("error");// 默认错误视图
        mv.addObject("ex", ex);// 默认错误信息

        if(ex instanceof ParamsException){
            ParamsException e = (ParamsException) ex;
            mv.addObject("ex", e.getMsg());
            mv.setViewName("pa_error");
        }

        if(ex instanceof BusinessException){
            BusinessException e = (BusinessException) ex;
            mv.addObject("ex", e.getMsg());
            mv.setViewName("bu_error");
        }

        return mv;
    }
}
