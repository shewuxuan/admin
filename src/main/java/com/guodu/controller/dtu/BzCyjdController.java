package com.guodu.controller.dtu;

import cn.hutool.json.JSONUtil;
import cn.hutool.log.StaticLog;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.guodu.pojo.dtu.BzCyjd;
import com.guodu.pojo.sys.Auth;
import com.guodu.service.dtu.BzCyjdService;
import com.guodu.util.IDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: BzCyjdController
 * @Description: TODO
 * @Author: 2uli
 * @Date: 2020/1/19 10:48 上午
 */
@RestController
@RequestMapping("bzcyjd/")
public class BzCyjdController {

    @Autowired
    private BzCyjdService bzCyjdServiceImpl;

    /**
     * @MethodName: insert
     * @Description: TODO
     * @Param: [BzCyjd]
     * @Return: int
     * @Author: 2uli
     * @Date: 2020/1/19 10:37 上午
     */
    @RequestMapping("insert")
    public int insert(BzCyjd bzCyjd) {
        bzCyjd.setId(IDUtil.getStrId());
        try {
            int i = bzCyjdServiceImpl.insert(bzCyjd);
            StaticLog.info("bz_cyjd表【插入】成功 -----> " + bzCyjd.getId(), "INFO");
            return i;
        } catch (Exception e) {
            StaticLog.error(e, "bz_cyjd表【插入】失败 -----> " + bzCyjd.getId(), "ERROR");
            return 0;
        }
    }

    /**
     * @MethodName: deleteByPrimaryKey
     * @Description: TODO
     * @Param: [id]
     * @Return: int
     * @Author: 2uli
     * @Date: 2020/1/19 10:50 上午
     */
    @RequestMapping("deleteByPrimaryKey/{id}")
    public int deleteByPrimaryKey(@PathVariable String id) {
        try {
            int i = bzCyjdServiceImpl.deleteByPrimaryKey(id);
            StaticLog.info("bz_cyjd表【删除】成功 -----> " + id, "INFO");
            return i;
        } catch (Exception e) {
            StaticLog.error(e, "bz_cyjd表【删除】失败 -----> " + id, "ERROR");
            return 0;
        }
    }

    /**
     * @MethodName: updateByPrimaryKey
     * @Description: TODO
     * @Param: [BzCyjd]
     * @Return: int
     * @Author: 2uli
     * @Date: 2020/1/19 10:49 上午
     */
    @RequestMapping("updateByPrimaryKey/{id}")
    public int updateByPrimaryKey(@PathVariable String id, BzCyjd bzCyjd) {
        try {
            bzCyjd.setId(id);
            int i = bzCyjdServiceImpl.updateByPrimaryKey(bzCyjd);
            StaticLog.info("bz_cyjd表【修改】成功 -----> " + bzCyjd.getId(), "INFO");
            return i;
        } catch (Exception e) {
            StaticLog.error(e, "bz_cyjd表【修改】失败 -----> " + bzCyjd.getId(), "ERROR");
            return 0;
        }
    }

    /**
     * @MethodName: selectByPrimaryKey
     * @Description: TODO
     * @Param: [id]
     * @Return: java.lang.String
     * @Author: 2uli
     * @Date: 2020/1/19 10:38 上午
     */
    @RequestMapping("selectByPrimaryKey/{id}")
    public String selectByPrimaryKey(@PathVariable String id) {
        BzCyjd bzCyjd = bzCyjdServiceImpl.selectByPrimaryKey(id);
        return JSONUtil.toJsonStr(bzCyjd);
    }

    /**
     * @MethodName: selectByAll
     * @Description: TODO
     * @Param: [BzCyjd]
     * @Return: java.lang.String
     * @Author: 2uli
     * @Date: 2020/1/19 10:38 上午
     */
    @RequestMapping("selectByAll")
    public String selectByAll(BzCyjd bzCyjd) {
        List<BzCyjd> bzCyjds = bzCyjdServiceImpl.selectByAll(bzCyjd);
        return JSONUtil.toJsonStr(bzCyjds);
    }

    @GetMapping("selectByPage")
    public String selectByAll(HttpServletRequest request,BzCyjd record,
                              @RequestParam(value = "page", defaultValue = "1") Integer page,
                              @RequestParam(value = "rows", defaultValue = "10") Integer rows) {
        Map<String, Object> map = new HashMap<>(16);
        // pagehelper分页
        if (record.getSsqy() == null || record.getSsqy().equals("0")){
            Auth auth = Auth.getAuth(request);
            record.setSsqy(auth.getZwSsqy());
        }
        PageHelper.startPage(page, rows);
        List<BzCyjd> list = bzCyjdServiceImpl.selectByPage(record);//???一些返回String,有的返回list
        PageInfo<BzCyjd> pageInfo = new PageInfo<>(list);
        map.put("rows", pageInfo.getList());
        map.put("total", pageInfo.getTotal());
        return JSONUtil.toJsonStr(map);
    }
}
