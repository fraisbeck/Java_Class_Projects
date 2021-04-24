<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
	<%@ include file="head.jsp"%>
<body>
<div id="wrap">

	<%@ include file="header.jsp"%>

	<%@ include file="sidebar.jsp"%>

	<div id="content">

        <%
            out.println(request.getServletContext().getAttribute("test"));
        %>

    </div>

	<%@ include file="footer.jsp"%>

</div>
</body>
</html>
