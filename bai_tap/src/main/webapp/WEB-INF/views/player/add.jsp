<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 14/09/2025
  Time: 10:30 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Thêm mới</h1>

<form:form action="/players/add" method="post" modelAttribute="player">
    ID:
    <form:input path="id"/><br>
    Họ và tên:
    <form:input path="fullName"/><br>
    Ngày sinh:
    <form:input path="dayOfBirth"/><br>
    Kinh nghiệm:
    <form:input path="experience"/><br>
    Vị trí:
    <form:input path="position"/><br>
    Link ảnh đại diện:
    <form:input path="avatar"/><br>
    <form:button>Lưu</form:button>
</form:form>
</body>
</html>
