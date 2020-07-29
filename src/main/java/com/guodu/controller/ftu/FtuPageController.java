package com.guodu.controller.ftu;

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
 * @Date: 2020/7/29 10:51 上午
 */
@Controller
public class FtuPageController {

    @RequestMapping("bz/ftu/{page}/{pageName}")
    public String bz3(@PathVariable String page, @PathVariable String pageName) {
        return "bz/ftu/" + page + "/" + pageName;
    }

    @RequestMapping("bz/ftu/{page}/{pageName}/{id}")
    public String bz4(@PathVariable String page,
                      @PathVariable String pageName,
                      @PathVariable String id,
                      Model model) {
        model.addAttribute("id", id);
        return "bz/ftu/" + page + "/" + pageName;
    }

    /**
     * @MethodName: ftu
     * @Description: TODO ftu ---> ts.jsp
     * @Param: [page1, page2, tsid, request]
     * @Return: java.lang.String
     * @Author: 2uli
     * @Date: 2020/5/12 10:17 上午
     */
    @RequestMapping("ftuJbxx/{page1}/{page2}/{tsid}")
    public String ftu(@PathVariable String page1, @PathVariable String page2, @PathVariable String tsid, HttpServletRequest request) {
        request.setAttribute("tsid", tsid);
        String userType = Auth.getAuth(request).getUserType();
        request.setAttribute("userType", userType);
        return "ftuJbxx/" + page1 + "/" + page2;
    }

    /**
     * @MethodName: addFtu
     * @Description: TODO 跳转添加ftu标准
     * @Param: [page1, page2, page3, tsid, ssqy, model]
     * @Return: java.lang.String
     * @Author: 2uli
     * @Date: 2020/5/19 10:00 上午
     */
    @RequestMapping("ftuJbxx/{page1}/{page2}/{page3}/{tsid}/{ssqy}")
    public String addFtu(@PathVariable String page1, @PathVariable String page2, @PathVariable String page3, @PathVariable String tsid, @PathVariable String ssqy, Model model) {
        model.addAttribute("tsid", tsid);
        model.addAttribute("ssqy", ssqy);
        return "ftuJbxx/" + page1 + "/" + page2 + "/" + page3;
    }
}
