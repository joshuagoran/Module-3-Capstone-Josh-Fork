<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:import url="/WEB-INF/jsp/common/header.jsp" />
<table>
	<th><h4>Park Name</h4></th>
	<th><h4># of Faves</h4></th>
	<c:forEach var="surveyResult" items="${surveyResults}">
		<tr>
			<td><b>${surveyResult.parkname}</b></td>
			<td class="count">${surveyResult.count}</td>
		</tr>
	</c:forEach>
</table>
<c:import url="/WEB-INF/jsp/common/footer.jsp" />