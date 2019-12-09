<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/WEB-INF/views/head/head.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <script type="text/javascript" src="/js/utils/purchasebillitemutil.js"></script>
    <script type="text/javascript" src="/js/easyui/plugins/datagrid-groupview.js"></script>
</head>
<body>
<table id="items"></table>
<div id="tb" style="padding:5px;height:auto">
    <form id="search-form">
        <div>
            日期: <input name="beginDate" class="easyui-datebox" style="width:150px">
            To: <input name="endDate" class="easyui-datebox" style="width:150px">
            状态:
            <select name="status" class="easyui-combobox" panelHeight="auto" style="width:100px">
                <option value="">请选择</option>
                <option value="1">已审</option>
                <option value="0">待审</option>
                <option value="-1">作废</option>
            </select>
            分组:
            <select name="groupBy" class="easyui-combobox" panelHeight="auto" style="width:100px">
                <option value="o.bill.supplier.name">供应商</option>
                <option value="o.bill.buyer.username">采购员</option>
                <option value="month(o.bill.vdate)">时间</option>
            </select>
            <a href="#" data-method="search" class="easyui-linkbutton" iconCls="icon-search">Search</a>
        </div>
    </form>
</div>
</body>


</html>