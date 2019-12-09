<%--
  Created by IntelliJ IDEA.
  User: 14241
  Date: 2019/6/7
  Time: 17:19
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
    <style>
        /*
         * 轮播图
         */
        #index-carousel {
            height: 600px;
        }
    </style>
    <link rel="stylesheet" href="/html/css/commons.css"  />
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
            <a class="navbar-brand" href="javascript:void(0);">青年招聘网</a>
        </div>

        <!-- 导航上其他按钮-->
        <div class="collapse navbar-collapse navbar-right" id="index-navbar">
            <ul class="nav navbar-nav">
                <li>
                    <a href="javascript:void(0);">首页</a>
                </li>
                <li>
                    <a href="/html/talents.html">人才发展</a>
                </li>
                <li>
                    <a href="/html/join_us_info.jsp">职位列表</a>
                </li>
                <li>
                    <a href="/html/qa.html">Q&A</a>
                </li>
            </ul>
        </div>
    </div>
</nav>
<!--轮播图-->
<div class="container-fluid">
    <div id="index-carousel" class="carousel slide" data-ride="carousel">
        <!-- 图片上的小圆点 -->
        <ol class="carousel-indicators">
            <li data-target="#index-carousel" data-slide-to="0" class="active"></li>
            <li data-target="#index-carousel" data-slide-to="1"></li>
            <li data-target="#index-carousel" data-slide-to="2"></li>
        </ol>
        <!-- 轮播 -->
        <div class="carousel-inner" role="listbox">
            <div class="item active">
                <img src="/images/img-1.jpg" style="height: 500px;" alt="码农">
                <div class="carousel-caption">
                    这是一个码农的故事
                </div>
            </div>
            <div class="item">
                <img src="/images/img-5.jpg" style="height: 500px;" alt="码农">
                <div class="carousel-caption">
                    这是一个码农的故事
                </div>
            </div>
            <div class="item">
                <img src="/images/img-3.jpg" style="height: 500px;" alt="码农">
                <div class="carousel-caption">
                    这是一个码农的故事
                </div>
            </div>
        </div>

        <!-- 图片点击 -->
        <a class="left carousel-control" href="#index-carousel" role="button" data-slide="prev">
            <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
            <span class="sr-only">Previous</span>
        </a>
        <a class="right carousel-control" href="#index-carousel" role="button" data-slide="next">
            <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
            <span class="sr-only">Next</span>
        </a>
    </div>
</div>
<!--职位列表-->
<div class="container job-table">
			<span>
				<img src="imgs/index_title_zw.jpg" alt="">
				<img src="imgs/index_title_more.jpg" alt="">
			</span>
    <!--数据表格-->
    <table id="mytable" class="table table-hover">
        <tr>
            <td>职位</td>
            <td>地址</td>
            <td>职位数量</td>
            <td>薪资</td>
            <td>职位性质</td>
            <td>职位描述</td>
            <td>要求</td>
        </tr>
    </table>
    <!--分页-->
    <nav class="navbar-right">
        <ul class="pagination" id="paging">
            <li>
                <span>当前第1页</span>
            </li>
            <li>
                <a href="#">
                    <span aria-hidden="true">首页</span>
                </a>
            </li>
            <li>
                <a href="#" aria-label="上一页">
                    <span aria-hidden="true">上一页</span>
                </a>
            </li>
            <li>

            </li>
            <li>
                <a href="#" aria-label="下一页">
                    <span aria-hidden="true">下一页</span>
                </a>
            </li>
            <li>
                <a href="#" aria-label="尾页">
                    <span aria-hidden="true">尾页</span>
                </a>
            </li>
            <li>
                <span>总页数：共10页</span>
                <span>总数据：共50条</span>
            </li>
        </ul>
    </nav>
</div>
<!--友情链接  手机端的时候，就隐藏掉-->
<div class="container hidden-xs hidden-sm" id="footer-link">
    <img src="imgs/index_link_img.jpg" alt="" class="out-border-left">
    <a href="" class="out-border-left">青年找官网</a>
</div>
<!--底部-->
<div class="container-fluid footer-common">
    <p>
        <a href="javascript:void(0);" class="out-border-left">招聘首页</a>
        <a href="about.html" class="out-border-left">走进青年找</a>
        <a href="talents.html" class="out-border-left">人才发展</a>
        <a href="join_us_info.html" class="out-border-left">职位列表</a>
        <a href="qa.html" class="out-border-left">Q&A</a>
    </p>
    <p>企业邮箱：test@test688.com </p>
    <p>电话热线：4000-888-888 传真：020-3333-3333</p>
    <p>公司地址:四川省成都市高新区府城大道西段399号天府新谷1号楼6F</p>
    <p>青年版权所有 Copyright © 2018 jobs.digitalchina.ourats.com All rights reserved.蜀ICP备18080118号-1</p>
</div>
</body>



<script type="text/javascript">
    $(function () {
        $.get("/job/findAll",function (res) {
            var data='';
            $.each(res.rows,function (index,value) {
                if (value.positiontype == true){
                    value["type"] = "全职";
                }else {
                    value["type"] = "兼职";
                }
                data += `<tr>
					<td>${"${value.title}"}</td>
					<td>${"${value.address}"}</td>
					<td>${"${value.jobnum}"}</td>
					<td>${"${value.treatment}"}</td>
					<td>${"${value.type}"}</td>
					<td>${"${value.describes}"}</td>
					<td>${"${value.requires}"}</td>
				</tr>`
            });
            $("#mytable").append(data);
        });
    });
</script>
</html>
