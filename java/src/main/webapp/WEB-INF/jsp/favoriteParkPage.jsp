<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:import url="/WEB-INF/jsp/common/header.jsp" />

<c:out value="${message}"/>

<table>  
	<th></th>
	<th><h4>Park Name</h4></th>
	<th><h4># of Votes</h4></th>
	<c:forEach var="surveyResult" items="${surveyResults}">
		<tr class="favorite-parks">
			<td><a href="parkDetail?parkcode=${surveyResult.parkcode}"><img src="img/parks/${surveyResult.parkcode.toLowerCase()}.jpg"></a></td>
			<td><b>${surveyResult.parkname}</b></td>
			<td class="count">${surveyResult.count}</td>
		</tr>
	</c:forEach>
</table>
<c:import url="/WEB-INF/jsp/common/footer.jsp" />