<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
    <%@ include file="../templates/head.jsp"%>
<body>
<div id="wrap">

    <%@ include file="../templates/header.jsp"%>

	<%@ include file="../templates/sidebar.jsp"%>

	<div id="content">
        <h3>MVC Demo</h3>

        <p>Data from my bean: ${myCoolBean.data}</p>

        <br />

        <a href="/java112">Home</a>
    </div>

	<%@ include file="../templates/footer.jsp"%>

</div>
</body>
</html>
