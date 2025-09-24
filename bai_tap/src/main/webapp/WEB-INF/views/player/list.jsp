<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 14/09/2025
  Time: 10:30 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Danh sách cầu thủ bóng đá</h1>
<table border="1" cellspacing="0" cellpadding="5" style="border-collapse: collapse; width: 100%; text-align: center;">
    <tr style="background-color: #f2f2f2;">
        <th>STT</th>
        <th>Id</th>
        <th>Họ và tên</th>
        <th>Ngày sinh</th>
        <th>Kinh nghiệm</th>
        <th>Vị trí</th>
        <th>Ảnh đại diện</th>
    </tr>
    <c:forEach items="${playerList}" var="player" varStatus="status">
        <tr>
            <td>${status.count}</td>
            <td>${player.id}</td>
            <td>${player.fullName}</td>
            <td>${player.dayOfBirth}</td>
            <td>${player.experience}</td>
            <td>${player.position}</td>
            <td>
                <img src="${player.avatar}" alt="avatar" width="120" height="120" style="object-fit: cover;">
            </td>
            <td>
                <a href="<c:url value='/players/delete/${player.id}'/>" onclick="return confirm('Xác nhận xoá?')"></a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
