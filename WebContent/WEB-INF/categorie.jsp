<%@ page language="java" contentType="text/html; charset=UTF-8" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title> Liste des catégories </title>
		
		<link rel="stylesheet" href='<c:url value="/css/categorie.css" />' />
	</head>
	<body>
		<section>
			<c:forEach items="${ categories }" var="cat">
				<%-- affichage d'un cadre stylisé pour chaque catégorie --%>
				<a href="<c:url value="/forum?id=${ cat.id }" />"> <c:out value="${ cat.libelle }" /> </a>
			</c:forEach>
		</section>
	</body>
</html>