<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
	<%@ include file="../templates/head.jsp"%>
<body>
<div id="wrap">

	<%@ include file="../templates/header.jsp"%>

	<%@ include file="../templates/sidebar.jsp"%>

	<div id="content">
		<h2>myFirstJSP<span class="post-span">- by Frank Raisbeck</span></h2>
		<img src="../images/codeSample.png" class="post-img" alt="Bild" />
        </br></br>
        <h3>This is a simple first look at a JSP page.</h3>
        <p>A change that gets compiled. Another change</p>
        <p>Right now it is <%= new java.util.Date() %></p>
	</div>

	<%@ include file="../templates/footerDirect.jsp"%>

</div>
</body>
</html>
