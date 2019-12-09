<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/WEB-INF/views/head/head.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <script type="text/javascript" src="/js/utils/productutil.js"></script>
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
            color:<input name="color" class="easyui-textbox" style="width:200px">
            <input type="hidden" name="search" value="search">
            <a href="javascript:;" class="easyui-linkbutton" data-method="search" iconCls="icon-search">Search</a>
        </form>
    </div>
</div>

<!-- 员工展示 -->
<table id="information" class="easyui-datagrid"
       data-options="url:'/product/getall',
	                    fitColumns:true,
	                    singleSelect:true,
	                    pagination:true,
	                    fit:true,
	                    toolbar:'#tools'">
    <thead>
    <tr>
        <th data-options="field:'name',width:100,align:'center'">name</th>
        <th data-options="field:'color',width:100,align:'center',formatter:blockmatter">color</th>
        <th data-options="field:'smallpic',width:100,align:'center',formatter:img">smallpic</th>
        <th data-options="field:'costprice',width:100,align:'center'">costprice</th>
        <th data-options="field:'saleprice',width:100,align:'center'">saleprice</th>
        <th data-options="field:'typesId',width:100,align:'center',formatter:producttype">typesId</th>
        <th data-options="field:'unitId',width:100,align:'center',formatter:unit">unitId</th>
        <th data-options="field:'brandId',width:100,align:'center',formatter:brand">brandId</th>
    </tr>
    </thead>
</table>


<!-- 弹出层，装form表单 -->
<div id="addform" class="easyui-dialog" title="添加/修改" style="width: 500px;height: 500px"
     data-options="iconCls:'icon-save',resizable:true,modal:true,closed:true,buttons:'#submit',constrain:true">
    <!-- form表单 -->
    <form id="editForm" method="post" enctype="multipart/form-data">
        <input type="hidden" name="id" id="editid">
        <table cellpadding="5">
            <tr>
                <td>名字:</td>
                <td><input class="easyui-validatebox" type="text"
                           name="name" data-options="required:true"></input></td>
            </tr>
            <tr>
                <td>颜色:</td>
                <td><input class="easyui-validatebox" type="color"
                           name="color" data-options="required:true"></input></td>
            </tr>
            <tr>
                <td easy-hiden="hiden">图片:</td>
                <td>
                    <img id="recoverImg" easy-hiden="hiden" src="" alt="无图片" style="height: 90px;width: 70px">
                </td>
            </tr>
            <tr>
                <td>修改:</td>
                <td>
                    <input class="easyui-filebox" name="fileImage">
                </td>
            </tr>
            <tr>
                <td>成本价:</td>
                <td><input class="easyui-validatebox" type="text"
                           name="costprice" data-options="required:true"></input></td>
            </tr>
            <tr>
                <td>销售价:</td>
                <td><input class="easyui-validatebox" type="text"
                           name="saleprice" data-options="required:true"></input></td>
            </tr>
            <tr>
                <td>类型:</td>
                <td><%--<input id="type" class="easyui-combobox" name="typesId.id"
                           data-options="valueField:'id',panelHeight:'auto',textField:'name',url:'/producttype/getall'" />--%>
                    <input class="easyui-combobox" name="typesId.id"
                           data-options="
                                        panelHeight:'auto',
                                        url: '/producttype/getchildren',
                                        method: 'get',
                                        valueField:'id',
                                        textField:'name',
                                        groupField:'group'
                                    ">
                </td>
            </tr>
            <tr>
                <td>单位:</td>
                <td><input id="unit" class="easyui-combobox" name="unitId.id"
                           data-options="valueField:'id',panelHeight:'auto',textField:'name',url:'/systemdictionarydetail/getunit'"/>
                </td>
            </tr>
            <tr>
                <td>品牌:</td>
                <td><input id="brand" class="easyui-combobox" name="brandId.id"
                           data-options="valueField:'id',panelHeight:'auto',textField:'name',url:'/systemdictionarydetail/getbrand'"/>
                </td>
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


</body>


</html>