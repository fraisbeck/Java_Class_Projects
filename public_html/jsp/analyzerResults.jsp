<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<c:set var="title" value="AnalyzerResults" scope="session"/>
<html xmlns="http://www.w3.org/1999/xhtml">
	<c:import url="../templates/headUnit4.jsp" />
<body>
<div id="wrap">

	<c:import url="../templates/header.jsp" />

	<c:import url="../templates/sidebar.jsp" />

	<div id="content">
		<h2>${success}</h2>
		<br />
		<a href="/java112/distinct_counts.txt" target="_blank">Distinct Token Counts</a>
		<br />
		<br />
		<a href="/java112/distinct_tokens.txt" target="_blank">Distinct Tokens List</a>
		<br />
		<br />
		<a href="/java112/largest_words.txt" target="_blank">Largest Words</a>
		<br />
		<br />
		<a href="/java112/lexical_density.txt" target="_blank">Lexical Density</a>
		<br />
		<br />
		<a href="/java112/summary.txt" target="_blank">File Summary</a>
		<br />
		<br />
		<a href="/java112/token_lengths.txt" target="_blank">Token Lengths</a>
		<br />
		<br />
		<a href="/java112/token_locations.txt" target="_blank">Token Locations</a>
    </div>

	<c:import url="../templates/footer.jsp" />

</div>
</body>
</html>
