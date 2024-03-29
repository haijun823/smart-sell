<%--
  Created by IntelliJ IDEA.
  User: 14241
  Date: 2019/6/7
  Time: 17:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>源码物流校招</title>
    <link rel="stylesheet" href="/html/css/bootstrap-theme.min.css" />
    <!--引入bootstrap样式文档-->
    <link rel="stylesheet" href="/html/css/bootstrap.min.css" />

    <script type="text/javascript" src="/html/js/jquery.min.js"></script>
    <script type="text/javascript" src="/html/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="/html/css/commons.css" />
</head>

<body>
<!--导航条-->
<nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container">
        <!-- 导航上Logo和目录显示 -->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#index-navbar" aria-expanded="false">
                <span class="sr-only">导航目录</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="javascript:void(0);">源码物流校园招聘网</a>
        </div>

        <!-- 导航上其他按钮-->
        <div class="collapse navbar-collapse navbar-right" id="index-navbar">
            <ul class="nav navbar-nav">
                <li>
                    <a href="/html/index.html">首页</a>
                </li>
                <li>
                    <a href="/html/about.html">走进网站</a>
                </li>
                <li>
                    <a href="/html/talents.html">人才发展</a>
                </li>
                <li>
                    <a href="/html/join_us_info.html">职位列表</a>
                </li>
                <li>
                    <a href="/html/qa.html">Q&A</a>
                </li>
            </ul>
        </div>
        <!-- /.navbar-collapse -->
    </div>
    <!-- /.container-fluid -->
</nav>
<!--职位列表-->
<div class="container nav-next-element" style="border: 1px solid #dcdcdc;padding-top: 30px;padding-bottom: 30px;">
			<span>
				<img src="imgs/join_us_title.jpg" alt="">
			</span>
    <!--职位名称-->
    <div class="col-md-offset-1" style="padding-top: 30px;">
        <img src="imgs/join_us_icon.jpg" style="float: left;margin-right: 30px;" />
        <h3>软件开发工程师</h3>
    </div>
    <!--职位描述-->
    <div class="col-md-offset-1" style="padding-top: 36px;">
        <h4 style="float: left;margin-right: 30px;">职位描述：</h4>
        <p style="float: left;font-size: 12px;color: #575656;line-height: 40px;">
            1、负责软件产品研发项目的需求分析、设计开发、研发管理工作，承担核心代码的编写，保证软件产品按计划交付；<br/> 2、解决项目实施过程中的关键问题和技术难点；
            <br> 3、协助测试团队完成软件系统及模块的测试；
            <br> 4、完成公司安排的其他工作。
        </p>
        <div style="clear: both;"></div>
    </div>
    <!--任职要求-->
    <div class="col-md-offset-1" style="padding-top: 36px;">
        <h4 style="float: left;margin-right: 30px;">任职要求：</h4>
        <p style="float: left;font-size: 12px;color: #575656;line-height: 40px;">
            1、2018届应届统招本硕毕业生，计算机技术、软件工程等相关专业；
            <br>2、具有非常强的责任心，能够承担压力做事细心，参与独立系统的设计、开发、维护工作；
            <br> 3、熟练掌握Java语法，了解JVM基本原理；
            <br> 4、了解Javascript，Html，Css，能独立完成简单前端功能开发；
            <br> 5、了解关系型数据库结构，熟悉sql语法，能熟练使用SQL语句完成增删改查和复杂报表功能；
            <br> 6、掌握基本的数据结构，了解算法设计的基本思路；
            <br> 7、使用过Maven, Spring MVC，Mybatis, Bootstrap框架的优先；<br> 8、思维清晰，逻辑清楚，执行力强；认真细致，踏实勤奋，具有较好的团队协作精神和沟通能力。
        </p>
        <div style="clear: both;"></div>
    </div>
</div>
<!--底部-->
<div class="container-fluid footer-common">
    <p>
        <a href="index.html" class="out-border-left">招聘首页</a>
        <a href="about.html" class="out-border-left">走进网站</a>
        <a href="talents.html" class="out-border-left">人才发展</a>
        <a href="join_us_info.html" class="out-border-left">职位列表</a>
        <a href="qa.html" class="out-border-left">Q&A</a>
    </p>
    <p>企业邮箱：test@test688.com </p>
    <p>电话热线：4000-888-888 传真：020-3333-3333</p>
    <p>公司地址:四川省成都市高新区府城大道西段399号天府新谷1号楼6F</p>
    <p>青年网版权所有 Copyright © 2018 jobs.digitalchina.ourats.com All rights reserved.蜀ICP备18080118号-1</p>
</div>
</body>
</html>
