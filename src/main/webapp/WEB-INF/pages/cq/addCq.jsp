<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../import.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>创建处缺记录</title>             <!-- 改-->
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
                    <th bgcolor="#FFFFFF"><p>选择设备</p></th>
                    <td bgcolor="#FFFFFF" style="text-align:left; ">
                        <input type="button" name="button" value="选择" class="iput_m" onclick="pickSbid();">
                    </td>
                </tr>

                <tr>
                    <th bgcolor="#FFFFFF"><p>设备信息</p></th>
                    <td bgcolor="#FFFFFF" style="text-align:left; ">
                        <input type="hidden" name="" id="sbxx_sbid"/>
<%--                        <input type="hidden" name="" id="ssqy"/>--%>
                        <table style="width: 99%; margin-top: 0">
                            <tr>
                                <th bgcolor="#FFFFFF" style="width: 20%;"><p>设备调度号</p></th>
                                <td bgcolor="#FFFFFF" style="text-align:left; ">
                                    <input type="text" name="" id="sbxx_azddDdh" style="width: 100%;" readonly/>
                                </td>
                            </tr>
                            <tr>
                                <th bgcolor="#FFFFFF"><p>所属区域</p></th>
                                <td bgcolor="#FFFFFF" style="text-align:left; ">
                                    <input id="sbxx_ssqy" type="hidden"/>
                                    <input type="text" name="" id="sbxx_ssqyname" style="width: 100%;" readonly/>
                                </td>
                            </tr>
                            <tr>
                                <th bgcolor="#FFFFFF"><p>设备线路</p></th>
                                <td bgcolor="#FFFFFF" style="text-align:left; ">
                                    <input id="sbxx_ssxl" type="hidden"/>
                                    <input type="text" name="" id="sbxx_ssxlname" style="width: 100%;" readonly/>
                                </td>
                            </tr>
                            <tr>
                                <th bgcolor="#FFFFFF"><p>装置类型</p></th>
                                <td bgcolor="#FFFFFF" style="text-align:left; ">
                                    <input id="sbxx_zzlx" type="hidden"/>
                                    <input type="text" name="" id="sbxx_zzlxname" style="width: 100%;" readonly/>
                                </td>
                            </tr>
                        </table>
                    </td>
                </tr>

                <tr>
                    <th bgcolor="#FFFFFF"><p>处缺日期</p></th>                <!--改-->
                    <td bgcolor="#FFFFFF" style="text-align:left; ">
                        <input type="date" name="cqrq" id="cqrq" style=""/>    <!--改-->
                    </td>
                </tr>

                <tr>
                    <th bgcolor="#FFFFFF"><p>缺陷分类</p></th>        <!--改-->
                    <td bgcolor="#FFFFFF" style="text-align:left; ">
                        <select id="qxfl"></select>
                    </td>
                </tr>

                <tr>
                    <th bgcolor="#FFFFFF"><p>缺陷</p></th>                <!--改-->
                    <td bgcolor="#FFFFFF" style="text-align:left; ">
                        <textarea id="qx" rows="5" cols="" style="width: 99%; border:1px solid #CCC;"></textarea>
                    </td>
                </tr>

                <tr>
                    <th bgcolor="#FFFFFF"><p>处缺记录</p></th>                <!--改-->
                    <td bgcolor="#FFFFFF" style="text-align:left; ">
                        <textarea id="cqjl" rows="5" cols="" style="width: 99%; border:1px solid #CCC;"></textarea>
                    </td>
                </tr>

                <tr>
                    <th bgcolor="#FFFFFF"><p>处缺结果</p></th>                <!--改-->
                    <td bgcolor="#FFFFFF" style="text-align:left; ">
                        <input type="text" name="cqjg" id="cqjg"
                               style="height:25px;width: 99%; border:1px solid #CCC;"/>    <!--改-->
                    </td>
                </tr>

                <tr>
                    <th bgcolor="#FFFFFF"><p>处缺人员</p></th>                <!--改-->
                    <td bgcolor="#FFFFFF" style="text-align:left; ">
                        <input type="text" name="sgdw" id="sgdw"
                               style="height:25px;width: 99%; border:1px solid #CCC;"/>    <!--改-->
                    </td>
                </tr>

                <tr>
                    <th bgcolor="#FFFFFF"><p>备注</p></th>                <!--改-->
                    <td bgcolor="#FFFFFF" style="text-align:left; ">
                        <textarea id="beizhu" rows="5" cols="" style="width: 99%; border:1px solid #CCC;"></textarea>
                    </td>
                </tr>

                <tr>
                    <td height="33" colspan="2" bgcolor="#f5f2ea">
                        <input type="button" name="button" value="确定" onclick="commit()" class="iput_m"
                               style="height:25px;"/>
                        <input type="button" onclick="javascript:window.close();" name="button" value="关闭"
                               class="iput_m" style="height:25px;"/>
                    </td>
                </tr>

                </tbody>
            </table>
        </form>
    </div>
