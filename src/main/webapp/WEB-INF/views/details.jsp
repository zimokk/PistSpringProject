<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Details</title>
</head>
<body>
    <div>
        <form action="${pageContext.request.contextPath}/additional">
            <label>
                <input type="radio" name="hotel" value="1"> 1* star
            </label>
            <label>
                <input type="radio" name="hotel" value="2"> 2* star
            </label>
            <label>
                <input type="radio" name="hotel" value="3"> 3* star
            </label>
            <label>
                <input type="radio" name="hotel" value="4"> 4* star
            </label>
            <label>
                <input type="radio" name="hotel" value="5"> 5* star
            </label>
            <label>Excursion
                <input type="checkbox" name="excursion">
            </label>
            <input type="submit" value="Next">
        </form>

    </div>
</body>
</html>
