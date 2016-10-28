
function modify(){
      var xhr=getXmlHttpRequest();
      var classID=document.getElementById("classID").value;
      var className=document.getElementById("className").value;
      var classNum=document.getElementById("classNum").value;
      var teacherID=document.getElementById("teacherID").value;
      xhr.open("post", "/StudentManage/ClassOperateServlet?cmd=modifyClass" + "&time=" + new Date().getTime(), true);
      xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
      xhr.send("classID="+classID+"&className="+className+"&classNum="+classNum+"&teacherID="+teacherID);
      xhr.onreadystatechange = function() {
              if (xhr.readyState == 4) {
                      if (xhr.status == 200 || xhr.status == 304) {
                	    alert("修改成功！");
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