<%@page import="com.jsp.expenseTracker.service.UserServiceImpl"%>
<%@page import="com.jsp.expenseTracker.service.UserService"%>
<%@page import="com.jsp.expenseTracker.entity.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<style>
body {
   display:flex;
   justify-content:center;
}
div {
   display:flex;
   justify-content:space-evenly;
}
#container {
   width:40vw;
   height:80vh;
   display:flex;
   justify-content:space-evenly;
   flex-direction:column;
   align-items:center;
}
#container input {
   width:90%;
}
</style>
<body>
   <%
   HttpSession session2=request.getSession();
   User user=(User) session2.getAttribute("userInfo");
   %>
   <div id="container">
   <form method="post" enctype="multipart/form-data" action="UpdateProfile">
     <label>username:</label><br><input type="text" value="<%= user.getUsername()%>" name="username">
     
     <label>fullname:</label><br><input type="text" value="<%= user.getFullname()%>" name="fullname">
     
     <label>mobile:</label><br><input type="text" value="<%= user.getMobile()%>" name="mobile">
     
     <label>password:</label><br><input type="text" value="<%= user.getPassword()%>" name="password">
     
     <label>email:</label><input type="email" value="<%= user.getEmail()%>" name="email">
     <label>image:</label><input type="file" id="ima" onchange="displayImage(this)" name="imageFile">
     <img alt="" src="" id="s" width="200px" height="200px" style="margin-left:0px">
     <input type="number" value="<%= user.getUserId()%>" hidden name="id">
     <input type="submit">
     </form>
   </div>
   <script>
      function displayImage(input) {
         var img = document.getElementById("s");
         if (input.files && input.files[0]) {
            var reader = new FileReader();
            reader.onload = function (e) {
               img.src = e.target.result;
            }
            reader.readAsDataURL(input.files[0]);
         }
      }
   </script>
</body>
</html>
