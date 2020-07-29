package com.guodu.controller.dtu;

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
public class DtuPageController {

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

}
