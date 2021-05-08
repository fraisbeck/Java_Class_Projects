<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
	<c:import url="../templates/head.jsp" />
<body>
<div id="wrap">

	<c:import url="../templates/header.jsp" />

	<c:import url="../templates/sidebar.jsp" />

	<div id="content">
        <h2>This is a sample form for Lab 4-1 Unit 4</h2>
        <br />
        <br />
        <form action="/java112/Lab41Servlet" method="GET">
            <label for="firstName">First Name:</label>
            <input type="text" name="firstName" /><br />
            <br />
            <label for="lastName">Last Name:</label>
            <input type="text" name="lastName" /><br />
            <br />
            <input type="radio" id="He/Him" name="sexChoice" value="He/Him" />
            <label for="He/Him">He/Him</label>
            <br />
            <br />
            <input type="radio" id="She/Her" name="sexChoice" value="She/Her" />
            <label for="She/Her">She/Her</label>
            <br />
            <br />
            <input type="radio" id="They/Them" name="sexChoice" value="They/Them" />
            <label for="They/Them">They/Them</label>
            <br />
            <br />
            <input type="submit" name="" value="Enter" /><br />
            <br />
        </form>

	</div>

	<c:import url="../templates/footerDirect.jsp" />

</div>
</body>
</html>
