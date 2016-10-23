window.onload = function() {
        var xhr = getXmlHttpRequest();
        xhr.open("post", "/StudentManage/ClassOperateServlet?cmd=listAll" + "&time=" + new Date().getTime(), true);
        xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
        xhr.send(null);
        xhr.onreadystatechange = function() {
                if (xhr.readyState == 4) {
                        if (xhr.status == 200 || xhr.status == 304) {
                                var data = xhr.responseText;
                                var json = eval("(" + data + ")");
                                for (var i = 0; i < json.length; i++) {
                                        var classID = json[i].classID;
                                        var className = json[i].className;
                                        var classNum = json[i].classNum;
                                        var teacherID = json[i].teacherID;
                                        var tr=document.createElement("tr");
                                        var td1=document.createElement("td");
                                        td1.id="classID"+(i+1);
                                        var td2=document.createElement("td");
                                        var td3=document.createElement("td");
                                        var td4=document.createElement("td");
                                        var td5=document.createElement("td");
                                        var td6=document.createElement("td");
                                        td1.innerHTML="<font color='white'>"+classID+"</font>";
                                        td2.innerHTML="<font color='white'>"+className+"</font>";
                                        td3.innerHTML="<font color='white'>"+classNum+"</font>";
                                        td4.innerHTML="<font color='white'>"+teacherID+"</font>";
                                        var bt_update=document.createElement("button");
                                        bt_update.innerHTML="修改";
                                        bt_update.id="bt_update"+(i+1);
                                        tr.appendChild(td1);
                                        tr.appendChild(td2);
                                        tr.appendChild(td3);
                                        tr.appendChild(td4);
                                        tr.appendChild(bt_update);
                                        document.getElementById("classTable").appendChild(tr);
                                }
                        }
                }
        }

}

function getXmlHttpRequest() {
        var xmlHttpRequest;
        try {
                xmlHttpRequest = new XMLHttpRequest();
        } catch (e) {
                try {
                        xmlHttpRequest = new ActiveXObject("Msxml2.XMLHttp");
                } catch (e) {
                        xmlHttpRequest = new ActiveXObject("Microsoft.XMLHttp");
                }
        }
        return xmlHttpRequest;
}