<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../import.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>设备信息--编辑</title>
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
    #txmkcj
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
    #descDiv::-webkit-scrollbar{
        display: none;
    }
</style>
<body>
<div class="right_main">
    <div class="right_table" style="width:96%;">
        <form name="myForm" id="myForm" method="post">
            <table width="100%" cellpadding="0" cellspacing="1" bgcolor="#c6c6c6" id="testTab">
                <tbody>
                    <tr>
                        <th colspan="4" align="center" bgcolor="#f5f2ea">修改</th>
                    </tr>
                    <tr>
                        <th bgcolor="#FFFFFF"><p>所属区域</p></th>
                        <td bgcolor="#FFFFFF" style="text-align:left; ">
                            <input type="hidden" id="sbid" name="sbid" value="${equipInfo.sbid}"></input>
                            <input type="hidden" id="oldSsqy" name="oldSsqy" value="${equipInfo.ssqy}"></input>
                            <select name="ssqy" id="ssqy"  onchange="changeSsqy()" style="height:25px; border:1px solid #CCC;">
                            </select>
                        </td>
                        <th bgcolor="#FFFFFF"><p id="zbbh_p">装置编号</p></th>
                        <td bgcolor="#FFFFFF" style="text-align:left; ">
                            <input type="text" name="zbbh" id="zbbh" value="${equipInfo.zbbh}" ondblclick="defaultClick(this)" style="height:25px; border:1px solid #CCC;"/>
                        </td>
                    </tr>
                    <tr>
                        <th bgcolor="#FFFFFF"><p>装置类型</p></th>
                        <td bgcolor="#FFFFFF" style="text-align:left; ">
                            <input type="hidden" id="oldZzlx" name="oldZzlx" value="${equipInfo.zzlx}"/>
                            <input type="hidden" id="zzlxKeyType"/>
                            <select name="zzlx" id="zzlx" style="height:25px; border:1px solid #CCC;">
                            </select>
                        </td>
                        <th bgcolor="#FFFFFF"><p id="zbxh_p">DTU装置型号</p></th>
                        <td bgcolor="#FFFFFF" style="text-align:left; ">
                            <input type="text" name="zbxh" id="zbxh" value="${equipInfo.zbxh}" style="height:25px; border:1px solid #CCC;" ondblclick="defaultClick(this)" />
                        </td>
                    </tr>
                    <tr>
                        <th bgcolor="#FFFFFF"><p>设备调度号</p></th>
                        <td bgcolor="#FFFFFF" style="text-align:left; ">
                            <input type="text" name="azddDdh" id="azddDdh" value="${equipInfo.azddDdh}" style="height:25px; border:1px solid #CCC;" readonly/>
                        </td>
                        <th bgcolor="#FFFFFF"><p id="sccs_p">DTU生产厂商</p></th>
                        <td bgcolor="#FFFFFF" style="text-align:left; ">
                            <input type="text" name="sccs" id="sccs" value="${equipInfo.sccs}" ondblclick="defaultClick(this)" style="height:25px; border:1px solid #CCC;"/>
                        </td>
                    </tr>
                    <tr>
                        <th bgcolor="#FFFFFF"><p>所属线路</p></th>
                        <td bgcolor="#FFFFFF" style="text-align:left; ">
                            <span id="yxdw_span">单位<select id="yxdw" onchange="changeYxdw()"></select></span>&nbsp;变电站<select id="bdz" ></select>&nbsp;线路<select id="xlmc"></select>
                            <input type="hidden" name="ssxl" id="ssxl" value=""/>
                            <%--<input type="text" name="ssxl" id="ssxl" value="${equipInfo.ssxl}" readonly style="height:25px; border:1px solid #CCC;"/>--%>
                        </td>
                        <th bgcolor="#FFFFFF"><p id="zbxhYcg_p">一次柜装置型号</p></th>
                        <td bgcolor="#FFFFFF" style="text-align:left; ">
                            <input type="text" name="zbxhYcg" id="zbxhYcg" value="${equipInfo.zbxhYcg}" ondblclick="defaultClick(this)" style="height:25px; border:1px solid #CCC;"/>
                        </td>
                    </tr>
                    <tr>
                        <%--<th bgcolor="#FFFFFF"><p>终端名称</p></th>
                        <td bgcolor="#FFFFFF" style="text-align:left; ">
                            <input type="text" name="zdmc" id="zdmc" value="${equipInfo.zdmc}" ondblclick="defaultClick(this)" style="height:25px; border:1px solid #CCC;"/>
                        </td>--%>
                            <th bgcolor="#FFFFFF"><p>通信模块厂家</p></th>
                            <td bgcolor="#FFFFFF" style="text-align:left; ">
                                <input type="text" name="txmkcj" id="txmkcj" value="${equipInfo.txmkcj}"  ondblclick="defaultClick(this)" style="height:25px; border:1px solid #CCC;"/>
                                <div id="searchresult" style="display: none;margin-top:10px;"/>
                            </td>
                        <th bgcolor="#FFFFFF"><p id="sccsYcg_p">一次柜生产厂商</p></th>
                        <td bgcolor="#FFFFFF" style="text-align:left; ">
                            <input type="text" name="sccsYcg" id="sccsYcg" value="${equipInfo.sccsYcg}" ondblclick="defaultClick(this)" style="height:25px; border:1px solid #CCC;"/>
                        </td>
                    </tr>
                    <tr>
                        <th bgcolor="#FFFFFF"><p id="wlwkh_p">物联网卡号</p></th>
                        <td bgcolor="#FFFFFF" style="text-align:left; ">
                            <input type="text" name="wlwkh" id="wlwkh" value="${equipInfo.wlwkh}"  ondblclick="defaultClick(this)" style="height:25px; border:1px solid #CCC;"/>
                        </td>
                        <th bgcolor="#FFFFFF"><p id="tsryxmYcg_p">一次柜调试人员姓名电话</p></th>
                        <td bgcolor="#FFFFFF" style="text-align:left; ">
                            <input type="text" name="tsryxmYcg" id="tsryxmYcg" value="${equipInfo.tsryxmYcg}" ondblclick="defaultClick(this)" style="height:25px; border:1px solid #CCC;"/>
                        </td>
                    </tr>
                    <tr>
                        <th bgcolor="#FFFFFF"><p id="ipdz_p">IP地址</p></th>
                        <td bgcolor="#FFFFFF" style="text-align:left; ">
                            <input type="text" name="ipdz" id="ipdz" value="${equipInfo.ipdz}"  ondblclick="defaultClick(this)" style="height:25px; border:1px solid #CCC;"/>
                        </td>
                        <th bgcolor="#FFFFFF"><p id="zbxhYs_p">溢水柜装置型号</p></th>
                        <td bgcolor="#FFFFFF" style="text-align:left; ">
                            <input type="text" name="zbxhYs" id="zbxhYs" value="${equipInfo.zbxhYs}" ondblclick="defaultClick(this)" style="height:25px; border:1px solid #CCC;"/>
                        </td>
                    </tr>
                    <tr>
                        <th bgcolor="#FFFFFF"><p id="rtudz_p">RTU地址</p></th>
                        <td bgcolor="#FFFFFF" style="text-align:left; ">
                            <input type="text" name="rtudz" id="rtudz" value="${equipInfo.rtudz}" ondblclick="defaultClick(this)" style="height:25px; border:1px solid #CCC;"/>
                        </td>
                        <th bgcolor="#FFFFFF"><p id="sccsYs_p">溢水生产厂商</p></th>
                        <td bgcolor="#FFFFFF" style="text-align:left; ">
                            <input type="text" name="sccsYs" id="sccsYs" value="${equipInfo.sccsYs}"ondblclick="defaultClick(this)"  style="height:25px; border:1px solid #CCC;"/>
                        </td>
                    </tr>
                    <tr>
                        <th bgcolor="#FFFFFF"><p id="dkh_p">端口号</p></th>
                        <td bgcolor="#FFFFFF" style="text-align:left; ">
                            <input type="text" name="dkh" id="dkh" value="${equipInfo.dkh}" ondblclick="defaultClick(this)" style="height:25px; border:1px solid #CCC;"/>
                        </td>
                        <th bgcolor="#FFFFFF"><p id="tsryxmYs_p">溢水柜调试人员姓名电话</p></th>
                        <td bgcolor="#FFFFFF" style="text-align:left; ">
                            <input type="text" name="tsryxmYs" id="tsryxmYs" value="${equipInfo.tsryxmYs}" ondblclick="defaultClick(this)" style="height:25px; border:1px solid #CCC;"/>
                        </td>
                    </tr>
                    <tr>
                        <th bgcolor="#FFFFFF"><p id="scrq_p">生产日期</p></th>
                        <td bgcolor="#FFFFFF" id="scrq_p2" style="text-align:left; ">
                            <input type="text" name="scrq" id="scrq" value="${equipInfo.scrq}" style="height:25px; border:1px solid #CCC;"/>
                            <%--<input class="easyui-datebox" name="scrq" id="scrq"
                                   data-options="required:true" value="${equipInfo.scrq}" style="width:120px"/>--%>
                        </td>
                        <th bgcolor="#FFFFFF"><p id="zbxhXf_p">消防装置型号</p></th>
                        <td bgcolor="#FFFFFF" style="text-align:left; ">
                            <input type="text" name="zbxhXf" id="zbxhXf" value="${equipInfo.zbxhXf}" ondblclick="defaultClick(this)" style="height:25px; border:1px solid #CCC;"/>
                        </td>
                    </tr>
                    <tr>
                        <th bgcolor="#FFFFFF"><p id="rjbbJym_p">软件版本及校验码</p></th>
                        <td bgcolor="#FFFFFF" id="rjbbJym_p2" style="text-align:left; ">
                            <input type="text" name="rjbbJym" id="rjbbJym" value="${equipInfo.rjbbJym}" ondblclick="defaultClick(this)" style="height:25px; border:1px solid #CCC;"/>
                        </td>
                        <th bgcolor="#FFFFFF"><p id="sccsXf_p">消防生产厂商</p></th>
                        <td bgcolor="#FFFFFF" style="text-align:left; ">
                            <input type="text" name="sccsXf" id="sccsXf" value="${equipInfo.sccsXf}" ondblclick="defaultClick(this)" style="height:25px; border:1px solid #CCC;"/>
                        </td>
                    </tr>
                    <tr>
                        <th bgcolor="#FFFFFF"><p id="yjbb_p">硬件版本</p></th>
                        <td bgcolor="#FFFFFF" id="yjbb_p2" style="text-align:left; ">
                            <input type="text" name="yjbb" id="yjbb" value="${equipInfo.yjbb}" ondblclick="defaultClick(this)" style="height:25px; border:1px solid #CCC;"/>
                        </td>
                        <th bgcolor="#FFFFFF"><p id="tsryxmXf_p">消防调试人员姓名电话</p></th>
                        <td bgcolor="#FFFFFF" style="text-align:left; ">
                            <input type="text" name="tsryxmXf" id="tsryxmXf" value="${equipInfo.tsryxmXf}" sondblclick="defaultClick(this)" style="height:25px; border:1px solid #CCC;"/>
                        </td>
                    </tr>
                    <tr>
                        <th bgcolor="#FFFFFF"><p>备注</p></th>
                        <td bgcolor="#FFFFFF" style="text-align:left; " colspan="3">
                            <textarea name="beizhu" id="beizhu" cols="100" rows="5" style="border:1px solid #CCC;">${equipInfo.beizhu}</textarea>
                            <input type="hidden" id="flagArrayStr" name="flagArrayStr">
                        </td>
                    </tr>
                    <tr>
                        <th bgcolor="#FFFFFF">添加照片</th>
                        <td bgcolor="#FFFFFF" colspan="3" style="text-align: left;">&nbsp;
                            <input type="button" value="添加"  onclick="addTr(15);" class="iput_m" />
                        </td>
                    </tr>
                    <c:forEach items="${files}" var="file" varStatus="status">
                        <tr id='ftr${status.index}'>
                            <td bgcolor="#FFFFFF" style="text-align: left;">
                                <p style='font-size: 12px;font-weight: bold;color: #333;font-family: \"宋体\";'>图片名称</p>
                                <input type="hidden"   name='fileId${status.index}' id='fileId${status.index}'  value="${file.PID}"/>
                            </td>
                            <td bgcolor="#FFFFFF" style="text-align: left;">
                                <input type="hidden"   name='photo[${status.index}].pid'  value="${file.PID}"/>
                                <input type="hidden"   name='photo[${status.index}].tsid'  value="${file.TSID}"/>
                                <input type='text' name='photo[${status.index}].pName' value="${file.P_NAME}" style='height:25px; border:1px solid #CCC;float: left;'/>
                            </td>
                           <%-- <td bgcolor="#FFFFFF" style="text-align: left;">
                                <span style="float: left;margin-left: 100px;">${file.P_NAME}</span>&nbsp;
                                <input type="hidden"   name='fileId${status.index}' id='fileId${status.index}'  value="${file.PID}"/>
                            </td>--%>
                            <td bgcolor="#FFFFFF" style="text-align: left;" colspan="2">
                                <div style='height:100px;float: left;margin-left: 60px;' > <img height="100px" src="/equip/getEquipPhotoView.action?pid=${file.PID}" class="pimg"></div><button class='iput_m'onclick="moveTr2(${status.index});" style='float: right;margin-left:-50px;margin-top: 60px;'>移除</button>
                            </td>
                            </td>
                        </tr>
                    </c:forEach>
                    <tr>
                        <th bgcolor="#FFFFFF" style="width: 20%"><p>经纬度</p></th>
                        <td bgcolor="#FFFFFF" style="text-align:left; " colspan="3">
                            <span class="label">腾讯地图经度</span>
                            <input type="text" name="t_jd" id="t_jd" style="height:25px; border:1px solid #CCC;"/>
                            <span class="label">腾讯地图纬度</span>
                            <input type="text" name="t_wd" id="t_wd" style="height:25px; border:1px solid #CCC;"/>
                            <input type="button" onclick="switchXY()" value="确 定" class="iput_m"
                                   style="height:25px;"/>
                            <br/> <br/>
                            <span class="label">经度</span>
                            <input type="text" name="jd" id="jd" value="${equipInfo.jd}" style="height:25px; border:1px solid #CCC;"/>
                            <span class="label">纬度</span>
                            <input type="text" name="wd" id="wd" value="${equipInfo.wd}" style="height:25px; border:1px solid #CCC;"/>
                            <span class="label">详细位置</span>
                            <input type='text' name='xxwz' id='xxwz' value="${equipInfo.xxwz}" size="30" style="height:25px; border:1px solid #CCC;">
                            <div class="main-div" style="height: 426px;width: 800px;margin-top: 5px;">
                                <div id='allmap' style='width:  75%; height:400px; position: absolute;'></div>
                            </div>
                    </tr>
                    <tr>
                        <td height="33" colspan="4" bgcolor="#f5f2ea">
                            <input type="button" name="button" value="提 交" onclick="change()" class="iput_m"
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

        $.post("/zzlx/selectZzlxByAll", function (data) {
            let zzlx = JSON.parse(data);
            var oldZzlx = $("#oldZzlx").val();
            for (let i = 0, length = zzlx.length; i < length; i++) {
                if(oldZzlx == zzlx[i].keyvalue){
                    $("#zzlx").append("<option value='" + zzlx[i].keyvalue + "' selected>" + zzlx[i].keymemo + "</option>");
                    if(zzlx[i].keytype ==2) changeToFtu();
                }else{
                    $("#zzlx").append("<option value='" + zzlx[i].keyvalue + "'>" + zzlx[i].keymemo + "</option>");
                }
            }
        });
    });

    function changeToFtu(){
        $("#wlwkh_p").html(" 无线卡号");
        $("#ipdz_p").html(" IP地址");
        $("#rtudz_p").html("相间CT变比");
        $("#dkh_p").html("零序CT变比");
        $("#scrq_p").html("软件版本及校验码");
        $("#scrq_p2").html('<input type="text" name="rjbbJym" id="rjbbJym" ondblclick="defaultClick(this)" style="height:25px; border:1px solid #CCC;"/>');
        $("#rjbbJym_p").html("硬件版本");
        $("#rjbbJym_p2").html('<input type="text" name="yjbb" id="yjbb" ondblclick="defaultClick(this)" style="height:25px; border:1px solid #CCC;"/>');
        $("#yjbb_p").html("");
        $("#yjbb_p2").html("");

        $("#zbbh_p").html(" FTU型号");
        $("#zbxh_p").html(" FTU编码");
        $("#sccs_p").html(" FTU厂家");
        $("#zbxhYcg_p").html("FTU生产日期");
        $("#sccsYcg_p").html("开关本体厂家");
        $("#tsryxmYcg_p").html("开关本体型号");
        $("#zbxhYs_p").html("开关本体生产日期");
        $("#sccsYs_p").html("通讯设备型号");
        $("#tsryxmYs_p").html("通讯设备厂家");
        $("#zbxhXf_p").html("通讯设备生产日期");
        $("#sccsXf_p").html("调试人员姓名");
        $("#tsryxmXf_p").html("");
        $("#tsryxmXf_p2").html("");
    }

    //选所属区域
    changeSsqy();
    function changeSsqy(){
        $("#yxdw").empty();
        $("#bdz").empty();
        $("#xlmc").empty();
        $("#yxdw").append("<option value=''>" +'请选择' + "</option>");
        var ssqy = $("#ssqy").val();
        if(ssqy != null && ssqy != '') {
            //若选择石景山
            if(ssqy ==1){
                $("#yxdw_span").hide();
                $("#bdz").empty();
                $("#xlmc").empty();
                $("#bdz").append("<option value=''>" +'请选择' + "</option>");
                $.get("/ssxl/selectByGroup/bdz", {'ssqy':$("#ssqy").val(),'yxdw':'石景山'},function (data) {
                    data = JSON.parse(data);
                    $.each(data, function (i) {
                        $("#bdz").append("<option value='" + data[i].bdz + "'>" + data[i].bdz + "</option>");
                    })
                });
            }else{
                $("#yxdw_span").show();
                $.get("/ssxl/selectByGroup/yxdw", {'ssqy':$("#ssqy").val()},function (data) {
                    data = JSON.parse(data);
                    $.each(data, function (i) {
                        $("#yxdw").append("<option value='" + data[i].yxdw + "'>" + data[i].yxdw + "</option>");
                    })
                });
            }
        }
    }
    //运营单位
    function changeYxdw(){
        var yxdw = $("#yxdw").val();
        $("#bdz").empty();
        $("#xlmc").empty();
        if(yxdw == '') return;
        $("#bdz").append("<option value=''>" +'请选择' + "</option>");
        $.get("/ssxl/selectByGroup/bdz", {'ssqy':$("#ssqy").val(),'yxdw':$("#yxdw").val()},function (data) {
            data = JSON.parse(data);
            $.each(data, function (i) {
                $("#bdz").append("<option value='" + data[i].bdz + "'>" + data[i].bdz + "</option>");
            })
        });
    }
    var ssxl = "${equipInfo.ssxl}";
    var ssqy = "${equipInfo.ssqy}";

    // 运行单位
    $("#yxdw").append("<option value=''>全部</option>");
    $.get("/ssxl/selectByGroup/yxdw",{'ssqy':ssqy}, function (data) {
        data = JSON.parse(data);
        $.each(data, function (i) {
            $("#yxdw").append("<option value='" + data[i].yxdw + "'>" + data[i].yxdw + "</option>");
        })
    });
    // 变电站
    $("#bdz").append("<option value=''>全部</option>");
    $.get("/ssxl/selectByGroup/bdz",{'ssqy':ssqy,'yxdw':$("#yxdw").val()}, function (data) {
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
        $.get("/ssxl/selectByGroup/xlmc",{'ssqy':$("#ssqy").val(),'bdz': $("#bdz").val(),'yxdw':$("#yxdw").val()}, function (data) {
            data = JSON.parse(data);
            $.each(data, function (i) {
                $("#xlmc").append("<option value='" + data[i].id + "'>" + data[i].xlmc + "</option>");
            });
        });
    });


    $.get("/ssxl/selectByPrimaryKey/"+ssxl, function (data) {
        data = JSON.parse(data);
        $('#yxdw').val(data.yxdw);
        $('#bdz').val(data.bdz);
        if(data.ssqy == 1){$("#yxdw_span").hide();}
        $("#xlmc").empty();
        $("#xlmc").append("<option value=''>全部</option>");
        $.get("/ssxl/selectByGroup/xlmc",{"bdz": $("#bdz").val()}, function (data2) {
            data2 = JSON.parse(data2);
            $.each(data2, function (i) {
                if(ssxl == data2[i].id){
                    $("#xlmc").append("<option value='" + data2[i].id + "' selected>" + data2[i].xlmc + "</option>");
                }else
                    $("#xlmc").append("<option value='" + data2[i].id + "'>" + data2[i].xlmc + "</option>");
            });
        });
    });

    function defaultClick(e){
        e.value="N/A";
    }

