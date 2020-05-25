// JavaScript Document
var countdown=60;
function settime(val) {
    if (countdown == 0) {
        val.removeAttribute("disabled");
        val.text="获取到短信验证码";
        countdown =60;
    } else {
        val.setAttribute("disabled", true);
        val.text=countdown+"秒后可重新发送";
        countdown--;
        setTimeout(function() {
            settime(val)
        },1000)
    }

}
$(function(){
    $(".tipTimer").trigger("click");
})

$(document).ready(function () {
    var height=$(document).height();
    $('.main').css('height',height);
})

function changeImg(){
    //获取当前时间作为种子
    var time = Date.now().toString();
    //每次点击后
    $("#validateCode").attr("src","getValidateCode.action?id="+time);

}

//在点击提交按钮的时候需要执行的检查
function checkLogin(){
    //如果用户名输入为空
    if($("#username").val() == undefined || $("#username").val().toString().trim()=="") {
        alert("请输入用户名");
        return false;
    }
    //如果密码输入为空
    if($("#password").val() == undefined || $("#password").val().toString().trim()=="") {
        alert("请输入密码");
        return false;
    }
    //如果验证码输入为空时进行提交
    if($("#inputCode").val() == undefined || $("#inputCode").val().toString().trim()=="") {
        alert("请输入验证码");
        return false;
    }
    //检查是否进行角色的选择
    // alert($("input:radio:checked").val() === undefined);
    if($("input:radio:checked").val() == undefined){
        alert("请选择角色");
        return false;
    }
    //通过Ajax进行异步验证验证码的正确性
    var flag;
    flag = checkCode(flag);
    // alert(flag);
    if(flag == true){//标志位为真，证明验证码输入正确
        return true;
    }else {//标志位为假，证明验证码输入不正确，或者请求失败，都不能提交表单
        return false;
    }
}

//在注册的时候进行验证码的检查
function checkReg(){
    //如果用户名为空进行提交
    if($("#username").val() == undefined || $("#username").val().toString().trim()=="") {
        alert("请输入邮箱");
        return false;
    }
    //如果验证码为空进行提交
    if($("#inputCode").val() == undefined || $("#inputCode").val().toString().trim()=="") {
        alert("请输入验证码");
        return false;
    }
    //检查是否同意协议
    if($("#xieyi:checked").val()==undefined){
        alert("请先同意协议");
        return false;
    }
    //通过Ajax进行异步验证验证码的正确性
    var flag;
    flag = checkCode(flag);
    // if(flag == true){//标志位为真，证明验证码输入正确
    //     return true;
    // }else {//标志位为假，证明验证码输入不正确，或者请求失败，都不能提交表单
    //     return false;
    // }
    return flag;
}

//检查邮箱的格式是否正确
function checkEmail() {
    var email = $("#username").val();
    var flag=false;//定义标志位，来记录邮箱验证是否成功，然后再根据标志位进行返回值的判定
    if(email != "") {
        var reg = /^\w+((-\w+)|(\.\w+))*\@[A-Za-z0-9]+((\.|-)[A-Za-z0-9]+)*\.[A-Za-z0-9]+$/;
        //调用正则验证test()函数
        isok= reg.test(email);
        if(!isok) {//如果邮箱格式不正确
            // alert(isok);
            $("#emailMess").text("邮箱格式不正确!");
            return false;
        }

        //把数据封装成json字符串
        var saveData = JSON.stringify({"email":email});
        // alert("saveData:"+saveData);
        $.ajax({
            url:"checkEmail.action",
            type:"post",
            dataType:"json",
            contentType : "application/json;charset=utf-8",
            data:saveData,
            async:false,
            success:function(data){
                alert(data.emailMess);
                if(data.emailMess=="0"){
                    $("#emailMess").text("该邮箱已经被注册过，请重新输入");
                    flag = false;
                }else {
                    $("#emailMess").empty();
                    flag = true;
                }
            },
            error:function () {
                alert("网络有问题，请刷新后重试！");
            }
        });
    }
    return flag;
}

//检查验证码的函数，这个函数可以异步检查，
// 解决验证码输入页面刷新需要重新输入账号和密码的状况，提高用户体验
function checkCode(flag) {
    var saveData = JSON.stringify({"code":$("#inputCode").val()});
    $.ajax({
        url:"checkCode.action",
        type:"post",
        dataType:"json",
        contentType : "application/json;charset=utf-8",
        data:saveData,
        async:false,
        success:function (responseText) {
            if(responseText.codeMess=="0"){//验证码输入不正确
                $("#codeMess").text("验证码输入不正确");
                changeImg();
                flag = false;
                // alert(flag);
            }else{//验证码输入正确
                // alert(flag);
                $("#codeMess").empty();
                flag = true;
            }
        },
        error:function (){
            alert("网络出现问题，请刷新后重试");
            flag = false;
        }
    });
    // alert("end======" + flag);
    return flag;
}
