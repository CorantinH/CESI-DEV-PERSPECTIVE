<%@ page language="java" contentType="text/html; charset=UTF-8" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title> Liste des forums </title>
		
		<link rel="stylesheet" href='<c:url value="/css/categorie.css" />' />
	</head>
	<body>
		<section class="liste">
			<c:forEach items="${ categories }" var="cat">
				<article class="forum">
					<h2> <c:out value="${ cat.libelle }" /> </h2>
				</article>
			</c:forEach>
		</section>
	</body>
</html>