/**
 *
 */

/* div悬浮窗 */
function showSpan(value) {
    if (value != null && value != '') {
        return "<div title='" + value.replaceAll("'", "&apos;") + "' class='textEllipsis'>" + value.replaceAll("'", "&apos;") + "</div>";
    } else {
        return '';
    }
    /* span悬浮窗（弃用） */
    /* if(value){
        return '<span title='+value+'>'+value+'</span>';
    }else{
        return '';
    } */
}

/* replaceAll方法 */
String.prototype.replaceAll = function (reallyDo, replaceWith, ignoreCase) {
    if (!RegExp.prototype.isPrototypeOf(reallyDo)) {
        return this.replace(new RegExp(reallyDo, (ignoreCase ? "gi" : "g")), replaceWith);
    } else {
        return this.replace(reallyDo, replaceWith);
    }
}

/* 判断是否为数字 */
function isRealNum(val) {
    // isNaN()函数 把空串 空格 以及NUll 按照0来处理 所以先去除
    if (val === "" || val == null) {
        return false;
    }
    if (!isNaN(val)) {
        return true;
    } else {
        return false;
    }
};

//在Jquery里格式化Date日期时间数据
function timeStamp2DateString(time) {
    var datetime = new Date(time);
    datetime.setTime(time);
    var year = datetime.getFullYear();
    var month = datetime.getMonth() + 1 < 10 ? "0" + (datetime.getMonth() + 1) : datetime.getMonth() + 1;
    var date = datetime.getDate() < 10 ? "0" + datetime.getDate() : datetime.getDate();
    return year + "-" + month + "-" + date;
}

function timeStamp2DateString2(time) {
    var datetime = new Date(time);
    datetime.setTime(time);
    var year = datetime.getFullYear();
    var month = datetime.getMonth() + 1 < 10 ? "0" + (datetime.getMonth() + 1) : datetime.getMonth() + 1;
    var date = datetime.getDate() < 10 ? "0" + datetime.getDate() : datetime.getDate();
    return year + "/" + month + "/" + date;
}

//在Jquery里格式化Date日期时间数据
function timeStamp2DateTimeString(time) {
    var datetime = new Date(time);
    datetime.setTime(time);
    var year = datetime.getFullYear();
    var month = datetime.getMonth() + 1 < 10 ? "0" + (datetime.getMonth() + 1) : datetime.getMonth() + 1;
    var date = datetime.getDate() < 10 ? "0" + datetime.getDate() : datetime.getDate();
    var hour = datetime.getHours() < 10 ? "0" + datetime.getHours() : datetime.getHours();
    var minute = datetime.getMinutes() < 10 ? "0" + datetime.getMinutes() : datetime.getMinutes();
    var second = datetime.getSeconds() < 10 ? "0" + datetime.getSeconds() : datetime.getSeconds();
    return year + "-" + month + "-" + date + " " + hour + ":" + minute + ":" + second;
}

// 日期时间差计算
function addDate(type, NumDay, vdate) {
    var date = new Date(vdate);
    type = parseInt(type); //类型 
    var lIntval = parseInt(NumDay);//间隔
    switch (type) {
        case 7 ://年
            date.setYear(date.getYear() + lIntval);
            break;
        case 6 ://季度
            date.setMonth(date.getMonth() + (lIntval * 3));
            break;
        case 5 ://月
            date.setMonth(date.getMonth() + lIntval);
            break;
        case 4 ://天
            date.setDate(date.getDate() + lIntval);
            break;
        case 3 ://时
            date.setHours(date.getHours() + lIntval);
            break;
        case 2 ://分
            date.setMinutes(date.getMinutes() + lIntval);
            break;
        case 1 ://秒
            date.setSeconds(date.getSeconds() + lIntval);
            break;
        default:
    }
    return date;
}

