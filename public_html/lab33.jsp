<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
	<%@ include file="head.jsp"%>
<body>
<div id="wrap">

	<%@ include file="header.jsp"%>

	<div id="sidebar">
		<%@ include file="unit1Sidebar.jsp"%>

		<%@ include file="unit2Sidebar.jsp"%>

		<%@ include file="unit3Sidebar.jsp"%>

		<%@ include file="unit4Sidebar.jsp"%>
	</div>

	<div id="content">
        <h2>Map on a JSP Page</h2>
        <p>${myMap["number"]}</p>
        <p>${myMap["text"]}</p>
        ${myMap["html"]}
        <p>${myMap["aDate"]}</p>
	</div>

	<%@ include file="footer.jsp"%>
	
</div>
</body>
</html>