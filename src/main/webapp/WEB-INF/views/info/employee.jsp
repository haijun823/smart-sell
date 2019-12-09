<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/WEB-INF/views/head/head.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <script type="text/javascript" src="/js/utils/employeeutil.js"></script>
</head>

<body>

<div id="tools" style="padding:5px;height:auto">
    <div style="margin-bottom:5px">
        <a href="javascript:;" data-method="add" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true">添加</a>
        <a href="javascript:;" data-method="remove" class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:true">删除</a>
        <a href="javascript:;" data-method="update" class="easyui-linkbutton"  data-options="iconCls:'icon-save',plain:true">修改</a>
    </div>
    <div>
        <form id="search-form" action="/employee/import" method="post">
            <input type="hidden" name="search" value="search">
            用户名: <input name="username" class="easyui-textbox"  style="width:200px">
            邮箱: <input name="email" class="easyui-textbox"  style="width:200px">
            部门:<input id="dept" class="easyui-combobox" name="department_id"
                      data-options="valueField:'id',textField:'name',url:'/department/getdept',panelHeight:'auto'" />
            <a href="javascript:;" class="easyui-linkbutton" data-method="search" iconCls="icon-search">Search</a>
            <button class="easyui-linkbutton" iconCls="icon-search">导出</button>
        </form>
    </div>
</div>

<!-- 员工展示 -->
<table id="information" class="easyui-datagrid"
       data-options="url:'/employee/getall',
	                    fitColumns:true,
	                    pagination:true,
	                    singleSelect:true,
	                    fit:true,
	                    toolbar:'#tools'">
    <thead>
    <tr>
        <th data-options="field:'username',width:100,align:'center'">用户名</th>
        <th data-options="field:'email',width:100,align:'center'">邮箱</th>
        <th data-options="field:'age',width:100,align:'center'">员工数量</th>
        <th data-options="field:'headImage',width:100,align:'center',formatter:imgform">商家头像</th>
        <th data-options="field:'department',width:100,align:'center',formatter:departmentformatter">商家名称</th>
        <th data-options="field:'roles',width:100,align:'center',formatter:permissionformatter">角色</th>
    </tr>
    </thead>
</table>


<!-- 弹出层，装form表单 -->
<div id="addform" class="easyui-dialog" title="添加/修改" width="400px"
     data-options="iconCls:'icon-save',resizable:true,modal:true,closed:true,buttons:'#submit',constrain:true">
    <!-- form表单 -->
    <form id="editForm" method="post">
        <input type="hidden" name="id" id="editid">
        <table cellpadding="5">
            <tr>
                <td>用户名:</td>
                <td><input class="easyui-validatebox" type="text"
                           name="username" data-options="required:true,validType:'isRepetition'"></input></td>
            </tr>
            <!-- 添加data-hidden属性用来在修改时隐藏掉密码框 -->
            <tr data-hidden>
                <td>密码:</td>
                <td><input class="easyui-validatebox" type="text"
                           id="password" name="password" data-options="required:true,validType:'password'"></input></td>
            </tr>
            <tr data-hidden>
                <td>重复密码:</td>
                <td><input class="easyui-validatebox" type="text"
                           validType="equals['password','id']"
                           data-options="required:true,validType:'password'"></input></td>
            </tr>
            <tr>
                <td>邮箱:</td>
                <td><input class="easyui-validatebox" type="text" name="email"
                           data-options="required:true,validType:'email'"></input></td>
            </tr>
            <tr>
                <td>年龄:</td>
                <td><input class="easyui-validatebox" type="text" name="age"
                           data-options="required:true,validType:'integer'"></input></td>
            </tr>
            <tr>
                <td>头像:</td>
                <td><input class="easyui-filebox" style="width:150px"></td>
            </tr>
            <tr>
                <td>部门:</td>
                <td>
                    <input id="department" class="easyui-combobox" name="department.id"
                           data-options="valueField:'id',textField:'name',url:'/department/getdept',panelHeight:'auto'" />
                </td>
            </tr>
        </table>
    </form>
</div>

<!-- form表单底部提交按钮 -->
<div id="submit">
    <a href="javascript:;" data-method="save" class="easyui-linkbutton" data-options="iconCls:'icon-ok',plain:true">提交</a>
    <a href="javascript:;" data-method="cancel" class="easyui-linkbutton" data-options="iconCls:'icon-cancel',plain:true">取消</a>
</div>


<!--菜单-->
<div id="mm" class="easyui-menu" style="width:120px;">
    <div>
        <span data-method="remove">删除</span>
    </div>
    <div>
        <span data-method="add">添加</span>
    </div>
</div>
</body>


</html>
