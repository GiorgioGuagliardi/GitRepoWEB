<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>

	
	<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
	
	<link rel="stylesheet" href="css/profilePage.css" type="text/css"/>
	<script src="/js/profilePage.js"></script>
	<jsp:include page="./navbar.jsp" />
	
	
	<meta charset="utf-8">
	
	<title>Insert title here</title>
</head>


<body>
	<div id="principale" class="container-fluid">
		<div class="row">
			<div class="col-sm-4">
				<h2 id="profilo" onclick="changeItBack()">Profilo</h2>
				<hr><br>
				<h2><a href="doLogout">Logout</a></h2>
				<hr><br>
				<c:if test="${permessiUtente >= 2}">
					<h2 id="classificaButton" onclick="changeIt()">Classifica</h2>
				</c:if>
			</div>
			<div class="col-sm-8">
				<div class="card" id="cartaProfilo">
        			<div class="top-container"> <img src="images/dodo5.png" class="img-fluid profile-image">
            			<div class="ml-3">
                			<h5 class="mail">"${user}"</h5>
            			</div>
        			</div>
        			<div class="middle-container d-flex justify-content-between align-items-center mt-3 p-2">
            			<div class="d-flex flex-column text-right mr-2"> 
            				<span class="current-balance">Versione segreta:</span>
            				<c:if test="${permessiUtente >= 2}">
            					<span class="attivo">attiva</span>
            				</c:if>
            				<c:if test="${permessiUtente < 2}">
            					<span class="attivo">non attiva</span>
            				</c:if>
            			</div>
        			</div>
        			<ul>
                    	<li class="nome">Nome: "${nome}"</li>
           	        	<li class="cognome">Cognome: "${cognome}"</li>
                        <li class="username">Username: "${username}"</li>	                           
	               </ul>
	               
    			</div>
				<table class="table" id="classifica" style="visibility:hidden;">
					<thead>
		      			<tr>
							<th>User</th>
							<th>Punteggio</th>
					   	</tr>
					</thead>
					<tbody>
						<c:forEach var="utentePunteggio" items="${utentiPunteggi}">
							<tr>
						    	<td>${utentePunteggio.utente}</td>
						        <td>${utentePunteggio.punteggio}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</body>

	<jsp:include page="./footer.jsp" /> 
</html>