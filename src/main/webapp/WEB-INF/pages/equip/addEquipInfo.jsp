<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../import.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>创建设备信息</title>
    <link rel="stylesheet" type="text/css" href="/style/wholemain.css"/>
    <script src="/js/jquery.js"></script>
    <script type="text/javascript" src="/js/jquery.min.js"></script>
    <script type="text/javascript" src="/js/WdatePicker.js"></script>
    <link rel="stylesheet" type="text/css" href="/style/easyui/themes/default/easyui.css"/>
    <script type="text/javascript" src="/js/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="/js/easyui-lang-zh_CN.js"></script>
    <script type="text/javascript" src="/js/sccj.js"></script>
    <!-- 设置地图ak, api key 申请的密钥 -->
    <script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=KU3KGvuGAZBLbLai55AuWrQikAsqmC2g"></script>
</head>
<style type="text/css">
    #searchresult
    {
        position: absolute;
        z-index: 1;
        overflow: hidden;
        background: #f0f0f0;
        border-top: none;
    }
    .sccs
    {
        width: 170px;
        font-size:15px;
        height:20px;
    }
    .line
    {
        font-size: 12px;
        background: #E0E0E0;
        width: 140px;
    }
    .hover
    {
        background: #007ab8;
        width: 140px;
        color: #fff;
    }
    .std
    {
        width: 165px;
        height: 20px;
    }
</style>
<script>
    $(function () {
        var curr_time = new Date();
        var strDate = curr_time.getFullYear() + "-";
        strDate += curr_time.getMonth() + 1 + "-";
        strDate += curr_time.getDate() + " ";
            $('#scrq').datebox('setValue', strDate);
    });
