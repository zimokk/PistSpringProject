<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
    <title>Details</title>
    <style type="text/css">
        body{
            background-color: aliceblue;
            padding: 50px;
        }
        .btn{
            margin-left: 20px;
        }
    </style>
</head>
<body>
    <div class="row">
        <div class="col-md-12">

        </div>
        <form action="${pageContext.request.contextPath}/additional">
            <label>
                <input class="form-control" type="radio" name="hotel" value="1"> 1 star
            </label>
            <label>
                <input class="form-control" type="radio" name="hotel" value="2"> 2 star
            </label>
            <label>
                <input class="form-control" type="radio" name="hotel" value="3"> 3 star
            </label>
            <label>
                <input class="form-control" type="radio" name="hotel" value="4"> 4 star
            </label>
            <label>
                <input class="form-control" type="radio" name="hotel" value="5"> 5 star
            </label>
            <div class="row">
                <label>Excursion
                    <input class="form-control" type="checkbox" name="excursion">
                </label>
                <input class="btn btn-primary" type="submit" value="Next">
            </div>
        </form>

    </div>
</body>
</html>