</script>
<script type="text/javascript">
    //放大图片
    $(function(){
        $(".pimg").click(function(){
            var _this = $(this);//将当前的pimg元素作为_this传入函数
            var src = _this.attr("src");//获取当前点击的pimg元素中的src属性
            imgShow("#outerdiv", "#innerdiv", "#bigimg", src);
        });
    });

    function imgMaxView(e) {
        var _this = $(e);//将当前的pimg元素作为_this传入函数
        var src = _this.attr("src");//获取当前点击的pimg元素中的src属性
        imgShow("#outerdiv", "#innerdiv", "#bigimg", src);
    }
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

    var flagArray = new Array();

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
    function moveTr2(id){
        var trId = 'ftr'+id;
        var tb=document.getElementById('testTab');
        var tr=document.getElementById(trId);
        var textId = '#fileId'+id;
        flagArray.push($(textId).val());
        tb.deleteRow(tr.rowIndex);
    }
    //装置类型选择
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
                break;
            case "6":
                name="柱上FTU";
                break;
            case "7":
                name="柱上变压器";
                break;
            case "8":
                name="故障指示器";
                break;
        }
        return name;
    }
    //调用百度api
    var map = new BMap.Map("allmap");
    var geoc = new BMap.Geocoder();  //地址解析对象
    var markersArray = [];
    var geolocation = new BMap.Geolocation();
    var point =null;

    var jd ="${equipInfo.jd}";
    var wd = "${equipInfo.wd}";
    //var point = new BMap.Point(jd, wd);
    var $arr = convertGCJ02ToBD09(wd,jd);
    var point = new BMap.Point($arr.lng, $arr.lat);
    var zdmc ="${equipInfo.zdmc}";
    var ssxl ="${equipInfo.ssxl}";
    var zzlx ="${equipInfo.zzlx}";
    var azddDdh ="${equipInfo.azddDdh}";
    var xxwz ="${equipInfo.xxwz}";
    var beizhu =$("#beizhu").val();
    var sbid ="${equipInfo.sbid}";
    addMarker2(point);
    //point = new BMap.Point(116.331398, 39.897445);
    map.centerAndZoom(point, 15); // 中心点
    geolocation.getCurrentPosition(function (r) {
        if (this.getStatus() == BMAP_STATUS_SUCCESS) {
            var mk = new BMap.Marker(r.point);
            //map.addOverlay(mk);
            //map.panTo(r.point);
            map.enableScrollWheelZoom(true);
        }
        else {
            alert('failed' + this.getStatus());
        }
    }, {enableHighAccuracy: true});
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
    function addMarker2(point){
        var marker = new BMap.Marker(point);
        map.addOverlay(marker);
        (function() {
            marker.addEventListener("click",
                function(){
                    showInfo2(this,sbid);
                });
        })();
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
                   // text +='<br/><br/>&nbsp;&nbsp;<img width=\'180px\' height=\'180px\' src=\'/equip/getEquipPhotoView.action?pid='+arr[i].PID+'\'>';
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
    //查询所属线路
    function getSsxlName(value) {
        var xlmc = "";
        $.ajax({
            url: '/ssxl/selectByPrimaryKey/'+value,
            type: 'GET',
            async: false,
            processData: false,
            contentType: false,
            beforeSend: function () {
                console.log("正在加载，请稍候");
            },
            success: function (data) {
                let data2 = JSON.parse(data);
                xlmc = data2.bdz+data2.xlmc;
            },
            error: function () {
                //alert("页面加载错误！");
            }
        });
        return xlmc;
    }
    //展示详细信息
    var isJDWD = ${equipInfo.jd != '' and equipInfo.wd != ''};//经纬度为空则不显示二维码
    function showInfo2(thisMarker,sbid) {
        var text = getEquipPhotoView(sbid);
        var qrcImg = "&nbsp;";
        if(isJDWD){
                qrcImg = '&nbsp;&nbsp;&nbsp;<img width=\'180px\' height=\'180px\' src=\'/equip/createQRCodeByEquipInfo.action?sbid='+sbid+'\'>';
        }
        var content = '<div id="descDiv" style="overflow-y:scroll; overflow-x:hidden; background-color:#f5f0f0;margin:0;line-height:20px;padding:15px;width:300px;height: 290px;">'
            +qrcImg
            +'<br/>&nbsp;<b>调度号：</b>'+azddDdh
            +'<br/>&nbsp;<b>装置类型：</b>'+choiceZzlxName(zzlx)
            +'<br/>&nbsp;<b>所属线路：</b>'+getSsxlName(ssxl)
            +'<br/>&nbsp;<b>详细位置：</b>'+xxwz
            +'<br/>&nbsp;<b>备注：</b>'+beizhu+'<hr>'
            +text
            +'</div>';
        var infoWindow = new BMap.InfoWindow(content); //创建信息窗口对象
        thisMarker.openInfoWindow(infoWindow); //图片加载完后重绘infoWindow
    }
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
   // $("#wd").blur(function () {switchXY();});

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
    function change() {
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
        /*if($("#ssxl").val() == ""){
            alert("请选择所属线路！");
            return;
        }*/

        $("#flagArrayStr").val(flagArray);
        $.ajax({
            url: '/equip/updateEquipInfo.action',
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
