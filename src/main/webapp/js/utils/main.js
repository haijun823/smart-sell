$(function(){
    //加载树组件
    $("#menu").tree({
        "url":"/main/menus",
        "animate":true,
        "lines":true,
        "datatype":"json",
        "onClick": function(node){
            if(node.url){
                //判断tab选项卡是否存在
                if($("#tt").tabs("exists",node.text)){//如果存在，直接选中该选项卡
                    $("#tt").tabs("select", node.text);//选中选项卡
                }else{//如果选项卡不存在，则添加选项卡
                    //动态添加选项卡
                    $('#tt').tabs('add',{
                        title: node.text,
                        content: "<iframe src='"+node.url+"' frameborder='0' width='100%' height='100%' />",
                        closable: true
                    });
                }
            }

        }
    })
    //给选项卡添加事件
    $("#tt").tabs({
        onContextMenu:function (e,title,index) {
            document.body.oncontextmenu = function (e) {
                e.preventDefault();
                $('#mm').menu('show', {
                    left: e.pageX,
                    top: e.pageY
                });
            }
            //关闭当前选项卡
            $("#closecur").on("click",function () {
                $('#tt').tabs('close',index);
            });
            //关闭所有
            $("#closeall").on("click",function () {
                var t =  $('#tt').tabs('tabs');
                var len = t.length;
                for(var i=len-1;i>=0;i--){
                    if(i != 0){
                        $('#tt').tabs('close',i);
                    }
                }
            });
            //关闭其它
            $("#closeother").on("click",function () {
                var t =  $('#tt').tabs('tabs');
                var len = t.length;
                for(var i=len-1;i>index;i--){
                    $('#tt').tabs('close',i);
                }
                var num = index-1;
                for(var i=num;i>0;i--){
                    $('#tt').tabs('close',i);
                }
            });
        }
    });

});

function talk() {
    layui.use('layer',function () {
        var layer = layui.layer;
        layer.open({
            type:2,
            title:"聊天室",
            content:"/main/talk",
            area:['500px','400px'],
            offset:['100px','500px'],
        });
    });
}


