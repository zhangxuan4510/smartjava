/**
 * Created by zhangxuan on 2016/7/11.
 */
function allSelect() {
    //1 获取总选框的值
    var allCheckbox=document.getElementById("allCheckbox");
    var checkboxes=document.getElementsByName("oneCheckbox");
    if(allCheckbox.checked){
        for(var i=0;i<checkboxes.length;i++){
            checkboxes[i].checked=true;
        }
    }else{
        for(var i=0;i<checkboxes.length;i++){
            checkboxes[i].checked=false;
        }
    }
}

function oneSelect() {
    var allCheckbox=document.getElementById("allCheckbox");
    var checkboxes=document.getElementsByName("oneCheckbox");
    var flag=true;
    for(var i=0;i<checkboxes.length;i++){
        if(!checkboxes[i].checked){
            flag=false;
            break;
        }
    }
    if(flag==true)
        allCheckbox.checked=true;
    else
        allCheckbox.checked=false;
}

function checkUpdate() {
    var checkboxs=document.getElementsByName("oneCheckbox");
    var count=0;
    var account=null;
    for(var i=0;i<checkboxs.length;i++){
        if(checkboxs[i].checked){
            count++;
            account=checkboxs[i].value;
        }
    }
    if(count>1){
        alert("您一次只能更新一条数据");
    }else if(count==0){
        alert("请您选择要更新的数据");
    }else{
        window.location.href='PayeeServlet?method=toUpdate&account='+account;
    }
}

function deletePayee() {
    var checkboxes=document.getElementsByName("oneCheckbox");
    var accounts="";
    for(var i=0;i<checkboxes.length;i++){
        if(checkboxes[i].checked){
            accounts=accounts+checkboxes[i].value+"-";
        }
    }
    if(accounts==""){
        alert("请选择您要删除的用户");
    }else{
        window.location.href='PayeeServlet?method=deletePayee&accounts='+accounts;
    }
}