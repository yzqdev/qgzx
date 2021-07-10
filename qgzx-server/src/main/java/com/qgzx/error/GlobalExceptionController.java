package com.qgzx.error;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Yangzhengqian
 * @Description:
 * @Date:Created time 2019/6/16 20:54
 * @Modified By:
 */
@ControllerAdvice(basePackages = "com.feixue.springtutor.tutor.controller")
public class GlobalExceptionController {
    /**
     * @return
     * @respondbody返回json格式 modeAndView返回页面
     */
    @ExceptionHandler(RuntimeException.class)
    @ResponseBody
    public Map<String, Object> errorResult() {

        Map<String, Object> errorResultMap = new HashMap<String, Object>();
        errorResultMap.put("errorCode", "500");
        errorResultMap.put("errorMsg", "system error");
        return errorResultMap;
    }
}
