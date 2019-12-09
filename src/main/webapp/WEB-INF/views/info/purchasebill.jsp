<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/WEB-INF/views/head/head.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <script type="text/javascript" src="/js/utils/purchasebillutil.js"></script>
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
            vdate:<input name="vdate" class="easyui-textbox" style="width:200px">
            totalamount:<input name="totalamount" class="easyui-textbox" style="width:200px">
            totalnum:<input name="totalnum" class="easyui-textbox" style="width:200px">
            inputtime:<input name="inputtime" class="easyui-textbox" style="width:200px">
            <input type="hidden" name="search" value="search">
            <a href="javascript:;" class="easyui-linkbutton" data-method="search" iconCls="icon-search">Search</a>
        </form>
    </div>
</div>

<!-- 员工展示 -->
<table id="information" class="easyui-datagrid"
       data-options="url:'/purchasebill/findAll',
	                    fitColumns:true,
	                    singleSelect:true,
	                    pagination:true,
	                    fit:true,
	                    toolbar:'#tools'">
    <thead>
    <tr>
        <th data-options="field:'vdate',width:100,align:'center'">vdate</th>
        <th data-options="field:'totalamount',width:100,align:'center'">总数量</th>
        <th data-options="field:'totalnum',width:100,align:'center'">总数</th>
        <th data-options="field:'inputtime',width:100,align:'center'">录入时间</th>
        <th data-options="field:'auditortime',width:100,align:'center'">审核时间</th>
        <th data-options="field:'status',width:100,align:'center'">状态</th>
        <th data-options="field:'supplier',width:100,align:'center'">供应商</th>
        <th data-options="field:'auditor',width:100,align:'center'">审核人</th>
        <th data-options="field:'inputUser',width:100,align:'center'">录入人</th>
        <th data-options="field:'buyer',width:100,align:'center'">采购人</th>
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
                <td>vdate:</td>
                <td><input class="easyui-validatebox" type="text"
                           name="vdate" data-options="required:true"></input></td>
            </tr>
            <tr>
                <td>totalamount:</td>
                <td><input class="easyui-validatebox" type="text"
                           name="totalamount" data-options="required:true"></input></td>
            </tr>
            <tr>
                <td>totalnum:</td>
                <td><input class="easyui-validatebox" type="text"
                           name="totalnum" data-options="required:true"></input></td>
            </tr>
            <tr>
                <td>inputtime:</td>
                <td><input class="easyui-validatebox" type="text"
                           name="inputtime" data-options="required:true"></input></td>
            </tr>
            <tr>
                <td>auditortime:</td>
                <td><input class="easyui-validatebox" type="text"
                           name="auditortime" data-options="required:true"></input></td>
            </tr>
            <tr>
                <td>status:</td>
                <td><input class="easyui-validatebox" type="text"
                           name="status" data-options="required:true"></input></td>
            </tr>
            <tr>
                <td>supplierId:</td>
                <td><input class="easyui-validatebox" type="text"
                           name="supplierId" data-options="required:true"></input></td>
            </tr>
            <tr>
                <td>auditorId:</td>
                <td><input class="easyui-validatebox" type="text"
                           name="auditorId" data-options="required:true"></input></td>
            </tr>
            <tr>
                <td>inputuserId:</td>
                <td><input class="easyui-validatebox" type="text"
                           name="inputuserId" data-options="required:true"></input></td>
            </tr>
            <tr>
                <td>buyerId:</td>
                <td><input class="easyui-validatebox" type="text"
                           name="buyerId" data-options="required:true"></input></td>
            </tr>
            <tr>
                <td>auditorid:</td>
                <td><input class="easyui-validatebox" type="text"
                           name="auditorid" data-options="required:true"></input></td>
            </tr>
            <tr>
                <td>buyerid:</td>
                <td><input class="easyui-validatebox" type="text"
                           name="buyerid" data-options="required:true"></input></td>
            </tr>
            <tr>
                <td>inputuserid:</td>
                <td><input class="easyui-validatebox" type="text"
                           name="inputuserid" data-options="required:true"></input></td>
            </tr>
            <tr>
                <td>supplierid:</td>
                <td><input class="easyui-validatebox" type="text"
                           name="supplierid" data-options="required:true"></input></td>
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