<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<c:set var="name" value="Frank" />
<html xmlns="http://www.w3.org/1999/xhtml">
	<c:import url="head.jsp" />
<body>
<div id="wrap">

	<c:import url="header.jsp" />

	<div id="sidebar">
		<c:import url="unit1Sidebar.jsp" />

		<c:import url="unit2Sidebar.jsp" />

		<c:import url="unit3Sidebar.jsp" />

		<c:import url="unit4Sidebar.jsp" />
	</div>

	<div id="content">
        <p>
            Hello there, ${name}!
        </p>
	</div>

	<c:import url="footer.jsp" />

</div>
</body>
</html>
