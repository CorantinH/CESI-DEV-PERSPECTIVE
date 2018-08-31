<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Créer un post </title>
<link type="text/css" rel="stylesheet" href="<c:url value="/css/topicIn.css"/>" />
</head>
<body>
<h2> Créer ton post! </h2>
  <form method="get" action="<c:url value="/creationReponse"/>">
                    <label for="Login">Pseudo <span class="requis">*</span></label>
                    <input type="text" id="Login" name="Login" value="" size="10" maxlength="50" />
                    <br />                 
                    Message
                    <br />  
                    <textarea rows="4" cols="50" name="comment" form="usrform"> Entrez votre message</textarea>
                    <br/>
                 	Catégorie <br> 
                 	<SELECT name="categ" size="1">
						<OPTION>HTML/CSS
						<OPTION>Java
						<OPTION>C#
						<OPTION>PHP
						<OPTION>Issou
						</SELECT>
						<br />
                <input type="submit" value="Valider"  />
                <input type="reset" value="Remettre à zéro" /> <br />
            </form>
</body>
</html>