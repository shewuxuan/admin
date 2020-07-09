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
        let record = null;
        let autosave = null;
        let tableReload = table.render({
            elem: '#dzjclx'                           // 改
            , page: false
            , skin: 'row,line' //行边框风格
            , even: false //开启隔行背景
            , url: '${basePath}/pwbh_dz/selectByAll?tsid=' + tsid //数据接口      改
            , toolbar: true
            , defaultToolbar: [
            ]
            , cols: [[ //表头
                {title: '相别', width: '10%', align: 'center', fixed: 'left', rowspan: 2, templet: function () {
                    return 'L-0';
                    }}
                , {field: 'lx1', title: '零序I段整定值', width: '13%', align: 'center', rowspan: 2}
                , {title: '实际通电0.95倍定值／1.05倍定值', align: 'center', colspan: 2}
                , {field: 'lx2', title: '零序II段整定值', width: '13%', align: 'center', rowspan: 2}
                , {title: '实际通电0.95倍定值／1.05倍定值', align: 'center', colspan: 2}
            ],
                [
                    {field: 'lx11', title: '不动作(A)', width: '16%', align: 'center'}
                    , {field: 'lx12', title: '动作(A)', width: '16%', align: 'center'}
                    , {field: 'lx21', title: '不动作(A)', width: '16%', align: 'center'}
                    , {field: 'lx22', title: '动作(A)', width: '16%', align: 'center'}

                ]]
            , done: function (res) {
                let resdata = res.data[0];
                record = resdata;
                if (record.l1 == null || record.l1 === ""
                || record.l11 == null || record.l11 === ""
                || record.l12 == null || record.l12 === ""
                || record.l2 == null || record.l2 === ""
                || record.l21 == null || record.l21 === ""
                || record.l22 == null || record.l22 === ""
                || record.lx1 == null || record.lx1 === ""
                || record.lx11 == null || record.lx11 === ""
                || record.lx12 == null || record.lx12 === ""
                || record.lx2 == null || record.lx2 === ""
                || record.lx21 == null || record.lx21 === ""
                || record.lx22 == null || record.lx22 === "") {
                    dzjclx = false;
                    bgcolor(dzjcgl,dzjclx);
                    return;
                }
                dzjclx = true;
                bgcolor(dzjcgl, dzjclx);
                // $.each(resdata, function (i) {
                //     if (resdata[i].jcjg == null || resdata[i].jcjg === "" || resdata[i].jcjg == -1) {
                //         dzjclx = false;
                //         bgcolor(dzjcgl, dzjclx);
                //         // $("#li_dzjc").css({"background-color": ""});
                //         return;
                //     }
                //     dzjclx = true;
                //     bgcolor(dzjcgl, dzjclx);
                //     // $("#li_dzjc").css({"background-color": "#009688"});
                // })
            }
        });
    });
</script>
</body>
</html>