</script>
<body>
<div class="right_main">
    <div class="right_table" style="width:96%;">
        <form name="myForm" id="myForm" method="post">
            <table width="100%" cellpadding="0" cellspacing="1" bgcolor="#c6c6c6" id="testTab">
                <tbody>
                    <tr>
                        <th colspan="4" align="center" bgcolor="#f5f2ea">添加</th>
                    </tr>
                    <tr>
                        <th bgcolor="#FFFFFF"><p>所属区域</p></th>
                        <td bgcolor="#FFFFFF" style="text-align:left; ">
                            <select name="ssqy" id="ssqy" style="height:25px; border:1px solid #CCC;">
                            </select>
                        </td>
                        <th bgcolor="#FFFFFF"><p>装置编号</p></th>
                        <td bgcolor="#FFFFFF" style="text-align:left; ">
                            <input type="text" name="zbbh" id="zbbh" ondblclick="defaultClick(this)" style="height:25px; border:1px solid #CCC;"/>
                        </td>
                    </tr>
                    <tr>
                        <th bgcolor="#FFFFFF"><p>装置类型</p></th>
                        <td bgcolor="#FFFFFF" style="text-align:left; ">
                            <select name="zzlx" id="zzlx" ondblclick="defaultClick(this)" style="height:25px; border:1px solid #CCC;">
                            </select>
                        </td>
                        <th bgcolor="#FFFFFF"><p>DTU装置型号</p></th>
                        <td bgcolor="#FFFFFF" style="text-align:left; ">
                            <input type="text" name="zbxh" id="zbxh" ondblclick="defaultClick(this)" style="height:25px; border:1px solid #CCC;"/>
                        </td>
                    </tr>
                    <tr>
                        <th bgcolor="#FFFFFF"><p>设备调度号</p></th>
                        <td bgcolor="#FFFFFF" style="text-align:left; ">
                            <input type="text" name="azddDdh" id="azddDdh" style="height:25px; border:1px solid #CCC;"/>
                        </td>
                        <th bgcolor="#FFFFFF"><p>DTU生产厂商</p></th>
                        <td bgcolor="#FFFFFF" style="text-align:left; ">
                            <input type="text" name="sccs" id="sccs" class="sccs" ondblclick="defaultClick(this)" style="height:25px; border:1px solid #CCC;"/>
                        </td>
                    </tr>
                    <tr>
                        <th bgcolor="#FFFFFF"><p>所属线路</p></th>
                        <td bgcolor="#FFFFFF" style="text-align:left; ">
                            <select id="bdz"></select>&nbsp;<select id="xlmc"></select>
                            <input type="hidden" name="ssxl" id="ssxl" value=""/>
                        </td>
                        <th bgcolor="#FFFFFF"><p>一次柜装置型号</p></th>
                        <td bgcolor="#FFFFFF" style="text-align:left; ">
                            <input type="text" name="zbxhYcg" id="zbxhYcg" ondblclick="defaultClick(this)" style="height:25px; border:1px solid #CCC;"/>
                        </td>
                    </tr>
                    <tr>
                        <%--<th bgcolor="#FFFFFF"><p>终端名称</p></th>
                        <td bgcolor="#FFFFFF" style="text-align:left; ">
                            <input type="text" name="zdmc" id="zdmc" ondblclick="defaultClick(this)" style="height:25px; border:1px solid #CCC;"/>
                        </td>--%>
                            <th bgcolor="#FFFFFF"><p>通信模块厂家</p></th>
                            <td bgcolor="#FFFFFF" style="text-align:left; ">
                                <input type="text" name="txmkcj" id="txmkcj" class="sccs" style="height:25px; border:1px solid #CCC;"/>
                                <div id="searchresult" style="display: none;margin-top:10px;"/>
                            </td>
                        <th bgcolor="#FFFFFF"><p>一次柜生产厂商</p></th>
                        <td bgcolor="#FFFFFF" style="text-align:left; ">
                            <input type="text" name="sccsYcg" id="sccsYcg" class="sccs" ondblclick="defaultClick(this)" style="height:25px; border:1px solid #CCC;"/>
                        </td>
                    </tr>
                    <tr>
                        <th bgcolor="#FFFFFF"><p>物联网卡号</p></th>
                        <td bgcolor="#FFFFFF" style="text-align:left; ">
                            <input type="text" name="wlwkh" id="wlwkh" ondblclick="defaultClick(this)" style="height:25px; border:1px solid #CCC;"/>
                        </td>
                        <th bgcolor="#FFFFFF"><p>一次柜调试人员姓名电话</p></th>
                        <td bgcolor="#FFFFFF" style="text-align:left; ">
                            <input type="text" name="tsryxmYcg" id="tsryxmYcg" ondblclick="defaultClick(this)" style="height:25px; border:1px solid #CCC;"/>
                        </td>
                    </tr>
                    <tr>
                        <th bgcolor="#FFFFFF"><p>IP地址</p></th>
                        <td bgcolor="#FFFFFF" style="text-align:left; ">
                            <input type="text" name="ipdz" id="ipdz" ondblclick="defaultClick(this)" style="height:25px; border:1px solid #CCC;"/>
                        </td>
                        <th bgcolor="#FFFFFF"><p>溢水柜装置型号</p></th>
                        <td bgcolor="#FFFFFF" style="text-align:left; ">
                            <input type="text" name="zbxhYs" id="zbxhYs" ondblclick="defaultClick(this)" style="height:25px; border:1px solid #CCC;"/>
                        </td>
                    </tr>
                    <tr>
                        <th bgcolor="#FFFFFF"><p>RTU地址</p></th>
                        <td bgcolor="#FFFFFF" style="text-align:left; ">
                            <input type="text" name="rtudz" id="rtudz" ondblclick="defaultClick(this)" style="height:25px; border:1px solid #CCC;"/>
                        </td>
                        <th bgcolor="#FFFFFF"><p>溢水生产厂商</p></th>
                        <td bgcolor="#FFFFFF" style="text-align:left; ">
                            <input type="text" name="sccsYs" id="sccsYs"  class="sccs" ondblclick="defaultClick(this)" style="height:25px; border:1px solid #CCC;"/>
                        </td>
                    </tr>
                    <tr>
                        <th bgcolor="#FFFFFF"><p>端口号</p></th>
                        <td bgcolor="#FFFFFF" style="text-align:left; ">
                            <input type="text" name="dkh" id="dkh" ondblclick="defaultClick(this)" style="height:25px; border:1px solid #CCC;"/>
                        </td>
                        <th bgcolor="#FFFFFF"><p>溢水柜调试人员姓名电话</p></th>
                        <td bgcolor="#FFFFFF" style="text-align:left; ">
                            <input type="text" name="tsryxmYs" id="tsryxmYs" ondblclick="defaultClick(this)" style="height:25px; border:1px solid #CCC;"/>
                        </td>
                    </tr>
                    <tr>
                        <th bgcolor="#FFFFFF"><p>生产日期</p></th>
                        <td bgcolor="#FFFFFF" style="text-align:left; ">
                            <input class="easyui-datebox" name="scrq" id="scrq"
                                   data-options="required:true" style="width:120px"/>
                        </td>
                        <th bgcolor="#FFFFFF"><p>消防装置型号</p></th>
                        <td bgcolor="#FFFFFF" style="text-align:left; ">
                            <input type="text" name="zbxhXf" id="zbxhXf" ondblclick="defaultClick(this)" style="height:25px; border:1px solid #CCC;"/>
                        </td>

                    </tr>
                    <tr>
                        <th bgcolor="#FFFFFF"><p>软件版本及校验码</p></th>
                        <td bgcolor="#FFFFFF" style="text-align:left; ">
                            <input type="text" name="rjbbJym" id="rjbbJym" ondblclick="defaultClick(this)" style="height:25px; border:1px solid #CCC;"/>
                        </td>
                        <th bgcolor="#FFFFFF"><p>消防生产厂商</p></th>
                        <td bgcolor="#FFFFFF" style="text-align:left; ">
                            <input type="text" name="sccsXf" id="sccsXf" class="sccs" ondblclick="defaultClick(this)" style="height:25px; border:1px solid #CCC;"/>
                        </td>
                    </tr>
                    <tr>
                        <th bgcolor="#FFFFFF"><p>硬件版本</p></th>
                        <td bgcolor="#FFFFFF" style="text-align:left; ">
                            <input type="text" name="yjbb" id="yjbb" ondblclick="defaultClick(this)" style="height:25px; border:1px solid #CCC;"/>
                        </td>
                        <th bgcolor="#FFFFFF"><p>消防调试人员姓名电话</p></th>
                        <td bgcolor="#FFFFFF" style="text-align:left; ">
                            <input type="text" name="tsryxmXf" id="tsryxmXf" ondblclick="defaultClick(this)" style="height:25px; border:1px solid #CCC;"/>
                        </td>
                    </tr>
                    <tr>
                        <th bgcolor="#FFFFFF">添加照片</th>
                        <td bgcolor="#FFFFFF" colspan="3" style="text-align: left;">&nbsp;
                            <input type="button" value="添加"  onclick="addTr(14);" class="iput_m" />
                        </td>
                    </tr>
                    <tr>
                        <th bgcolor="#FFFFFF" style="width: 20%"><p>百度经纬度</p></th>
                        <td bgcolor="#FFFFFF" style="text-align:left; " colspan="3">
                                <span class="label">腾讯地图经度</span>
                                <input type="text" name="t_jd" id="t_jd" style="height:25px; border:1px solid #CCC;"/>
                                <span class="label">腾讯地图纬度</span>
                                <input type="text" name="t_wd" id="t_wd" style="height:25px; border:1px solid #CCC;"/>
                                <input type="button" onclick="switchXY()" value="确 定" class="iput_m"
                                       style="height:25px;"/>
                                <br/> <br/>
                                <span class="label">百度地图经度</span>
                                <input type="text" name="jd" id="jd" style="height:25px; border:1px solid #CCC;"/>
                                <span class="label">百度地图纬度</span>
                                <input type="text" name="wd" id="wd" style="height:25px; border:1px solid #CCC;"/>
                                <span class="label">详细位置</span>
                                <input type='text' name='xxwz' id='xxwz' size="30" style="height:25px; border:1px solid #CCC;">
                                <div class="main-div" style="height: 426px;width: 800px;margin-top: 5px;">
                                    <div id='allmap' style='width:  75%; height:400px; position: absolute;'></div>
                                </div>
                    </tr>
                    <tr>
                        <th bgcolor="#FFFFFF"><p>备注</p></th>
                        <td bgcolor="#FFFFFF" style="text-align:left; " colspan="3">
                            <textarea name="beizhu" id="beizhu" cols="100" rows="5" style="border:1px solid #CCC;"></textarea>
                        </td>
                    </tr>
                    <tr>
                        <td height="33" colspan="4" bgcolor="#f5f2ea">
                            <input type="button" name="button" value="提 交" onclick="commit()" class="iput_m"
                                   style="height:25px;"/>
                            <input type="button" onclick="javascript:window.close();" name="button" value="取 消"
                                   class="iput_m" style="height:25px;"/>
                        </td>
                    </tr>
                </tbody>
            </table>
            <div id="outerdiv" style="position:fixed;top:0;left:0;background:rgba(0,0,0,0.7);z-index:2;width:100%;height:100%;display:none;">
                <div id="innerdiv" style="position:absolute;">
                    <img id="bigimg" style="border:1px solid #fff;" src="" />
                </div>
            </div>
        </form>
    </div>
