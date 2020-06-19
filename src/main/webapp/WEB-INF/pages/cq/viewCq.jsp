<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../import.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>处缺记录详细信息</title>             <!-- 改-->
    <link rel="stylesheet" type="text/css" href="/style/wholemain.css"/>
    <script type="text/javascript" src="/js/jquery-1.12.3.min.js"></script>
</head>
</head>
<body>
<div class="right_main">
    <div class="right_table" style="width:96%;">
        <form name="myForm" id="myForm">
            <table width="100%" cellpadding="0" cellspacing="1" bgcolor="#c6c6c6">
                <tbody>
                <tr>
                    <th bgcolor="#FFFFFF"><p>设备信息</p></th>
                    <td bgcolor="#FFFFFF" style="text-align:left; ">
                        <input type="hidden" name="" id="sbxx_sbid"/>
<%--                        <input type="hidden" name="" id="ssqy"/>--%>
                        <table style="width: 99%; margin-top: 0">
                            <tr>
                                <th bgcolor="#FFFFFF"><p>所属区域</p></th>
                                <td bgcolor="#FFFFFF" style="text-align:left; ">
                                    <input id="sbxx_ssqy" type="hidden"/>
                                    <input type="text" name="" id="sbxx_ssqyname" style="width: 100%;" readonly/>
                                </td>
                                <th bgcolor="#FFFFFF" style="width: 20%;"><p>设备调度号</p></th>
                                <td bgcolor="#FFFFFF" style="text-align:left; ">
                                    <input type="text" name="" id="sbxx_azddDdh" style="width: 100%;" readonly/>
                                </td>
                            </tr>
                            <tr>
                                <th bgcolor="#FFFFFF"><p>终端名称</p></th>
                                <td bgcolor="#FFFFFF" style="text-align:left; ">
                                    <input type="text" name="" id="sbxx_zdmc" style="width: 100%;" readonly/>
                                </td>
                                <th bgcolor="#FFFFFF"><p>设备线路</p></th>
                                <td bgcolor="#FFFFFF" style="text-align:left; ">
                                    <input id="sbxx_ssxl" type="hidden"/>
                                    <input type="text" name="" id="sbxx_ssxlname" style="width: 100%;" readonly/>
                                </td>
                            </tr>
                            <tr>
                                <th bgcolor="#FFFFFF"><p>通信模块厂家</p></th>
                                <td bgcolor="#FFFFFF" style="text-align:left; ">
                                    <input type="text" name="" id="sbxx_txmkcj" style="width: 100%;" readonly/>
                                </td>
                                <th bgcolor="#FFFFFF"><p>IP地址</p></th>
                                <td bgcolor="#FFFFFF" style="text-align:left; ">
                                    <input type="text" name="" id="sbxx_ipdz" style="width: 100%;" readonly/>
                                </td>
                            </tr>
                            <tr>
                                <th bgcolor="#FFFFFF"><p>物联网卡号</p></th>
                                <td bgcolor="#FFFFFF" style="text-align:left; ">
                                    <input type="text" name="" id="sbxx_wlwkh" style="width: 100%;" readonly/>
                                </td>
                                <th bgcolor="#FFFFFF"><p>RTU地址</p></th>
                                <td bgcolor="#FFFFFF" style="text-align:left; ">
                                    <input type="text" name="" id="sbxx_rtudz" style="width: 100%;" readonly/>
                                </td>
                            </tr>
                            <tr>
                                <th bgcolor="#FFFFFF"><p>端口号</p></th>
                                <td bgcolor="#FFFFFF" style="text-align:left; ">
                                    <input type="text" name="" id="sbxx_dkh" style="width: 100%;" readonly/>
                                </td>
                                <th bgcolor="#FFFFFF"><p>终端厂家</p></th>
                                <td bgcolor="#FFFFFF" style="text-align:left; ">
                                    <input type="text" name="" id="sbxx_sccs" style="width: 100%;" readonly/>
                                </td>
                            </tr>
                            <tr>
                                <th bgcolor="#FFFFFF"><p>生产日期</p></th>
                                <td bgcolor="#FFFFFF" style="text-align:left; ">
                                    <input type="text" name="" id="sbxx_scrq" style="width: 100%;" readonly/>
                                </td>
                                <th bgcolor="#FFFFFF"><p>装置型号</p></th>
                                <td bgcolor="#FFFFFF" style="text-align:left; ">
                                    <input type="text" name="" id="sbxx_zbxh" style="width: 100%;" readonly/>
                                </td>
                            </tr>
                            <tr>
                                <th bgcolor="#FFFFFF"><p>装置编号</p></th>
                                <td bgcolor="#FFFFFF" style="text-align:left; ">
                                    <input type="text" name="" id="sbxx_zbbh" style="width: 100%;" readonly/>
                                </td>
                                <th bgcolor="#FFFFFF"><p>装置类型</p></th>
                                <td bgcolor="#FFFFFF" style="text-align:left; ">
                                    <input id="sbxx_zzlx" type="hidden"/>
                                    <input type="text" name="" id="sbxx_zzlxname" style="width: 100%;" readonly/>
                                </td>
                            </tr>
                            <tr>
                                <th bgcolor="#FFFFFF"><p>软件版本及校验码</p></th>
                                <td bgcolor="#FFFFFF" style="text-align:left; ">
                                    <input type="text" name="" id="sbxx_rjbbJym" style="width: 100%;" readonly/>
                                </td>
                                <th bgcolor="#FFFFFF"><p>硬件版本</p></th>
                                <td bgcolor="#FFFFFF" style="text-align:left; ">
                                    <input type="text" name="" id="sbxx_yjbb" style="width: 100%;" readonly/>
                                </td>
                            </tr>
                            <tr>
                                <th bgcolor="#FFFFFF"><p>一次柜生产厂商</p></th>
                                <td bgcolor="#FFFFFF" style="text-align:left; ">
                                    <input type="text" name="" id="sbxx_sccsYcg" style="width: 100%;" readonly/>
                                </td>
                                <th bgcolor="#FFFFFF"><p>一次柜装置型号</p></th>
                                <td bgcolor="#FFFFFF" style="text-align:left; ">
                                    <input type="text" name="" id="sbxx_zbxhYcg" style="width: 100%;" readonly/>
                                </td>
                            </tr>
                            <tr>
                                <th bgcolor="#FFFFFF"><p>一次柜调试人员姓名</p></th>
                                <td bgcolor="#FFFFFF" style="text-align:left; ">
                                    <input type="text" name="" id="sbxx_tsryxmYcg" style="width: 100%;" readonly/>
                                </td>
                                <th bgcolor="#FFFFFF"><p>溢水生产厂商</p></th>
                                <td bgcolor="#FFFFFF" style="text-align:left; ">
                                    <input type="text" name="" id="sbxx_sccsYs" style="width: 100%;" readonly/>
                                </td>
                            </tr>
                            <tr>
                                <th bgcolor="#FFFFFF"><p>溢水柜装置型号</p></th>
                                <td bgcolor="#FFFFFF" style="text-align:left; ">
                                    <input type="text" name="" id="sbxx_zbxhYs" style="width: 100%;" readonly/>
                                </td>
                                <th bgcolor="#FFFFFF"><p>溢水柜调试人员姓名</p></th>
                                <td bgcolor="#FFFFFF" style="text-align:left; ">
                                    <input type="text" name="" id="sbxx_tsryxmYs" style="width: 100%;" readonly/>
                                </td>
                            </tr>
                            <tr>
                                <th bgcolor="#FFFFFF"><p>消防生产厂商</p></th>
                                <td bgcolor="#FFFFFF" style="text-align:left; ">
                                    <input type="text" name="" id="sbxx_sccsXf" style="width: 100%;" readonly/>
                                </td>
                                <th bgcolor="#FFFFFF"><p>消防装置型号</p></th>
                                <td bgcolor="#FFFFFF" style="text-align:left; ">
                                    <input type="text" name="" id="sbxx_zbxhXf" style="width: 100%;" readonly/>
                                </td>
                            </tr>
                            <tr>
                                <th bgcolor="#FFFFFF"><p>消防调试人员姓名</p></th>
                                <td bgcolor="#FFFFFF" style="text-align:left; ">
                                    <input type="text" name="" id="sbxx_tsryxmXf" style="width: 100%;" readonly/>
                                </td>
                                <th bgcolor="#FFFFFF"><p>详细位置</p></th>
                                <td bgcolor="#FFFFFF" style="text-align:left; ">
                                    <input type="text" name="" id="sbxx_xxwz" style="width: 100%;" readonly/>
                                </td>
                            </tr>
                        </table>
                    </td>
                </tr>

                <tr>
                    <th bgcolor="#FFFFFF"><p>处缺日期</p></th>                <!--改-->
                    <td bgcolor="#FFFFFF" style="text-align:left; ">
                        <input type="date" name="cqrq" id="cqrq" style="" readonly/>    <!--改-->
                    </td>
                </tr>

                <tr>
                    <th bgcolor="#FFFFFF"><p>缺陷分类</p></th>        <!--改-->
                    <td bgcolor="#FFFFFF" style="text-align:left; ">
                        <select id="qxfl" disabled></select>
                    </td>
                </tr>

                <tr>
                    <th bgcolor="#FFFFFF"><p>缺陷</p></th>                <!--改-->
                    <td bgcolor="#FFFFFF" style="text-align:left; ">
                        <textarea id="qx" rows="5" cols="" style="width: 99%; border:1px solid #CCC;" readonly></textarea>
                    </td>
                </tr>

                <tr>
                    <th bgcolor="#FFFFFF"><p>处缺记录</p></th>                <!--改-->
                    <td bgcolor="#FFFFFF" style="text-align:left; ">
                        <textarea id="cqjl" rows="5" cols="" style="width: 99%; border:1px solid #CCC;" readonly></textarea>
                    </td>
                </tr>

                <tr>
                    <th bgcolor="#FFFFFF"><p>处缺结果</p></th>                <!--改-->
                    <td bgcolor="#FFFFFF" style="text-align:left; ">
                        <input type="text" name="cqjg" id="cqjg" style="height:25px;width: 99%; border:1px solid #CCC;" readonly/>    <!--改-->
                    </td>
                </tr>

                <tr>
                    <th bgcolor="#FFFFFF"><p>处缺人员</p></th>                <!--改-->
                    <td bgcolor="#FFFFFF" style="text-align:left; ">
                        <input type="text" name="sgdw" id="sgdw" style="height:25px;width: 99%; border:1px solid #CCC;" readonly/>    <!--改-->
                    </td>
                </tr>

                <tr>
                    <th bgcolor="#FFFFFF"><p>备注</p></th>                <!--改-->
                    <td bgcolor="#FFFFFF" style="text-align:left; ">
                        <textarea id="beizhu" rows="5" cols="" style="width: 99%; border:1px solid #CCC;" readonly></textarea>
                    </td>
                </tr>

                <tr>
                    <td height="33" colspan="2" bgcolor="#f5f2ea">
                        <input type="button" onclick="javascript:window.close();" name="button" value="关闭" class="iput_m" style="height:25px;"/>
                    </td>
                </tr>

                </tbody>
            </table>
        </form>
    </div>
