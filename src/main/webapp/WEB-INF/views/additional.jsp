<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
  <div>
    <form action="${pageContext.request.contextPath}/result" method="get">
      <textarea name="wishes" placeholder="Enter da additional wishes"></textarea>
        <input type="submit" value="Result">
    </form>
  </div>
</body>
</html>
