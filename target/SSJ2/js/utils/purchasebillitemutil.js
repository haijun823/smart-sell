//添加，删除，修改
$(function () {
    var item = $("#items");
    item.datagrid({
        nowrap:false,
        fitColumns:true,
        singleSelect:true,
        fit:true,
        fixed:true,
        fitColumns:true,
        toolbar:'#tb',
        url:'/purchasebillitem/findAll',
        columns:[[
            {field:'id',title:'编号',width:100},
            {field:'supplier',title:'供应商',width:100},
            {field:'buyer',title:'采购员',width:100},
            {field:'product',title:'产品',width:100},
            {field:'productType',title:'产品类型',width:100},
            {field:'vdate',title:'日期',width:100},
            {field:'num',title:'数量',width:100},
            {field:'price',title:'单价',width:100},
            {field:'amount',title:'小计',width:100},
            {field:'status',title:'状态',width:100,formatter:function (action) {
                    var data = {
                        0:"<div style='color:red;'>待审</div>",
                        1:"<div style='color: green'>已审</div>",
                        "-1":"<div><s>作废</s></div>"
                    };
                    return data[action];
                }}
        ]],
        groupField:'groupField',
        view: groupview,
        groupFormatter:function(value, rows){
            console.debug(value);
            var totalNum = 0;
            var totalAmount = 0;
            for(var i=0;i<rows.length;i++){
                totalNum += rows[i].num;
                totalAmount += rows[i].amount;
            }
            return value + ' - ' + rows.length + ' 条数据' +"  <span style='color:green;'>共"+totalNum+"件商品</span>" +"<span style='color:#5d2f80;'>总金额:"+totalAmount+"</span>";
        }
    });

    $("[data-method]").on("click",function () {
        var $method = $(this).attr("data-method");
        //动态调用方法
        method[$method]();
    });

    var method={
        //查询的方法
        search:function () {
            //将表单转换成参数
            var params = $("#search-form").serializeObject();
            //重新请求，发送对应的查询参数
            item.datagrid('load',params);
        }
    }

});//添加，删除，修改