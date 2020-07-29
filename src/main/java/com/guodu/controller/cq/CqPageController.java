package com.guodu.controller.cq;

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
public class CqPageController {

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
}
