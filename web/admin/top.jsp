<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="damain.Admain" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="css/common.css">
</head>
<style>
    .admin_top {
        height: 70px;
        background: #1cc09f;
        text-align: right;
        padding-right: 70px;
        color: white;
        position: relative;
    }

    .admin_top span {
        position: absolute;
        right: 10px;
        top: 30px;

    }

    .admin_top img {
        margin-top: 20px;
    }

    .admin_top .top_left {
        width: 250px;
        height: 70px;
        background: #283643;
        float: left;
        color: white;
        font-weight: bold;
        text-align: center;
        padding-top: 20px;
        font-size: 20px;

    }

    .admin_top .top_left:hover {
        background: #000;
    }


</style>
<body style="background:blue">

<div class="admin_top">
    <div class="top_left">
        码蚁商城
    </div>
    <div class="h_top_right">
        <img src="images/user_icon.png" alt="">
        <!-- 从session域 当中取出数据 -->
        <span> <%--@elvariable id="admin" type="Service.AdmainService"--%>
           <%
               Admain u = (Admain) session.getAttribute("admain");
               System.out.println("test");
               System.out.println(u);
           %>
       <c:if test="${empty admain}">
           没有登录
       </c:if>
        <c:if test="${!empty admain}">
            ${admain.username}
        </c:if></span>

    </div>

</div>

</body>
</html>