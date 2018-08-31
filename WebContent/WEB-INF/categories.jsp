<%@ page language="java" contentType="text/html; charset=UTF-8" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title> Liste des catégories </title>
		
		<link rel="stylesheet" href='<c:url value="/css/categories.css" />' />
	</head>
	<body>
		<section>
			<c:forEach items="${ categories }" var="categorie">
				<%-- affichage d'un cadre stylisé pour chaque catégorie --%>
				<a href="<c:url value="/forum?idCat=${ categorie.id }" />"> <c:out value="${ categorie.libelle }" /> </a>
			</c:forEach>
		</section>
	</body>
</html>