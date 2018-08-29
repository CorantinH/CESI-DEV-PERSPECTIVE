<%@ page language="java" contentType="text/html; charset=UTF-8" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title> Liste des topics </title>
		
		<link rel="stylesheet" href='<c:url value="/css/topic.css" />' />
	</head>
	<body>
		<section>
			<c:forEach items="${ topics }" var="top">
				<a href="/topic">
					<div class="info">
						<h2> <c:out value="${ top.sujet }" /> </h2>
						<p> par <b><c:out value="${ top.auteur }" /></b> le <i><c:out value="${ top.date }" /></i> </p>
					</div>
					<aside class="nbMessage">
						5 messages
					</aside>
				</a>
			</c:forEach>
		</section>
	</body>
</html>