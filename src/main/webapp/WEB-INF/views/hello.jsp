<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8"%>
Hi JSP.现在时间是${now}

<table align='center' border='1' cellspacing='0'>
    <tr>
        <td>id</td>
        <td>name</td>
    </tr>
    <c:forEach items="${students}" var="s" varStatus="st">
        <tr>
            <td>${s.id}</td>
            <td>${s.name}</td>
        </tr>
    </c:forEach>
</table>

<form action="upload" method="post" enctype="multipart/form-data">
    <input type="file" name="file" />
    <input type="submit" value="Submit" />
</form>