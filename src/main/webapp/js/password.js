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

//检查输入邮箱是否为空
function checkPwd() {
    //如果用户名为空进行提交
    if ($("#username").val() == undefined || $("#username").val().toString().trim() == "") {
        alert("请输入邮箱");
        return false;
    }
    var res = checkEmail();
    return res;
}

//检查邮箱的格式是否正确
function checkEmail() {
    var email = $("#username").val().toString().trim();
    if (email != "") {
        var reg = /^\w+((-\w+)|(\.\w+))*\@[A-Za-z0-9]+((\.|-)[A-Za-z0-9]+)*\.[A-Za-z0-9]+$/;
        //调用正则验证test()函数
        isok = reg.test(email);
        if (!isok) {//如果邮箱格式不正确
            // alert(isok);
            $("#emailMess").text("邮箱格式不正确!");
            return false;
        }
        return true;
    }
}

//实现密码的规则检验
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

function checkLastPwd(){
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