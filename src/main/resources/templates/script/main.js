

function register() {

}

function model() {

    xmlHttp.open("post","http://localhost:8088/homework1/addQuestion");
    xmlHttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
    xmlHttp.onreadystatechange = handleStateChange;

    var para = "question="+document.getElementById("ping").value;
    console.log(para);
    xmlHttp.send(para);
}

function addAnswer(index) {
    var tmp = "class"+index;
    var inputs = document.getElementsByClassName(tmp);
    console.log(inputs.length)
    console.log(index)
    var answer =  inputs.item(1).value;
    xmlHttp.open("post","http://localhost:8088/homework1/addAnswer");
    xmlHttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
    xmlHttp.onreadystatechange = handleStateChange;

    var para = "answer="+answer+"&"+"rowIndex="+index;
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