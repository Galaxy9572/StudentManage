window.onload = function() {
        xhr = getXmlHttpRequest();
}

function findStuByStuNum() {
        var stuNum = document.getElementById("findSByNum").value;
        xhr.open("post", "/StudentManage/StudentOperateServlet?cmd=findStuByStuNum" + "&time=" + new Date().getTime(), true);
        xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
        xhr.send("stuNum=" + stuNum);
        xhr.onreadystatechange = function() {
                if (xhr.readyState == 4) {
                        if (xhr.status == 200 || xhr.status == 304) {
                                var json = eval("(" + xhr.responseText + ")");
                                if (json === null || json == "") {
                                        alert("此学生不存在哦！");
                                } else {
                                        alert("查询结果：\n" + "学号：" + json.stuNum + "\n" + "姓名：" + json.stuName + "\n" + "性别：" + json.gender + "\n" + "年龄：" + json.age);
                                }
                        }
                }
        }
}

function findStuByStuName() {
        var stuName = document.getElementById("findSByName").value;
        xhr.open("post", "/StudentManage/StudentOperateServlet?cmd=findStuByStuName" + "&time=" + new Date().getTime(), true);
        xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
        xhr.send("stuName=" + stuName);
        xhr.onreadystatechange = function() {
                if (xhr.readyState == 4) {
                        if (xhr.status == 200 || xhr.status == 304) {
                                var json = eval("(" + xhr.responseText + ")");
                                if (json === null || json == "") {
                                        alert("此学生不存在哦！");
                                } else {
                                        var result = "";
                                        for (var i = 0; i < json.length; i++) {
                                                result = result + "学号：" + json[i].stuNum + "\n" + "姓名：" + json[i].stuName + "\n" + "性别：" + json[i].gender + "\n" + "年龄：" + json[i].age + "\n\n";
                                        }
                                        alert("查询结果：\n" + result);
                                }
                        }
                }
        }
}

function delStuByStuNum() {
        var stuNum = document.getElementById("delSByNum").value;
        xhr.open("post", "/StudentManage/StudentOperateServlet?cmd=delStuByStuNum" + "&time=" + new Date().getTime(), true);
        xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
        xhr.send("stuNum=" + stuNum);
        xhr.onreadystatechange = function() {
                if (xhr.readyState == 4) {
                        if (xhr.status == 200 || xhr.status == 304) {
                                var result = xhr.responseText;
                                if (result == 0) {
                                        alert("删除失败哦！");
                                } else {
                                        alert("删除成功！");
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