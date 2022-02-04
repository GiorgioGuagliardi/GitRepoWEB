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
	
	<link rel="stylesheet" href="css/paginaArgomento.css" type="text/css"/>
	<script src="/js/argomento.js"></script> 
	 <script src="/js/api.js"></script>
	<jsp:include page="./navbar.jsp" />
	
	
	
	<meta charset="utf-8">
	
	<title>Insert title here</title>
</head>
<body>
	<div id="principale" class="container-fluid">
		<input type="hidden" id="search" name="search" value="${argomentoRichiesto.id}">
		<div class="row">
			<div class="col-sm-1"></div>
			<div class="col-sm-10">
				<div class="media border p-5" id="schede" style="max-width:750px">
	  					<img class="img-thumbnail" src="${argomentoRichiesto.urlImmagine}" style="height: 900px;width: 100%;">
	  			</div>	
			</div>
			<div class="col-sm-1"></div>
		</div>
		<br>
		<div class ="row">	
			<div class="col-sm-12 text-center">
			<c:if test="${permessiUtente >= 1}">
				<form id="formGetEsercitazione" method="post" action="getEsercitazione">
					<input type="hidden" id="id" name="id" value="${argomentoRichiesto.id}">                 
					<button type="submit" class="btn btn-sm btn-outline-info" style="float:center;height:50px;width:150px;">Esercitati</button> 
				</form>
			</c:if>
				<br>
				<input type="hidden" id="search" name="search" value="${argomentoRichiesto.id} english lesson">                 
				<button type="submit" class="btn btn-sm btn-outline-info" style="float:center;height:50px;width:150px;" onclick="cercaVideo()">Cerca Video</button> 
			</div>
		</div>
		<br>
		<div class="row">
			<div class="col-md-12 text-center">
				<div id="videos">
				</div>
			</div>
  		</div>
	</div>

</body>

	<jsp:include page="./footer.jsp" /> 
</html>