</div>
<script type="text/javascript">
    // 变电站
    $("#bdz").append("<option value=''>全部</option>");
    $.get("/ssxl/selectByGroup/bdz", function (data) {
        data = JSON.parse(data);
        $.each(data, function (i) {
            $("#bdz").append("<option value='" + data[i].bdz + "'>" + data[i].bdz + "</option>");
        })
    });
    // 线路名称
    $("#xlmc").append("<option value=''>全部</option>");

    // 变电站更改时，线路名称随之更改
    $("#bdz").change(function () {
        if ($("#bdz").val() === '') {
            $("#xlmc").empty();
            $("#xlmc").append("<option value=''>全部</option>");
            return;
        }
        $("#xlmc").empty();
        $("#xlmc").append("<option value=''>全部</option>");
        $.get("/ssxl/selectByGroup/xlmc",{"bdz": $("#bdz").val()}, function (data) {
            data = JSON.parse(data);
            $.each(data, function (i) {
                $("#xlmc").append("<option value='" + data[i].id + "'>" + data[i].xlmc + "</option>");
            })
        });
    });

    function defaultClick(e){
        e.value="N/A";
    }
</script>
<script type="text/javascript">
    function previewImage(file, prvid,imgName) {
        /* file：file控件
         * prvid: 图片预览容器
         */
        var tip = "请选择图片格式的文件!"; // 设定提示信息
        var filters = {
            "jpeg" : "/9j/4",
            "gif" : "R0lGOD",
            "png" : "iVBORw"
        }
        var prvbox = document.getElementById(prvid);
        prvbox.innerHTML = "";
        if (window.FileReader) { // html5方案
            for (var i = 0, f; f = file.files[i]; i++) {
                var fr = new FileReader();
                fr.onload = function(e) {
                    var src = e.target.result;
                    if (!validateImg(src)) {
                        alert(tip)
                    } else {
                        showPrvImg(src);
                    }
                }
                fr.readAsDataURL(f);
            }
        } else { // 降级处理

            if (!/\.jpg$|\.png$|\.gif$/i.test(file.value)) {
                alert(tip);
            } else {
                showPrvImg(file.value);
            }
        }

        function validateImg(data) {
            var pos = data.indexOf(",") + 1;
            for ( var e in filters) {
                if (data.indexOf(filters[e]) === pos) {
                    return e;
                }
            }
            return null;
        }

        function showPrvImg(src) {
            var img = document.createElement("img");
            img.src = src;
            img.height = 100;
            prvbox.appendChild(img);
            $(img).bind("click",function(){
                imgMaxView(this);
            });
           /* var fileNames = file.value;
            var index = fileNames.lastIndexOf("\\")+1;
            var end = fileNames.indexOf(".");
            var name = fileNames.substr(index);
            document.getElementById(imgName).value=name;*/
        }
    }
