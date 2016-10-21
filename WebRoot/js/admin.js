var xhr = getXmlHttpRequest();

function sendToServer() {
        var stuNum = findSByNum();
        alert(stuNum);
        xhr.open("post", "/StudentManage/StudentOperateServlet", true);
        xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
        xhr.send("stuNum=" + stuNum+"&time="+new Date().getTime());
}

function findSByNum() {
        var stuNum = document.getElementById("findSByNum").value;
        return stuNum;
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