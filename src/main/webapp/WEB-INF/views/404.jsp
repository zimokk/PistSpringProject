<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
  <h1>An error occurred</h1>
  From page - <a href="http://localhost:8080/<c:out value='${source}'></c:out>?errorPage=true">Back</a>
</body>
</html>
