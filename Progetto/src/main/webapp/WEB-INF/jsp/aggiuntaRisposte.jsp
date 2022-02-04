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
  <script src="/js/aggiuntaRisposta.js"></script>

</head>
<body>
	<div id="principale" class="container-fluid">
		<div class="row">
			<div class="col-sm-1"></div>
		  		<div class="col-sm-10">
		  		<div class="myform form" id="formEsercitazione" style="floating:center">
		  			<form method="post" action="#" id="formEsercitazione" >
			  			<div class="form-group">
	                    	<label for="numeroRisposta">Numero Risposta</label>
	                    	<input type="text"  name="numeroRisposta" class="form-control" id="numeroRisposta" aria-describedby="emailHelp" placeholder="numero risposta" required>
	                    	<label for="esercitazione">Esercitazione</label>
	                    	<input type="text"  name="esercitazione" class="form-control" id="esercitazione" aria-describedby="emailHelp" placeholder="esercitazione" required>
	                    	<label for="risposta">Risposta</label>
	                    	<input type="text"  name="risposta" class="form-control" id="risposta" aria-describedby="emailHelp" placeholder="risposta" required>
	                    	</div>
	           			<div class="col-md-12 text-center mb-3">
	                		<button type="button" class="btn btn-primary" onclick="aggiunta()" style="floating:center">Aggiungi</button>                      
	           			</div>                       
	           		</form>
	            </div> 		 		
  			</div>
			<div class="col-sm-1"></div>
		</div>
	</div>
</body>
	<jsp:include page="./footer.jsp" /> 
</html>