<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
        <title></title>
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
        <table>
            <thead>
                <tr>
                    <td>Country</td>
                    <td>Hotel</td>
                    <td>Excursion</td>
                    <td>Cost</td>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${tourList}" var="tour">
                    <tr>
                        <td>${tour.getCountry()}</td>
                        <td>${tour.getHotel()}</td>
                        <td>${tour.getExcursion()==null ? "Nope" : "Yeap"}</td>
                        <td>${tour.getCost()}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <p>
            requirements: (Country: <c:out value='${country==null ? "Doesnt matter" : country}'></c:out>,
            Hotel: <c:out value="${hotel}"></c:out>*,
            Excursion included? <c:out value='${excursion==null ? "Doesn^t matter" : "Yeap"}'></c:out>,
            Wishes? <c:out value='${wishes==null || wishes.equals("") ? "Nope" : wishes}'></c:out>)
        </p>
    </body>
</html>
