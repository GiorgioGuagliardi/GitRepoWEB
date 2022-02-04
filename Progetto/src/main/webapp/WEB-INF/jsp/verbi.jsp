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
	
	<link rel="stylesheet" href="css/verbi.css" type="text/css"/>
	<script src="/js/api.js"></script>
	<jsp:include page="./navbar.jsp" />
	
	
	
	<meta charset="utf-8">
	
	<title>Insert title here</title>
</head>


<body>
	<div id="info" class="container-fluid">
	  <input type="hidden" id="search" name="search" value="english verbs">
	  <div class="row">
	    <div class="col-sm-2">
	      <img class="rounded" src="images/dodo1.png">
	    </div>
	    <div class="col-sm-10">
	      <h1>I Verbi</h1><br>
	      <h3>Queste sono le schede che il Dodo ti offre per iniziare lo sudio dei verbi!</h3><br>
	      <h5> I verbi sono parole che rappresentano <strong>azioni, occorrenze o stati di essere.</strong> Quasi ogni frase richiede un verbo, e la loro coniugazione dipeende da: <strong>chi compie l'azione, il modo in cui l'azione si compie e il tempo nel quale avviene l'azione</strong>.</h5>
	      <h5>Come nell'italiano le persone sono 3 e ciascuna ha 2 numeri, <strong>singolare e plurale</strong>. Ma a differenza dell'italiano, <strong>il soggetto deve essere sempre espresso</strong> perchè in genere i verbi subiscono poche modifichenella coniugazione.</h5>
	    </div>
	  </div>
    </div>
  
  <div id="principale" class="container-fluid">
  	<div class="row">
  			<div class="media border p-5" id="schede">
  				<div class="row row-cols-1 row-cols-md-3">
					<c:forEach var="argomento" items="${verbi}">
					  	<!-- Card -->
						<div class="card mb-4">
							<!-- Card image -->
							<div class="view overlay">
								<img class="card-img-top" src="${argomento.urlImmagine}" alt="Card image cap">
							</div>
							<div class="card-body">
								<h4 class="card-title">${argomento.titolo}</h4>
								<p class="card-text">"${argomento.descrizione}"</p>
								<form id="formGetArgomento" method="post" action="getArgomento">
									<input type="hidden" id="id" name="id" value="${argomento.id}">                 
									<button type="submit" class="btn btn-sm btn-outline-info" style="float:right">Visualizza</button> 
								</form>
								<c:if test="${permessiUtente == 3}">
									<form id="formGetArgomento" method="post" action="getArgomentoModificaElimina">
										<input type="hidden" id="id" name="id" value="${argomento.id}">                 
										<button type="submit" class="btn btn-sm btn-outline-info" style="float:right">Modifica</button> 
									</form>
								</c:if>
							</div>
						</div>
					 </c:forEach>
					 <c:if test="${permessiUtente >= 2}">
					 	<c:forEach var="argomentoPro" items="${verbiPro}">
					  	<!-- Card -->
						<div class="card mb-4">
							<!-- Card image -->
							<div class="view overlay">
								<img class="card-img-top" src="${argomentoPro.urlImmagine}" alt="Card image cap">
							</div>
							<div class="card-body">
								<h4 class="card-title" style="color:#e1ad01">${argomentoPro.titolo}</h4>
								<p class="card-text">"${argomentoPro.descrizione}"</p>
								<form id="formGetArgomento" method="post" action="getArgomento">
									<input type="hidden" id="id" name="id" value="${argomentoPro.id}">                 
									<button type="submit" class="btn btn-sm btn-outline-info" style="float:right">Visualizza</button> 
								</form>
								<c:if test="${permessiUtente == 3}">
									<form id="formGetArgomento" method="post" action="getArgomentoModificaElimina">
										<input type="hidden" id="id" name="id" value="${argomentoPro.id}">                 
										<button type="submit" class="btn btn-sm btn-outline-info" style="float:right">Modifica</button> 
									</form>
								</c:if>
							</div>
						</div>
					 </c:forEach>
					 </c:if>
			  	</div>
			  </div>
  	</div>
  	<div class="row">
		<div class="col-md-12 text-center">
			<br>
			<input type="hidden" id="search" name="search" value="verbs english lesson">                 
			<button type="submit" class="btn btn-sm btn-outline-info" style="float:center;height:50px;width:150px;" onclick="cercaVideo()">Cerca Video</button> 
			<div id="videos">
			<br>
			</div>
		</div>
  	</div> 	
  </div>
</body>

	<jsp:include page="./footer.jsp" /> 
</html>