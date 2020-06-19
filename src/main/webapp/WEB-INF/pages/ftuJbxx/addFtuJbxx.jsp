<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../import.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>基本信息——添加</title>
    <link rel="stylesheet" type="text/css" href="/style/wholemain.css"/>
    <script src="/js/jquery.js"></script>
    <script type="text/javascript" src="/js/jquery.min.js"></script>
    <script type="text/javascript" src="/js/WdatePicker.js"></script>
    <link rel="stylesheet" type="text/css" href="/easyui/themes/default/easyui.css"/>
    <script type="text/javascript" src="/js/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="/js/easyui-lang-zh_CN.js"></script>
</head>
<script>
    $(function () {
        var curr_time = new Date();
        var strDate = curr_time.getFullYear() + "-";
        strDate += curr_time.getMonth() + 1 + "-";
        strDate += curr_time.getDate() + " ";
        var tssj = '${jbxx}';
        if (tssj == '' || tssj == null) {
            $('#tssj').datebox('setValue', strDate);
            $('#ysrq').datebox('setValue', strDate);
            $('#kgScrq').datebox('setValue', strDate);
            $('#ftuScrq').datebox('setValue', strDate);
            $('#txsbScrq').datebox('setValue', strDate);
        }
    });
</script>
<body>
<div class="right_main">
    <div class="right_table" style="width:96%;">
        <form name="myForm" id="myForm" method="post">
            <table width="100%" cellpadding="0" cellspacing="1" bgcolor="#c6c6c6">
                <tbody>
                <c:if test="${ftuJbxx == null }">
                    <tr>
                        <th colspan="2" align="center" bgcolor="#f5f2ea">添加</th>
                    </tr>
                    <tr>
                        <th bgcolor="#FFFFFF">调试时间</th>
                        <td bgcolor="#FFFFFF" style="text-align:left; ">
                            <input class="easyui-datebox" name="tssj" id="tssj"
                                   data-options="required:true" style="width:120px"/>
                        </td>
                    </tr>
                    <tr>
                        <th bgcolor="#FFFFFF"><p>调度编号</p></th>
                        <td bgcolor="#FFFFFF" style="text-align:left; ">
                            <input type="text" name="ddbh" id="ddbh" style="height:25px; border:1px solid #CCC;"/>
                        </td>
                    </tr>
                    <tr>
                        <th bgcolor="#FFFFFF"><p>线路名称</p></th>
                        <td bgcolor="#FFFFFF" style="text-align:left; ">
                            <input type="text" name="xlmc" id="xlmc" style="height:25px; border:1px solid #CCC;"/>
                        </td>
                    </tr>
                    <tr>
                        <th bgcolor="#FFFFFF"><p>FTU编码</p></th>
                        <td bgcolor="#FFFFFF" style="text-align:left; ">
                            <input type="text" name="ftuBm" id="ftuBm" style="height:25px; border:1px solid #CCC;"/>
                        </td>
                    </tr>
                    <tr>
                        <th bgcolor="#FFFFFF"><p>验收人员</p></th>
                        <td bgcolor="#FFFFFF" style="text-align:left; ">
                            <input type="text" name="ysry" id="ysry" style="height:25px; border:1px solid #CCC;"/>
                        </td>
                    </tr>
                    <tr>
                        <th bgcolor="#FFFFFF"><p>验收日期</p></th>
                        <td bgcolor="#FFFFFF" style="text-align:left; ">
                            <input class="easyui-datebox" name="ysrq" id="ysrq"
                                   data-options="required:true" style="width:120px"/>
                        </td>
                    </tr>
                    <tr>
                        <th bgcolor="#FFFFFF"><p>验收单位</p></th>
                        <td bgcolor="#FFFFFF" style="text-align:left; ">
                            <input type="text" name="ysdw" id="ysdw" style="height:25px; border:1px solid #CCC;"/>
                        </td>
                    </tr>
                    <tr>
                        <th bgcolor="#FFFFFF"><p>开关本体厂家</p></th>
                        <td bgcolor="#FFFFFF" style="text-align:left; ">
                            <input type="text" name="kgCj" id="kgCj" style="height:25px; border:1px solid #CCC;"/>
                        </td>
                    </tr>
                    <tr>
                        <th bgcolor="#FFFFFF"><p>开关本体型号</p></th>
                        <td bgcolor="#FFFFFF" style="text-align:left; ">
                            <input type="text" name="kgXh" id="kgXh" style="height:25px; border:1px solid #CCC;"/>
                        </td>
                    </tr>
                    <tr>
                        <th bgcolor="#FFFFFF"><p>开关本体生产日期</p></th>
                        <td bgcolor="#FFFFFF" style="text-align:left; ">
                            <input class="easyui-datebox" name="kgScrq" id="kgScrq"
                                   data-options="required:true" style="width:120px"/>
                        </td>
                    </tr>
                    <tr>
                        <th bgcolor="#FFFFFF"><p>FTU厂家</p></th>
                        <td bgcolor="#FFFFFF" style="text-align:left; ">
                            <input type="text" name="ftuCj" id="ftuCj" style="height:25px; border:1px solid #CCC;"/>
                        </td>
                    </tr>
                    <tr>
                        <th bgcolor="#FFFFFF"><p>FTU型号</p></th>
                        <td bgcolor="#FFFFFF" style="text-align:left; ">
                            <input type="text" name="ftuXh" id="ftuXh" style="height:25px; border:1px solid #CCC;"/>
                        </td>
                    </tr>
                    <tr>
                        <th bgcolor="#FFFFFF"><p>FTU生产日期</p></th>
                        <td bgcolor="#FFFFFF" style="text-align:left; ">
                            <input class="easyui-datebox" name="ftuScrq" id="ftuScrq"
                                   data-options="required:true" style="width:120px"/>
                        </td>
                    </tr>
                    <tr>
                        <th bgcolor="#FFFFFF"><p>通讯设备厂家</p></th>
                        <td bgcolor="#FFFFFF" style="text-align:left; ">
                            <input type="text" name="txsbCj" id="txsbCj" style="height:25px; border:1px solid #CCC;"/>
                        </td>
                    </tr>
                    <tr>
                        <th bgcolor="#FFFFFF"><p>通讯设备型号</p></th>
                        <td bgcolor="#FFFFFF" style="text-align:left; ">
                            <input type="text" name="txsbXh" id="txsbXh" style="height:25px; border:1px solid #CCC;"/>
                        </td>
                    </tr>
                    <tr>
                        <th bgcolor="#FFFFFF"><p>通讯设备生产日期</p></th>
                        <td bgcolor="#FFFFFF" style="text-align:left; ">
                            <input class="easyui-datebox" name="txsbScrq" id="txsbScrq"
                                   data-options="required:true" style="width:120px"/>
                        </td>
                    </tr>
                    <tr>
                        <th bgcolor="#FFFFFF"><p>无线卡号</p></th>
                        <td bgcolor="#FFFFFF" style="text-align:left; ">
                            <input type="text" name="wxkh" id="wxkh" style="height:25px; border:1px solid #CCC;"/>
                        </td>
                    </tr>
                    <tr>
                        <th bgcolor="#FFFFFF"><p>IP地址</p></th>
                        <td bgcolor="#FFFFFF" style="text-align:left; ">
                            <input type="text" name="ipdz" id="ipdz" style="height:25px; border:1px solid #CCC;"/>
                        </td>
                    </tr>
                    <tr>
                        <th bgcolor="#FFFFFF"><p>装置类型</p></th>
                        <td bgcolor="#FFFFFF" style="text-align:left; ">
                            <select name="zzlx" id="zzlx" style="height:25px; border:1px solid #CCC;">
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <th bgcolor="#FFFFFF"><p>调试人员姓名</p></th>
                        <td bgcolor="#FFFFFF" style="text-align:left; ">
                            <input type="text" name="tsryxm" id="tsryxm" style="height:25px; border:1px solid #CCC;"/>
                        </td>
                    </tr>
                    <tr>
                        <th bgcolor="#FFFFFF"><p>备注</p></th>
                        <td bgcolor="#FFFFFF" style="text-align:left; ">
                            <input type="text" name="beizhu" id="beizhu" style="height:25px; border:1px solid #CCC;"/>
                        </td>
                    </tr>
                    <tr>
                        <td height="33" colspan="2" bgcolor="#f5f2ea">
                            <input type="button" name="button" value="提 交" onclick="commit()" class="iput_m"
                                   style="height:25px;"/>
                            <input type="button" onclick="javascript:window.close();" name="button" value="取 消"
                                   class="iput_m" style="height:25px;"/>
                        </td>
                    </tr>
                </c:if>
                <c:if test="${ftuJbxx != null }">
                    <tr>
                        <th colspan="2" align="center" bgcolor="#f5f2ea">修改</th>
                    </tr>
                    <tr>
                        <th bgcolor="#FFFFFF">调试时间</th>
                        <td bgcolor="#FFFFFF" style="text-align:left; ">
                            <input class="easyui-datebox" name="tssj" id="tssj" value="${ftuJbxx.tssj}"
                                   data-options="required:true" style="width:120px"/>
                        </td>
                    </tr>
                    <tr>
                        <th bgcolor="#FFFFFF"><p>调度编号</p></th>
                        <td bgcolor="#FFFFFF" style="text-align:left; ">
                            <input type="text" name="ddbh" id="ddbh" value="${ftuJbxx.ddbh}" style="height:25px; border:1px solid #CCC;"/>
                        </td>
                    </tr>
                    <tr>
                        <th bgcolor="#FFFFFF"><p>线路名称</p></th>
                        <td bgcolor="#FFFFFF" style="text-align:left; ">
                            <input type="text" name="xlmc" id="xlmc" value="${ftuJbxx.xlmc}" style="height:25px; border:1px solid #CCC;"/>
                        </td>
                    </tr>
                    <tr>
                        <th bgcolor="#FFFFFF"><p>FTU编码</p></th>
                        <td bgcolor="#FFFFFF" style="text-align:left; ">
                            <input type="text" name="ftuBm" id="ftuBm" value="${ftuJbxx.ftuBm}" style="height:25px; border:1px solid #CCC;"/>
                        </td>
                    </tr>
                    <tr>
                        <th bgcolor="#FFFFFF"><p>验收人员</p></th>
                        <td bgcolor="#FFFFFF" style="text-align:left; ">
                            <input type="text" name="ysry" id="ysry" value="${ftuJbxx.ysry}" style="height:25px; border:1px solid #CCC;"/>
                        </td>
                    </tr>
                    <tr>
                        <th bgcolor="#FFFFFF"><p>验收日期</p></th>
                        <td bgcolor="#FFFFFF" style="text-align:left; ">
                            <input class="easyui-datebox" name="ysrq" value="${ftuJbxx.ysrq}" id="ysrq"
                                   data-options="required:true" style="width:120px"/>
                        </td>
                    </tr>
                    <tr>
                        <th bgcolor="#FFFFFF"><p>验收单位</p></th>
                        <td bgcolor="#FFFFFF" style="text-align:left; ">
                            <input type="text" name="ysdw" id="ysdw" value="${ftuJbxx.ysdw}" style="height:25px; border:1px solid #CCC;"/>
                        </td>
                    </tr>
                    <tr>
                        <th bgcolor="#FFFFFF"><p>开关本体厂家</p></th>
                        <td bgcolor="#FFFFFF" style="text-align:left; ">
                            <input type="text" name="kgCj" id="kgCj" value="${ftuJbxx.kgCj}" style="height:25px; border:1px solid #CCC;"/>
                        </td>
                    </tr>
                    <tr>
                        <th bgcolor="#FFFFFF"><p>开关本体型号</p></th>
                        <td bgcolor="#FFFFFF" style="text-align:left; ">
                            <input type="text" name="kgXh" id="kgXh" value="${ftuJbxx.kgXh}" style="height:25px; border:1px solid #CCC;"/>
                        </td>
                    </tr>
                    <tr>
                        <th bgcolor="#FFFFFF"><p>开关本体生产日期</p></th>
                        <td bgcolor="#FFFFFF" style="text-align:left; ">
                            <input class="easyui-datebox" name="kgScrq" id="kgScrq" value="${ftuJbxx.kgScrq}"
                                   data-options="required:true" style="width:120px"/>
                        </td>
                    </tr>
                    <tr>
                        <th bgcolor="#FFFFFF"><p>FTU厂家</p></th>
                        <td bgcolor="#FFFFFF" style="text-align:left; ">
                            <input type="text" name="ftuCj" id="ftuCj" value="${ftuJbxx.ftuCj}" style="height:25px; border:1px solid #CCC;"/>
                        </td>
                    </tr>
                    <tr>
                        <th bgcolor="#FFFFFF"><p>FTU型号</p></th>
                        <td bgcolor="#FFFFFF" style="text-align:left; ">
                            <input type="text" name="ftuXh" id="ftuXh" value="${ftuJbxx.ftuXh}" style="height:25px; border:1px solid #CCC;"/>
                        </td>
                    </tr>
                    <tr>
                        <th bgcolor="#FFFFFF"><p>FTU生产日期</p></th>
                        <td bgcolor="#FFFFFF" style="text-align:left; ">
                            <input class="easyui-datebox" name="ftuScrq" id="ftuScrq" value="${ftuJbxx.ftuScrq}"
                                   data-options="required:true" style="width:120px"/>
                        </td>
                    </tr>
                    <tr>
                        <th bgcolor="#FFFFFF"><p>通讯设备厂家</p></th>
                        <td bgcolor="#FFFFFF" style="text-align:left; ">
                            <input type="text" name="txsbCj" id="txsbCj" value="${ftuJbxx.txsbCj}" style="height:25px; border:1px solid #CCC;"/>
                        </td>
                    </tr>
                    <tr>
                        <th bgcolor="#FFFFFF"><p>通讯设备型号</p></th>
                        <td bgcolor="#FFFFFF" style="text-align:left; ">
                            <input type="text" name="txsbXh" id="txsbXh"  value="${ftuJbxx.txsbXh}" style="height:25px; border:1px solid #CCC;"/>
                        </td>
                    </tr>
                    <tr>
                        <th bgcolor="#FFFFFF"><p>通讯设备生产日期</p></th>
                        <td bgcolor="#FFFFFF" style="text-align:left; ">
                            <input class="easyui-datebox" name="txsbScrq" id="txsbScrq"  value="${ftuJbxx.txsbScrq}"
                                   data-options="required:true" style="width:120px"/>
                        </td>
                    </tr>
                    <tr>
                        <th bgcolor="#FFFFFF"><p>无线卡号</p></th>
                        <td bgcolor="#FFFFFF" style="text-align:left; ">
                            <input type="text" name="wxkh" id="wxkh" value="${ftuJbxx.wxkh}" style="height:25px; border:1px solid #CCC;"/>
                        </td>
                    </tr>
                    <tr>
                        <th bgcolor="#FFFFFF"><p>IP地址</p></th>
                        <td bgcolor="#FFFFFF" style="text-align:left; ">
                            <input type="text" name="ipdz" id="ipdz" value="${ftuJbxx.ipdz}" style="height:25px; border:1px solid #CCC;"/>
                        </td>
                    </tr>
                    <tr>
                        <th bgcolor="#FFFFFF"><p>装置类型</p></th>
                        <td bgcolor="#FFFFFF" style="text-align:left; ">
                            <select name="zzlx" id="zzlx" value="${ftuJbxx.tsryxm}" style="height:25px; border:1px solid #CCC;">
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <th bgcolor="#FFFFFF"><p>调试人员姓名</p></th>
                        <td bgcolor="#FFFFFF" style="text-align:left; ">
                            <input type="text" name="tsryxm" id="tsryxm" value="${ftuJbxx.tsryxm}" style="height:25px; border:1px solid #CCC;"/>
                        </td>
                    </tr>
                    <tr>
                        <th bgcolor="#FFFFFF"><p>备注</p></th>
                        <td bgcolor="#FFFFFF" style="text-align:left; ">
                            <textarea rows="5" cols="100" name="beizhu" id="beizhu" style="border:1px solid #CCC;">${ftuJbxx.beizhu}</textarea>
                        </td>
                    </tr>
                    <tr>
                        <td height="33" colspan="2" bgcolor="#f5f2ea">
                            <input type="button" name="button" value="提 交" onclick="change()" class="iput_m"
                                   style="height:25px;"/>
                            <input type="button" onclick="javascript:window.close();" name="button" value="取 消"
                                   class="iput_m" style="height:25px;"/>
                        </td>
                    </tr>
                </c:if>
                </tbody>
            </table>
        </form>
    </div>