</div>

<script type="text/javascript">
    let cqid = "${requestScope.cqid}";
    $.get("${basePath}/cqrecord/selectByPrimaryKey/" + cqid, function (data) {		// 改
        let cq = JSON.parse(data);
        $("#sbxx_sbid").val(cq.data.sbid);		// 改
        $("#cqrq").val(timeStamp2DateString(cq.data.cqrq));
        // 选中缺陷分类
        $.get("${basePath}/qxfl/selectQxTypeByAll", function (data) {
            data = JSON.parse(data);
            $.each(data, function (i) {
                if (cq.data.qxfl === data[i].keyvalue) {
                    $("#qxfl").append("<option value='" + data[i].keyvalue + "' selected>" + data[i].keymemo + "</option>");
                } else {
                    $("#qxfl").append("<option value='" + data[i].keyvalue + "'>" + data[i].keymemo + "</option>");
                }
            })
        });
        $("#qx").val(cq.data.qx);		// 改
        $("#cqjl").val(cq.data.cqjl);		// 改
        $("#cqjg").val(cq.data.cqjg);		// 改
        $("#sgdw").val(cq.data.sgdw);		// 改
        $("#beizhu").val(cq.data.beizhu);		// 改

        selectBySbid(cq.data.sbid);
    });

    <!-- 给设备信息赋值 -->
    function selectBySbid(sbid) {
        $.get("${basePath}/equip/selectByPrimaryKey/"+ sbid, function (data) {
            data = JSON.parse(data);
            $("#sbxx_sbid").val(data.sbid);
            $("#sbxx_ssqy").val(data.ssqy);
            $("#sbxx_ssqyname").val(data.ssqyname);
            $("#sbxx_azddDdh").val(data.azddDdh);		// 改
            $("#sbxx_zdmc").val(data.zdmc);		// 改
            $("#sbxx_ssxl").val(data.ssxl);
            $("#sbxx_ssxlname").val(data.ssxlname);
            $("#sbxx_txmkcj").val(data.txmkcj);		// 改
            $("#sbxx_ipdz").val(data.ipdz);		// 改
            $("#sbxx_wlwkh").val(data.wlwkh);		// 改
            $("#sbxx_wlwkh").val(data.wlwkh);		// 改
            $("#sbxx_rtudz").val(data.rtudz);		// 改
            $("#sbxx_dkh").val(data.dkh);		// 改
            $("#sbxx_sccs").val(data.sccs);		// 改
            $("#sbxx_scrq").val(data.scrq);		// 改
            $("#sbxx_zbxh").val(data.zbxh);		// 改
            $("#sbxx_zbbh").val(data.zbbh);		// 改
            $("#sbxx_zzlx").val(data.zzlx);
            $("#sbxx_zzlxname").val(data.zzlxname);
            $("#sbxx_rjbbJym").val(data.rjbbJym);		// 改
            $("#sbxx_yjbb").val(data.yjbb);		// 改
            $("#sbxx_sccsYcg").val(data.sccsYcg);		// 改
            $("#sbxx_zbxhYcg").val(data.zbxhYcg);		// 改
            $("#sbxx_tsryxmYcg").val(data.tsryxmYcg);		// 改
            $("#sbxx_sccsYs").val(data.sccsYs);		// 改
            $("#sbxx_zbxhYs").val(data.zbxhYs);		// 改
            $("#sbxx_tsryxmYs").val(data.tsryxmYs);		// 改
            $("#sbxx_sccsXf").val(data.sccsXf);		// 改
            $("#sbxx_zbxhXf").val(data.zbxhXf);		// 改
            $("#sbxx_tsryxmXf").val(data.tsryxmXf);		// 改
            $("#sbxx_xxwz").val(data.xxwz);		// 改
        });
    }
</script>

<script type="text/javascript">
    //在Jquery里格式化Date日期时间数据
    function timeStamp2DateString(time) {
        var datetime = new Date(time);
        datetime.setTime(time);
        var year = datetime.getFullYear();
        var month = datetime.getMonth() + 1 < 10 ? "0" + (datetime.getMonth() + 1) : datetime.getMonth() + 1;
        var date = datetime.getDate() < 10 ? "0" + datetime.getDate() : datetime.getDate();
        return year + "-" + month + "-" + date;
    }
</script>
</body>
</html>
