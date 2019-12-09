<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="/js/easyui/jquery.min.js"></script>
    <link rel="stylesheet" href="/plugins/bootstrap/bootstrap.min.css"/>
    <link rel="stylesheet" href="/plugins/bootstrap/bootstrap-theme.min.css"/>
    <script src="/plugins/bootstrap/bootstrap.js"></script>

</head>
<body>
<div class="page-header" id="tou">
    webSocket多终端聊天测试
</div>
<div class="well" id="msg" style="height: 200px;width: 450px;"></div>
<div class="col-lg">
    <div class="input-group" style="width: 450px">
        <input type="text" class="form-control" placeholder="发送信息..." id="message">
        <span class="input-group-btn">
                    <button class="btn btn-default" type="button" id="send" >发送</button>
                </span>
    </div>
</div>

</body>

<script type="text/javascript">
    $(function() {
        var websocket;
        var url = window.location.href;
        if('WebSocket' in window) {
            console.log("此浏览器支持websocket");
            websocket = new WebSocket("ws://172.16.10.233/websocket/msg");
        } else if('MozWebSocket' in window) {
            alert("此浏览器只支持MozWebSocket");
        } else {
            alert("此浏览器只支持SockJS");
        }
        websocket.onopen = function(evnt) {
            $("#tou").html("链接服务器成功!")
        };
        websocket.onmessage = function(evnt) {
            $("#msg").html($("#msg").html() + "<br/>" + evnt.data);
        };
        websocket.onerror = function(evnt) {};

        websocket.onclose = function(evnt) {
            $("#tou").html("与服务器断开了链接!")
        }

        $('#send').click(function(){
            send();
        });

        function send() {
            if(websocket != null) {
                var message = $("#message").val();
                websocket.send(message);
            } else {
                alert('未与服务器链接.');
            }
        }
    });
</script>

</html>
