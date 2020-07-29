package com.guodu.controller.pwbh;

import com.guodu.pojo.sys.Auth;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName: PageController
 * @Description: TODO
 * @Author: 2Uli
 * @Date: 2020/2/14 10:51 上午
 */
@Controller
public class PwbhPageController {

    /**
     * @MethodName: bzPwbhByList
     * @Description: TODO 跳转配网保护(pwbh)列表页面
     * @Param: [page, pageName]
     * @Return: java.lang.String
     * @Author: 2uli
     * @Date: 2020/6/10 3:35 下午
     */
    @RequestMapping("bz/pwbh/{page}/{pageName}")
    public String bzPwbhByList(@PathVariable String page, @PathVariable String pageName) {
        return "bz/pwbh/" + page + "/" + pageName;
    }

    /**
     * @MethodName: bzPwbhByAddAndUpdate
     * @Description: TODO 跳转配网保护(pwbh)添加/修改页面
     * @Param: [page, pageName, id, model]
     * @Return: java.lang.String
     * @Author: 2uli
     * @Date: 2020/6/10 3:36 下午
     */
    @RequestMapping("bz/pwbh/{page}/{pageName}/{id}")
    public String bzPwbhByAddAndUpdate(@PathVariable String page,
                                       @PathVariable String pageName,
                                       @PathVariable String id,
                                       Model model) {
        model.addAttribute("id", id);
        return "bz/pwbh/" + page + "/" + pageName;
    }

    @RequestMapping("pwbh/tsjl/{page}/{tsid}")
    public String tsjl(@PathVariable String page, @PathVariable String tsid, HttpServletRequest request) {
        request.setAttribute("tsid", tsid);
        String userType = Auth.getAuth(request).getUserType();
        request.setAttribute("userType", userType);
        return "pwbh/tsjl/" + page;
    }
}
