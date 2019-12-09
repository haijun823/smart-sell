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
            $addform.dialog("center").dialog("open").form("clear");
        },
        update() {
            //数据回显
            //获得选中的数据
            var $selected = $information.datagrid("getSelected");
            if ($selected) {
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
                        $.get("/permission/del", {id: $selected.id}, function (msg) {
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
            var $url = "/permission/add";
            if ($("#editid").val()) {
                $url = "/permission/upd?cmd=upd";
            }
            $editform.form('submit', {
                url:$url,
                onSubmit: function(){
                    return $editform.form("validate")
                },
                success:function(data){
                    $.messager.alert('提示',data);
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
});