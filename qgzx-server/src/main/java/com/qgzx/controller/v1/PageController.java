package com.qgzx.controller.v1;

import com.qgzx.entity.User;
import io.swagger.annotations.Api;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

/**
 * @Author: Yangzhengqian
 * @Description:
 * @Date:Created time 2019/8/26 21:53
 * @Modified By:
 */
@Controller
@Api(tags = "页面管理模块",value = "yemianguanli")
public class PageController {

    /**
     * 登录界面
     *
     * @return
     * @author zhangzhengan
     * @since JDK 1.7
     */
    @RequestMapping(value = "/", method = RequestMethod.GET )
    public String index() {
        return "index";
    }

    @RequestMapping(value = "/admin", method = RequestMethod.GET )
    public String home(HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (user == null) {
            return "login";
        }
        return "admin";
    }

    @RequestMapping(value = "/exit", method = RequestMethod.GET )
    public String exit(HttpSession session) {
        session.removeAttribute("user");
        return "login";
    }

    @RequestMapping(value = "/admin-left", method = RequestMethod.GET)
    public String adminLeft() {
        return "admin-left";
    }

    @RequestMapping(value = "/insertWorkStudyInfo", method = RequestMethod.GET)
    public String insertWorkStudyInfo() {
        return "insertWorkStudyInfo";
    }

    @RequestMapping(value = "/manage", method = RequestMethod.GET)
    @CrossOrigin
    public String manage() {
        return "manage";
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String read() {
        return "index";
    }

    @RequestMapping(value = "/back", method = RequestMethod.GET)
    public String back() {
        return "back";
    }

    @RequestMapping(value = "/getWorkStudyInfo", method = RequestMethod.GET)
    public String getWorkStudyInfo() {
        return "workStudyInfo";
    }

    @RequestMapping(value = "/adminsignup", method = RequestMethod.GET)
    public String adminSignup() {
        return "signup";
    }
}
