/**
 * Created by zhangxuan on 2016/7/10.
 */
function loginByUserName() {
    var userName=$("#userName").val();
    var userPwd=$("#rowlogin").val();
    $.ajax({
        type:"POST",
        url:"LoginServlet",
        data:"method=loginByUserName&userName="+userName+"&userPwd="+userPwd,
        success: function(msg){
            if(msg=="success"){
                window.location.href="../payee/payeeList.jsp";
            }else{
                alert("您输入的用户名或密码有误");
            }
        }
    });
}