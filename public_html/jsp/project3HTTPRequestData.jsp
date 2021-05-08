<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
    <%@ include file="../templates/head.jsp"%>
<body>
<div id="wrap">

    <%@ include file="../templates/header.jsp"%>

	<%@ include file="../templates/sidebar.jsp"%>

	<div id="content">
        <h3>Project 3 HTTP Request Data</h3>

        <ul>
            <li>The remote computer making the request: ${results.remoteComputer}</li>
            <li>The address of the remote computer making the request: ${results.remoteAddress}</li>
            <li>The HTTP method of the request: ${results.requestMethod}</li>
            <li>The request URI: ${results.requestURI}<li>
            <li>The request URL: ${results.requestURL}</li>
            <li>The protocol of the request: ${results.protocolRequest}</li>
            <li>The server name: ${results.serverName}</li>
            <li>The server port number: ${results.serverPortNumber}</li>
            <li>The current Locale of the server: ${results.localeServer}</li>
            <li>The query string: ${results.stringQuery}</li>
            <li>The value of a query parameter with the name of queryParameter: ${results.queryParameter}</li>
            <li>The value of the request header with the name of User-Agent: ${results.userAgent} </li>

        </ul>

        <br />

    </div>

	<%@ include file="../templates/footer.jsp"%>

</div>
</body>
</html>
