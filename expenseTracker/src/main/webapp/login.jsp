<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
    <style>
        .nav{
            width: 100vw;
            height:10vh;
            background-color: violet;
            display: flex;
            align-items: center;
            font-size:large;
            font-weight: 600;
            position: absolute;
        }
        body{
                display: flex;
                height: 100vh;
                justify-content: center;
                /* align-items: center; */
                background:linear-gradient(to bottom,rgba(128, 128, 128, 0.118),rgb(239, 201, 239),rgb(248, 209, 248),rgba(238, 130, 215, 0.879));
                margin: 0;
        }
        .outlet{
            background-color:white;
            width:45vw;
            height: 85vh;
            margin-top: 13vh;
            display: flex;
            justify-content: center;
            position: absolute;
            border-radius: 10px;
        }
        .form{
            font-size: larger;
            background-color: white;
            width:40vw;
            height: 70vh;
            margin:0;
            position: relative;
            margin-left: 30px;
            /* display: flex; */
            /* justify-content: center; */
            
        }
        tr{
            height: 10vh;

        }
        .fb{
            height: 10vh;
            width: 46%;
            border-radius: 7px;
            background-color: blue;
            box-shadow: 2px 2px 2px grey;
            font-size: large;
            cursor: pointer;
        }
        .google{
            height: 10vh;
            width: 46%;
            border-radius: 7px;
            background-color: white;
            box-shadow: 2px 2px 2px grey;
            font-size: larger;
            cursor: pointer;
           
        }
        input{
            height: 7vh;
            width: 92%;
            border-radius: 7px;
        }
        .btn{
            height: 7vh;
            width: 93%;
            background-color: black;
            color: white;
            font-size: medium;
        }
    </style>
</head>
<body>
    
    <%
    //to retrieve data-transferred from servlet class
    String message=(String)request.getAttribute("msg");
    if(message!=null){
    %>
       <script>
       alert("<%= message%>");
       </script>
    <%
    }
    message=null;
    //to reset form-assignment
    %>
    
    <div class="nav" style="margin-left:20px;">Spring Expenses Tracker</div>
   
   <div class="outlet">
   <form action="Login" method="post">
    <table class="form">
        <tr align="center"> <td>Sign In With</td></tr>
        <tr><td><button class="fb"><a href="https://www.facebook.com" style=" color: black;">FaceBook</a></button>&nbsp;&nbsp;&nbsp;<button class="google"><a href="https://www.google.com" style=" color: black;">google</a></button></td></tr>
        <tr><td>username</td></tr>
        <tr><td colspan="2"><input type="text" name="username"></td></tr>
        <tr><td>password?&nbsp;<u>forgot?</u></td></tr>
        <tr><td colspan="2"><input type="text" name=password></td></tr>
        <tr><td colspan="2"><button class="btn">SignUp</button></td></tr>
        <tr align="center"><td colspan="2" onclick="Signup()" style="cursor: pointer;">not a member?<u>signup now</u></td></tr>
    </table>
    </form>

   </div>
  
</body>
</html>