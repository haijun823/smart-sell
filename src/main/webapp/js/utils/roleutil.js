function persFettr(value,row) {
    var role = [];
    if (value){
        $.each(value,function (index,obj) {
            role.push(obj.name);
        })
    }
    return role.toString();
}

//添加，删除，修改
$(function () {
    //获得被选中的对象
    var $information = $("#information");
    //获得弹出框
    var $addform = $("#addform");
    //获得表单
    var $editform = $("#editForm");
    //获得权限的数据表格
    var permissions = $("#permissionAll");
    var mypermissions = $("#mypermission");

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
            mypermissions.datagrid("loadData",[]);
        },
        update() {
            //数据回显
            //获得选中的数据
            var row = $information.datagrid("getSelected");
            if (row) {
                //将窗口绝对居中
                $addform.dialog("center").dialog("open").form("clear");
                var newRow = []
                $.extend(newRow,row.permissions);
                mypermissions.datagrid("loadData",newRow);
                $editform.form("load",row);
            } else {
                $.messager.alert('提示', '您还没有选中需要修改的信息哟!!!');
            }
        },
        remove() {
            var $selected = $information.datagrid("getSelected");
            if ($selected) {
                $.messager.confirm('确认', '您确认想要删除记录吗？', function (r) {
                    if (r) {
                        $.get("/role/del", {id: $selected.id}, function (msg) {
                            if (msg == '删除成功!!') {
                                //刷新当前页面
                                $.messager.alert('提示', '恭喜您删除成功');
                                $information.datagrid("reload");
                            } else {
                                $.messager.alert('提示', msg);
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
            var $url = "/role/add";
            if ($("#editid").val()) {
                $url = "/role/upd?cmd=upd";
            }
            $editform.form('submit', {
                url: $url,
                onSubmit: function (param) {
                    var rows = mypermissions.datagrid("getRows");
                    $.each(rows,function (i,v) {
                       param["permissions["+i+"].id"] = v.id;
                    });
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
        },
        addRow(index,row){
            var rows = mypermissions.datagrid("getRows");
            if (rows.length){
                for(var i=0;i < rows.length;i++){
                    if (row.id == rows[i].id){
                        $.messager.show({
                            title:'提示',
                            msg:'不能重复哟',
                            timeout:2000,
                            showType:'slide'
                        });
                        return;
                    }
                }
            }
            mypermissions.datagrid("appendRow",row);
        },
        removeRow(index,row){
            mypermissions.datagrid("deleteRow",index);
        }
    }
    permissions.datagrid({
        url:'/permission/getall',
        fitColumns:true,
        singleSelect:true,
        pagination:true,
        fit:true,
        onDblClickRow:method.addRow
    });
    mypermissions.datagrid({
        fitColumns:true,
        singleSelect:true,
        fit:true,
        onDblClickRow:method.removeRow
    });

});
