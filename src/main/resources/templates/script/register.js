var xmlHttp = new XMLHttpRequest();
function register(){
     var userName = document.getElementById('userName').value;
     var kind = document.getElementById('user');
     var passWd = document.getElementById('passWd').value;
     var rePassWd = document.getElementById('rePassWd').value;

     xmlHttp.open("post","http://localhost:8088/homework2/register");
     xmlHttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");

     if(kind.checked){
         var para = "userName="+userName+"&"+"passWd="+passWd+"&"+"kind="+1;
         xmlHttp.onreadystatechange = handleStateChange;
         console.log(para);
         xmlHttp.send(para);
     }else {
         var para = "userName="+userName+"&"+"passWd="+passWd+"&"+"kind="+2;
         xmlHttp.onreadystatechange = handleStateChange;
         console.log(para);
         xmlHttp.send(para);
     }
}

function handleStateChange() {
    if(xmlHttp.readyState == 4) {

        if(xmlHttp.status == 200){
            alert("操作成功");
        }else {
            alert("用户名重复");
        }
    }
}