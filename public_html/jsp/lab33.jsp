<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
	<%@ include file="../templates/head.jsp"%>
<body>
<div id="wrap">

	<%@ include file="../templates/header.jsp"%>

	<%@ include file="../templates/sidebar.jsp"%>

	<div id="content">
        <h2>Map on a JSP Page</h2>
        <p>${myMap["number"]}</p>
        <p>${myMap["text"]}</p>
        ${myMap["html"]}
        <p>${myMap["aDate"]}</p>
	</div>

	<%@ include file="../templates/footer.jsp"%>

</div>
</body>
</html>
