<!DOCTYPE html>
<%!
    public ServletContext context;

    public void jspInit() {
        ServletContext context = getServletContext();
        context.setAttribute("test", "This is a test on setting a value through a jsp!");
    }
%>
<html xmlns="http://www.w3.org/1999/xhtml">
	<%@ include file="../templates/head.jsp"%>
<body>
<div id="wrap">

	<%@ include file="../templates/header.jsp"%>

	<%@ include file="../templates/sidebar.jsp"%>

	<div id="content">

        <p>This is the test servlet output:
            <%= request.getServletContext().getAttribute("test") %>
        </p>

    </div>

	<%@ include file="../templates/footer.jsp"%>

</div>
</body>
</html>
