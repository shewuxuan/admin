package com.guodu.mapper.sys;

import com.guodu.pojo.sys.SysSsxl;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ClassName: SysSsxlMapper
 * @Description: TODO
 * @Author: 2Uli
 * @Date: 2020/5/25 10:53 上午
 */
@Mapper
public interface SysSsxlMapper {
    /**
     * select by primary key
     *
     * @param id primary key
     * @return object by primary key
     */
    SysSsxl selectByPrimaryKey(String id);

    /**
     * @MethodName: selectByAll
     * @Description: TODO
     * @Param:
     * @Return:
     * @Author: 2uli
     * @Date: 2020/5/25 4:35 下午
     */
    List<SysSsxl> selectByAll(SysSsxl sysSsxl);

    /**
     * @MethodName: selectByGroup
     * @Description: TODO 分组查询
     * @Param: 
     * @Return: 
     * @Author: 2uli
     * @Date: 2020/5/25 1:52 下午
     */
    List<SysSsxl> selectByGroup(@Param("sysSsxl") SysSsxl sysSsxl, @Param("groupBy") String groupBy);
}