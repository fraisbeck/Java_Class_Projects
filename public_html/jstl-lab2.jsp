<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
	<c:import url="head.jsp" />
<body>
<div id="wrap">

	<c:import url="header.jsp" />

	<c:import url="sidebar.jsp" />

	<div id="content">
        <ul>
            <c:forEach var="hobbies" items="${myList}">
                <li>${hobbies}</li>
            </c:forEach>
        </ul>
	</div>

	<c:import url="footer.jsp" />

</div>
</body>
</html>
