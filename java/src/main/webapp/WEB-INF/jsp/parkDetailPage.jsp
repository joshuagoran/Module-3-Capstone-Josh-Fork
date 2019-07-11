<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:import url="/WEB-INF/jsp/common/header.jsp" />

<h1>${park.parkname}</h1>

<c:url value="img/parks/${park.parkcode.toLowerCase()}.jpg"
	var="parkImageURL" />
<img src="${parkImageURL}" />


<div class="weather">
<c:forEach var="eachWeather" items="${weatherList}" varStatus="loop">
	
	
	<div class="weather-lg">
		<c:if test="${loop.first}">
			<h3>TODAY</h3>
			<c:url value="img/weather/${eachWeather.forecast}.png"
				var="weatherImageURL" />
			<img src="${weatherImageURL}" />
			<p>High: ${eachWeather.high}</p>
			<p>Low: ${eachWeather.low}</p>
		</c:if>
	</div>

	<div class="weather-sm">
		<c:if test="${not loop.first}">
			<c:url value="img/weather/${eachWeather.forecast}.png"
				var="weatherImageURL" />
			<img src="${weatherImageURL}" />
			<p>High: ${eachWeather.high}</p>
			<p>Low: ${eachWeather.low}</p>
		</c:if>
	</div>
</c:forEach>
</div>

<c:import url="/WEB-INF/jsp/common/footer.jsp" />