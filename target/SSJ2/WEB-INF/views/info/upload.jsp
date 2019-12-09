<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/views/head/head.jsp"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="/employee/upload" method="post" enctype="multipart/form-data">
        <input class="easyui-filebox" name="empFile" style="width:80%"
               data-options="prompt:'选择一个文件...',buttonText: '选择文件'" />
        <button class="easyui-linkbutton">导入</button>
    </form>
</body>
</html>
