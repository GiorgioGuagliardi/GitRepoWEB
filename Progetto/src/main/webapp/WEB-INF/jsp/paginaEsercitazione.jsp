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
	
	<link rel="stylesheet" href="css/paginaEsercitazione.css" type="text/css"/>
	<jsp:include page="./navbar.jsp" />
	<script src="/js/esercitazione.js"></script>
	
	
	
	<meta charset="utf-8">
	
	<title>Insert title here</title>
</head>
<body>
	<div id="principale" class="container-fluid">
  		<div class="row">
	  		<div class="col-sm-1"></div>
	  		<div class="col-sm-10">
	  			<div class="media border p-5" id="schede">
	  				<input type="hidden" id="size" name="size" value="${size}">
	  				<input type="hidden" id="argomento" name="argomento" value="${esercitazioneRichiesta.idEsercitazione}" >
	  				<input type="hidden" id="user" name="user" value="${user}">
	  				<img class="img-thumbnail" src="${esercitazioneRichiesta.urlImmagine}" style="height: 450px;width: 100%;">
	  			</div>
	  		</div>
	  		<div class="col-sm-1"></div>
  		</div>
  		<div class="row">
  			<div class="col-sm-2"></div>
  			<div class="col-sm-4">
		  			<div class="myform form" id="esercitazione" style="floating:center">
		  			<form method="post" action="#" id="formEsercitazione" >
			  			<c:forEach var="risposta" items="${risposte}">
			  				<div class="form-group">
	                           <label for="${risposta.numeroRisposta}">${risposta.numeroRisposta}</label>
	                           <input type="text"  name="${risposta.numeroRisposta}" class="form-control" id="${risposta.numeroRisposta}" aria-describedby="emailHelp" placeholder="${risposta.numeroRisposta}" required>
	                        </div>
			  			</c:forEach>
	                    <div class="col-md-12 text-center mb-3">
	                    	<button type="button" class="btn btn-primary" onclick="consegna()">Consegna</button>                      
	                    </div>                        
	            	</form>
	           		</div>     		
  			</div>
  				<div class="col-sm-4">
  					<div class="myform form" id="risposteCorrette" style="floating:center">
		  			<form method="post" action="#" id="formRisposte" >
			  			<c:forEach var="risposta" items="${risposte}">
			  				<div class="form-group">
	                        	<label for="risposta${risposta.numeroRisposta}">${risposta.numeroRisposta}</label>
	                        	<input name="risposta${risposta.numeroRisposta}" class="form-control" id="risposta${risposta.numeroRisposta}" value="${risposta.risposta}" style="visibility:hidden;">
	                        </div>
			  			</c:forEach> 
			  			<div class="col-md-12 text-center mb-3">
			  				<button type="button" id="btnVisualizza" class="btn btn-primary" data-toggle="modal" data-target="#showRisposte">Visualizza Risposte</button>
			  			</div>                                     
	            	</form>	            	
	           		</div>
	           	</div>
  			<div class="col-sm-2"></div>
  		</div>
  	</div>


	<div class="modal fade" id="showRisposte">
	    <div class="modal-dialog"> 
	      <!-- Modal content-->
	      <div class="modal-content">
	        <div class="modal-header">
	          <h4 class="modal-title">Risposte</h4>
	        </div>
	        <div class="modal-body">
	          <p>Se visualizzerai le risposte non riceverai alcun punteggio. Vuoi proseguire?</p>
	        </div>
	        <div class="modal-footer">
	          <button type="button" class="btn btn-primary" onclick="visualizzaRisposte()" data-dismiss="modal">Visualizza</button>
	          <button type="button" class="btn btn-danger" data-dismiss="modal">Chiudi</button>
	        </div>
	      </div>
	     </div>
	 	</div>
</body>

	<jsp:include page="./footer.jsp" /> 
</html>