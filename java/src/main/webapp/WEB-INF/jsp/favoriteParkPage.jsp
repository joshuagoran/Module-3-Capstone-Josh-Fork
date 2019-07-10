<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:import url="/WEB-INF/jsp/common/header.jsp" />
<table>
<c:forEach var="surveyResult" items="${surveyResults}">
		<tr>
			<td>${surveyResult.parkname}</td>
			<td>${surveyResult.count}</td>
		</tr>
</c:forEach>
</table>
<c:import url="/WEB-INF/jsp/common/footer.jsp" />