</script>
<%--//调用百度地图--%>
<script type="text/javascript">
    //放大图片
    function imgMaxView(e) {
        var _this = $(e);//将当前的pimg元素作为_this传入函数
        var src = _this.attr("src");//获取当前点击的pimg元素中的src属性
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
    var id=1;
    function addTr(index) {
        var tb=document.getElementById('testTab');
        var newTr = tb.insertRow(index);//在最下的位置
        newTr.height=500;
        newTr.id='tr'+id;
        var newTd0 = newTr.insertCell();
        var newTd1 = newTr.insertCell();
        var newTd2 = newTr.insertCell();
        var newTd3 = newTr.insertCell();
        newTd0.innerHTML="<p style='font-size: 12px;font-weight: bold;color: #333;font-family: \"宋体\";'>图片名称</p>";
        newTd1.innerHTML="<input type='text' name='imgName' id='imgName"+id+"' style='height:25px; border:1px solid #CCC;float: left;' value=''/>";
        newTd2.innerHTML= "<input style='float: left;margin: 40px 10px;width: 180px;' id='file"+id+"' name='file' type=file onchange=\"previewImage(this, 'prvid"+id+"','imgName"+id+"')\">";
        newTd3.innerHTML= "<div style='height:100px;float: left;margin-left: 60px;' id='prvid"+id+"'></div><button class='iput_m'onclick=\"moveTr('"+id+"');\" style='float: right;margin-left:-50px;margin-top: 60px;'>移除</button>";
        id++;
    }
    function moveTr(id){
        var tb=document.getElementById('testTab');
        var tr=document.getElementById('tr'+id);
        tb.deleteRow(tr.rowIndex);
    }

    var map = new BMap.Map("allmap");
    var geoc = new BMap.Geocoder();  //地址解析对象
    var markersArray = [];
    var geolocation = new BMap.Geolocation();
    var point = new BMap.Point(116.331398, 39.897445);

    map.centerAndZoom(point, 12); // 中心点
    geolocation.getCurrentPosition(function (r) {
        if (this.getStatus() == BMAP_STATUS_SUCCESS) {
            var mk = new BMap.Marker(r.point);
            map.addOverlay(mk);
            map.panTo(r.point);
            map.enableScrollWheelZoom(true);
        }
        else {
            alert('failed' + this.getStatus());
        }
    }, {enableHighAccuracy: true})
    map.addEventListener("click", showInfo);
    //清除标识
    function clearOverlays() {
        if (markersArray) {
            for (i in markersArray) {
                map.removeOverlay(markersArray[i])
            }
        }
    }
    // 编写自定义函数,创建标注
    //地图上标注
    function addMarker(point) {
        var marker = new BMap.Marker(point);
        markersArray.push(marker);
        clearOverlays();
        map.addOverlay(marker);
    }
    //点击地图时间处理
    function showInfo(e) {
        document.getElementById('jd').value = e.point.lng;
        document.getElementById('wd').value = e.point.lat;
        geoc.getLocation(e.point, function (rs) {
            var addComp = rs.addressComponents;
            var address = addComp.province + addComp.city + addComp.district + addComp.street + addComp.streetNumber;
            document.getElementById('xxwz').value = address;
        });
        addMarker(e.point);
    }

    //缩放按钮
    var top_left_control = new BMap.ScaleControl({anchor: BMAP_ANCHOR_TOP_LEFT});// 左上角，添加比例尺
    var top_left_navigation = new BMap.NavigationControl();  //左上角，添加默认缩放平移控件
    var top_right_navigation = new BMap.NavigationControl({anchor: BMAP_ANCHOR_TOP_RIGHT, type: BMAP_NAVIGATION_CONTROL_SMALL}); //右上角，仅包含平移和缩放按钮
    //缩放控件type有四种类型:
    map.addControl(top_left_control);
    map.addControl(top_left_navigation);
    map.addControl(top_right_navigation);

    // 添加定位控件
    var geolocationControl = new BMap.GeolocationControl();
    geolocationControl.addEventListener("locationSuccess", function(e){
        // 定位成功事件
        var address = '';
        address += e.addressComponent.province;
        address += e.addressComponent.city;
        address += e.addressComponent.district;
        address += e.addressComponent.street;
        address += e.addressComponent.streetNumber;

        document.getElementById('jd').value = e.point.lng;
        document.getElementById('wd').value = e.point.lat;
        document.getElementById('xxwz').value = address;
        //alert("当前定位地址为：" + address);
    });
    geolocationControl.addEventListener("locationError",function(e){
        // 定位失败事件
        alert(e.message);
    });
    //添加定位到地图
    map.addControl(geolocationControl);

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
    function switchXY() {
        var inputJd = $("#t_jd").val();
        var inputWd = $("#t_wd").val();

        if(inputJd!='' && inputWd!=''){
            $arr = [];
            $arr = convertGCJ02ToBD09(inputWd,inputJd);
            deletePoint();
            map.clearOverlays();
            var point = new BMap.Point($arr.lng,$arr.lat);
            map.centerAndZoom(point, 15);
            addMarker(point);
            $("#jd").val($arr.lng);
            $("#wd").val($arr.lat);
            $("#xxwz").val("");
        }
    }
    //$("#jd").blur(function () {switchXY();});
    //$("#wd").blur(function () {switchXY();});

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
            var oldSsqy = $("#oldSsqy").val();
            for (let i = 0, length = ssqy.length; i < length; i++) {
                if(oldSsqy == ssqy[i].keyvalue){
                    $("#ssqy").append("<option value='" + ssqy[i].keyvalue + "' selected>" + ssqy[i].keymemo + "</option>");
                }else{
                    $("#ssqy").append("<option value='" + ssqy[i].keyvalue + "'>" + ssqy[i].keymemo + "</option>");
                }
            }
        });

        $.post("/sbZzlx/selectSbZzlxByAll", function (data) {
            let zzlx = JSON.parse(data);
            var oldZzlx = $("#oldZzlx").val();
            for (let i = 0, length = zzlx.length; i < length; i++) {
                if(oldZzlx == zzlx[i].keyvalue){
                    $("#zzlx").append("<option value='" + zzlx[i].keyvalue + "' selected>" + zzlx[i].keymemo + "</option>");
                }else{
                    $("#zzlx").append("<option value='" + zzlx[i].keyvalue + "'>" + zzlx[i].keymemo + "</option>");
                }
            }
        });
    });
    function commit() {
        //验证必填字段
        if($("#ssqy").val() == ""){
            alert("所属区域不能为空！");
            return;
        }
        if($("#azddDdh").val() == ""){
            alert("设备调度号不能为空！");
            return;
        }
        $("#ssxl").val($("#xlmc").val());
        if($("#ssxl").val() == ""){
            alert("请选择所属线路！");
            return;
        }

        $.ajax({
            url: '/equip/addEquipInfo.action',
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
