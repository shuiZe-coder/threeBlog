package org.three.ourblog.config.error;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;


@ControllerAdvice
public class MyExceptionHandler {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @ExceptionHandler(Exception.class)
    public ModelAndView exceptionHandle(HttpServletRequest req, Exception e){
        ModelAndView mv = new ModelAndView();
        mv.addObject("url", req.getRequestURL());
        logger.error("Request Url: {}, Exception: {}", req.getRequestURL(), e.getMessage());
        mv.addObject("exception", e);
        mv.setViewName("/error/error");
        return mv;
    }
}
