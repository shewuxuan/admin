<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="import.jsp" %>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<html lang="en">
<head>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,Chrome=1"/>

    <title>评估方案管理</title>
    <link rel="stylesheet" type="text/css" href="/css/fanganchuangjian.css"/>
    <link rel="stylesheet" type="text/css" href="/css/menu.css"/>
</head>
<body onload="open()">
<div class="left" style="height: 1000px;">

    <ul>
        <c:if test="${funcMap.bzgl !=0}">
        <li class="current">
            <a href="/toSjglView.action" target='mainFrame'    class="current left_hover"  >
                <img src="/images/top04.png" />
                <p>标准管理</p>
            </a>
        </li>
        </c:if>
        <c:if test="${funcMap.tsgl !=0}">
        <li class="current">
            <a href="/jl/jbxxList" target='mainFrame'  class="current left_hover"  >
                <img src="/images/top09.gif" />
                <p>调试信息</p>
            </a>
        </li>
        </c:if>
        <c:if test="${funcMap.sbgl !=0}">
        <li class="current">
            <a href="/equip/toEquipInfoView.action" target='mainFrame' class="current left_hover"  >
                <img src="/images/top06.gif" />
                <p>设备管理</p>
            </a>
        </li>
        </c:if>
        <c:if test="${funcMap.cqgl !=0}">
        <li class="current">
            <a href="/cq/cqManage" target='mainFrame'  onmousedown=""  class="current left_hover"  >
                <img src="/images/top06.png" />
                <p>处缺记录</p>
            </a>
        </li>
        </c:if>
       <%-- <li class="current">
            <a href="/pwbhJbxx/toPwbhJbxxView.action" target='mainFrame'  onmousedown=""  class="current left_hover"  >
                <img src="/images/top02.gif" />
                <p>配网保护</p>
            </a>
        </li>--%>
        <li>
            <a href="/user/sysByUser.action" target='mainFrame' class="left_hover"  >
                  <img src="/images/top08.png" />
                  <p>系统管理</p>
              </a>
          </li>
    </ul>
</div>
<script>
    window.onload = function () {
        console.info(${basePath});
        var lis = document.getElementById("list").getElementsByTagName("li");
        for (var i = 0; i < lis.length; i++) {
            lis[i].setAttribute("index", i);
            lis[i].onclick = function () {
                for (var i = 0; i < lis.length; i++) {
                    if (this.getAttribute("index") == i) {
                        lis[i].className = "current";
                    } else {
                        lis[i].className = "";
                    }
                }
            }
        }
    }
</script>

</body>
</html>