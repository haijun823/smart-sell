<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="ZH-CN">
<head>
    <meta charset="utf-8">
    <title>web RTC 测试</title>
</head>
<body>
<script type="text/javascript" src="/js/form/jquery.min.js"></script>
<script type="text/javascript" src="/js/utils/login.js"></script>
<div class="booth">
    <div id="face-box">
        <video id="video"></video>
        <canvas id="canvas" style="display: none;"></canvas>
        <button onclick="offUserMedia()">提交</button>
    </div>
</div>
</body>
</html>
