function checkForm() {
    var form = document.forms[0];
    if (form.schemeName.value == "") {
        alert("任务名称不能为空!");
        form.schemeName.focus();
        return false;
    }
    if (form.unitName.value == "") {
        alert("受评单位不能为空!");
        form.unitName.focus();
        return false;
    }
    if (form.pgjcName.value == "") {
        alert("评检中心不能为空!");
        form.pgjcName.focus();
        return false;
    }
    dian();
}

//要确定行的唯一性（提示：你可以使用你的主键）
var id = 1;

//添加行的方法
function addTr() {
    //获得表格对象
    var tb = document.getElementById('testTab');

    //添加一行    
    var newTr = tb.insertRow(6);//在最下的位置


    //给这个行设置id属性，以便于管理（删除）
    newTr.id = 'tr' + id;


    //设置对齐方式（只是告诉你，可以以这种方式来设置任何它有的属性）
    /*  newTr.align='right';*/

    //添加两列    
    var newTd0 = newTr.insertCell();
    var newTd1 = newTr.insertCell();
    var newTd2 = newTr.insertCell();
    var newTd3 = newTr.insertCell();
    var newTd4 = newTr.insertCell();

    //设置列内容和属性
    newTd4.innerHTML = "&nbsp;<button  class='btne' onclick=\"moveTr('" + id + "');\" >移除</button>";
    ;
    newTd3.innerHTML = "<input >";
    ;//移除按钮
    newTd2.innerHTML = "<span>技术职称:<span>";
    ;
    newTd1.innerHTML = "<input >";
    ;
    newTd0.innerHTML = "<span>评组成员:<span>"; //让你看到删除的是指定的行


    id++;

}

//移除行的方法
function moveTr(id) {
    //获得表格对象
    var tb = document.getElementById('testTab');
    //根据id获得将要删除行的对象
    var tr = document.getElementById('tr' + id);
    //取出行的索引，设置删除行的索引
    tb.deleteRow(tr.rowIndex);

}

