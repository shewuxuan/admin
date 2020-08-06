package com.guodu.controller;

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
@RequestMapping("ksdjfkdsfks/")
public class PageController {

    /**
     * @MethodName: bz1
     * @Description: TODO DTU标准页面跳转控制器
     * @Param: [page, pageName]
     * @Return: java.lang.String
     * @Author: 2uli
     * @Date: 2020/3/6 11:08 上午
     */
    @RequestMapping("bz/{page}/{pageName}")
    public String bz1(@PathVariable String page, @PathVariable String pageName) {
        return "bz/dtu/" + page + "/" + pageName;
    }

    /**
     * @MethodName: bz2
     * @Description: TODO DTU修改标准页面跳转控制器
     * @Param: [page, pageName, id, model]
     * @Return: java.lang.String
     * @Author: 2uli
     * @Date: 2020/3/6 11:11 上午
     */
    @RequestMapping("bz/{page}/{pageName}/{id}")
    public String bz2(@PathVariable String page,
                      @PathVariable String pageName,
                      @PathVariable String id,
                      Model model) {
        model.addAttribute("id", id);
        return "bz/dtu/" + page + "/" + pageName;
    }

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
     * @MethodName: jl2
     * @Description: TODO 跳转jl/下的页面  ---> jl/
     * @Param: [page]
     * @Return: java.lang.String
     * @Author: 2uli
     * @Date: 2020/3/12 9:39 上午
     */
    @RequestMapping("jl/{page}")
    public String jl2(@PathVariable String page) {
        return "jl/" + page;
    }

    /**
     * @MethodName: jl1
     * @Description: TODO 调试页面控制器
     * @Param: [page, tsid, request]
     * @Return: java.lang.String
     * @Author: 2uli
     * @Date: 2020/3/12 9:04 上午
     */
    @RequestMapping("jl/{page}/{tsid}")
    public String jl1(@PathVariable String page, @PathVariable String tsid, HttpServletRequest request) {
        request.setAttribute("tsid", tsid);
        String userType = Auth.getAuth(request).getUserType();
        request.setAttribute("userType", userType);
        return "jl/" + page;
    }


    /**
     * @MethodName: cq
     * @Description: TODO 处缺页面控制器
     * @Param: [page]
     * @Return: java.lang.String
     * @Author: 2uli
     * @Date: 2020/3/26 2:53 下午
     */
    @RequestMapping("cq/{page}")
    public String cq(@PathVariable String page) {
        return "cq/" + page;
    }

    /**
     * @MethodName: cq
     * @Description: TODO 修改处缺控制器
     * @Param: [page, id, model]
     * @Return: java.lang.String
     * @Author: 2uli
     * @Date: 2020/3/26 2:55 下午
     */
    @RequestMapping("cq/{page}/{id}")
    public String cq(@PathVariable String page, @PathVariable String id, Model model) {
        model.addAttribute("cqid", id);
        return "cq/" + page;
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
}