////将金额类型转为数字类型
//function toNum(str) {
//	return str.replace(/\,|\￥/g, "");
//}
//
//// 保留两位小数（四舍五入）
//function toPrice(num) {
//	num = parseFloat(toNum(num)).toFixed(2).toString().split(".");
//	num[0] = num[0].replace(new RegExp('(\\d)(?=(\\d{3})+$)','ig'),"$1,");
//	return "￥" + num.join(".");
//}
////保留两位小数（不四舍五入）
//function toPrice1(num) {
//	num = parseFloat(toNum(num).replace(/(\.\d{2})\d+$/,"$1")).toFixed(2).toString().split(".");
//	num[0] = num[0].replace(new RegExp('(\\d)(?=(\\d{3})+$)','ig'),"$1,");
//	return "￥" + num.join(".");;
//}
//
//// 不处理小数部分
//function toPrice2(num) {
//	var source = toNum(num).split(".");
//	source[0] = source[0].replace(new RegExp('(\\d)(?=(\\d{3})+$)','ig'),"$1,");
//	return "￥" + source.join(".");
//}

function itemBar(itemInfo) {
    /* 采购计划-begin */
    var cgjh = itemInfo.cgjhList;
    for (var i = 0; i < cgjh.length; i++) {

        /* 带招标-begin */
        var xmzb = itemInfo.cgjhList[i].xmzbList;
        for (var j = 0; j < xmzb.length; j++) {
            // 展示图标
            // $("#"+itemInfo.itemNo+"-"+xmzb[j].xmzbNo+"li1").show();
            // 修改状态图标颜色
            $("#" + itemInfo.itemNo + "-" + xmzb[j].xmzbNo + "btn1").removeClass("btn_cz cur").addClass("btn_cz");
            // 修改箭头颜色
            $("#" + itemInfo.itemNo + "-" + xmzb[j].xmzbNo + "img1").attr('src', "/dance/static/images/jt_g.png");
            // 添加时间
            $("#" + itemInfo.itemNo + "-" + xmzb[j].xmzbNo + "img1").prev().html(xmzb[j].zbsj);

            // 质保金
            if (xmzb[j].sfzbj == 1) {			// 无质保金
                $("#" + itemInfo.itemNo + "-" + xmzb[j].xmzbNo + "li11").hide();
                $("#" + itemInfo.itemNo + "-" + xmzb[j].xmzbNo + "li12").hide();
            }

            // 付款方式
            if (xmzb[j].fkfs == 0) {			// 三期付
                $("#" + itemInfo.itemNo + "-" + xmzb[j].xmzbNo + "li8").hide();
            } else if (xmzb[j].fkfs == 1) {		// 两期付
                $("#" + itemInfo.itemNo + "-" + xmzb[j].xmzbNo + "li4").hide();
                $("#" + itemInfo.itemNo + "-" + xmzb[j].xmzbNo + "li8").hide();
            } else if (xmzb[j].fkfs == 2) {	// 全额付
                $("#" + itemInfo.itemNo + "-" + xmzb[j].xmzbNo + "li3").hide();
                $("#" + itemInfo.itemNo + "-" + xmzb[j].xmzbNo + "li4").hide();
                $("#" + itemInfo.itemNo + "-" + xmzb[j].xmzbNo + "li7").hide();
            }

            // 合同
            var xmht = xmzb[j].xmhtList;
            if (xmht) {
                // $("#"+itemInfo.itemNo+"-"+xmht[j].xmhtNo+"li2").show();
                $("#" + itemInfo.itemNo + "-" + xmzb[j].xmzbNo + "btn2").removeClass("btn_cz cur").addClass("btn_cz");
                $("#" + itemInfo.itemNo + "-" + xmzb[j].xmzbNo + "img2").attr('src', "/dance/static/images/jt_g.png");
                $("#" + itemInfo.itemNo + "-" + xmzb[j].xmzbNo + "img2").prev().html(xmht[0].htsj);

                // 付款
                var xmfk = xmht[0].xmfkList;
                for (var k = 0; k < xmfk.length; k++) {
                    if (xmfk[k].fklb == 0) {	// 质保金入账
                        // $("#"+itemInfo.itemNo+"-"+xmht[j].xmhtNo+"li9").show();
                        $("#" + itemInfo.itemNo + "-" + xmzb[j].xmzbNo + "btn11").removeClass("btn_cz cur").addClass("btn_cz");
                        $("#" + itemInfo.itemNo + "-" + xmzb[j].xmzbNo + "img11").attr('src', "/dance/static/images/jt_g.png");
                        $("#" + itemInfo.itemNo + "-" + xmzb[j].xmzbNo + "img11").prev().html(timeStamp2DateString(xmfk[k].fksj));
                    }
                    if (xmfk[k].fklb == 5) {	// 退质保金
                        // $("#"+itemInfo.itemNo+"-"+xmht[j].xmhtNo+"li9").show();
                        $("#" + itemInfo.itemNo + "-" + xmzb[j].xmzbNo + "btn12").removeClass("btn_cz cur").addClass("btn_cz");
                        $("#" + itemInfo.itemNo + "-" + xmzb[j].xmzbNo + "img12").attr('src', "/dance/static/images/jt_g.png");
                        $("#" + itemInfo.itemNo + "-" + xmzb[j].xmzbNo + "img12").prev().html(timeStamp2DateString(xmfk[k].fksj));
                        // 已完成
                        $("#" + itemInfo.itemNo + "-" + xmzb[j].xmzbNo + "btn9").removeClass("btn_cz cur").addClass("btn_cz");
                    }
                    if (xmfk[k].fklb == 1) {	// 首款
                        // $("#"+itemInfo.itemNo+"-"+xmht[j].xmhtNo+"li3").show();
                        $("#" + itemInfo.itemNo + "-" + xmzb[j].xmzbNo + "btn3").removeClass("btn_cz cur").addClass("btn_cz");
                        $("#" + itemInfo.itemNo + "-" + xmzb[j].xmzbNo + "img3").attr('src', "/dance/static/images/jt_g.png");
                        $("#" + itemInfo.itemNo + "-" + xmzb[j].xmzbNo + "img3").prev().html(timeStamp2DateString(xmfk[k].fksj));
                    }
                    if (xmfk[k].fklb == 2) {	// 中期款
                        // $("#"+itemInfo.itemNo+"-"+xmht[j].xmhtNo+"li4").show();
                        $("#" + itemInfo.itemNo + "-" + xmzb[j].xmzbNo + "btn4").removeClass("btn_cz cur").addClass("btn_cz");
                        $("#" + itemInfo.itemNo + "-" + xmzb[j].xmzbNo + "img4").attr('src', "/dance/static/images/jt_g.png");
                        $("#" + itemInfo.itemNo + "-" + xmzb[j].xmzbNo + "img4").prev().html(timeStamp2DateString(xmfk[k].fksj));
                    }
                    if (xmfk[k].fklb == 3) {	// 尾款
                        // $("#"+itemInfo.itemNo+"-"+xmht[j].xmhtNo+"li7").show();
                        $("#" + itemInfo.itemNo + "-" + xmzb[j].xmzbNo + "btn7").removeClass("btn_cz cur").addClass("btn_cz");
                        $("#" + itemInfo.itemNo + "-" + xmzb[j].xmzbNo + "img7").attr('src', "/dance/static/images/jt_g.png");
                        $("#" + itemInfo.itemNo + "-" + xmzb[j].xmzbNo + "img7").prev().html(timeStamp2DateString(xmfk[k].fksj));
                    }
                    if (xmfk[k].fklb == 4) {	// 全款
                        // $("#"+itemInfo.itemNo+"-"+xmht[j].xmhtNo+"li8").show();
                        $("#" + itemInfo.itemNo + "-" + xmzb[j].xmzbNo + "btn8").removeClass("btn_cz cur").addClass("btn_cz");
                        $("#" + itemInfo.itemNo + "-" + xmzb[j].xmzbNo + "img8").attr('src', "/dance/static/images/jt_g.png");
                        $("#" + itemInfo.itemNo + "-" + xmzb[j].xmzbNo + "img8").prev().html(timeStamp2DateString(xmfk[k].fksj));
                    }
                }
                // 验收
                var xmys = xmht[0].xmysList;
                for (var l = 0; l < xmys.length; l++) {
                    // $("#"+itemInfo.itemNo+"-"+xmht[j].xmhtNo+"li5").show();
                    $("#" + itemInfo.itemNo + "-" + xmzb[j].xmzbNo + "btn5").removeClass("btn_cz cur").addClass("btn_cz");
                    $("#" + itemInfo.itemNo + "-" + xmzb[j].xmzbNo + "img5").attr('src', "/dance/static/images/jt_g.png");
                    $("#" + itemInfo.itemNo + "-" + xmzb[j].xmzbNo + "img5").prev().html(xmys[0].yssj);
                }

                // 资产
                var xmzc = xmht[0].xmzcList;
                for (var m = 0; m < xmzc.length; m++) {
                    // $("#"+itemInfo.itemNo+"-"+xmht[m].xmhtNo+"li6").show();
                    $("#" + itemInfo.itemNo + "-" + xmzb[j].xmzbNo + "btn6").removeClass("btn_cz cur").addClass("btn_cz");
                    $("#" + itemInfo.itemNo + "-" + xmzb[j].xmzbNo + "img6").attr('src', "/dance/static/images/jt_g.png");
                    $("#" + itemInfo.itemNo + "-" + xmzb[j].xmzbNo + "img6").prev().html(xmzc[0].djsj);
                }

            }

        }/* 带招标-end */

        /* 不带招标-begin */
        var xmht = itemInfo.cgjhList[i].xmhtList;
        for (var j = 0; j < xmht.length; j++) {
            // 修改状态图标颜色
            // $("#"+itemInfo.itemNo+"-"+xmht[j].xmhtNo+"li2").show();
            $("#" + itemInfo.itemNo + "-" + xmht[j].xmhtNo + "btn2").removeClass("btn_cz cur").addClass("btn_cz");
            // 修改箭头颜色
            $("#" + itemInfo.itemNo + "-" + xmht[j].xmhtNo + "img2").attr('src', "/dance/static/images/jt_g.png");
            // 添加时间
            $("#" + itemInfo.itemNo + "-" + xmht[j].xmhtNo + "img2").prev().html(xmht[j].htsj);

            // 质保金
            if (xmht[j].sfzbj == 1) {
                $("#" + itemInfo.itemNo + "-" + xmht[j].xmhtNo + "li11").hide();
                $("#" + itemInfo.itemNo + "-" + xmht[j].xmhtNo + "li12").hide();
            }

            // 付款方式
            if (xmht[j].fkfs == 0) {			// 三期付
                $("#" + itemInfo.itemNo + "-" + xmht[j].xmhtNo + "li8").hide();
            } else if (xmht[j].fkfs == 1) {		// 两期付
                $("#" + itemInfo.itemNo + "-" + xmht[j].xmhtNo + "li4").hide();
                $("#" + itemInfo.itemNo + "-" + xmht[j].xmhtNo + "li8").hide();
            } else if (xmht[j].fkfs == 2) {	// 全额付
                $("#" + itemInfo.itemNo + "-" + xmht[j].xmhtNo + "li3").hide();
                $("#" + itemInfo.itemNo + "-" + xmht[j].xmhtNo + "li4").hide();
                $("#" + itemInfo.itemNo + "-" + xmht[j].xmhtNo + "li7").hide();
            }

            // 付款
            var xmfk = xmht[j].xmfkList;
            for (var k = 0; k < xmfk.length; k++) {
                if (xmfk[k].fklb == 0) {	// 质保金入账
                    $("#" + itemInfo.itemNo + "-" + xmht[j].xmhtNo + "btn11").removeClass("btn_cz cur").addClass("btn_cz");
                    $("#" + itemInfo.itemNo + "-" + xmht[j].xmhtNo + "img11").attr('src', "/dance/static/images/jt_g.png");
                    $("#" + itemInfo.itemNo + "-" + xmht[j].xmhtNo + "img11").prev().html(timeStamp2DateString(xmfk[k].fksj));
                }
                if (xmfk[k].fklb == 5) {	// 退质保金
                    $("#" + itemInfo.itemNo + "-" + xmht[j].xmhtNo + "btn12").removeClass("btn_cz cur").addClass("btn_cz");
                    $("#" + itemInfo.itemNo + "-" + xmht[j].xmhtNo + "img12").attr('src', "/dance/static/images/jt_g.png");
                    $("#" + itemInfo.itemNo + "-" + xmht[j].xmhtNo + "img12").prev().html(timeStamp2DateString(xmfk[k].fksj));

                    $("#" + itemInfo.itemNo + "-" + xmht[j].xmhtNo + "btn9").removeClass("btn_cz cur").addClass("btn_cz");
                }
                if (xmfk[k].fklb == 1) {	// 首款
                    // $("#"+itemInfo.itemNo+"-"+xmht[j].xmhtNo+"li3").show();
                    $("#" + itemInfo.itemNo + "-" + xmht[j].xmhtNo + "btn3").removeClass("btn_cz cur").addClass("btn_cz");
                    $("#" + itemInfo.itemNo + "-" + xmht[j].xmhtNo + "img3").attr('src', "/dance/static/images/jt_g.png");
                    $("#" + itemInfo.itemNo + "-" + xmht[j].xmhtNo + "img3").prev().html(timeStamp2DateString(xmfk[k].fksj));
                }
                if (xmfk[k].fklb == 2) {	// 中期款
                    // $("#"+itemInfo.itemNo+"-"+xmht[j].xmhtNo+"li4").show();
                    $("#" + itemInfo.itemNo + "-" + xmht[j].xmhtNo + "btn4").removeClass("btn_cz cur").addClass("btn_cz");
                    $("#" + itemInfo.itemNo + "-" + xmht[j].xmhtNo + "img4").attr('src', "/dance/static/images/jt_g.png");
                    $("#" + itemInfo.itemNo + "-" + xmht[j].xmhtNo + "img4").prev().html(timeStamp2DateString(xmfk[k].fksj));
                }
                if (xmfk[k].fklb == 3) {	// 尾款
                    // $("#"+itemInfo.itemNo+"-"+xmht[j].xmhtNo+"li7").show();
                    $("#" + itemInfo.itemNo + "-" + xmht[j].xmhtNo + "btn7").removeClass("btn_cz cur").addClass("btn_cz");
                    $("#" + itemInfo.itemNo + "-" + xmht[j].xmhtNo + "img7").attr('src', "/dance/static/images/jt_g.png");
                    $("#" + itemInfo.itemNo + "-" + xmht[j].xmhtNo + "img7").prev().html(timeStamp2DateString(xmfk[k].fksj));
                }
                if (xmfk[k].fklb == 4) {	// 全款
                    // $("#"+itemInfo.itemNo+"-"+xmht[j].xmhtNo+"li8").show();
                    $("#" + itemInfo.itemNo + "-" + xmht[j].xmhtNo + "btn8").removeClass("btn_cz cur").addClass("btn_cz");
                    $("#" + itemInfo.itemNo + "-" + xmht[j].xmhtNo + "img8").attr('src', "/dance/static/images/jt_g.png");
                    $("#" + itemInfo.itemNo + "-" + xmht[j].xmhtNo + "img8").prev().html(timeStamp2DateString(xmfk[k].fksj));
                }
                /* if(xmfk[k].fklb==5){	// 退履约质保金
                    // $("#"+itemInfo.itemNo+"-"+xmht[j].xmhtNo+"li9").show();
                    $("#"+itemInfo.itemNo+"-"+xmht[j].xmhtNo+"btn9").removeClass("btn_cz").addClass("btn_cz cur");
                } */
            }
            // 验收
            var xmys = xmht[j].xmysList;
            for (var l = 0; l < xmys.length; l++) {
                // $("#"+itemInfo.itemNo+"-"+xmht[l].xmhtNo+"li5").show();
                $("#" + itemInfo.itemNo + "-" + xmht[j].xmhtNo + "btn5").removeClass("btn_cz cur").addClass("btn_cz");
                $("#" + itemInfo.itemNo + "-" + xmht[j].xmhtNo + "img5").attr('src', "/dance/static/images/jt_g.png");
                $("#" + itemInfo.itemNo + "-" + xmht[j].xmhtNo + "img5").prev().html(xmys[l].yssj);
            }

            // 资产
            var xmzc = xmht[j].xmzcList;
            for (var m = 0; m < xmzc.length; m++) {
                // $("#"+itemInfo.itemNo+"-"+xmht[m].xmhtNo+"li6").show();
                $("#" + itemInfo.itemNo + "-" + xmht[j].xmhtNo + "btn6").removeClass("btn_cz cur").addClass("btn_cz");
                $("#" + itemInfo.itemNo + "-" + xmht[j].xmhtNo + "img6").attr('src', "/dance/static/images/jt_g.png");
                $("#" + itemInfo.itemNo + "-" + xmht[j].xmhtNo + "img6").prev().html(xmzc[m].djsj);
            }
        }/* 不带招标-end */

    }/* 采购计划-end */
}

