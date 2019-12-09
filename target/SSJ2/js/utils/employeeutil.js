//加载图片方法
function imgform(value,row,index) {
    var $img = "<img src='"+value+"' width='70px' height='70px' alt='头像加载错误'>";
    return value?$img:"没有头像";
}
//加载部门
function departmentformatter(value,row,index) {
    return value?value.name:"没有部门";
}
//加载权限
function permissionformatter(value,row,index) {
    var role = [];
    if (value){
        $.each(value,function (index,obj) {
            role.push(obj.name);
        })
    }
    return role.toString();
}
//验证账户名是否重复
$.extend($.fn.validatebox.defaults.rules, {
    isRepetition: {
        validator: function(value, param){
            //只能使用同步验证，否则响应还没有回来就会返回值
            var result = $.ajax({
                 url:"/employee/checkname"
                ,data:{username:value,id:$("#editid").val()}
                ,async:false //同步
            }).responseText;
            return result == 'true';
        },
        message: '用户名重复'
    }
});



//添加，删除，修改
$(function () {
    //获得被选中的对象
    var $information = $("#information");
    //获得弹出框
    var $addform = $("#addform");
    //获得表单
    var $editform = $("#editForm");
    //修改和删除的地址
    var $url;
    //顶部工具栏添加事件
    $("[data-method]").on("click",function () {
        var $method = $(this).attr("data-method");
        //动态调用方法
        method[$method]();

    });
    //定义一个对象其中包括增删该查的方法
    var method = {
        add(){
            $addform.dialog("center").dialog("open").form("clear");
            //打开密码框，并且启用验证
            $("[data-hidden]").show().form("enableValidation");
        },
        update(){
            //数据回显
            //获得选中的数据
            var $selected = $information.datagrid("getSelected");
            if($selected){
                //隐藏密码框,并且禁用验证
                $("[data-hidden]").hide().form("disableValidation");
                //部门
                if ($selected.department){
                    $selected["department.id"] = $selected.department.id;
                }
                //将窗口绝对居中
                $addform.dialog("center").dialog("open").form("clear");
                $addform.form("load",$selected);
            }else {
                $.messager.alert('提示','您还没有选中需要修改的信息哟!!!');
            }
        },
        remove(){
            var $selected = $information.datagrid("getSelected");
            if($selected){
                $.messager.confirm('确认','您确认想要删除记录吗？',function(r){
                    if (r){
                        $.get("/employee/del",{id:$selected.id},function (msg) {
                            if (msg == '删除成功!!'){
                                //刷新当前页面
                                $.messager.alert('提示','恭喜您删除成功');
                                $information.datagrid("reload");
                            }else {
                                $.messager.alert('提示','删除失败');
                                $information.datagrid("reload");
                            }
                        });
                    }
                });
            }else {
                $.messager.alert('警告','您还没有选中需要删除的信息哟!!!');
            }
        },
        //提交表单
        save(){
            $url = "/employee/add";
            if ($("#editid").val()){
                $url = "/employee/upd?cmd=upd";
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
        cancel(){
            $addform.dialog("close");
        },
        //高级查询
        search(){
            //获得查询表单的所有值
            var $search = $("#search-form").serializeObject();
            //使用load发生请求载入数据
            $information.datagrid("load",$search);
        }
    }
    //给页面注册事件
    document.body.oncontextmenu = function (e) {
        e.preventDefault();
        if (e.button == 2){
            $('#mm').menu('show', {
                left: e.pageX,
                top: e.pageY,
                onClick:function (obj) {
                    console.debug(obj.text);
                }
            });
        }
    };
});
