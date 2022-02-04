<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
  <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.3/css/all.css" integrity="sha384-UHRtZLI+pbxtHCWp1t77Bi1L4ZtiqrqD80Kn4Z8NTSRyMA2Fd33n5dQ8lWUE00s/" crossorigin="anonymous"></head>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>

  <link rel="stylesheet" href="css/index.css" type="text/css"/>	
  <jsp:include page="./navbar.jsp"/>
  <script src="/js/modificaEliminaEsercitazione.js"></script>

</head>
<body>
	<div id="principale" class="container-fluid">
		<div class="row">
			<div class="col-sm-1"></div>
			<div class="col-sm-10">
		  		<div class="myform form" id="esercitazione" style="floating:center">
		  			<form method="post" action="#" id="formEsercitazione" >
			  			<div class="form-group">
	                    	<label for="id">Id</label>
	                    	<input type="text"  name="id" class="form-control" id="id" aria-describedby="emailHelp" placeholder="id" value="${esercitazioneRichiesta.idEsercitazione}" readonly required>
	                    	<label for="urlImmagine">Url Immagine</label>
	                    	<input type="text"  name="macroargomento" class="form-control" id="urlImmagine" aria-describedby="emailHelp" placeholder="urlImmagine" value="${esercitazioneRichiesta.urlImmagine}" required>
	                    </div>
	           			<div class="col-md-12 text-center mb-3">
	                		<button type="button" class="btn btn-primary" onclick="modifica()" style="floating:center">Modifica</button>                      
	           			</div>
	           			<div class="col-md-12 text-center mb-3">
	                		<button type="button" class="btn btn-primary" onclick="elimina()" style="floating:center">Elimina</button>                      
	           			</div>                       
	           		</form>
	            </div>  
	            <div class="col-md-12 text-center mb-3">
	            	<form id="formGetEsercitazione" method="post" action="getRisposteModificaElimina">
						<input type="hidden" id="id" name="id" value="${esercitazioneRichiesta.idEsercitazione}">                 
						<button type="submit" class="btn btn-primary" style="float:center">Modifica Risposte</button> 
					</form>     
	           	</div>  		
  			</div>
			<div class="col-sm-1"></div>
		</div>
	</div>
</body>
	<jsp:include page="./footer.jsp" /> 
</html>