<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
    <style>
        input{
            height: 7vh;
            width: 98%;
            border-radius: 5px;
           box-sizing: border-box;
           align-items: center;
        }
        table{
            height: 90vh;
            width: 70vw;
           justify-content: center;
            background-color: blue;
            border-radius: 5px;
        }
        tr{
            margin-left: 20px;
        }
        button{
            background: linear-gradient(to right,rgb(50, 25, 102),skyblue);
            height: 7vh;
            width: 98%;
            border-radius: 5px;
        }
    </style>
    <script>
        //e=document.getElementById("eye");
       // e.classList.add("fa-eye");
        function login(){
            location.href="SpringExpensesTracker.html"
        }
        function showpwd(){
           e=document.getElementById("eye")
           e.classlist.remove("fa-eye");
           e.classlist.add("fa-eye-slash")

        }
    </script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css">
</head>

<body>
    
    
    <div>
       <table align="center" cellspacing="5px" border="0" cellpadding="">
       <form action="Registration" method="post">
        <tr align="center"><td style="font-size: larger;font-weight: 700;">Create Account</td></tr>
        <tr><td><input type="text" name="fullname" id="" placeholder="your name" ></td></tr>
        <tr><td><input type="text" name="username" id="" placeholder="your username" ></td></tr>
        <tr><td><input type="text" name="email" id="" placeholder="your email"></td></tr>
        <tr><td><input type="text" name="mobile" id="" placeholder="your Mobile"></td></tr>
        <tr><td><input type="password" name="password" id="pwd" placeholder=" password"><i class="fa fa-eye" id="eye" style="margin-left:-30px;cursor: pointer;margin-top:15px;" onclick="showpwd()"></i></td></tr>
        <tr><td><input type="password" name="cpassword" id="pwd" placeholder=" repeat password"><i class="fa fa-eye-slash" id="eye1" style="margin-left:-30px;cursor: pointer;margin-top:15px;" onclick="showpwd()"></i></td></tr>
        <tr><td><button>sign up</button></td></tr>
        <tr><td align="center" onclick="login()" style="cursor: pointer;">have an account?<u>Login Here</u></td></tr>
        </form>
       </table>
    </div>
    
</body>
</html>