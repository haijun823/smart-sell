<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/WEB-INF/views/head/head.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <script type="text/javascript" src="/js/utils/roleutil.js"></script>
</head>
<body>


<div id="tools" style="padding:5px;height:auto">
    <div style="margin-bottom:5px">
        <a href="javascript:;" data-method="add" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true">添加</a>
        <a href="javascript:;" data-method="remove" class="easyui-linkbutton"
           data-options="iconCls:'icon-remove',plain:true">删除</a>
        <a href="javascript:;" data-method="update" class="easyui-linkbutton"
           data-options="iconCls:'icon-save',plain:true">修改</a>
    </div>
    <div>
        <form id="search-form">
            name:<input name="name" class="easyui-textbox" style="width:200px">
            sn:<input name="sn" class="easyui-textbox" style="width:200px">
            <a href="javascript:;" class="easyui-linkbutton" data-method="search" iconCls="icon-search">Search</a>
        </form>
    </div>
</div>

<!-- 员工展示 -->
<table id="information" class="easyui-datagrid"
       data-options="url:'/role/getall',
	                    fitColumns:true,
	                    singleSelect:true,
	                    pagination:true,
	                    fit:true,
	                    toolbar:'#tools'">
    <thead>
    <tr>
        <th data-options="field:'name',width:100,align:'center'">name</th>
        <th data-options="field:'sn',width:100,align:'center'">sn</th>
        <th data-options="field:'permissions',width:100,align:'center',formatter:persFettr">sn</th>
    </tr>
    </thead>
</table>


<!-- 弹出层，装form表单 -->
<div id="addform" class="easyui-dialog" title="添加/修改" style="width: 920px;height: 615px"
     data-options="iconCls:'icon-save',resizable:true,modal:true,closed:true,buttons:'#submit',constrain:true">
    <!-- form表单 -->
    <form id="editForm" method="post">
        <input type="hidden" name="id" id="editid">
        名称
        <input type="text" class="easyui-textbox" name="name">
        编号
        <input type="text" class="easyui-textbox" name="sn">
        <div class="easyui-layout" style="width:900px;height:500px;">
            <div data-options="region:'west',split:true" title="已有权限" style="width:50%;height: 100%">
                <table id="mypermission">
                    <thead>
                    <tr>
                        <th data-options="field:'name',width:100,align:'center'">权限名</th>
                        <th data-options="field:'url',width:100,align:'center'">url</th>
                        <th data-options="field:'sn',width:100,align:'center'">权限编号</th>
                    </tr>
                    </thead>
                </table>
            </div>
            <div data-options="region:'center',title:'添加权限',iconCls:'icon-ok'">
                <table id="permissionAll">
                    <thead>
                    <tr>
                        <th data-options="field:'name',width:100,align:'center'">权限名</th>
                        <th data-options="field:'url',width:100,align:'center'">url</th>
                        <th data-options="field:'sn',width:100,align:'center'">权限编号</th>
                    </tr>
                    </thead>
                </table>
            </div>
        </div>
    </form>
</div>

<!-- form表单底部提交按钮 -->
<div id="submit">
    <a href="javascript:;" data-method="save" class="easyui-linkbutton"
       data-options="iconCls:'icon-ok',plain:true">提交</a>
    <a href="javascript:;" data-method="cancel" class="easyui-linkbutton"
       data-options="iconCls:'icon-cancel',plain:true">取消</a>
</div>

</body>


</html>