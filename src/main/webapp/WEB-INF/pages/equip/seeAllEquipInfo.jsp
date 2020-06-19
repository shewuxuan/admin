<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../import.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>查看设备信息</title>
    <link rel="stylesheet" type="text/css" href="/style/wholemain.css"/>
    <script src="/js/jquery.js"></script>
    <script type="text/javascript" src="/js/jquery.min.js"></script>
    <script type="text/javascript" src="/js/WdatePicker.js"></script>
    <link rel="stylesheet" type="text/css" href="/style/easyui/themes/default/easyui.css"/>
    <script type="text/javascript" src="/js/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="/js/easyui-lang-zh_CN.js"></script>
    <!-- 设置地图ak, api key 申请的密钥 -->
    <script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=KU3KGvuGAZBLbLai55AuWrQikAsqmC2g"></script>
</head>
<style type="text/css">
    #descDiv::-webkit-scrollbar{
        display: none;
    }
</style>
<body>
<div class="right_main">
    <div class="right_table" style="width:96%;">
        <form name="myForm" id="myForm" method="post">
            <table width="100%" cellpadding="0" cellspacing="1" bgcolor="#c6c6c6">
                <tbody>
                    <tr>
                        <th bgcolor="#FFFFFF"><p>所属区域</p></th>
                        <td bgcolor="#FFFFFF" style="text-align:left; ">
                            <select name="ssqy" id="ssqy" style="height:25px; border:1px solid #CCC;">
                            </select>
                        </td>
                        <th bgcolor="#FFFFFF"><p>装置类型</p></th>
                        <td bgcolor="#FFFFFF" style="text-align:left; ">
                            <select name="zzlx" id="zzlx" style="height:25px; border:1px solid #CCC;">
                            </select>
                        </td>
                        <th bgcolor="#FFFFFF"><p>设备调度号</p></th>
                        <td bgcolor="#FFFFFF" style="text-align:left; ">
                            <input type="text" name="azddDdh" id="azddDdh" style="height:25px; border:1px solid #CCC;"/>
                            &nbsp;<input type="button" name="button"  value="查 询" class="iput_m" onclick="searchList()"/>
                           <%-- <img src='/equip/createQRCodeByEquipInfo.action?sbid=202003200202487133'>--%>
                           <%-- <img src='/equip/createQRCodeByEquipInfo.action?sbid=202003200202487133'>--%>
                            <%--<img src="/img/vcodeimg.action" id="vImg">--%>
                        </td>
                    </tr>
                </tbody>
            </table>
                            <div class="main-div" style="height:500px;width: 800px;margin-top: 5px;">
                                <div id='allmap' style='width:  96%; height:80%; position: absolute;'></div>
                            </div>
            <div id="outerdiv" style="position:fixed;top:0;left:0;background:rgba(0,0,0,0.7);z-index:2;width:100%;height:100%;display:none;">
                <div id="innerdiv" style="position:absolute;">
                    <img id="bigimg" style="border:1px solid #fff;" src="" />
                </div>
            </div>
        </form>
    </div>
</div>
<%--//调用百度地图--%>
<%--<a href="bdapp://map/direction?region=beijing&origin=39.98871,
        116.43234&destination=西直门&coord_type=bd09ll&mode=driving&src=andr.baidu.openAPIdemo">
    公交/驾车去这里2</a>--%>
