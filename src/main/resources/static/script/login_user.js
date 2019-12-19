var xmlHttp = new XMLHttpRequest();

function login(){
    var userName =  document.getElementById("userName").value
    var passWd = document.getElementById("passWd").value;

    xmlHttp.open("post","http://47.93.221.123:8080/webhomework3/login");
    xmlHttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
    var para = "userName="+userName+"&"+"passWd="+passWd+"&kind="+"1";
    xmlHttp.onreadystatechange = handleStateChange;
    console.log(para);
    xmlHttp.send(para);
}

function handleStateChange() {
    if(xmlHttp.readyState === 4) {

        console.log(xmlHttp.status);
        if(xmlHttp.status === 200){

            window.location.href="http://47.93.221.123:8080/webhomework3/index.html"
             alert("操作成功");//放在上面那句话后面！！！
        }else {
            alert("用户不存在");
        }
    }

}