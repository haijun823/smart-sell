<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/WEB-INF/views/head/head.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <script type="text/javascript" src="/js/utils/jobutil.js"></script>
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
</div>

<!-- 员工展示 -->
<table id="information" class="easyui-datagrid"
       data-options="url:'/job/findAll',
	                    fitColumns:true,
	                    singleSelect:true,
	                    pagination:true,
	                    fit:true,
	                    toolbar:'#tools'">
    <thead>
    <tr>
        <th data-options="field:'title',width:100,align:'center'">title</th>
        <th data-options="field:'address',width:100,align:'center'">address</th>
        <th data-options="field:'jobnum',width:100,align:'center'">jobnum</th>
        <th data-options="field:'treatment',width:100,align:'center'">treatment</th>
        <th data-options="field:'describes',width:100,align:'center'">describes</th>
        <th data-options="field:'requires',width:100,align:'center'">requires</th>
        <th data-options="field:'positiontype',width:100,align:'center'">positiontype</th>
    </tr>
    </thead>
</table>


<!-- 弹出层，装form表单 -->
<div id="addform" class="easyui-dialog" title="添加/修改" style="width: 500px;height: 400px"
     data-options="iconCls:'icon-save',resizable:true,modal:true,closed:true,buttons:'#submit',constrain:true">
    <!-- form表单 -->
    <form id="editForm" method="post">
        <input type="hidden" name="id" id="editid">
        <table cellpadding="5">
            <tr>
                <td>title:</td>
                <td><input class="easyui-validatebox" type="text"
                           name="title" data-options="required:true"></input></td>
            </tr>
            <tr>
                <td>address:</td>
                <td><input class="easyui-validatebox" type="text"
                           name="address"></input></td>
            </tr>
            <tr>
                <td>jobnum:</td>
                <td><input class="easyui-validatebox" type="text"
                           name="jobnum"></input></td>
            </tr>
            <tr>
                <td>treatment:</td>
                <td><input class="easyui-validatebox" type="text"
                           name="treatment"></input></td>
            </tr>
            <tr>
                <td>describes:</td>
                <td><input class="easyui-validatebox" type="text"
                           name="describes"></input></td>
            </tr>
            <tr>
                <td>requires:</td>
                <td><input class="easyui-validatebox" type="text"
                           name="requires"></input></td>
            </tr>
            <tr>
                <td>positiontype:</td>
                <td><input class="easyui-validatebox" type="text"
                           name="positiontype"></input></td>
            </tr>
        </table>
    </form>
</div>

<!-- form表单底部提交按钮 -->
<div id="submit">
    <a href="javascript:;" data-method="save" class="easyui-linkbutton"
       data-options="iconCls:'icon-ok',plain:true">提交</a>
    <a href="javascript:;" data-method="cancel" class="easyui-linkbutton"
       data-options="iconCls:'icon-cancel',plain:true">取消</a>
</div>

<!--菜单-->
<div id="mm" class="easyui-menu" style="width:120px;">
    <div>
        <span>升序</span>
        <div name="ASC" style="width:150px;">
            <div>id</div>
            <div>年纪</div>
        </div>
    </div>
    <div>
        <span name="DESC">降序</span>
        <div style="width:150px;">
            <div>id</div>
            <div>年纪</div>
        </div>
    </div>
    <div>Exit</div>
</div>
</body>


</html>