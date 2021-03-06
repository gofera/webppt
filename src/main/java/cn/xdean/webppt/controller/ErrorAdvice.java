package cn.xdean.webppt.controller;

import cn.xdean.webppt.core.error.AppException;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.http.HttpStatus;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Map;

@ControllerAdvice
public class ErrorAdvice {
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(AppException.class)
    public Map<String, Object> handle(AppException e) {
        return new ModelMap()
                .addAttribute("line", e.getLine())
                .addAttribute("message", e.getMessage())
                .addAttribute("trace", ExceptionUtils.getStackTrace(e));
    }
}
