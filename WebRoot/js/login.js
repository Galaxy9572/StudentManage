function login(){
      var form=document.getElementById("form");
      var student=document.getElementById("student");
      var teacher=document.getElementById("teacher");
      if(teacher.checked){
	    form.action="/StudentManage/RegLoginServlet?cmd=teacherLogin" ;
      }else if(student.checked){
	    form.action="/StudentManage/RegLoginServlet?cmd=stuLogin" ;
      }
}
