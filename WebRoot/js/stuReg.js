window.onload = function() {
        var xhr = getXmlHttpRequest();
        alert("js载入···");
}

function checkStuName() {
        var stuName = document.getElementById("stuName").value;
        var stuName_info = document.getElementById("stuName_info");
        if (!/^[\u4E00-\u9FA5\uF900-\uFA2D\w]+$/.test(stuName)) {
                stuName_info.innerHTML = "<font color='red'>姓名不能为空</font>";
        } else {
                stuName_info.innerHTML = "";
        }
}

function checkStuNum() {
        var stuNum = document.getElementById("stuNum").value;
        var stuNum_info = document.getElementById("stuNum_info");
        if (!/^\d+$/.test(stuNum)) {
                stuNum_info.innerHTML = "<font color='red'>请输入数字</font>";
        } else {
                stuNum_info.innerHTML = "";
        }
        xhr.onreadystatechange = function() {
                alert(xhr.readyState);
                if (xhr.readyState == 4) {
                        if (xhr.status >= 200 || xhr.status <= 304) {
                                xhr.open("post", "/StudentManage/RegLoginServlet?cmd=valStuNum", true);
                                xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
                                xhr.send("valStuNum=" + stuNum + "&time=" + new Date().getTime());
                                var response = xhr.responseText;
                                if (response == "true") {
                                        stuNum_info.innerHTML = "<font color='red'>该学号可以注册</font>";
                                } else if (response == "false") {
                                        stuNum_info.innerHTML = "<font color='red'>该学号已被注册</font>";
                                }
                        }
                }
        }
}

function checkAge() {
        var age = document.getElementById("age").value;
        var age_info = document.getElementById("age_info");
        if (!/^([1-9]\d{0,1}|100)$/.test(age)) {
                age_info.innerHTML = "<font color='red'>请输入1-100之间的数字</font>";
        } else {
                age_info.innerHTML = "";
        }
}

function checkPassword() {
        var password = document.getElementById("password").value;
        alert(password);
        var password_info = document.getElementById("password_info");
        if (password.trim() == "") {
                password_info.innerHTML = "<font color='red'>密码不能为空</font>";
        } else {
                password_info.innerHTML = "";
        }
}

function confirmPassword() {
      var password = document.getElementById("password").value;
      alert(password);
      var password_info = document.getElementById("password_info");
      var cfpassword = document.getElementById("cfpassword").value;
      alert(cfpassword);
      var cfpassword_info = document.getElementById("cfpassword_info");
      if (password.!=cfpassword) {
              cfpassword_info.innerHTML = "<font color='red'>两次密码输入不一致</font>";
      } else {
              cfpassword_info.innerHTML = "";
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