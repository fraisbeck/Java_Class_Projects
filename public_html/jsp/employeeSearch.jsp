<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<c:set var="title" value="EmployeeSearch" scope="session"/>
<html xmlns="http://www.w3.org/1999/xhtml">
	<c:import url="../templates/headUnit4.jsp" />
<body>
<div id="wrap">

	<c:import url="../templates/header.jsp" />

	<c:import url="../templates/sidebar.jsp" />

	<div id="content">

        <h2>Search the Employee database for employees</h2>
        <br />
        <br />
        <form action="/java112/employeeSearchResults" method="GET">
            <fieldset>
                <legend>Search Category</legend>
                <br />
                <input type="radio" id="emp_id" name="searchType"
                    value="emp_id" required/>
                <label for="emp_id">Employee ID Number</label>
                <br />
                <br />
                <input type="radio" id="first_name" name="searchType"
                    value="first_name" />
                <label for="first_name">First Name</label>
                <br />
                <br />
                <input type="radio" id="last_name" name="searchType"
                    value="last_name" />
                <label for="last_name">Last Name</label>
                <br />
                <br />
                <input type="radio" id="dept" name="searchType"
                    value="dept" />
                <label for="dept">Department</label>
                <br />
                <br />
            </fieldset>
            <br />
            <br />
            <label for="searchTerm">Search For: </label>
            <input type="text" name="searchTerm" required/><br />
            <br />
            <br />
            <input type="submit" name="" value="Enter" /><br />
            <br />
        </form>

    </div>

	<c:import url="../templates/footer.jsp" />

</div>
</body>
</html>
