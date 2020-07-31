$(function () {
    $.post("/ssqy/selectSsqyByAll", function (data) {
        let ssqy = JSON.parse(data);
        $("#ssqy").append("<option value='' selected>全部</option>");
        for (let i = 0, length = ssqy.length; i < length; i++) {
            $("#ssqy").append("<option value='" + ssqy[i].keyvalue + "'>" + ssqy[i].keymemo + "</option>");
        }
    });
});

//改变所属区域
function changeSsqy(){
    var ssqy = $("#ssqy").val();
    $("#yxdw").empty();
    $("#bdz").empty();
    $("#xlmc").empty();
    $("#yxdw").append("<option value=''>全部</option>");
    if(ssqy != null && ssqy != '') {
        //若选择石景山
        if(ssqy ==1){
            $("#yxdw_span").hide();
            $("#bdz").empty();
            $("#xlmc").empty();
            $("#bdz").append("<option value=''>全部</option>");
            $.get("/ssxl/selectByGroup/bdz", {'ssqy':$("#ssqy").val(),'yxdw':'石景山'},function (data) {
                data = JSON.parse(data);
                $.each(data, function (i) {
                    $("#bdz").append("<option value='" + data[i].bdz + "'>" + data[i].bdz + "</option>");
                })
            });
        }else{
            $("#yxdw_span").show();
            $.get("/ssxl/selectByGroup/yxdw", {'ssqy':ssqy},function (data) {
                data = JSON.parse(data);
                $.each(data, function (i) {
                    $("#yxdw").append("<option value='" + data[i].yxdw + "'>" + data[i].yxdw + "</option>");
                })
            });
        }
    }else{
        $("#yxdw").empty();
    }
}
//秀昂贵运行单位
function changeYxdw(){
    var yxdw = $("#yxdw").val();
    $("#bdz").empty();
    $("#xlmc").empty();
    if(yxdw == '') return;
    $("#bdz").append("<option value=''>全部</option>");
    $.get("/ssxl/selectByGroup/bdz", {'ssqy':$("#ssqy").val(),'yxdw':$("#yxdw").val()},function (data) {
        data = JSON.parse(data);
        $.each(data, function (i) {
            $("#bdz").append("<option value='" + data[i].bdz + "'>" + data[i].bdz + "</option>");
        })
    });
}
//修改变电站
function changeBdz(){
    $("#xlmc").empty();
    $("#xlmc").append("<option value=''>全部</option>");
    $.get("/ssxl/selectByGroup/xlmc", {'ssqy':$("#ssqy").val(),'yxdw':$("#yxdw").val(),'bdz': $("#bdz").val()}, function (data) {
        data = JSON.parse(data);
        $.each(data, function (i) {
            $("#xlmc").append("<option value='" + data[i].id + "'>" + data[i].xlmc + "</option>");
        })
    });
}
// 装置类型
$(function () {
    $("#zzlx").append("<option value=''>全部</option>");
    $.post("/zzlx/selectZzlxByAll", function (data) {
        let zzlx = JSON.parse(data);
        for (let i = 0, length = zzlx.length; i < length; i++) {
            $("#zzlx").append("<option value='" + zzlx[i].keyvalue + "'>" + zzlx[i].keymemo + "</option>");
        }
    });
});