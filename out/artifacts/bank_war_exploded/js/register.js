
/**
 * Created by zhangxuan on 2016/7/7.
 */
var fName=false;
var fUserName=false;
var fPassword=false;
var fCardID=false;
var fPhone=false;

function check() {
    if(fName&&fUserName&&fPassword&&fCardID&&fPhone){
        $("#registerForm").submit();
    }else{
        alert("请您完成合法输入后提交");
    }
}

function checkName() {
     if(checkNull("name")){
         showNull("sname");
         fName=false;
     }else{
         var reg =  /^[\u4E00-\u9FA5]{1,6}$/;
         var value=$("#name").val();
         var flag=reg.test(value);
         if(flag){
             showRight("sname");
             fName=true;
         }else{
             showError("sname","请您输入中文");
             fName=false;
         }
     }
}

function checkUserName() {
    var userName=$("#userName").val();
    if(checkNull("userName")){
        showNull("suserName");
    }else{
        $.ajax({
            type:"POST",
            url:"RegisterServlet",
            data:"method=checkNotUserName&userName="+userName,
            success: function(msg){
                if(msg=="true"){
                   showRight("suserName");
                    fUserName=true;
                }else{
                    showError("suserName","该用户名已存在");
                    fUserName=false;
                }
            }
        });
    }
    
}

function checkPassword() {
     if(checkNull("password")){
         showNull("spassword");
         fPassword=false;
     }
     if(checkNull("password")){
         showNull("spassword1");
         fPassword=false;
         return;
     }
     var pass1=$("#password").val();
     var pass2=$("#password1").val();
     if(pass1==pass2){
         showRight("spassword");
         showRight("spassword1");
         fPassword=true;
     }else{
         showError("spassword","两次密码不一致");
         showError("spassword1","两次密码不一致");
         fPassword=false;
     }
    
}

function checkCardID() {
    var cardID=$("#cardID").val();
    if(checkNull("cardID")){
        showNull("scardID");
        fCardID=false;
    }else{
        var myReg=/(^\d{15}$)|(^\d{18}$)|(^\d{17}(\d|X|x)$)/;
        if(myReg.test(cardID)){
            $.ajax({
                type:"POST",
                url:"RegisterServlet",
                data:"method=checkNotCardID&cardID="+cardID,
                success: function(msg){
                    if(msg=="true"){
                        showRight("scardID");
                        fCardID=true;
                    }else{
                        showError("scardID","该cardID已经存在");
                        fCardID=false;
                    }
                }
            });
        }else{
            fCardID=false;
            showError("scardID","输入的身份证号不合法");
        }

    }

}

function checkPhone() {
    if(checkNull("phone")){
        showNull("sphone");
    }else{
        var myReg=/^1[34578]\d{9}$/;
        if(myReg.test($("#phone").val())){
            showRight("sphone");
            fPhone=true;
        }else {
            fPhone=false;
            showError("sphone","您输入的电话号码有误");
        }
    }

}

function checkEmail() {
    if(checkNull("email")){
        showNull("semail");
    }else{
        showRight("semail");
    }
    
}

function checkNull(id) {
   var key=$("#"+id).val();
    if(key==null||key==""){
        return true;
    }
    return false;
}

function showNull(id) {
    var span= $("#"+id);
    span.html("输入的内容不能为空");
    span.css("color","red");

}

function showRight(id) {
    var span= $("#"+id);
    span.html("✔");
    span.css("color","green");
}

function showError(id,err) {
    var span= $("#"+id);
    span.html(err);
    span.css("color","red");
}


