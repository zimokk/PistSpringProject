<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
  <h1>result</h1>
  <h1>
      <c:out value="${country}"></c:out>
  </h1>

  <h1>
      Hotel - <c:out value="${hotel}"></c:out> stars
  </h1>

  <h1>
      Excursion included? <c:out value="${excursion}"></c:out>
  </h1>

  <h1>
      Wishes? <c:out value="${wishes}"></c:out>
  </h1>
</body>
</html>
