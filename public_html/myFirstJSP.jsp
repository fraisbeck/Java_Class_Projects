<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
	<%@ include file="head.jsp"%>
<body>
<div id="wrap">

	<%@ include file="header.jsp"%>

	<%@ include file="sidebar.jsp"%>

	<div id="content">
		<h2>myFirstJSP<span class="post-span">- by Frank Raisbeck</span></h2>
		<img src="images/codeSample.png" class="post-img" alt="Bild" />
        </br></br>
        <h3>This is a simple first look at a JSP page.</h3>
        <p>A change that gets compiled. Another change</p>
        <p>Right now it is <%= new java.util.Date() %></p>
	</div>

	<%@ include file="footer.jsp"%>

</div>
</body>
</html>
