<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link href="https://fonts.googleapis.com/css?family=Russo+One|Cinzel|DM+Serif+Display|Dancing+Script|Indie+Flower|Lobster|Pacifico|Permanent+Marker|Righteous|Teko&display=swap" rel="stylesheet">
	<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
	<link href="<c:url value="/css/site.css"/>" rel="stylesheet" type="text/css" />
	<meta charset="UTF-8">
	<title>National Park Geek</title>
</head>
<body>
	<img id="header-logo" src="img/logo.png">

	<nav class="navbar navbar-default">
		<div class="container-fluid">
			<ul class="nav navbar-nav">
				<li><a href="home">Home</a></li>
				<li><a href="survey">Survey</a></li>
				<li><a href="favoriteParks">Favorite Parks</a></li>
			</ul>
		</div>
	</nav>