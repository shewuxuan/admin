package com.guodu.util;

import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.IdUtil;

/**
 * @author 2Uli
 * @ClassName: IDUtil
 * @TODO:
 * @Date: 2020/1/19 9:35 上午
 */
public class IDUtil {

    private static final Snowflake SNOWFLAKE = IdUtil.createSnowflake(1, 1);

    public static long getLongId() {
        return SNOWFLAKE.nextId();
    }

    public static String getStrId() {
        return SNOWFLAKE.nextIdStr();
    }
}
