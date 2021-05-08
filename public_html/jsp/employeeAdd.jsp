<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<c:set var="title" value="AddEmployee" scope="session"/>
<html xmlns="http://www.w3.org/1999/xhtml">
	<c:import url="../templates/headUnit4.jsp" />
<body>
<div id="wrap">

	<c:import url="../templates/header.jsp" />

	<c:import url="../templates/sidebar.jsp" />

	<div id="content">

        <h2>Enter a new Employee to the database</h2>
        <br />
        <h4>Required fields *</h4>
        <br />
        <form action="/java112/addNewEmployee" method="POST">
            <label for="first_name">First Name: <span>*</span></label>
            <input type="text" name="first_name" pattern="[A-Za-z]{1,30}" required/><br />
            <br />
            <br />
            <label for="last_name">Last Name: <span>*</span></label>
            <input type="text" name="last_name" pattern="[A-Za-z]{1,40}" required/><br />
            <br />
            <br />
            <label for="ssn">Social Security Number: <span>*</span></label>
            <input type="text" name="ssn" pattern="[0-9]{3}-[0-9]{2}-[0-9]{4}"required/><br />
            <br />
            <br />
            <label for="dept">Department: <span>*</span></label>
            <input type="text" name="dept" pattern="[A-Za-z]{1,10}"required/><br />
            <br />
            <br />
            <label for="room">Room Number: <span>*</span></label>
            <input type="text" name="room" pattern="[0-9]{3}"required/><br />
            <br />
            <br />
            <label for="phone">Phone Number: <span>*</span></label>
            <input type="text" name="phone" pattern="[0-9]{3}-[0-9]{4}" required/><br />
            <br />
            <br />
            <input type="submit" name="" value="Enter" /><br />
            <br />
        </form>
            <h2>${project4AddMessage}</h2>
    </div>

	<c:import url="../templates/footer.jsp" />
    <c:set var="project4AddMessage" value="" scope="session"/>
</div>
</body>
</html>
