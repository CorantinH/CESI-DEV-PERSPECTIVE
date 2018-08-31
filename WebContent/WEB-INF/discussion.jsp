<%@ page language="java" contentType="text/html; charset=UTF-8" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title> <c:out value="${ topic.sujet }" ></c:out> </title>
		<link type="text/css" rel="stylesheet" href="<c:url value="/css/discussion.css"/>" />
	</head>
	<body>
	<h2> <c:out value="${ topic.sujet }"> </c:out> [<c:out value="${ topic.statut }"></c:out>] </h2>
			<c:forEach items="${ posts }" var="post">
					<div class="info">
						 <c:out value="${ post.contenu }" /> 
						<p> par <b><c:out value="${ post.auteur }" /></b> le <i><c:out value="${ post.date }" /></i> </p>
					</div>
			</c:forEach>
		</section>
       <c:choose>
    <c:when test="${topic.statut == 'En cours'}">
        <form method="post" action="<c:url value="/ajoutPost?idTopic=${ topic.id }"/>">
                    <label for="Login">Pseudo <span class="requis">*</span></label>
                    <input type="text" id="Login" name="auteur" value="" size="10" maxlength="50" required/>
                    <br />                 
                     <label for="Message">Message<span class="requis">*</span></label>
                    <br />  
                    <textarea rows="4" cols="50" name="contenu" required placeholder="Entrez votre réponse"></textarea>
                    <br/>
                <input type="submit" value="Valider"  />
                <input type="reset" value="Remettre à zéro" /> <br />
                <a href="<c:url value="/closeTopic?idTopic=${ topic.id }"/>"> Fermer la discussion</a>
            </form>
        <br />
    </c:when>    
    <c:otherwise>
        <h2> Discussion terminée! </h2>
        <br />
    </c:otherwise>
	</c:choose>

		<a href="javascript:history.back()">Page précédente</a>
		<a href="index"> Menu </a>
	</body>
</html>