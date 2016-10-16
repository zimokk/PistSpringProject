<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <link href="<c:url value="./resources/css/main.css" />" rel="stylesheet">
    <title>${title}</title>
</head>
<body>
    <h1>${title}</h1>
    <form action="${pageContext.request.contextPath}/details" method="get">
        <label>
            <select name="country">
                <option value="no">Doesn't matter</option>
                <option value="en">England</option>
                <option value="fr">France</option>
                <option value="us">USA</option>
                <option value="by">Belarus</option>
            </select>
        </label>
        <input type="submit" value="Next">
    </form>
</body>
</html>