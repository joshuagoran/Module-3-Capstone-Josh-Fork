<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:import url="/WEB-INF/jsp/common/header.jsp" />

<p>check this now ${park.parkcode}</p>

<c:url value="img/parks/${park.parkcode.toLowerCase()}.jpg" var="parkImageURL" />
<img src="${parkImageURL}" />


<c:import url="/WEB-INF/jsp/common/footer.jsp" />