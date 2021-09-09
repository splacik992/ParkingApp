<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<body>

<c:forEach items="${currentUserList}" var="i" varStatus="status">

</c:forEach>

    <form method="post" action="api/reservation/{userId}/{spotId}/{parkingId}">

              <label for="spotlist">Wybierz miejsce parkingowe</label>
              <input list="spots" name="spotlist" id="spotlist">
              <datalist id="spots">
                <c:forEach items="${freeSpots}" var="slot">
                    <option value="${slot}">
                </c:forEach>
              </datalist>
              <input type="submit">
    </form>
</body>
</html>

