//通信模块厂家
$(function () {
    $("#txmkcj").keyup(function (evt) {
        ChangeCoords(); //控制查询结果div坐标
        var k = window.event ? evt.keyCode : evt.which;
        if ($("#txmkcj").val() != "" && k != 38 && k != 40 && k != 13) {
            $.ajax({
                type: 'post',
                async: true, //同步执行，不然会有问题
                dataType: "json",
                url: "/equip/selectListSccj.action",
                data: {cjmc:$("#txmkcj").val()},

                error: function (msg) {//请求失败处理函数
                    alert("数据加载失败");
                },
                success: function (data) {
                    if (data.length > 0) {
                        var layer = "";
                        layer = "<table id='aa' style='margin-top: 0px;'>";
                        $.each(data, function (idx, item) {
                            layer += "<tr class='line'><td class='std'>" + item.cjmc + "</td></tr>";
                        });
                        layer += "</table>";

                        //将结果添加到div中
                        $("#searchresult").empty();
                        $("#searchresult").append(layer);
                        $(".line:first").addClass("hover");
                        $("#searchresult").css("display", "");
                        //鼠标移动事件

                        $(".line").hover(function () {
                            $(".line").removeClass("hover");
                            $(this).addClass("hover");
                        }, function () {
                            $(this).removeClass("hover");
                            //$("#searchresult").css("display", "none");
                        });
                        //鼠标点击事件
                        $(".line").click(function () {
                            $("#txmkcj").val($(this).text());
                            $("#searchresult").css("display", "none");
                        });
                    } else {
                        $("#searchresult").empty();
                        $("#searchresult").css("display", "none");
                    }
                }
            });
        }
        else if (k == 38) {//上箭头
            $('#aa tr.hover').prev().addClass("hover");
            $('#aa tr.hover').next().removeClass("hover");
            $('#txmkcj').val($('#aa tr.hover').text());
        } else if (k == 40) {//下箭头
            $('#aa tr.hover').next().addClass("hover");
            $('#aa tr.hover').prev().removeClass("hover");
            $('#txmkcj').val($('#aa tr.hover').text());
        }
        else if (k == 13) {//回车
            $('#txmkcj').val($('#aa tr.hover').text());
            $("#searchresult").empty();
            $("#searchresult").css("display", "none");
        }
        else {
            $("#searchresult").empty();
            $("#searchresult").css("display", "none");
        }
    });
    $("#searchresult").bind("mouseleave", function () {
          $("#searchresult").empty();
          $("#searchresult").css("display", "none");
      });
});
function ChangeCoords() {
    var left = $("#txmkcj").position().left; //获取距离最左端的距离，像素，整型
    var top = $("#txmkcj").position().top + 20; ; //获取距离最顶端的距离，像素，整型（20为搜索输入框的高度）
    $("#searchresult").css("left", left + "px"); //重新定义CSS属性
    $("#searchresult").css("top", top + "px"); //同上
}
//DTU生产厂商
$(function () {
    $("#sccs").keyup(function (evt) {
        ChangeCoords2(); //控制查询结果div坐标
        var k = window.event ? evt.keyCode : evt.which;
        if ($("#sccs").val() != "" && k != 38 && k != 40 && k != 13) {
            $.ajax({
                type: 'post',
                async: true, //同步执行，不然会有问题
                dataType: "json",
                url: "/equip/selectListSccj.action",
                data: {cjmc:$("#sccs").val()},

                error: function (msg) {//请求失败处理函数
                    alert("数据加载失败");
                },
                success: function (data) {
                    if (data.length > 0) {
                        var layer = "";
                        layer = "<table id='aa' style='margin-top: 0px;'>";
                        $.each(data, function (idx, item) {
                            layer += "<tr class='line'><td class='std'>" + item.cjmc + "</td></tr>";
                        });
                        layer += "</table>";

                        //将结果添加到div中
                        $("#searchresult").empty();
                        $("#searchresult").append(layer);
                        $(".line:first").addClass("hover");
                        $("#searchresult").css("display", "");
                        //鼠标移动事件

                        $(".line").hover(function () {
                            $(".line").removeClass("hover");
                            $(this).addClass("hover");
                        }, function () {
                            $(this).removeClass("hover");
                            //$("#searchresult").css("display", "none");
                        });
                        //鼠标点击事件
                        $(".line").click(function () {
                            $("#sccs").val($(this).text());
                            $("#searchresult").css("display", "none");
                        });
                    } else {
                        $("#searchresult").empty();
                        $("#searchresult").css("display", "none");
                    }
                }
            });
        }
        else if (k == 38) {//上箭头
            $('#aa tr.hover').prev().addClass("hover");
            $('#aa tr.hover').next().removeClass("hover");
            $('#sccs').val($('#aa tr.hover').text());
        } else if (k == 40) {//下箭头
            $('#aa tr.hover').next().addClass("hover");
            $('#aa tr.hover').prev().removeClass("hover");
            $('#sccs').val($('#aa tr.hover').text());
        }
        else if (k == 13) {//回车
            $('#sccs').val($('#aa tr.hover').text());
            $("#searchresult").empty();
            $("#searchresult").css("display", "none");
        }
        else {
            $("#searchresult").empty();
            $("#searchresult").css("display", "none");
        }
    });
    $("#searchresult").bind("mouseleave", function () {
        $("#searchresult").empty();
        $("#searchresult").css("display", "none");
    });
});
function ChangeCoords2() {
    var left = $("#sccs").position().left; //获取距离最左端的距离，像素，整型
    var top = $("#sccs").position().top + 20; ; //获取距离最顶端的距离，像素，整型（20为搜索输入框的高度）
    $("#searchresult").css("left", left + "px"); //重新定义CSS属性
    $("#searchresult").css("top", top + "px"); //同上
}
//一次柜生产厂商
$(function () {
    $("#sccsYcg").keyup(function (evt) {
        ChangeCoords3(); //控制查询结果div坐标
        var k = window.event ? evt.keyCode : evt.which;
        if ($("#sccsYcg").val() != "" && k != 38 && k != 40 && k != 13) {
            $.ajax({
                type: 'post',
                async: true, //同步执行，不然会有问题
                dataType: "json",
                url: "/equip/selectListSccj.action",
                data: {cjmc:$("#sccsYcg").val()},

                error: function (msg) {//请求失败处理函数
                    alert("数据加载失败");
                },
                success: function (data) {
                    if (data.length > 0) {
                        var layer = "";
                        layer = "<table id='aa' style='margin-top: 0px;'>";
                        $.each(data, function (idx, item) {
                            layer += "<tr class='line'><td class='std'>" + item.cjmc + "</td></tr>";
                        });
                        layer += "</table>";

                        //将结果添加到div中
                        $("#searchresult").empty();
                        $("#searchresult").append(layer);
                        $(".line:first").addClass("hover");
                        $("#searchresult").css("display", "");
                        //鼠标移动事件

                        $(".line").hover(function () {
                            $(".line").removeClass("hover");
                            $(this).addClass("hover");
                        }, function () {
                            $(this).removeClass("hover");
                            //$("#searchresult").css("display", "none");
                        });
                        //鼠标点击事件
                        $(".line").click(function () {
                            $("#sccsYcg").val($(this).text());
                            $("#searchresult").css("display", "none");
                        });
                    } else {
                        $("#searchresult").empty();
                        $("#searchresult").css("display", "none");
                    }
                }
            });
        }
        else if (k == 38) {//上箭头
            $('#aa tr.hover').prev().addClass("hover");
            $('#aa tr.hover').next().removeClass("hover");
            $('#sccsYcg').val($('#aa tr.hover').text());
        } else if (k == 40) {//下箭头
            $('#aa tr.hover').next().addClass("hover");
            $('#aa tr.hover').prev().removeClass("hover");
            $('#sccsYcg').val($('#aa tr.hover').text());
        }
        else if (k == 13) {//回车
            $('#sccsYcg').val($('#aa tr.hover').text());
            $("#searchresult").empty();
            $("#searchresult").css("display", "none");
        }
        else {
            $("#searchresult").empty();
            $("#searchresult").css("display", "none");
        }
    });
    $("#searchresult").bind("mouseleave", function () {
        $("#searchresult").empty();
        $("#searchresult").css("display", "none");
    });
});
function ChangeCoords3() {
    var left = $("#sccsYcg").position().left; //获取距离最左端的距离，像素，整型
    var top = $("#sccsYcg").position().top + 20; ; //获取距离最顶端的距离，像素，整型（20为搜索输入框的高度）
    $("#searchresult").css("left", left + "px"); //重新定义CSS属性
    $("#searchresult").css("top", top + "px"); //同上
}
//溢水柜生产厂商
$(function () {
    $("#sccsYs").keyup(function (evt) {
        ChangeCoords4(); //控制查询结果div坐标
        var k = window.event ? evt.keyCode : evt.which;
        if ($("#sccsYs").val() != "" && k != 38 && k != 40 && k != 13) {
            $.ajax({
                type: 'post',
                async: true, //同步执行，不然会有问题
                dataType: "json",
                url: "/equip/selectListSccj.action",
                data: {cjmc:$("#sccsYs").val()},

                error: function (msg) {//请求失败处理函数
                    alert("数据加载失败");
                },
                success: function (data) {
                    if (data.length > 0) {
                        var layer = "";
                        layer = "<table id='aa' style='margin-top: 0px;'>";
                        $.each(data, function (idx, item) {
                            layer += "<tr class='line'><td class='std'>" + item.cjmc + "</td></tr>";
                        });
                        layer += "</table>";

                        //将结果添加到div中
                        $("#searchresult").empty();
                        $("#searchresult").append(layer);
                        $(".line:first").addClass("hover");
                        $("#searchresult").css("display", "");
                        //鼠标移动事件

                        $(".line").hover(function () {
                            $(".line").removeClass("hover");
                            $(this).addClass("hover");
                        }, function () {
                            $(this).removeClass("hover");
                            //$("#searchresult").css("display", "none");
                        });
                        //鼠标点击事件
                        $(".line").click(function () {
                            $("#sccsYs").val($(this).text());
                            $("#searchresult").css("display", "none");
                        });
                    } else {
                        $("#searchresult").empty();
                        $("#searchresult").css("display", "none");
                    }
                }
            });
        }
        else if (k == 38) {//上箭头
            $('#aa tr.hover').prev().addClass("hover");
            $('#aa tr.hover').next().removeClass("hover");
            $('#sccsYs').val($('#aa tr.hover').text());
        } else if (k == 40) {//下箭头
            $('#aa tr.hover').next().addClass("hover");
            $('#aa tr.hover').prev().removeClass("hover");
            $('#sccsYs').val($('#aa tr.hover').text());
        }
        else if (k == 13) {//回车
            $('#sccsYs').val($('#aa tr.hover').text());
            $("#searchresult").empty();
            $("#searchresult").css("display", "none");
        }
        else {
            $("#searchresult").empty();
            $("#searchresult").css("display", "none");
        }
    });
    $("#searchresult").bind("mouseleave", function () {
        $("#searchresult").empty();
        $("#searchresult").css("display", "none");
    });
});
function ChangeCoords4() {
    var left = $("#sccsYs").position().left; //获取距离最左端的距离，像素，整型
    var top = $("#sccsYs").position().top + 20; ; //获取距离最顶端的距离，像素，整型（20为搜索输入框的高度）
    $("#searchresult").css("left", left + "px"); //重新定义CSS属性
    $("#searchresult").css("top", top + "px"); //同上
}
//消防生产厂商
$(function () {
    $("#sccsXf").keyup(function (evt) {
        ChangeCoords5(); //控制查询结果div坐标
        var k = window.event ? evt.keyCode : evt.which;
        if ($("#sccsXf").val() != "" && k != 38 && k != 40 && k != 13) {
            $.ajax({
                type: 'post',
                async: true, //同步执行，不然会有问题
                dataType: "json",
                url: "/equip/selectListSccj.action",
                data: {cjmc:$("#sccsXf").val()},

                error: function (msg) {//请求失败处理函数
                    alert("数据加载失败");
                },
                success: function (data) {
                    if (data.length > 0) {
                        var layer = "";
                        layer = "<table id='aa' style='margin-top: 0px;'>";
                        $.each(data, function (idx, item) {
                            layer += "<tr class='line'><td class='std'>" + item.cjmc + "</td></tr>";
                        });
                        layer += "</table>";

                        //将结果添加到div中
                        $("#searchresult").empty();
                        $("#searchresult").append(layer);
                        $(".line:first").addClass("hover");
                        $("#searchresult").css("display", "");
                        //鼠标移动事件

                        $(".line").hover(function () {
                            $(".line").removeClass("hover");
                            $(this).addClass("hover");
                        }, function () {
                            $(this).removeClass("hover");
                            //$("#searchresult").css("display", "none");
                        });
                        //鼠标点击事件
                        $(".line").click(function () {
                            $("#sccsXf").val($(this).text());
                            $("#searchresult").css("display", "none");
                        });
                    } else {
                        $("#searchresult").empty();
                        $("#searchresult").css("display", "none");
                    }
                }
            });
        }
        else if (k == 38) {//上箭头
            $('#aa tr.hover').prev().addClass("hover");
            $('#aa tr.hover').next().removeClass("hover");
            $('#sccsXf').val($('#aa tr.hover').text());
        } else if (k == 40) {//下箭头
            $('#aa tr.hover').next().addClass("hover");
            $('#aa tr.hover').prev().removeClass("hover");
            $('#sccsXf').val($('#aa tr.hover').text());
        }
        else if (k == 13) {//回车
            $('#sccsXf').val($('#aa tr.hover').text());
            $("#searchresult").empty();
            $("#searchresult").css("display", "none");
        }
        else {
            $("#searchresult").empty();
            $("#searchresult").css("display", "none");
        }
    });
    $("#searchresult").bind("mouseleave", function () {
        $("#searchresult").empty();
        $("#searchresult").css("display", "none");
    });
});
function ChangeCoords5() {
    var left = $("#sccsXf").position().left; //获取距离最左端的距离，像素，整型
    var top = $("#sccsXf").position().top + 20; ; //获取距离最顶端的距离，像素，整型（20为搜索输入框的高度）
    $("#searchresult").css("left", left + "px"); //重新定义CSS属性
    $("#searchresult").css("top", top + "px"); //同上
}