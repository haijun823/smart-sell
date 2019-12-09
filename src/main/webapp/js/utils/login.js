var video;
var canvas;
var context;
var mediaStreamTrack=null;

$(function () {
   video = document.getElementById("video");
   canvas  = document.getElementById("canvas");
   context  = canvas.getContext("2d");
    // openUserMedia();
});

function success(stream){
    //兼容webkit核心浏览器
    // var CompatibleURL = window.URL || window.webkitURL;
    //将视频流转化为video的源
    mediaStreamTrack=stream;
    try {
        // video.src = CompatibleURL.createObjectURL(stream);
        video.srcObject=stream;
    }catch (e) {
        console.log("访问用户媒体设备失败：",error.name,error.message);
    }
    video.play();//播放视频
    //将视频绘制到canvas上
}
//错误回调函数
function error(error) {
    console.log('访问用户媒体失败：',error.name,error.message);
}
function getUserMediaToPhoto(constraints,success,error) {
    if(navigator.mediaDevices.getUserMedia){
        //最新标准API
        navigator.mediaDevices.getUserMedia(constraints).then(success).catch(error);
    }else if (navigator.webkitGetUserMedia) {
        //webkit核心浏览器
        navigator.webkitGetUserMedia(constraints,success,error);
    }else if(navigator.mozGetUserMedia){
        //firefox浏览器
        navigator.mozGetUserMedia(constraints,success,error);
    }else if(navigator.getUserMedia){
        //旧版API
        navigator.getUserMedia(constraints,success,error);
    }
}

function getFace() {
    context.drawImage(video,0,0,300,150);
    this.img=canvas.toDataURL('image/jpg')
    //获取完整的base64编码
    this.img=img.split(',')[1];
    return this.img;
}
function openUserMedia() {
    if(navigator.mediaDevices.getUserMedia || navigator.webkitGetUserMedia || navigator.mozGetUserMedia || navigator.getUserMedia){
        getUserMediaToPhoto({
            video:{width:480,height:320,facingMode: "user"
            }},success,error);
    }else{
        alert('你的浏览器不支持访问用户媒体设备');
    }
}
function  offUserMedia() {
    if(mediaStreamTrack!=null){
        mediaStreamTrack.getTracks()[0].stop();
        Facelogin();
    }
}

function Facelogin() {
    setTimeout(function () {
        img = getFace();
        $.ajax({
            type:"post",
            url:"/login/faceCkecked",
            data:{
                "imgpath":img,
                "imgType":"BASE64"
            },
            success:function (data) {
                console.debug(res);
                var res = JSON.parse(data);
                if(res.error_msg == "SUCCESS"){
                    var score =res.result.user_list[0].score;
                    // 获得后台传来的数据，并且获得对比的分数
                    if(score){
                        if(score>70){
                            alert("对比成功");
                            window.location.href = "/main/index";
                        }else {
                            alert("对比失败");
                        }
                    }
                }else {
                    alert("对不起照片不合格");
                    openUserMedia();
                }
            },
            error:function () {
                alert("连接服务器失败")
            },
            async:true
        })
    },500);
}
