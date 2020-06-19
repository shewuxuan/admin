var path;
$.fn.DTree = function (options) {
    var me = this;
    me.empty();
    var defos = {
        params: {"id": "deptId", "name": "name", "pId": "pId", "childs": "depts", "type": "type", "levels": "levels"},
        data: {},
        success: null,
        initEvent: function () {
            $(".muen_title").click(function () {
                var parent = $(this).parent();
                var title = parent.find(".muen_title");
                if (options.click) {
                    var t = parent.find("[name='back']");
                    var name = $(this).text();
                    var dept = {
                        id: t.val(),
                        pid: t.attr("id").substring(1),
                        name: name.substring(0, name.indexOf("("))
                    };
                    defos.click(t, t.val(), t.attr("treeType"), t.attr("treeLevels"));
                }
            });
            $(".open").click(function () {
                var parent = $(this).parent();
                var icon = parent.find("span");
                var child = parent.next(".childs-box");
                if (child[0]) {
                    child.slideToggle(200);
                    if (icon[0]) {
                        if (icon.hasClass("close")) {
                            icon.removeClass("close");
                            icon.addClass("open");
                        } else {
                            icon.removeClass("open");
                            icon.addClass("close");
                        }
                    }
                }

            });
            /*        $(".tagBox").mouseover(function(){
                            var that=$(this);
                            var ions=that.find(".icons");
                           ions.show();
                    });
                    $(".tagBox").mouseout(function(){
                        var that=$(this);
                        var ions=that.find(".icons");
                        ions.hide();
                    });*/

        },
        traverse: function (data, params, el) {
            if (data && data.length) {
                for (var i = 0; i < data.length; i++) {
                    if (data[i][params.childs] && data[i][params.childs].length) {
                        var deHtml = "<div class=\"tagBox\"><span class=\"icon-all open\"></span>" +
                            "<input type=\"radio\" treeType=\"" + data[i][params["type"]] + "\" treeLevels=\"" + data[i][params["levels"]] + "\" name=\"back\"class=\"dra_back\" id=\"d" + data[i][params["id"]] + "\" value=\"" + data[i][params.id] + "\"><label for=\"d" + data[i][params["id"]] + "\" class=\"muen_title\">" + data[i][params.name] + "</label>";

                        if (data[i].levels > 1) {
                            deHtml += "<div class='icons'><span class='icon-all add' ></span><span class='icon-all delete' ></span><span class='icon-all update' ></span></div></div>";
                        } else {
                            deHtml += "<div class='icons'><span class='icon-all add' ></span></div></div>";
                        }
                        var dept = $(deHtml);
                        el.append(dept);
                        var childs = $("<div class=\"childs-box\"></div>");
                        defos.traverse(data[i][params.childs], params, childs);
                        el.append(childs);
                    } else {
                        var deHtml = "<div class=\"tagBox\"><span class=\"icon-all open\"></span>" +
                            "<input type=\"radio\" treeType=\"" + data[i][params["type"]] + "\" treeLevels=\"" + data[i][params["levels"]] + "\" name=\"back\" class=\"dra_back\" id=\"d" + data[i][params["id"]] + "\" value=\"" + data[i][params.id] + "\"><label for=\"d" + data[i][params["id"]] + "\" class=\"muen_title\">" + data[i][params.name] + "</label>";
                        if (data[i].levels > 1) {
                            deHtml += "<div class='icons'><span class='icon-all add' ></span><span class='icon-all delete' ></span><span class='icon-all update' ></span></div></div>";
                        } else {
                            deHtml += "<div class='icons'><span class='icon-all add' ></span></div></div>";
                        }
                        var dept = $(deHtml);
                        el.append(dept);
                    }
                }
            }
        }
    };
    defos = $.extend(defos, options);
    defos.traverse(defos.data, defos.params, me);
    defos.initEvent();
    if (options.success) {
        defos.success();
    }
    return me;
};

$(function () {
    path = $("#path").val();
    initDept($("#verId").val());

});

function initDept(verId) {
    $.getJSON("test/DTree1.action", {"cmd": "getAll", verId: verId}, function (data) {
        console.log(data);
        var options = {
            data: data.body,
            params: {
                "id": "treId",
                "name": "treName",
                "pId": "parentId",
                "childs": "listtTree",
                "type": "type",
                "levels": "levels"
            },
            success: function () {
            },
            click: function (el, id, type, levels) {
                console.log("单击。。。");
                console.log(id);
                console.log(type);
                console.log(levels);
                $(window.parent.document).find("#right").attr("src", path + "/test/toList.action?deptId=" + id + "&type=" + type + "&levels=" + levels);
                localStorage.clear();
            }
        };
        $("#tree1").DTree(options);
    });


}


