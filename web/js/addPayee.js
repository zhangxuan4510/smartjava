/**
 * Created by zhangxuan on 2016/7/10.
 */

$(function () {
   
});

var faccount=false;
var fname=false;
var fswiftCode=false;
var faddress=true;


function check() {
    if(!onlyOne()){
        alert("swift账号与银行信息只能选择一个");
        return;
    }
    if(faccount&&fname&&fswiftCode&&faddress){
        $("#addPayeeForm").submit();
    }else {
        alert("请您完成正确的输入");
    }
}

function checkUpdate() {
    if(faccount&&fname&&fswiftCode&&faddress){
        $("#updatePayeeForm").submit();
    }else {
        alert("请您完成正确的输入");
    }
}

function checkAccount() {
    var account=$("#account").val();
    if(checkNull("account")){
        showNull("saccount");
        faccount=false;
    }else{
        var reg=new RegExp("^[0-9]{16,19}$");
        if(!reg.test(account)){
            showError("saccount","输入的位数不对");
            faccount=false;
        }else{
            $.ajax({
                type:"POST",
                url:"../PayeeServlet",
                data:"method=noAccount&account="+account,
                success: function(msg){
                    if(msg=="true"){
                        showRight("saccount");
                        faccount=true;
                    }else{
                        showError("saccount","该账号已经被添加");
                        faccount=false;
                    }
                }
            });
        }
    }
}

function checkName() {
    var name=$("#name").val();
    if(checkNull("name")){
        showNull("sname");
        fname=false;
    }else {
        var reg=new RegExp("^[a-zA-Z]*$");
        if(!reg.test(name)){
            showError("sname","输入的名字必须全为英文");
            fname=false;
        }else{
            fname=true;
            showRight("sname");
        }
    }
}

// function checkAddress() {
//     if(checkNull("address")){
//         showNull("saddress");
//         faddress=false;
//     }else{
//         showRight("saddress");
//         faddress=true;
//     }
// }

function checkSwiftCode() {
    var swiftCode=$("#swiftCode").val();
    var reg=new RegExp("^[a-zA-Z0-9_]{11}$");
    if(!reg.test(swiftCode)){
        showError("sswiftCode","swiftCode必须为11位的数字或字母");
        fswiftCode=false;
    }else {
        showRight("sswiftCode");
        fswiftCode=true;
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

function checkNameAddress() {
   var bankName=$("#bankName").val();
    var bankAddress=$("#bankAddress").val();
    if(bankAddress!=null&&bankName!=null)
        fname=true;
}
function onlyOne() {
    var swift=$("#swiftCode").val();
    var bankName=$("#bankName").val();
    var bankAddress=$("#bankAddress").val();
    if(swift!=""&&bankName==""&&bankAddress==""){
        return true;
    }
    if(swift==""&&bankName!=""&&bankAddress!=""){
        return true;
    }
    return false;
}








function swiftOrName() {
    var val=$('input:radio[name="bankKind"]:checked').val();
    if(val=="swift"){
        $("#swiftTr").show();
        $("#nameTr").hide();
        $("#addressTr").hide();
    }else{
        $("#swiftTr").hide();
        $("#nameTr").show();
        $("#addressTr").show();
    }
}