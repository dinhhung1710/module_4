<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update</title>
</head>
<body>
    <h2>Result</h2>
    <p>Language: ${email.language}</p>
    <p>Page Size: ${email.pageSize}</p>
    <p>Spams Filter: ${email.spamsFilter ? "Enabled" : "Disabled"}</p>
    <p>Signature:<br/> <pre>${email.signature}</pre></p>
</body>
</html>
