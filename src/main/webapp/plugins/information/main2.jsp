<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title></title>
    <link rel="stylesheet" type="text/css" href="/plugins/information/css/bootstrap-grid.min.css" /><!--CSS RESET-->
    <link rel="stylesheet" href="http://jrain.oscitas.netdna-cdn.com/tutorial/css/fontawesome-all.min.css">
    <link rel="stylesheet" type="text/css" href="/plugins/information/css/htmleaf-demo.css"><!--演示页面样式，使用时可以不引用-->
    <link rel="stylesheet" type="text/css" href="/plugins/information/css/shop.css">
    <script type="text/javascript" src="/js/easyui/jquery.min.js"></script>
    <script src="/plugins/shubiao/js/emojiCursor.js" type="text/javascript"></script>
</head>

<script type="text/javascript">
    $(function () {
        var $defalut = '';
        $.get("/employee/getall",function (data) {
            $.each(data.rows,function (index,value) {
                $defalut += `<div class="col-md-3 col-sm-6">
								 	<div class="product-grid">
								 		<div class="product-image">
											<a href="#">
												<img class="pic-1" src="/plugins/information/images/img-${"${value.id}"}.jpg">
												<img class="pic-2" src="/plugins/information/images/img-${"${value.id+1}"}.jpg">
											</a>
											<span class="product-trend-label">${"${value.department.name}"}</span>
											<ul class="social">
												<li><a href="#" data-tip="${"${value.name}"}"><i class="fas fa-search"></i></a></li>
											</ul>
											<div class="product-content">
												<h3 class="name"><a href="#">${"${value.username}"}</a></h3>
											</div>
	                       				 </div>
									</div>
							 </div>`;
            });
            $(".row").html($defalut);
        });


    });


</script>

<body>
<div class="htmleaf-container">
    <header class="htmleaf-header">
        <h1>商家信息 <span>Employee Information Style</span></h1>
    </header>
    <div class="demo">
        <div class="container">
            <div class="row">

            </div>
        </div>
    </div>
</div>
</body>
</html>
