<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<c:set var="title" value="EmployeeSearchResults" scope="session"/>
<html xmlns="http://www.w3.org/1999/xhtml">
	<c:import url="../headUnit4.jsp" />
<body>
<div id="wrap">

	<c:import url="../header.jsp" />

	<c:import url="../sidebar.jsp" />

	<div id="content">

        <c:choose>
            <c:when test="${EmployeeSearchResults.getEmployeeFound()}">
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
                            <td>${employee.employeeID()}</td>
                            <td>${employee.firstName()}</td>
                            <td>${employee.lastName()}</td>
                            <td>${employee.socialSecurityNumber()}</td>
                            <td>${employee.department()}</td>
                            <td>${employee.roomNumber()}</td>
                            <td>${employee.phoneNumber()}</td>
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

	<c:import url="../footer.jsp" />

</div>
</body>
</html>
