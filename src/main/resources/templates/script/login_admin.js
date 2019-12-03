var xmlHttp = new XMLHttpRequest();

function login(){
    var userName =  document.getElementById("userName").value
    var passWd = document.getElementById("passWd").value;

    xmlHttp.open("post","http://localhost:8088/login");
    xmlHttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
    var para = "userName="+userName+"&"+"passWd="+passWd+"&kind="+"2";
    xmlHttp.onreadystatechange = handleStateChange;
    console.log(para);
    xmlHttp.send(para);
}

function handleStateChange() {
    if(xmlHttp.readyState == 4) {

        if(xmlHttp.status == 200){
            alert("操作成功");
        }else {
            alert("服务器开小差了~");
        }
    }
}