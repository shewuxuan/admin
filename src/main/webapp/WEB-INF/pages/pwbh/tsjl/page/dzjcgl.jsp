<%--
  Created by IntelliJ IDEA.
  User: 2uli
  Date: 2020/6/17
  Time: 10:51 上午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<script>
    layui.use('table', function () {
        let table = layui.table;
        let tableReload = table.render({
            elem: '#dzjcgl'                           // 改
            , page: false
            , skin: 'row,line' //行边框风格
            , even: false //开启隔行背景
            , url: '${basePath}/pwbh_jl_dzjc/selectByAll?tsid=' + tsid //数据接口      改
            , toolbar: true
            , defaultToolbar: [
            ]
            , cols: [[ //表头
                {field: 'jg', title: '相别', width: '10%', align: 'center', fixed: 'left', sort: true, rowspan: 2}
                , {field: 'g1', title: '过流I段整定值', width: '15%', align: 'center', rowspan: 2}
                , {title: '实际通电0.95倍定值／1.05倍定值', align: 'center', colspan: 2}
                , {field: 'g2', title: '过流II段整定值', width: '15%', align: 'center', rowspan: 2}
                , {title: '实际通电0.95倍定值／1.05倍定值', align: 'center', colspan: 2}
            ],
                [
                    {field: 'g11', title: '不动作(A)', width: '15%', align: 'center'}
                    , {field: 'g12', title: '动作(A)', width: '15%', align: 'center'}
                    , {field: 'g21', title: '不动作(A)', width: '15%', align: 'center'}
                    , {field: 'g22', title: '动作(A)', width: '15%', align: 'center'}

                ]]
            , done: function (res) {
            }
        });
    });
</script>
</body>
</html>
