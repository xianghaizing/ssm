package com.lyf.exception;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by xlf on 2019/7/13.
 */
//@Component
public class GlobalExceptionResolver implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest request,
                                         HttpServletResponse response,
                                         Object target, Exception ex) {
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
