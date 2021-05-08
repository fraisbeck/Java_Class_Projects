<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
	<%@ include file="../templates/head.jsp"%>
<body>
<div id="wrap">

	<%@ include file="../templates/header.jsp"%>

	<%@ include file="../templates/sidebar.jsp"%>

	<div id="content">

        <%
            out.println(request.getServletContext().getAttribute("test"));
        %>

    </div>

	<%@ include file="../templates/footer.jsp"%>

</div>
</body>
</html>
