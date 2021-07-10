//package com.qgzx.config;
//
//import org.springframework.boot.web.servlet.error.ErrorController;
//import org.springframework.http.MediaType;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import javax.servlet.http.HttpServletRequest;
//
///**
// * @author yzq
// */
//@Controller
//public class ErrorPageController implements ErrorController {
//
//
//    @Override
//    public String getErrorPath() {
//        return null;
//    }
//
//    private static final String ERROR_PATH = "/public/error";
//
//    @RequestMapping(value=ERROR_PATH,produces = {MediaType.TEXT_HTML_VALUE})
//    public String handleError(HttpServletRequest request){
//        //获取statusCode:401,404,500
//        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
//        if(statusCode == 400){
//            return "/error/400";
//        }else if(statusCode == 404){
//            return "/error/404";
//        }else{
//            return "/error/error-500";
//        }
//    }
//
//
//    @GetMapping("/to500")
//    public String to500(HttpServletRequest request){
//        throw  new RuntimeException();
//    }
//
//}