<script>
    //放大图片
    function divImgView(imgId) {
        var src = '/equip/getEquipPhotoView.action?pid='+imgId;
        imgShow("#outerdiv", "#innerdiv", "#bigimg", src);
    }
    function imgShow(outerdiv, innerdiv, bigimg, src){
        $(bigimg).attr("src", src);//设置#bigimg元素的src属性
        /*获取当前点击图片的真实大小，并显示弹出层及大图*/
        $("<img/>").attr("src", src).load(function(){
            var windowW = $(window).width();//获取当前窗口宽度
            var windowH = $(window).height();//获取当前窗口高度
            var realWidth = this.width;//获取图片真实宽度
            var realHeight = this.height;//获取图片真实高度
            var imgWidth, imgHeight;
            var scale = 0.8;//缩放尺寸，当图片真实宽度和高度大于窗口宽度和高度时进行缩放

            if(realHeight>windowH*scale) {//判断图片高度
                imgHeight = windowH*scale;//如大于窗口高度，图片高度进行缩放
                imgWidth = imgHeight/realHeight*realWidth;//等比例缩放宽度
                if(imgWidth>windowW*scale) {//如宽度扔大于窗口宽度
                    imgWidth = windowW*scale;//再对宽度进行缩放
                }
            } else if(realWidth>windowW*scale) {//如图片高度合适，判断图片宽度
                imgWidth = windowW*scale;//如大于窗口宽度，图片宽度进行缩放
                imgHeight = imgWidth/realWidth*realHeight;//等比例缩放高度
            } else {//如果图片真实高度和宽度都符合要求，高宽不变
                imgWidth = realWidth;
                imgHeight = realHeight;
            }
            $(bigimg).css("width",imgWidth);//以最终的宽度对图片缩放

            var w = (windowW-imgWidth)/2;//计算图片与窗口左边距
            var h = (windowH-imgHeight)/2;//计算图片与窗口上边距
            $(innerdiv).css({"top":h, "left":w});//设置#innerdiv的top和left属性
            $(outerdiv).fadeIn("fast");//淡入显示#outerdiv及.pimg
        });

        $(outerdiv).click(function(){//再次点击淡出消失弹出层
            $(this).fadeOut("fast");
        });
    }
    $(function () {
        searchList();
    });

    var points = [];
    var map = new BMap.Map("allmap");

    function searchList(){
        deletePoint();
        map.clearOverlays();
        var queryParams = new Object();
        var ssqy = $('#ssqy').val();
        queryParams.ssqy = ssqy;
        queryParams.azddDdh = $('#azddDdh').val();
        queryParams.zzlx = $('#zzlx').val();
        $.post("/equip/seeAllEquipInfoQuery.action", queryParams,function (data) {
           points = data;
           createMap();
            //设置版权控件位置
            var cr = new BMap.CopyrightControl({anchor: BMAP_ANCHOR_TOP_RIGHT});
            cr.addCopyright({id: 1, content: '<ul style="width:90px;font-size: 12px;line-height:19px;background-color: #fff;\"><li>&nbsp;<img src="/images/blue.png" width="15" height="15"/>&nbsp;开闭站</li>'
                    +'<li>&nbsp;<img src="/images/orange.png" width="15" height="15"/>&nbsp;开闭器</li>'
                    +'<li>&nbsp;<img src="/images/green.png" width="15" height="15"/>&nbsp;分界室</li>'
                    +'<li>&nbsp;<img src="/images/grey.png" width="15" height="15"/>&nbsp;箱变</li>'
                    +'<li>&nbsp;<img src="/images/violet.png" width="15" height="15"/>&nbsp;配电室</li>'
                    +'<li>&nbsp;<img src="/images/darkblue.png" width="15" height="15"/>&nbsp;柱变TTU</li>'
                    +'<li>&nbsp;<img src="/images/pink.png" width="15" height="15"/>&nbsp;柱上FTU</li>'
                    +'<li>&nbsp;<img src="/images/red.png" width="15" height="15"/>&nbsp;故障指示器</li></ul>'});
           getBoundary(choicePlan(ssqy));
            map.addControl(cr);
        });
        $('. BMap_cpyCtrl BMap_noprint anchorBL').hide();
    }

    function choicePlan(ssqy) {
        var name = "";
        switch (ssqy) {
            case "1":
                name="北京市石景山区";
                break;
            case "2":
                name="北京市门头沟区";
                break;
            case "3":
                name="北京市朝阳区";
                break;
            default:
                name="北京市";
        }
        return name;
    }

    function choiceZzlxName(zzlx) {
        var name = "";
        switch (zzlx) {
            case "1":
                name="开闭站";
                break;
            case "2":
                name="开闭器";
                break;
            case "3":
                name="分界室";
                break;
            case "4":
                name="箱变";
                break;
            case "5":
                name="配电室";
            case "6":
                name="柱变TTU";
            case "7":
                name="柱上FTU";
            case "8":
                name="故障指示器";
                break;
        }
        return name;
    }
    //中国正常GCJ02坐标---->百度地图BD09坐标
    function convertGCJ02ToBD09($lat, $lng)
    {
        $xPi   = 3.14159265358979324 * 3000.0 / 180.0;
        $x     = $lng;
        $y     = $lat;
        $z     = Math.sqrt($x * $x + $y * $y) + 0.00002 * Math.sin($y * $xPi);
        $theta = Math.atan2($y, $x) + 0.000003 * Math.cos($x * $xPi);
        $lng   = $z * Math.cos($theta) + 0.0065;
        $lat   = $z * Math.sin($theta) + 0.006;

        $arr = [];
        $arr['lng'] = $lng;
        $arr['lat'] = $lat;

        return $arr;
    }
    //装置类型
    var icon1 = new BMap.Icon("/images/blue.png",new BMap.Size(19,25));
    var icon2 = new BMap.Icon("/images/orange.png",new BMap.Size(19,25));
    var icon3 = new BMap.Icon("/images/green.png",new BMap.Size(19,25));
    var icon4 = new BMap.Icon("/images/grey.png",new BMap.Size(19,25));
    var icon5 = new BMap.Icon("/images/violet.png",new BMap.Size(19,25));
    var icon6 = new BMap.Icon("/images/darkblue.png",new BMap.Size(19,25));
    var icon7 = new BMap.Icon("/images/pink.png",new BMap.Size(19,25));
    var icon8 = new BMap.Icon("/images/red.png",new BMap.Size(19,25));
    //创建标注点并添加到地图中
    function addMarker(points) {
        for(var i=0, pointsLen = points.length; i<pointsLen; i++) {
            var $arr = convertGCJ02ToBD09(points[i].wd,points[i].jd);
            var point = new BMap.Point($arr.lng, $arr.lat);
            var marker = null;
            if(points[i].zzlx == 1){
                marker = new BMap.Marker(point,{icon:icon1}); //将点转化成标注点
            }else if(points[i].zzlx == 2){
                marker = new BMap.Marker(point,{icon:icon2}); //将点转化成标注点
            }else if(points[i].zzlx == 3){
                marker = new BMap.Marker(point,{icon:icon3}); //将点转化成标注点
            }else if(points[i].zzlx == 4){
                marker = new BMap.Marker(point,{icon:icon4}); //将点转化成标注点
            }else if(points[i].zzlx == 5){
                marker = new BMap.Marker(point,{icon:icon5}); //将点转化成标注点
            }else if(points[i].zzlx == 6){
                marker = new BMap.Marker(point,{icon:icon6}); //将点转化成标注点
            }else if(points[i].zzlx == 7){
                marker = new BMap.Marker(point,{icon:icon7}); //将点转化成标注点
            }else if(points[i].zzlx == 8){
                marker = new BMap.Marker(point,{icon:icon8}); //将点转化成标注点
            }
            //markers.setColor("green");
        map.addOverlay(marker);  //将标注点添加到地图上
             (function() {
                 var thePoint = points[i];
                 marker.addEventListener("click",
                     function(){
                     showInfo(this,thePoint);
                 });
             })();
        //直接显示tip，不添加事件
        //showInfo(marker,points[i]);
        }
    }

    //查询设备照片
    function getEquipPhotoView(sbid) {
            var formdata = new FormData(); // 模拟表单对象
            formdata.append("sbid",sbid);
            var text = "";
            $.ajax({
                url : '${ctx}/equip/getEquipPhotos.action',
                type : 'POST',
                async : false,
                data: formdata,
                processData : false,
                contentType : false,
                beforeSend:function(){
                    console.log("正在加载，请稍候");
                },
                success:function(result){
                    var arr = JSON.parse(result);
                    for(var i = 0; i < arr.length; i++){
                        //text +='<br/><br/>&nbsp;&nbsp;<img width=\'180px\' height=\'180px\' src=\'/equip/getEquipPhotoView.action?pid='+arr[i].PID+'\'>';
                        text +='<br/><div align="center"><img src=\'/equip/getEquipPhotoView.action?pid='+arr[i].PID+'\' id=\''+arr[i].PID+'\'  width="150" onclick=\'divImgView("'+arr[i].PID+'")\'><p>'+arr[i].P_NAME+'</p></div>';
                    }
                },
                error : function(XMLHttpRequest, textStatus, errorThrown) {
                    alert(errorThrown);
                },
                async:false
            });
            return text;
    }
    //展示详细信息
    function showInfo(thisMarker,point) {
        var text = getEquipPhotoView(point.sbid);
        var content = '<div id="descDiv" style="overflow-y:scroll; overflow-x:hidden; background-color:#f5f0f0;margin:0;line-height:20px;padding:15px;width:300px;height: 290px;">'
            +'&nbsp;&nbsp;&nbsp;<img width=\'180px\' height=\'180px\' src=\'/equip/createQRCodeByEquipInfo.action?sbid='+point.sbid+'\'>'
            +'<br/>&nbsp;<b>终端名称：</b>'+point.zdmc
            +'<br/>&nbsp;<b>装置类型：</b>'+choiceZzlxName(point.zzlx)
            +'<br/>&nbsp;<b>设备调度号：</b>'+point.azddDdh
            +'<br/>&nbsp;<b>详细位置：</b>'+point.xxwz+'<hr>'
            +text
            +'</div>';
        var infoWindow = new BMap.InfoWindow(content); //创建信息窗口对象
        thisMarker.openInfoWindow(infoWindow); //图片加载完后重绘infoWindow
    }
    //创建地图
    function createMap() {
        map.centerAndZoom(new BMap.Point(116.403765, 39.914850));  // 设置中心点
        map.setCurrentCity("北京");
        //map.addControl(new BMap.MapTypeControl());
        map.enableScrollWheelZoom(true);
        addMarker(points);
    }

    //行政区域轮廓
    function getBoundary(ssqy){
        var bdary = new BMap.Boundary();
        bdary.get(ssqy, function(rs){       //获取行政区域
            //map.clearOverlays();        //清除地图覆盖物
            var count = rs.boundaries.length; //行政区域的点有多少个
            if (count === 0) {
                alert('未能获取当前输入行政区域');
                return ;
            }
            var pointArray = [];
            for (var i = 0; i < count; i++) {
                var ply = new BMap.Polygon(rs.boundaries[i], {strokeWeight: 2,fillOpacity: 0.1, strokeColor: "#ff0000"}); //建立多边形覆盖物
                map.addOverlay(ply);  //添加覆盖物
                pointArray = pointArray.concat(ply.getPath());
            }
            map.setViewport(pointArray);    //调整视野
            addlabel();
        });
    }
    //删除标注
    function deletePoint(){
        var allOverlay = map.getOverlays();
        for (var i = 0; i < allOverlay.length -1; i++){
            //if(allOverlay[i].getLabel().content == "我是id=1"){
                map.removeOverlay(allOverlay[i]);
            //}
        }
    }

</script>

<script>
    $(function () {
        $.post("/ssqy/selectSsqyByAll", function (data) {
            let ssqy = JSON.parse(data);
            $("#ssqy").append("<option value='' selected>全部</option>");
            for (let i = 0, length = ssqy.length; i < length; i++) {
                    $("#ssqy").append("<option value='" + ssqy[i].keyvalue + "'>" + ssqy[i].keymemo + "</option>");
            }
        });

        $.post("/sbZzlx/selectSbZzlxByAll", function (data) {
            let zzlx = JSON.parse(data);
            $("#zzlx").append("<option value='' selected>全部</option>");
            for (let i = 0, length = zzlx.length; i < length; i++) {
                    $("#zzlx").append("<option value='" + zzlx[i].keyvalue + "'>" + zzlx[i].keymemo + "</option>");
            }
        });
    });
</script>
</body>
</html>
