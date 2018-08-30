<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Créer un post </title>
</head>
<body>
 <form method="get" action="<c:url value="/creationReponse"/>">
                    <label for="Login">Pseudo <span class="requis">*</span></label>
                    <input type="text" id="Login" name="Login" value="" size="10" maxlength="50" />
                    <br />                 
                    Message
                    <br />  
                    <textarea rows="4" cols="50" name="comment" form="usrform"> Entrez votre réponse</textarea>
                    <br/>
					<label for="Date">Date <span class="requis">*</span></label>
                    <input type="text" id="Date" name="Date" value="" size="10" maxlength="10" />
                    <br />
                 	Catégorie <br> 
                 	<SELECT name="categ" size="1">
						<OPTION>HTML/CSS
						<OPTION>Java
						<OPTION>C#
						<OPTION>PHP
						<OPTION>Issou
						</SELECT>
                <input type="submit" value="Valider"  />
                <input type="reset" value="Remettre à zéro" /> <br />
            </form>
</body>
</html>