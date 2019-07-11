<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:import url="/WEB-INF/jsp/common/header.jsp" />
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<jsp:useBean id="date" class="java.util.Date" />

<div>
<h1>${park.parkname}, ${park.state}</h1>
<h3>Established: ${park.yearfounded}</h3>

</div>
<c:url value="img/parks/${park.parkcode.toLowerCase()}.jpg"
	var="parkImageURL" />
<img src="${parkImageURL}" />


<div class="weather">
<c:forEach var="eachWeather" items="${weatherList}" varStatus="loop">


		<div class="weather-lg">
			<c:if test="${loop.first}">
				<h3>TODAY</h3>
				<h4><fmt:formatDate value="${date}" pattern="MM/dd"/>
				</h4>
				<c:url value="img/weather/${eachWeather.forecast}.png"
					var="weatherImageURL" />
				<img src="${weatherImageURL}" />
				<p>High: ${eachWeather.high}</p>
				<p>Low: ${eachWeather.low}</p>
				<p> FORCAST AND TEMPERATURE ADVISORY</p>
		<div class="temperatureAdvisory">
				<c:choose>
					<c:when test="${eachWeather.high > 75}">
       					With hiking and being out in the sun, we suggest you bring 
       					an extra gallon of water with you today!!
    			</c:when>
					<c:when test="${eachWeather.low < 20}">
        			It's going to get cold tonight. Bring warm clothes 
        			or risk the dangers of exposure to frigid temperatures!!
    			</c:when>
    			<c:when test="${(eachWeather.high - eachWeather.low) > 20}">
        			Be Careful!! With the variation in temperature, remember to wear breathable layers.
    			</c:when>
					<c:otherwise>
       		
    				</c:otherwise>
				</c:choose>
			</div>
		<div class="weatherAdvisory">
				<c:choose>
					<c:when test="${eachWeather.forecast == 'snow'}">
       					If it's not already snowing, it will. For your safety, rememeber to bring
       					snowshoes with you for safe traveling.
    			</c:when>
					<c:when test="${eachWeather.forecast == 'rain'}">
        				If it's not already raining, it will. We here at Clark & Josh Inc 
        				suggest that you pack rain gear and wear waterproofed shoes for those 
        				potentially slippery rocks. 
        			</c:when>
					<c:when test="${eachWeather.forecast == 'thunderstorms'}">
        				We at Clark & Josh Inc. highly suggest you don't go out in thunderstorms,
        				but if you get caught in one, seek shelter and avoid hiking on exposed ridges. 
        				
					</c:when>
					<c:when test="${eachWeather.forecast == 'sunny'}">
        				Whether its hot or not, the sun can still burn you with its UV rays. 
        				Be sure to wear and pack sunblock.
					</c:when>
					<c:otherwise>
       			 		You may or may not be able to count on the sun coming out today,
       			 		but you definitely can count on the clouds being there!!
    				</c:otherwise>
				</c:choose>
			</div>
			
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