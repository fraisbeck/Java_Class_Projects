<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<c:set var="title" value="EmployeeSearchResults" scope="session"/>
<html xmlns="http://www.w3.org/1999/xhtml">
	<c:import url="../templates/headUnit4.jsp" />
<body>
<div id="wrap">

	<c:import url="../templates/header.jsp" />

	<c:import url="../templates/sidebar.jsp" />

	<div id="content">

        <c:choose>
            <c:when test="${EmployeeSearchResults.getEmployeeFound() == true}">
                <table>
                    <h2>Search Results for ${EmployeeSearchResults.getSearchTerm()}</h2>
                    <br />
                    <tr>
                        <th>Employee ID</th>
                        <th>First Name</th>
                        <th>Last Name</th>
                        <th>Social Security Number</th>
                        <th>Department</th>
                        <th>Room Number</th>
                        <th>Phone Number</th>
                    </tr>
                    <c:forEach var="employee" items="${EmployeeSearchResults.getResults()}">
                        <tr>
                            <td>${employee.getEmployeeID()}</td>
                            <td>${employee.getFirstName()}</td>
                            <td>${employee.getLastName()}</td>
                            <td>${employee.getSocialSecurityNumber()}</td>
                            <td>${employee.getDepartment()}</td>
                            <td>${employee.getRoomNumber()}</td>
                            <td>${employee.getPhoneNumber()}</td>
                        </tr>
                    </c:forEach>
                </table>
            </c:when>
            <c:otherwise>
                <h2>Sorry, your search for ${EmployeeSearchResults.getSearchTerm()}
                    came back with nothing.</h2>
            </c:otherwise>
        </c:choose>
    </div>

	<c:import url="../templates/footer.jsp" />

</div>
</body>
</html>
