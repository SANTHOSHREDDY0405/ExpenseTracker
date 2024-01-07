<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@page import="com.jsp.expenseTracker.entity.Expense"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
    <title>Document</title>
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />
        <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <!-- <link rel="stylesheet" href="https://fontawesome.com/icons/hand-holding-dollar?f=classic&s=solid"> -->
        <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />
        <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />
        <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />
    <style>
        body {
            margin: 0;
            padding: 0;r̥
        }

        #nav-bar {
            position: absolute;
            width: 100vw;
            height: 10vh;
            background-color: rgb(223, 130, 186);
            display: flex;
            justify-content: space-between;
            align-items: center;
        }

        b {
            font-size: larger;
        }

        #display {
            background:radial-gradient(circle at center,red,maroon);
            width: 100vw;
            height: 100vh;
            display: flex;
            flex-direction: row;
            justify-content: center;
            align-items: center;
        }

        #container {
            position: absolute;
        }

        #menu {
            width: 100vw;
            height: 100vh;
            display: flex;
            flex-direction: column;
            align-items: flex-end;
            position: fixed;
            z-index: -1;
            transition: z-index 0.3s ease-in;
        }

        td {
            height: 5vh;
            width: 10vw;
            background-color: aquamarine;
        }

        #icon {
            background-color: rgba(225, 225, 225, 0.1);
            cursor: pointer;
            width: 5vw;
            height: 10vh;
            display: flex;
            align-items: center;
            justify-content: center;
        }
        
        #section1{
            width: 50%;
            height: 90%;
            display: flex;
            justify-content: center;
            align-items: center;
        }
        #section2{
            width: 50%;
            height: 90%;
            display: flex;
            flex-direction: column;
            align-items: center;
            justify-content: space-evenly;
        }
        .expense{
            background-color: rgba(255, 255, 255, 0);
            font-size:25px;
            color: white;
        }
        #innerDiv{
            margin-top: 10vh;
            background: radial-gradient(circle at center,rgb(241, 183, 223),rgb(184, 24, 134));
            width: 70vw;
            height: 80vh;
            border-radius: 15px;
            display: flex;
        }
        input{
            text-align: center;
            border-radius:10px;
        }
    </style>
    <script src="https://kit.fontawesome.com/745fad844e.js" crossorigin="anonymous"></script>

</head>

<body>
    <script>
        function showMenu() {
            document.getElementById("menu").style.zIndex = 1;
        }

        function hideMenu() {
            document.getElementById("menu").style.zIndex = -1;
        }

    </script>
    <div id="container">
        <div id="nav-bar">
            <div><b>spring Expense Tracker</b></div>
            <div id="icon" onmouseover="showMenu()" onmouseout="hideMenu()">
                <i>
                    <span class="material-symbols-outlined">
                        manage_accounts
                    </span>
                </i>
            </div>
        </div>
        <form action="ViewExpenses" >
        <div id="display">
            <table border="2">
            <tr>
                    <th>s.no</th>
                <th>date</th>
                <th>amount</th>
                <th>category</th>
                <th>description</th>
                <th>action</th>
            </tr>
               <%
                   List<Expense> listOfExpenses=(List)request.getAttribute("list"); 
                   if(listOfExpenses != null)
                   {
                	   int count=0;
                	   for(Expense e : listOfExpenses)
                	   {
               %>
               <tr>
                    <th><%= count++%></th>
                    <td><%= e.getDate()%></td>
                    <td><%= e.getAmount()%></td>
                    <td><%= e.getCategory()%></td>
                    <td><%= e.getDescription()%></td>
                    <td>
                      <a href="UpdateExpense.jsp?expenseId=<%= e.getExpenseId()%>">
                         <input type="button" value="Update">
                      </a>
                      <a href="DeleteExpense?expenseId=<%= e.getExpenseId()%>">
                       <input type="button" value="Delete">
                      </a>
                    </td>
                    
               </tr>
               <%
                	   }//close forEach
                   }//close if
               %>
               
            </table>
        </div>
    </div>         
    <div id="menu" onmouseover="showMenu()" onmouseout="hideMenu()">
        <table border="2px" cellspacing="0px" style="margin-top: 5vh;">
            <tr class=".btn">
                <td onclick="location.href='home.html'">home</td>
            </tr>
            <tr class=".btn">
                <td onclick="location.href='login.html'">login</td>
            </tr><br>
            <tr class=".btn">
                <td onclick="location.href='signup.html'">sign up</td>
            </tr>
        </table>
    </div>
   </form>

</body>
</html>