</div>

<%-- 缺陷分类 --%>
<script type="text/javascript">
    $(function () {
        // 缺陷分类
        $.get("${basePath}/qxfl/selectQxTypeByAll", function (data) {
            data = JSON.parse(data);
            $.each(data, function (i) {
                $("#qxfl").append("<option value='" + data[i].keyvalue + "'>" + data[i].keymemo + "</option>");
            })
        });

        // 日期框默认选中今天
        let time = new Date();
        let day = ("0" + time.getDate()).slice(-2);
        let month = ("0" + (time.getMonth() + 1)).slice(-2);
        let today = time.getFullYear() + "-" + (month) + "-" + (day);
        $('#cqrq').val(today);
    })
</script>
<%--  选择设备信息--%>
<script type="text/javascript">
    // 选择设备信息
    function pickSbid() {
        window.open("${basePath}/cq/pickSbid", "", "fullscreen=1");
    }

    // 给设备信息赋值
    function selectBySbid(sbid) {
        $.get("${basePath}/equip/selectByPrimaryKey/" + sbid, function (data) {
            data = JSON.parse(data);
            $("#sbxx_ssqy").val(data.ssqy);
            $("#sbxx_ssxl").val(data.ssxl);
            $("#sbxx_zzlx").val(data.zzlx);
            $("#sbxx_azddDdh").val(data.azddDdh);
            $("#sbxx_ssqyname").val(data.ssqyname);
            $("#sbxx_ssxlname").val(data.ssxlname);
            $("#sbxx_zzlxname").val(data.zzlxname);
        });
    }
</script>

<script type="text/javascript">
    <!-- 提交表单 -->
    function commit() {
        let sbid = $("#sbxx_sbid").val();
        let ssqy = $("#sbxx_ssqy").val();
        let ssxl = $("#sbxx_ssxl").val();
        let azddDdh = $("#sbxx_azddDdh").val();
        let zzlx = $("#sbxx_zzlx").val();
        let cqrq = $("#cqrq").val();
        let qxfl = $("#qxfl").val();
        let qx = $("#qx").val();
        let cqjl = $("#cqjl").val();
        let cqjg = $("#cqjg").val();
        let sgdw = $("#sgdw").val();
        let beizhu = $("#beizhu").val();
        if (sbid === "" || sbid == null || sbid.replace(/(^\s*)|(\s*$)/g, "") === "") {
            alert("请选择设备信息！");
        } else if (qx === "" || qx == null || qx.replace(/(^\s*)|(\s*$)/g, "") === "") {
            alert("缺陷不能为空！");
            $("#qx").focus();
            return false;
        } else if (cqjl === "" || cqjl == null || cqjl.replace(/(^\s*)|(\s*$)/g, "") === "") {
            alert("处缺记录不能为空！");
            $("#cqjl").focus();
            return false;
        } else if (cqjg === "" || cqjg == null || cqjg.replace(/(^\s*)|(\s*$)/g, "") === "") {
            alert("处缺结果不能为空！");
            $("#cqjg").focus();
            return false;
        } else if (sgdw === "" || sgdw == null || sgdw.replace(/(^\s*)|(\s*$)/g, "") === "") {
            alert("处缺人员不能为空！");
            $("#sgdw").focus();
            return false;
        } else {
            let record = {
                "sbid": sbid,
                "ssqy": ssqy,
                "ssxl": ssxl,
                "azddDdh": azddDdh,
                "zzlx": zzlx,
                "cqrq": cqrq,
                "qxfl": qxfl,
                "qx": qx,
                "cqjl": cqjl,
                "cqjg": cqjg,
                "sgdw": sgdw,
                "beizhu": beizhu
            };

            $.ajax({
                type: "POST",
                url: "${basePath}/cqrecord/insert",              // 改
                data: JSON.stringify(record),//必须
                contentType: "application/json;charsetset=UTF-8",//必须
                dataType: "json",//必须
                success: function (data) {
                    alert(data.msg);
                    window.opener.location.reload();
                    window.close();
                }
            });
        }
    }
</script>
</body>
</html>
