<%@ page language="java" contentType="text/html; charset=UTF-8" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title> Liste des topics </title>
		
		<link rel="stylesheet" href='<c:url value="/css/topics.css" />' />
	</head>
	<body>
		<section>
			<c:forEach items="${ topics }" var="topic">
				<a href="<c:url value="/topic?idCat=${ categorie.id }&id=${ topic.id }" />">
					<div class="info">
						<h2> <c:out value="${ topic.sujet }" /> </h2>
						<p> par <b><c:out value="${ topic.auteur }" /></b> le <i><c:out value="${ topic.date }" /></i> </p>
					</div>
					<aside class="nbMessage">
						<c:out value="${ topic.nbMessages }" /> messages
					</aside>
				</a>
			</c:forEach>
		</section>
	</body>
</html>