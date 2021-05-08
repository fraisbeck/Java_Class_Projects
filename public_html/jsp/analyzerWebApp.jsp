<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<c:set var="title" value="FileAnalyzer" scope="session"/>
<html xmlns="http://www.w3.org/1999/xhtml">
	<c:import url="../templates/headUnit4.jsp" />
<body>
<div id="wrap">

	<c:import url="../templates/header.jsp" />

	<c:import url="../templates/sidebar.jsp" />

	<div id="content">

        <h2>Upload your text file to be analyzed</h2>
        <br />
        <br />
        <form action="/java112/analyzerResults" method="POST" enctype="multipart/form-data">
            <label for ="uploadedFile">Select a file: </label>
            <input type="file" id="uploadedFile" name="uploadedFile">
            <br />
            <br />
            <input type="submit" name="" value="Upload File" /><br />
            <br />
        </form>

    </div>

	<c:import url="../templates/footer.jsp" />

</div>
</body>
</html>
