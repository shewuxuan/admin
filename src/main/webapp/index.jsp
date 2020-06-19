<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>自动化标准管理系统</title>
    <link type="text/css" rel="stylesheet" href="/style/style.css"/>
    <script type="text/javascript" src="/js/jquery-1.12.3.min.js"></script>
    <script type="text/javascript">
        function checkForm() {
            var form = document.forms[0];
            if (form.username.value == "") {
                alert("用户名不能为空!");
                form.username.focus();
                return false;
            }
            if (form.password.value == "") {
                alert("密码不能为空!");
                form.password.focus();
                return false;
            }
            if (form.rand.value == "") {
                alert("验证码不能为空!");
                form.rand.focus();
                return false;
            }
        }
    </script>
</head>
<body>
<div class="login">
    <div class="header">
        <div class="bt">自动化标准管理系统</div>
    </div>
    <ul>
        <li><b>用户名:</b><input name="loginName" id="loginName" type="text"/></li>
        <li><b style=" letter-spacing:3px;">密 码:</b><input name="password" id="password" type="password"/></li>
        <li><b>验证码:</b><input class="vCode" title="点击刷新验证码" alt="vCode" name="vCode" id="vCode" type="text"
                              style="width:80px;"/>
            <span style="flaot:left;"><img src="/img/vcodeimg.action" id="vImg"></span>
        </li>
        <%--            <li><b>区域:</b>--%>
        <%--                <select id="ssqy" style="    float: left;">--%>
        <%--                    <option value="1" selected>石景山</option>--%>
        <%--                    <option value="2">朝阳</option>--%>
        <%--                </select>--%>
        <%--            </li>--%>

        <li class="curr"><b>&nbsp;</b><input type="submit" value="登录" onclick="commit()"/><b>&nbsp;</b></li>
    </ul>

</div>
<script>
    $(function () {
        $('#loginName').focus();
    });
    $("#vImg").click(function () {
        $(this)[0].src = '/img/vcodeimg.action?' + Math.random()
    });

    function checkParam() {
        if ($("#loginName").val() == '') {
            alert("请输入用户名！");
            return false;
        }
        if ($("#password").val() == '') {
            alert("请输入密 码！");
            return false;
        }
        if ($("#vCode").val() == '') {
            alert("请输入验证码！");
            return false;
        }
        return true;
    }

    function commit() {
        if (!checkParam()) return;
        var formdata = new FormData(); // 模拟表单对象
        formdata.append("loginname", $("#loginName").val());
        formdata.append("password", $("#password").val());
        formdata.append("vCode", $("#vCode").val());
        // formdata.append("ssqy", $("#ssqy").val());
        $.ajax({
            url: '/loginJson.action',
            type: 'POST',
            async: false,
            data: formdata,
            // 告诉jQuery不要去处理发送的数据
            processData: false,
            // 告诉jQuery不要去设置Content-Type请求头
            contentType: false,
            beforeSend: function () {
                console.log("正在加载，请稍候");
            },
            success: function (data) {
               if (data.code == 0) {
                    window.location.href = '/main.action';
                } else {
                    alert(data.message);
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