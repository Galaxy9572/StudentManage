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
                                        var bt_select=document.createElement("button");
                                        bt_select.innerHTML="选择";
                                        bt_select.id="bt_select"+(i+1);
                                        bt_select.onclick=function(){selectClass(this)};
                                        tr.appendChild(td1);
                                        tr.appendChild(td2);
                                        tr.appendChild(td3);
                                        tr.appendChild(td4);
                                        tr.appendChild(bt_select);
                                        document.getElementById("classTable").appendChild(tr);
                                }
                        }
                }
        }
}

function selectClass(obj){
      var xhr = getXmlHttpRequest();
      var index=obj.id.substring(9);
      var classID=document.getElementById("classID"+index).value;
      xhr.open("post", "/StudentManage/StudentOperateServlet?cmd=selectClass" + "&time=" + new Date().getTime(), true);
      xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
      xhr.send("classID="+index);
      xhr.onreadystatechange = function() {
              if (xhr.readyState == 4) {
                      if (xhr.status == 200 || xhr.status == 304) {
                	    var data=xhr.responseText;
                	    alert(data);
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