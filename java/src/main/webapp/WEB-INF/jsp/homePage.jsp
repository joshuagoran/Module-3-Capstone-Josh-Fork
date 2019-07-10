<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:import url="/WEB-INF/jsp/common/header.jsp" />

<c:forEach var="park" items="${parks}">
	<div class="home">
	<div class="home-image"><a href="parkDetail?parkcode=${park.parkcode }"> <img src="img/parks/${park.parkcode}.jpg"/></a></div>
	<div class="home-text"><h2>${park.parkname}</h2>
	<p>${park.parkdescription }</p></div>
	</div>
	<hr>
</c:forEach>


<c:import url="/WEB-INF/jsp/common/footer.jsp" />