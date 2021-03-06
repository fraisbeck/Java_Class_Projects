<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<c:set var="name" value="Frank" />
<html xmlns="http://www.w3.org/1999/xhtml">
	<c:import url="../templates/head.jsp" />
<body>
<div id="wrap">

	<c:import url="../templates/header.jsp" />

	<c:import url="../templates/sidebar.jsp" />

	<div id="content">
        <p>
            Hello there, ${name}!
        </p>
	</div>

	<c:import url="../templates/footerDirect.jsp" />

</div>
</body>
</html>
