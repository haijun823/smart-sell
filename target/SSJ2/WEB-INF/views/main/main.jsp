<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%@include file="/WEB-INF/views/head/head.jsp" %>
<html>
<head>
    <title>后台管理</title>

    <link rel="stylesheet" type="text/css" href="/plugins/kefu/css/normalize.css" />
    <link rel="stylesheet" type="text/css" href="/plugins/kefu/css/htmleaf-demo.css">
    <link href="/plugins/kefu/css/style.css" rel="stylesheet" type="text/css" />
    <script type="text/javascript" src="/js/utils/main.js"></script>
</head>
<body>
    <div class="easyui-layout" data-options="fit:true">
        <div data-options="region:'north'" class="north">
            <div class="logo" style="background-color: #393D49;height: 100px">
                <span class="logoText" style="color: white;font-size: 20px">青年找后台管理系统</span>
                <div class="loginUser" style="text-align: right;background-color: #393D49;">
                    <span style="color: white">欢迎<shiro:principal property="username"/>登录系统</span>
                    <a href="/login/cookielogout" style="color: red">注销</a>
                </div>
            </div>
        </div>
        <div data-options="region:'west'" title="菜单" style="width:140px;">
            <ul id="menu"></ul>;
        </div>
        <div data-options="region:'center'">
            <div id="tt" class="easyui-tabs" data-options="fit:true,border:false">
                <div title="主页" style="padding:10px">
                    <iframe src="/plugins/information/main2.jsp" style="width: 100%;height: 100%"></iframe>
                </div>
            </div>
        </div>
        //右键菜单
        <div id="mm" class="easyui-menu" style="">
            <div data-options="iconCls:'icon-cancel'" id="closecur">
                关闭
            </div>
            <div id="closeall">
                关闭全部
            </div>
        </div>
    </div>
    <%--客服--%>
    <div id="rightArrow"><a href="javascript:;" title="在线客户"></a></div>
    <div id="floatDivBoxs">
        <div class="floatDtt">在线客服</div>
        <div class="floatShadow">
            <ul class="floatDqq">
                <li style="padding-left:0px;"><a target="_blank" href="tencent://message/?uin=1425275978&Site=sc.chinaz.com&Menu=yes"><img src="/plugins/kefu/images/qq.png" align="absmiddle">&nbsp;&nbsp;在线客服1号</a></li>
                <li style="padding-left:0px;"><a href="javascript:void(0)" onclick="talk()"><img src="/plugins/kefu/images/qq.png" align="absmiddle">&nbsp;&nbsp;聊天室</a></li>
                <li style="padding-left:0px;"><a target="_blank" href="tencent://message/?uin=1234567890&Site=sc.chinaz.com&Menu=yes"><img src="/plugins/kefu/images/qq.png" align="absmiddle">&nbsp;&nbsp;在线客服3号</a></li>
            </ul>
            <div class="floatDtxt">热线电话</div>
            <div class="floatDtel"><img src="/plugins/kefu/images/online_phone.jpg" width="155" height="45" alt=""></div>
            <div style="text-align:center;padding:10PX 0 5px 0;background:#EBEBEB;"><img src="/plugins/kefu/images/wap_ico.jpg"><br>微信公众账号</div>
        </div>
        <div class="floatDbg"></div>
    </div>

    <script>window.jQuery || document.write('<script src="/js/easyui/jquery.min.js"><\/script>')</script>
    <script type="text/javascript">
        var flag=1;
        $('#rightArrow').click(function(){
            if(flag==1){
                $("#floatDivBoxs").animate({right: '-175px'},300);
                $(this).animate({right: '-5px'},300);
                $(this).css('background-position','-50px 0');
                flag=0;
            }else{
                $("#floatDivBoxs").animate({right: '0'},300);
                $(this).animate({right: '170px'},300);
                $(this).css('background-position','0px 0');
                flag=1;
            }
        });
    </script>


</body>
</html>
