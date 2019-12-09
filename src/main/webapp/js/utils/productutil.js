function producttype(value,row,index) {
    return value?value.name:"";
}
function unit(value,row,index) {
    return value?value.name:"";
}
function brand(value,row,index) {
    return value?value.name:"";
}
function blockmatter(value,row,index) {
    var divblock = `<div style="height: 40px;width: 40px;background-color:${value};margin-left: 40px">`;
    return value?divblock:"";
}
//加载图片方法
function img(value,row,index) {
    var path = row.pic;
    var $img = `<img onclick=\"maxpic('${row.pic}')\" src='${value}' width='70px' height='70px' alt='头像加载错误'>`;
    return value?$img:"没有头像";
}



//添加，删除，修改
$(function () {
    //获得被选中的对象
    var $information = $("#information");
    //获得弹出框
    var $addform = $("#addform");
    //获得表单
    var $editform = $("#editForm");
    //顶部工具栏添加事件
    $("[data-method]").on("click", function () {
        var $method = $(this).attr("data-method");
        //动态调用方法
        method[$method]();
    });
    //定义一个对象其中包括增删该查的方法
    var method = {
        add() {
            $("[easy-hiden]").hide();
            $addform.dialog("center").dialog("open").form("clear");
        },
        update() {
            //数据回显
            //获得选中的数据
            var $selected = $information.datagrid("getSelected");
            if ($selected) {
                $("[easy-hiden]").show();
                if ($selected.typesId){
                    $selected["typesId.id"] = $selected.typesId.id;
                }if ($selected.unitId){
                    $selected["unitId.id"] = $selected.unitId.id;
                }if($selected.brandId){
                    $selected["brandId.id"] = $selected.brandId.id;
                }if($selected.pic){
                    $("#recoverImg").attr("src",$selected.pic);
                }
                //将窗口绝对居中
                $addform.dialog("center").dialog("open").form("clear");
                $addform.form("load", $selected);

            } else {
                $.messager.alert('提示', '您还没有选中需要修改的信息哟!!!');
            }
        },
        remove() {
            var $selected = $information.datagrid("getSelected");
            if ($selected) {
                $.messager.confirm('确认', '您确认想要删除记录吗？', function (r) {
                    if (r) {
                        $.get("/product/del", {id: $selected.id}, function (msg) {
                            if (msg == '删除成功!!') {
                                //刷新当前页面
                                $.messager.alert('提示', '恭喜您删除成功');
                                $information.datagrid("reload");
                            } else {
                                $.messager.alert('提示', '删除失败');
                                $information.datagrid("reload");
                            }
                        });
                    }
                });
            } else {
                $.messager.alert('警告', '您还没有选中需要删除的信息哟!!!');
            }
        },
        //提交表单
        save() {
            var $url = "/product/upd";
            if ($("#editid").val()) {
                $url = "/product/upd?cmd=upd";
            }
            $editform.form('submit', {
                url: $url,
                onSubmit: function () {
                    return $editform.form("validate")
                },
                success: function (data) {
                    $.messager.alert('提示', data);
                    $addform.dialog("close");
                    $information.datagrid("reload");
                }
            });
        },
        cancel() {
            $addform.dialog("close");
        },
        //高级查询
        search() {
            //获得查询表单的所有值
            var $search = $("#search-form").serializeObject();
            //使用load发生请求载入数据
            $information.datagrid("load", $search);
        }
    }
    //给页面注册事件
    document.body.oncontextmenu = function (e) {
        e.preventDefault();
        if (e.button == 2) {
            $('#mm').menu('show', {
                left: e.pageX,
                top: e.pageY,
                onClick: function (obj) {
                    var $text = obj.text;
                    console.debug();
                    if ($text == '年纪') {
                        $information.datagrid("load", {});
                    }
                }
            });
        }
    };

});
//显示图片的大图
var layer;
function maxpic(obj){
    layui.use('layer',function () {
        var e = window.event;
        layer = layui.layer;
        layer.open({
            type:1,
            title:false,
            area:['400px','500px'],
            content:'<img src="'+obj+'" style="width: 400px;height: 500px">',
            offset:[e.pageY-100,e.pageX+100],
            shade:'0'
        });
    });
};

