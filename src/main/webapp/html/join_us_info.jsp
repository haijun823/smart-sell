<%--
  Created by IntelliJ IDEA.
  User: 14241
  Date: 2019/6/7
  Time: 17:32
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
                    <a href="html/index.jsp">首页</a>
                </li>
                <li>
                    <a href="html/about.html">走进网站</a>
                </li>
                <li>
                    <a href="html/talents.html">人才发展</a>
                </li>
                <li>
                    <a href="html/javascript:void(0);">职位列表</a>
                </li>
                <li>
                    <a href="html/qa.html">Q&A</a>
                </li>
            </ul>
        </div>
        <!-- /.navbar-collapse -->
    </div>
    <!-- /.container-fluid -->
</nav>
<!--职位搜索-->
<div class="container" style="border: 1px solid #dcdcdc;padding-top: 30px;padding-bottom: 30px;margin-top: 60px;">
			<span>
				<img src="imgs/join_us_search.jpg" alt="">
			</span>
    <div class="row" style="padding-top: 30px;">
        <form class="form-inline">
            <div class="form-group col-md-3">
                <label for="jobTitle">职位名称</label>
                <input type="text" class="form-control" name="title" id="jobTitle" placeholder="职位名称">
            </div>
            <div class="form-group col-md-3" style="padding-top: 5px;">
                <label for="workingTime">工作时间:</label>
                <label class="radio-inline">
                    <input type="radio" name="positiontype" value="-1" checked="checked"> 全部
                </label>
                <label class="radio-inline">
                    <input type="radio" name="positiontype" value="1"> 全职
                </label>
                <label class="radio-inline">
                    <input type="radio" name="positiontype" value="0"> 兼职
                </label>
            </div>
            <button id="submit" type="button" class="btn btn-default">搜索职位</button>
        </form>
    </div>
</div>
<!--职位列表-->
<div class="container job-table">
			<span>
				<img src="imgs/index_title_zw.jpg" alt="">
				<img src="imgs/index_title_more.jpg" alt="">
			</span>
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
    <a href="" class="out-border-left">源码时代官网</a>
    <a href="" class="out-border-left">BootStrap官网</a>
</div>
<!--底部-->
<div class="container-fluid footer-common">
    <p>
        <a href="javascript:void(0);" class="out-border-left">招聘首页</a>
        <a href="about.html" class="out-border-left">走进网站</a>
        <a href="talents.html" class="out-border-left">人才发展</a>
        <a href="join_us_info.html" class="out-border-left">职位列表</a>
        <a href="qa.html" class="out-border-left">Q&A</a>
    </p>
    <p>企业邮箱：test@test688.com </p>
    <p>电话热线：4000-888-888 传真：020-3333-3333</p>
    <p>公司地址:四川省成都市高新区府城大道西段399号天府新谷1号楼6F</p>
    <p>源码物流版权所有 Copyright © 2018 jobs.digitalchina.ourats.com All rights reserved.蜀ICP备18080118号-1</p>
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

        $("#submit").on("click",function () {
            var p =$("form").serialize();
            $.post("/job/findAll",p,function (res) {
                var data=`<tr>
                            <td>职位</td>
                            <td>地址</td>
                            <td>职位数量</td>
                            <td>薪资</td>
                            <td>职位性质</td>
                            <td>职位描述</td>
                            <td>要求</td>
                        </tr>`;
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
                $("#mytable").html(data);
            })
        });

    });


</script>

</html>
