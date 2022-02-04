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
	  <div class="row">
	    <div class="col-sm-2">
	      <img class="rounded" src="images/dodo3.png">
	    </div>
	    <div class="col-sm-10">
	      <h1>Il Vocabolario</h1><br>
	      <h3>Questa è la sezione che Dodo vuole tu possa usare per costruire il tup primo vocabolario!</h3><br>
	      <h5>Il vocabolario consiste <strong>nell'insieme delle parole conosciute da una certa persona</strong>. E' fondamentale dunque conoscere più parole possibile ed il loro significao, altrimenti non sarebbe possibile esprimere alcun concetto, nemmeno il più semplice.</h5>
	      <h5>Per molti aspetti il vocabolario rappresenta in parole semplici <strong>il numero di parole che si conoscono</strong>, tuttavia non si limita solo a questo, poichè le parole hanno varie sfaccettature e <strong>non sempre utilizzare parole più complesse è meglio di utlizzarne di più semplici</strong>, ma certamente conoscerle è un vantaggio!</h5>
	    </div>
	  </div>
    </div>
  
  <div id="principale" class="container-fluid">
  	<div class="row">
  			<div class="media border p-5" id="schede">
  				<div class="row row-cols-1 row-cols-md-3">
					<c:forEach var="argomento" items="${vocabolario}">
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
					 	<c:forEach var="argomentoPro" items="${vocabolarioPro}">
					  	<!-- Card -->
						<div class="card mb-4">
							<!-- Card image -->
							<div class="view overlay">
								<img class="card-img-top" src="${argomentoPro.urlImmagine}" alt="Card image cap">
							</div>
							<div class="card-body">
								<h4 class="card-title" style="color:#e1ad01">${argomentoPro.titolo}</h4>
								<p class="card-text">"${argomentoPro.descrizione}"</p>
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
			<input type="hidden" id="search" name="search" value="vocabolary english lesson">                 
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