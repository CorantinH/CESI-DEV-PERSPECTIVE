<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Créer un post</title>
		<link rel="stylesheet" href="<c:url value="/css/discussion.css"/>" />
	</head>
	<body>
		<h2>Créer ton topic !</h2>
		<form method="post" action="<c:url value="/newTopic" />">
			<label for="auteur"> Pseudo </label>
			<input type="text" id="auteur" name="auteur" size="10" maxlength="50" required />
			
			<label for="sujet"> Sujet </label>
			<input type="text" id="sujet" name="sujet" size="10" maxlength="50" required />
			
			<label for="contenu"> Message </label>
			<textarea rows="4" cols="50" id="contenu" name="contenu" placeholder="Entrez votre message" required></textarea>
			
			<label for="categorie"> Catégorie </label>
			<select id="categorie" name="categorie" required>
				<c:forEach items="${ categories }" var="categorie">
					<c:choose>
						<c:when test="${ categorie.id == selectedCategorie }">
							<option value="<c:out value="${ categorie.id }" />" selected> <c:out value="${ categorie.libelle }" /> </option>
						</c:when>
						<c:otherwise>
							<option value="<c:out value="${ categorie.id }" />"> <c:out value="${ categorie.libelle }" /> </option>
						</c:otherwise>
					</c:choose>
				</c:forEach>
			</select>
			
			<input type="reset" value="Remettre à zéro" />
			<input type="submit" value="Valider" />
		</form>
	</body>
</html>