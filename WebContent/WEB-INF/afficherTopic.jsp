<%@ page language="java" contentType="text/html; charset=UTF-8" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title> <c:out value="${ name }" ></c:out> </title>
		<link type="text/css" rel="stylesheet" href="<c:url value="/css/topicIn.css"/>" />
	</head>
	<body>
	<h2> <c:out value="${ name }"> </c:out> [<c:out value="${ status }"></c:out>] </h2>
	<div class="main"> 
		<section>
		Je comprend pas j'ai tout bien fais <br>
		<p> par <b> Corantin </b>  <i> le 30/01/2015 </i> </p>
		</div>
			<c:forEach items="${ corps }" var="top">
					<div class="info">
						 <c:out value="${ corps }" /> 
						<p> par <b><c:out value="${ author }" /></b> le <i><c:out value="${ date }" /></i> </p>
					</div>
			</c:forEach>
		</section>
       <c:choose>
    <c:when test="${status == 'En cours'}">
        <form method="get" action="<c:url value="/creationReponse"/>">
                    <label for="Login">Pseudo <span class="requis">*</span></label>
                    <input type="text" id="Login" name="Login" value="" size="10" maxlength="50" />
                    <br />                 
                     <label for="Message">Message<span class="requis">*</span></label>
                    <br />  
                    <textarea rows="4" cols="50" name="comment" form="usrform"> Entrez votre réponse</textarea>
                    <br/>
					<label for="Date">Date <span class="requis">*</span></label>
                    <input type="text" id="Date" name="Date" value="" size="10" maxlength="10" />
                    <br />
           
                <input type="submit" value="Valider"  />
                <input type="reset" value="Remettre à zéro" /> <br />
            </form>
        <br />
    </c:when>    
    <c:otherwise>
        <h2> Discussion terminée! </h2>
        <br />
    </c:otherwise>
</c:choose>
		
	</body>
</html>