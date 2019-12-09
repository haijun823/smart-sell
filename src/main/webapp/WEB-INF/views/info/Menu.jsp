<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/WEB-INF/views/head/head.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <script type="text/javascript" src="/js/utils/menuutil.js"></script>
</head>
<body>

                                            
                                        
                                        
                                        
                                        
                

<div id="tools" style="padding:5px;height:auto">
    <div style="margin-bottom:5px">
        <a href="javascript:;" data-method="add" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true">添加</a>
        <a href="javascript:;" data-method="remove" class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:true">删除</a>
        <a href="javascript:;" data-method="update" class="easyui-linkbutton"  data-options="iconCls:'icon-save',plain:true">修改</a>
    </div>
    <div>
        <form id="search-form">
                                    name:<input name="name" class="easyui-textbox"  style="width:200px">
                                    url:<input name="url" class="easyui-textbox"  style="width:200px">
                                    icon:<input name="icon" class="easyui-textbox"  style="width:200px">
                                    parentId:<input name="parentId" class="easyui-textbox"  style="width:200px">
                                    href:<input name="href" class="easyui-textbox"  style="width:200px">
                        <input type="hidden" name="search" value="search">
            <a href="javascript:;" class="easyui-linkbutton" data-method="search" iconCls="icon-search">Search</a>
        </form>
    </div>
</div>

<!-- 员工展示 -->
<table id="information" class="easyui-datagrid"
       data-options="url:'/menu/getall',
	                    fitColumns:true,
	                    singleSelect:true,
	                    pagination:true,
	                    fit:true,
	                    toolbar:'#tools'">
    <thead>
    <tr>
                                <th data-options="field:'name',width:100,align:'center'">name</th>
                                <th data-options="field:'url',width:100,align:'center'">url</th>
                                <th data-options="field:'icon',width:100,align:'center'">icon</th>
                                <th data-options="field:'parentId',width:100,align:'center'">parentId</th>
                                <th data-options="field:'href',width:100,align:'center'">href</th>
            </tr>
    </thead>
</table>


<!-- 弹出层，装form表单 -->
<div id="addform" class="easyui-dialog" title="添加/修改" style="width: 260px;height: 200px"
     data-options="iconCls:'icon-save',resizable:true,modal:true,closed:true,buttons:'#submit',constrain:true">
    <!-- form表单 -->
    <form id="editForm" method="post">
        <input type="hidden" name="id" id="editid">
        <table cellpadding="5">
                                                         <tr>
                    <td>name:</td>
                    <td><input class="easyui-validatebox" type="text"
                           name="name" data-options="required:true"></input></td>
                    </tr>
                                                         <tr>
                    <td>url:</td>
                    <td><input class="easyui-validatebox" type="text"
                           name="url" data-options="required:true"></input></td>
                    </tr>
                                                         <tr>
                    <td>icon:</td>
                    <td><input class="easyui-validatebox" type="text"
                           name="icon" data-options="required:true"></input></td>
                    </tr>
                                                         <tr>
                    <td>parentId:</td>
                    <td><input class="easyui-validatebox" type="text"
                           name="parentId" data-options="required:true"></input></td>
                    </tr>
                                                         <tr>
                    <td>href:</td>
                    <td><input class="easyui-validatebox" type="text"
                           name="href" data-options="required:true"></input></td>
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
        <span>升序</span>
        <div  name="ASC" style="width:150px;">
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