function appendParam(url, params) {
    var has = url.indexOf("?") === -1;

    for (var i in params) {
        if (has) {
            url += "?" + i + "=" + params[i];
            has = false;
        } else {
            url += "&" + i + "=" + params[i];
        }
    }

    return url;
}

//设置Ajax操作的默认设置
$.ajaxSetup({
    cache: false,
    error: function (XMLHttpRequest, textStatus, errorThrown) {
        alert("调用服务器失败!");
    }
});

