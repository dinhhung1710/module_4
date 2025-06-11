<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Settings</title>
</head>
<body>
    <h2>Settings</h2>
    <form:form action="/update" modelAttribute="email" method="post">

        <label>Languages</label>
        <form:select path="language">
            <form:options items="${languages}"/>
        </form:select>
        <br><br>

        <label>Page Size:</label>
        Show <form:select path="pageSize">
        <form:options items="${pageSizes}"/>
    </form:select> emails per page
        <br><br>

        <label>Spams filter:</label>
        <form:checkbox path="spamsFilter"/> Enable spams filter
        <br><br>

        <label>Signature:</label><br>
        <form:textarea path="signature" rows="5" cols="40"/>
        <br><br>

        <input type="submit" value="Update"/>
        <input type="reset" value="Cancel"/>

    </form:form>
</body>
</html>
