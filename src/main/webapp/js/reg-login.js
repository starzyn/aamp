// JavaScript Document
//实现重发验证码的倒计时按钮功能
var countdown=0;
var flagg = 1;
function settime(val) {
    if (countdown == 0 && flagg == 1) {
        //把数据封装成json字符串
        var saveData = JSON.stringify({"username":$("#username").val()});
        // alert("saveData:"+saveData);
        $.ajax({
            url:"/aamp/sentEmail.action",
            type:"post",
            dataType:"json",
            contentType : "application/json;charset=utf-8",
            data:saveData,
            async:false,
            success:function(data){
                // alert("======="+data.codeMess);
                if(data.codeMess=="1")
                    alert("验证码发送成功请注意查收");
                else alert("发送失败");
            },
            error:function () {
                alert("网络有问题，请刷新后重试！");
            }
        });
        flagg = 0;
        countdown =60;
        $(".tipTimer").trigger("click");
    } else if( countdown==0&&flagg==0){
        val.removeAttribute("disabled");
        val.innerText="获取到短信验证码";
        flagg = 1;
    } else{
        val.setAttribute("disabled","disabled");
        val.innerText=countdown+"秒后可重新发送";
        countdown--;
        setTimeout(function() {
            settime(val)
        },1000)
    }

}
// $(function(){
//     $(".tipTimer").trigger("click");
// })

$(document).ready(function () {
    var height=$(document).height();
    $('.main').css('height',height);
})

//实现点击更换验证码的功能
function changeImg(){
    //获取当前时间作为种子
    var time = Date.now().toString();
    //每次点击后
    $("#validateCode").attr("src","/aamp/getValidateCode.action?id="+time);

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
    var flagg = checkEmail();
    if(flag&&flagg) return true;
    // if(flag == true){//标志位为真，证明验证码输入正确
    //     return true;
    // }else {//标志位为假，证明验证码输入不正确，或者请求失败，都不能提交表单
    //     return false;
    // }
    return false;
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
            url:"/aamp/checkEmail.action",
            type:"post",
            dataType:"json",
            contentType : "application/json;charset=utf-8",
            data:saveData,
            async:false,
            success:function(data){
                // alert(data.emailMess);
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
        url:"/aamp/checkCode.action",
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

//实现检查注册的时候密码的规则检验
function checkPwd(){
    var pwd = $("#password").val().toString().trim();
    var pattern = /^(?![a-zA-z]$)(?!\d$)(?![!@#$%^&*]$)[a-zA-Z\d!@#$%^&*]{6,12}$/;
    var res = pattern.test(pwd);
    if(!res){
        $("#pwdMess").text("密码不符合要求!");
        return false;
    }else {
        $("#pwdMess").empty();
        return true;
    }

}

    //实现确认密码的时候保证密码一致
    function reCheckPwd(){
        var pwd = $("#password").val().toString().trim();
        var repwd = $("#repassword").val().toString().trim();
        if(pwd==repwd){
            $("#rePwdMess").empty();
            return true;

        }else {
            $("#rePwdMess").text("两次输入的密码不一致!");
            return false;
        }
    }

    //实现注册的最后一步，验证码邮箱验证码的正确性
function checkLastReg(){
    if($("#code").val().toString().trim()=="" || $("#code").val()==undefined){
        alert("请输入邮箱验证码");
        return false;
    }
    var pwdisok = checkPwd();
    if(!pwdisok){
        alert("密码不符合要求！");
        return false;
    }
    var repwdisok = reCheckPwd();
    if(!repwdisok) {
        alert("密码不一致");
        return false;
    }

    //验证邮箱验证码
    var flag = false;
    var saveData = JSON.stringify({"code":$("#code").val()});
    $.ajax({
        url:"/aamp/checkEmailCode.action",
        type:"post",
        dataType:"json",
        contentType : "application/json;charset=utf-8",
        data:saveData,
        async:false,
        success:function (responseText) {
            if(responseText.emailCodeMess=="0"){//验证码输入不正确
                $("#emailCodeMess").text("验证码输入不正确");
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
    return flag;
}
