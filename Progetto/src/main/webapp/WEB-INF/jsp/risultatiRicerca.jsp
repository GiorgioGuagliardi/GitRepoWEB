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
	
	<link rel="stylesheet" href="css/index.css" type="text/css"/>
	<jsp:include page="./navbar.jsp" />
	
	
	
	<meta charset="utf-8">
	
	<title>Insert title here</title>
</head>


<body>
<div id="principale" class="container-fluid">
	<div class="media border p-5" id="schede">
  		<div class="row row-cols-1 row-cols-md-3">
			 <c:forEach var="argomento" items="${argomenti}">
			  	<!-- Card -->
				<div class="card mb-4" style="min-width:400px">
					<!-- Card image -->
					<div class="view overlay" style="min-width:400px">
						<img class="card-img-top" src="${argomento.urlImmagine}" alt="Card image cap" style="height:650px;width: 100%;min-width:350px">
					</div>
					<div class="card-body" style="min-width:400px">
						<h4 class="card-title">${argomento.titolo}</h4>
						<p class="card-text">"${argomento.descrizione}"</p>
						<form id="formGetArgomento" method="post" action="getArgomento">
							<input type="hidden" id="id" name="id" value="${argomento.id}">                 
							<button type="submit" class="btn btn-sm btn-outline-info" style="float:right">Visualizza</button> 
						</form>
					</div>
				</div>
			</c:forEach>
			<c:if test="${permessiUtente >= 2}">
					 	<c:forEach var="argomentoPro" items="${argomentiPro}">
					  	<!-- Card -->
						<div class="card mb-4" style="min-width:400px">
							<!-- Card image -->
							<div class="view overlay">
								<img class="card-img-top" src="${argomentoPro.urlImmagine}" alt="Card image cap" style="height:650px;width: 100%;min-width:350px">
							</div>
							<div class="card-body" style="min-width:400px">
						<h4 class="card-title" style="color:#e1ad01">${argomentoPro.titolo}</h4>
						<p class="card-text">"${argomentoPro.descrizione}"</p>
						<form id="formGetArgomento" method="post" action="getArgomento">
							<input type="hidden" id="id" name="id" value="${argomentoPro.id}">                 
							<button type="submit" class="btn btn-sm btn-outline-info" style="float:right">Visualizza</button> 
						</form>
					</div>
						</div>
					 </c:forEach>
			</c:if>
			<c:if test="${permessiUtente < 2 && argomenti.size() == 0 }">
				<div class="card mb-4" style="min-width:400px">
					<!-- Card image -->
					<div class="view overlay" style="min-width:400px">
						<img class="card-img-top" src="images/dodo2.png" alt="Card image cap" style="height:550px;width: 100%;min-width:350px">
					</div>
					<div class="card-body" style="min-width:400px">
						<h4 class="card-title">Nessun argomento</h4>
						<p class="card-text">Nessun argomento trovato con la tua ricerca. Riprova!</p>
					</div>
				</div>
			</c:if>
			<c:if test="${permessiUtente >= 2 && argomentiPro.size() == 0 && argomenti.size() == 0}">
				<div class="card mb-4" style="min-width:400px">
					<!-- Card image -->
					<div class="view overlay" style="min-width:400px">
						<img class="card-img-top" src="images/dodo2.png" alt="Card image cap" style="height:550px;width: 100%;min-width:350px">
					</div>
					<div class="card-body" style="min-width:400px">
						<h4 class="card-title">Nessun argomento</h4>
						<p class="card-text">Nessun argomento trovato con la tua ricerca. Riprova!</p>
					</div>
				</div>
			</c:if>		
		</div>
  	</div>
</div>
</body>

	<jsp:include page="./footer.jsp" /> 
</html>