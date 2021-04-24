<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
	<%@ include file="head.jsp"%>
<body>
<div id="wrap">

	<%@ include file="header.jsp"%>

	<%@ include file="sidebar.jsp"%>

	<div id="content">

        <table>
            <tr>
                <th>Name of Property</th>
                <th>Value of Property</th>
            </tr>
            <tr>
                <td>Author</td>
                <td>${properties.getProperty("author")}</td>
            </tr>
            <tr>
                <td>Author.Email.Address</td>
                <td>${properties.getProperty("author.email.address")}</td>
            </tr>
            <tr>
                <td>Course.Title</td>
                <td>${properties.getProperty("course.title")}</td>
            </tr>
            <tr>
                <td>Course.Meeting.Days</td>
                <td>${properties.getProperty("course.meeting.days")}</td>
            </tr>
            <tr>
                <td>Instructor.Name</td>
                <td>${properties.getProperty("instructor.name")}</td>
            </tr>
            <tr>
                <td>Project.Description</td>
                <td>${properties.getProperty("project.description")}</td>
            </tr>
        </table>

    </div>

	<%@ include file="footer.jsp"%>

</div>
</body>
</html>