</div>
<script>
    $(function () {
        var formdata = new FormData(); // 模拟表单对象
        $.ajax({
            url: '/jbxx/selectZzlxAll.action',
            type: 'POST',
            async: false,
            data: formdata,
            processData: false,
            contentType: false,
            beforeSend: function () {
                console.log("正在加载，请稍候");
            },
            success: function (result) {
                $.each(result, function (index, value) {
                    var oldZzlx = $("#oldZzlx").val();
                    if (oldZzlx == value.keyvalue) {
                        $("#zzlx").append("<option value='" + value.keyvalue + "' selected>" + value.keymemo + "</option>");
                    } else {
                        $("#zzlx").append("<option value='" + value.keyvalue + "' >" + value.keymemo + "</option>");
                    }
                });
            },
            error: function (XMLHttpRequest, textStatus, errorThrown) {
                alert(errorThrown);
            },
            async: false             //false表示同步
        });
    });

    function commit() {
        $.ajax({
            url: '/ftuJbxx/addFtuJbxx.action',
            type: 'POST',
            async: false,
            data: new FormData($("#myForm")[0]),
            processData: false,
            contentType: false,
            beforeSend: function () {
                console.log("正在加载，请稍候");
            },
            success: function (data) {
                alert(data.message);
                if (data.code == 0) {
                    window.opener.location.reload();
                    window.close();
                }
            },
            error: function () {
                alert("页面加载错误！");
            }
        });
    }

    function change() {
        $.ajax({
            url: '/ftuJbxx/updateFtuJbxx.action',
            type: 'POST',
            async: false,
            data: new FormData($("#myForm")[0]),
            processData: false,
            contentType: false,
            beforeSend: function () {
                console.log("正在加载，请稍候");
            },
            success: function (data) {
                alert(data.message);
                if (data.code == 0) {
                    window.opener.location.reload();
                    window.close();
                }
            },
            error: function () {
                alert("页面加载错误！");
            }
        });
    }
</script>
</body>
</html>
