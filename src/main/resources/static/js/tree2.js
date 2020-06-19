var path;
$.fn.DTree = function (options) {
    var me = this;
    me.empty();
    var defos = {
        params: {"id": "deptId", "name": "name", "pId": "pId", "childs": "depts", "type": "type"},
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
                    defos.click(t, t.val(), t.attr("treeType"));
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
            $(".tagBox").mouseover(function () {
                var that = $(this);
                var ions = that.find(".icons");
                ions.show();
            });
            $(".tagBox").mouseout(function () {
                var that = $(this);
                var ions = that.find(".icons");
                ions.hide();
            });
            $(".add").mouseover(function () {
                var that = $(this);
                that.addClass("showBorder");
            });
            $(".add").mouseout(function () {
                var that = $(this);
                that.removeClass("showBorder");
            });
            $(".delete").mouseover(function () {
                var that = $(this);
                that.addClass("showBorder");
            });
            $(".delete").mouseout(function () {
                var that = $(this);
                that.removeClass("showBorder");
            });
            $(".update").mouseover(function () {
                var that = $(this);
                that.addClass("showBorder");
            });
            $(".update").mouseout(function () {
                var that = $(this);
                that.removeClass("showBorder");
            });

            $(".add").click(function () {
                var that = $(this);
                var box = that.parent().parent();
                var input = $("<div class='addbox'><input type='text' ><span class='icon-all yes'></span><span class='icon-all no'></span></div>");
                box.append(input);
                $(".yes").click(function () {
                    var that = $(this);
                    var box = that.parent().parent();
                    var input = that.parent().find("input").val();
                    var treedata = box.find("[name='back']");
                    var pid = treedata.val();
                    var treeType = treedata.attr("treeType");
                    if (options.add) {
                        options.add(pid, treeType, input);
                        that.parent().remove();
                    }
                });
                $(".no").click(function () {
                    var that = $(this);
                    that.parent().remove();

                });
            });
            $(".update").click(function () {
                var that = $(this);
                var box = that.parent().parent();
                var input = $("<div class='addbox'><input type='text' ><span class='icon-all updateyes'></span><span class='icon-all updateno'></span></div>");
                box.append(input);
                $(".updateyes").click(function () {
                    var that = $(this);
                    var box = that.parent().parent();
                    var newName = that.parent().find("input").val();
                    var id = box.find("[name='back']").val();
                    var delabel = box.find("label");
                    console.log(newName);
                    delabel.text(newName);
                    if (options.update) {
                        options.update(id, newName);
                        that.parent().remove();
                    }
                });
                $(".updateno").click(function () {
                    var that = $(this);
                    that.parent().remove();

                });
            });
            $(".delete").click(function () {
                var that = $(this).parent().parent();
                var id = that.find("[name='back']").val();
                var child = that.next(".childs-box");
                that.remove();
                child.remove();
                if (options.Delete) {
                    options.Delete(id);
                }
            });

        },
        traverse: function (data, params, el) {
            if (data && data.length) {
                if (data && data.length) {
                    for (var i = 0; i < data.length; i++) {
                        if (data[i][params.childs] && data[i][params.childs].length) {
                            var deHtml = "<div class=\"tagBox\"><span class=\"icon-all open\"></span>" +
                                "<input type=\"radio\" treeType=\"" + data[i][params["type"]] + "\" name=\"back\"class=\"dra_back\" id=\"d" + data[i][params["id"]] + "\" value=\"" + data[i][params.id] + "\"><label for=\"d" + data[i][params["id"]] + "\" class=\"muen_title\">" + data[i][params.name] + "</label>";

                            if (data[i].levels > 1) {
                                deHtml += "<div class='icons'><span class='icon-all add' ></span><span class='icon-all delete' ></span><span class='icon-all update' ></span></div></div>";
                            } else {
                                if (data[i].levels == 1) {
                                    deHtml += "<div class='icons'><span class='icon-all add' ></span></div></div>";
                                }
                            }
                            var dept = $(deHtml);
                            el.append(dept);
                            var childs = $("<div class=\"childs-box\"></div>");
                            defos.traverse(data[i][params.childs], params, childs);
                            el.append(childs);
                        } else {
                            var deHtml = "<div class=\"tagBox\"><span class=\"icon-all open\"></span>" +
                                "<input type=\"radio\" treeType=\"" + data[i][params["type"]] + "\" name=\"back\" class=\"dra_back\" id=\"d" + data[i][params["id"]] + "\" value=\"" + data[i][params.id] + "\"><label for=\"d" + data[i][params["id"]] + "\" class=\"muen_title\">" + data[i][params.name] + "</label>";
                            if (data[i].levels > 1) {
                                deHtml += "<div class='icons'><span class='icon-all add' ></span><span class='icon-all delete' ></span><span class='icon-all update' ></span></div></div>";
                            } else {
                                if (data[i].levels == 1) {
                                    deHtml += "<div class='icons'><span class='icon-all add' ></span></div></div>";
                                }
                            }
                            var dept = $(deHtml);
                            el.append(dept);
                        }
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
    $.getJSON("Xgpgbz/DTree2.action", {"cmd": "getAll", verId: verId}, function (data) {
        console.log(data);
        var options = {
            data: data.body,
            params: {"id": "treId", "name": "treName", "pId": "parentId", "childs": "listtTree", "type": "type"},
            success: function () {
            },
            click: function (el, id, type) {
                console.log("单击。。。");
                console.log(id);
                console.log(type);
                $(window.parent.document).find("#right").attr("src", path + "/TPgfa/toList1.action?deptId=" + id + "&type=" + type);
            },
            update: function (id, newName) {
                console.log("修改。。。");
                $.getJSON("Cjpgbz/DTree.action", {"cmd": "update", deptId: id, newName: newName}, function (data) {
                    alert(data.Msg);
                    console.log(id);
                    console.log(newName);
                    initDept(verId);
                });
            },
            Delete: function (id) {
                console.log("删除。。。");
                console.log(id);
                $.getJSON("Cjpgbz/DTree.action", {"cmd": "delete", deptId: id}, function (data) {
                    alert(data.Msg);
                });
            },
            add: function (pid, type, newName) {
                console.log("添加。。。");
                $.getJSON("Cjpgbz/DTree.action", {
                    "cmd": "add",
                    pId: pid,
                    newName: newName,
                    type: type
                }, function (data) {
                    // alert(data.Msg);
                    if (data.state == 0) {
                        initDept(verId);
                    }
                });
                console.log(pid);
                console.log(newName);
            }
        };
        $("#tree2").DTree(options);
    });
}


