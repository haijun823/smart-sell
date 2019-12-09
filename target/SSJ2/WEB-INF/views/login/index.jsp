<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8"/>
    <title>后台登录</title>
    <meta name="author" content="DeathGhost"/>
    <link rel="stylesheet" type="text/css" href="/css/style.css"/>
    <style>
        body {
            height: 100%;
            background: #16a085;
            overflow: hidden;
        }

        canvas {
            z-index: -1;
            position: absolute;
        }
    </style>
    <script type="text/javascript" src="/js/easyui/jquery.min.js"></script>
    <script src="/js/form/verificationNumbers.js"></script>
    <script src="/js/form/Particleground.js"></script>
    <script type="text/javascript" src="/js/utils/login.js"></script>
    <script type="text/javascript" src="/js/layui/layui.js"></script>
    <script>
        $(document).ready(function () {
            //粒子背景特效
            $('body').particleground({
                dotColor: '#5cbdaa',
                lineColor: '#5cbdaa'
            });
            //验证码
            createCode();
            window.onkeydown = function (envet) {
                if (event.keyCode == 13) {
                    if (validate()){
                        submitForm();
                    }
                }
            };

        });
        function submitForm() {
            console.debug(validate())
            if (validate()) {
                $.post("/login/login", $("form").serialize(), function (data) {
                    if (data.success == "succuss") {
                        window.location.href = "/main/index";
                    } else {
                        alert(data.msg);
                    }
                });
            }
        }
        function showface() {
            layui.use('layer',function () {
                openUserMedia();
                var layer = layui.layer;
                layer.open({
                    type:1,
                    content:$("#face-box"),
                    area:['500px','350px'],
                    offset:['100px','500px'],
                    btn:['识别','取消'],
                    yes:function () {
                        offUserMedia();
                    }
                });
            });
        }
    </script>
</head>
<body>
<dl class="admin_login">
    <dt>
        <strong>青年找后台管理系统</strong>
        <em>Management System</em>
    </dt>
    <form>
        <dd class="user_icon">
            <input name="username" type="text" required placeholder="账号" class="login_txtbx"/>
        </dd>
        <dd class="pwd_icon">
            <input name="password" type="password" required placeholder="密码" class="login_txtbx"/>
        </dd>
        <dd class="val_icon">
            <div class="checkcode">
                <input type="text" id="J_codetext" required placeholder="验证码" maxlength="4" class="login_txtbx">
                <canvas class="J_codeimg" id="myCanvas" onclick="createCode()">对不起，您的浏览器不支持canvas，请下载最新版浏览器!</canvas>
            </div>
            <input type="button" value="验证码核验" class="ver_btn" onClick="validate();">
        </dd>
        <dd>
            记住密码:<input type="checkbox" name="isRemember" value="y">
        </dd>
    </form>
    <dd>
        <input type="submit" value="立即登陆" class="submit_btn" onclick="submitForm()"/>
    </dd>
    <a href="javascript:showface()">人脸识别</a>
    <a href="/login/faceRegist">人脸注册</a>

    <div id="face-box">
        <video id="video"></video>
        <canvas id="canvas" style="display: none;"></canvas>
    </div>

</dl>
</body>
</html>
