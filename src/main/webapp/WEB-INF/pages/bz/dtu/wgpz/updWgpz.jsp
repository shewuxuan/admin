<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../../import.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>创建标准——DTU外观结构与配置</title>
    <link rel="stylesheet" type="text/css" href="/static/style/wholemain.css"/>
    <script type="text/javascript" src="/static/js/jquery-1.12.3.min.js"></script>
    <script type="text/javascript" src="/static/js/bignumber.min.js"></script>
</head>
</head>
<body>
<div class="right_main">
    <div class="right_table" style="width:96%;">
        <form name="myForm" id="myForm" action="${basePath}/ssqy/selectSsqyByAll" method="post">
            <table width="100%" cellpadding="0" cellspacing="1" bgcolor="#c6c6c6">
                <tbody>

                <tr>
                    <th bgcolor="#FFFFFF"><p>所属区域</p></th>
                    <td bgcolor="#FFFFFF" style="text-align:left; ">
                        <select name="ssqy" id="ssqy" style="height:25px; border:1px solid #CCC;"></select>
                    </td>
                </tr>

                <tr>
                    <th bgcolor="#FFFFFF"><p>测试项目</p></th>
                    <td bgcolor="#FFFFFF" style="text-align:left; ">
                        <input type="text" name="csxm" id="csxm" style="height:25px; border:1px solid #CCC;"/></td>
                </tr>

                <tr>
                    <th bgcolor="#FFFFFF"><p>技术标准或测试要求</p></th>
                    <td bgcolor="#FFFFFF" style="text-align:left; ">
                        <textarea id="csyq" name="csyq" class="" style="border:1px solid #CCC; width: 99%"
                                  rows="10"></textarea>
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

<script type="text/javascript">
    $(function () {
        // 获取当前id的标准信息
        let id = "${requestScope.id}";
        $.get("${basePath}/bzwgpz/selectByPrimaryKey/" + id, function (data) {		// 改url
            let bz = JSON.parse(data);
            $("#csxm").val(bz.csxm);		// 改
            $("#csyq").val(bz.csyq);		// 改

            // 给所属区域赋值，并选中
            $.get("${basePath}/ssqy/selectSsqyByAll", function (data) {
                let ssqy = JSON.parse(data);
                for (let i = 0, length = ssqy.length; i < length; i++) {
                    if (bz.ssqy == ssqy[i].keyvalue) {
                        $("#ssqy").append("<option value='" + ssqy[i].keyvalue + "' selected>" + ssqy[i].keymemo + "</option>");
                    } else {
                        $("#ssqy").append("<option value='" + ssqy[i].keyvalue + "'>" + ssqy[i].keymemo + "</option>");
                    }
                }
            });

        });
    });
</script>

<script type="text/javascript">
    <%-- 提交表单 --%>

    function commit() {
        let csxm = $("#csxm").val();
        let csyq = $("#csyq").val();
        if (csxm === "" || csxm == null || csxm.replace(/(^\s*)|(\s*$)/g, "") === "") {
            alert("测试项目不能为空！");
            $("#csxm").focus();
            return false;
        } else if (csyq === "" || csyq == null || csyq.replace(/(^\s*)|(\s*$)/g, "") === "") {
            alert("技术标准或测试要求不能为空！");
            $("#csyq").focus();
            return false;
        } else {
            let data = new FormData($(".myForm")[0]);
            data.append("ssqy", $("#ssqy").val());
            data.append("csxm", csxm);
            data.append("csyq", csyq);

            $.ajax({
                type: 'POST',
                processData: false, // 告诉jquery不要处理数据
                contentType: false, // 告诉jquery不要设置contentType
                data: data,
                url: '${basePath}/bzwgpz/updateByPrimaryKey/' + "${requestScope.id}",
                success: function (data) {
                    if (data == 1) {
                        alert("修改成功！");
                        window.opener.location.reload();
                        window.close();
                    } else {
                        alert("修改失败！");
                        window.opener.location.reload();
                        window.close();
                    }
                }
            })
        }
    }
</script>
</body>
</html>
