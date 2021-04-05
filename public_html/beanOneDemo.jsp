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
        <h3>MVC Demo</h3>

        <p>Data from my bean: ${myCoolBean.data}</p>

        <br />

        <a href="/java112">Home</a>
    </div>

	<%@ include file="footer.jsp"%>
    
</div>
</body>
</html>
