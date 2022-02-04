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

</head>
<body>
  
  <div id="info" class="container-fluid">
	  <div class="row">
	    <div class="col-sm-9">
	      <h2>Dodo ti dà il benvenuto!</h2><br>
	      <h4>Il dodo di nome Dodo sarà felice di aiutarti a imparare la lingua inglese nella maniera più facile possibile</h4><br>
	      <p>In questo sito avrai la possibilità di imparare l'inglese suddiviso in 3 macro-argomenti: Verbi, Grammatica e Vocabolario, e potrai tenere conto dei tuoi progressi e perfezionare l'inglese come solo Dodo può insegnarti! Inoltre, con un piccolo sostegno, avrai la possibilità di sbloccare ancora più argomenti coi quali esercitarti!</p>
	      <br>
	      <p>Inoltre potrai comparare il tuo studio col livello di altri studiosi come te e confrontare i vostri miglioramenti</p>
	    </div>
	    <div class="col-sm-3">
	      <img class="rounded" src="images/dodo2.png">
	    </div>
	  </div>
  </div>
  
  <!-- Sezione degli articoli più venduti -->
  <div id="sezionePiuCliccati" class="container-fluid">
  <br>
  <h2 style="text-align:center"><a href="tendenze"> Gli argomenti di tendenza</a></h2> 
  <br>
  <div class="card-deck">
  <c:forEach var="argomento" items="${tendenze}">
  	<!-- Card -->
	<div class="card mb-4">
		<!-- Card image -->
		<div class="view overlay">
			<img class="card-img-top" src="${argomento.urlImmagine}" alt="Card image cap" style="height: 650px;width: 100%;">
				
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
  </div>
  
  </div>
 
 <div id="sezioneVerbi" class="container-fluid">
	 <div class="row">
	    <div class="col-sm-4">
	      <img class="rounded" src="images/dodo1.png">
	    </div>
	    <div class="col-sm-8">
	      <h2><a href="verbi">I Verbi</a></h2><br>
	      <h4>I verbi messi a disposizione dal nostro Dodo sono tutti qui, clicca per dare un'occhiata!</h4><br>
	      <p>I verbi rappresentano una parte fondamentale per costruire delle frasi ed esprimere concetti! Così Dodo ha pensato di riunire tutta la sua conoscenza a riguardo in un unico posto così che tu possa apprendere da lui!</p>	
	    </div>
  	</div>
 </div>
  
  
 <div id="sezioneVocabolario" class="container-fluid">
	  <div class="row">
	    <div class="col-sm-8">
	      <h2><a href="vocabolario">Il Vocabolario</a></h2><br>
	      <h4>Qui puoi invece trovare le prime parole che il Dodo vorrebbe tu imparassi! Perchè non gli dai un'occhiata?</h4><br>
	      <p>In questa sezione il caro Dodo vuole invece aiutarti nel creare il tuo primo vocabolario in lingua inglese! Ti verranno fornite le prime e fondamentali parole da conoscere per iniziare a costruire delle frasi.</p>
	    </div>
	    <div class="col-sm-4">
	      <img class="rounded" src="images/dodo3.png">
	    </div>
	  </div>
 </div>
 
 <div id="sezioneGrammatica" class="container-fluid">
	  <div class="row">
	    <div class="col-sm-4">
	      <img class="rounded" src="images/dodo5.png">
	    </div>
	    <div class="col-sm-8">
	      <h2><a href="grammatica">La Grammatica</a></h2><br>
	      <h4>In questa sezione troverai invece la parte che Dodo crede possa farti fare il salto di qualità!</h4><br>
	      <p>Dodo crede anche che le parole e i verbi servano a poco senza conoscere delle altre componenti che ti permettano di unire le due cose. Ecco perchè vuole che tu conosca anche la grammatica inglese, in modo che tu sia in grado di consolidare le basi dell'inglese che ti è stato fornito fin'ora.</p>
	    </div>
	  </div>
 </div>
 
 <!-- Container (Pricing Section) -->
<div id="pricing" class="container-fluid">
  <div class="text-center">
    <h2>Abbonamento</h2>
    <h4>Le sfide che il Dodo è disposto a offrirti per imparare!</h4>
    <br><br>
  </div>
  <div class="row">
    <div class="col-sm-6 col-xs-12">
      <div class="panel panel-default text-center">
        <div class="panel-heading">
          <h1>Gratis</h1>
        </div>
        <div class="panel-body">
          <p> Le migliori schede per studiare</p>
          <p><strong>1</strong> Scheda di spiegazione per argomento</p>
          <p><strong>1</strong> Esercitazione per argomento</p>
        </div>
        <div class="panel-footer">
          <h3>Completamente gratuito!</h3>
          <a href="#" title="To Top">
          	<button class="btn btn-lg">Torna su</button>
          </a>   
        </div>
      </div>      
    </div>            
    <div class="col-sm-6 col-xs-12">
      <div class="panel panel-default text-center">
        <div class="panel-heading">
          <h1>Premium</h1>
        </div>
        <div class="panel-body">
          <p><strong>Nuove schede esclusive!</strong></p>
          <p><strong>Sblocca gli "argomenti segreti" completando i vari esami</strong></p>
          <p><strong>3</strong> Nuovi argomenti da studiare</p>
          <p><strong>3</strong> Relative schede di esercitazione</p>
          <p><strong>Possibilità di scaricare le schede di esercitazione</strong></p>
          <p><strong>Confronta i tuoi risultati con quelli di altri utenti</strong></p>
          <p><strong>Ottieni l'accesso per le future lezioni di Dodo</strong></p>
        </div>
        <div class="panel-footer">
          <h3>Dimostra di essere il migliore!</h3>
          <a href="#" title="To Top">
          	<button class="btn btn-lg">Torna su</button>
          </a>   
        </div>
      </div>      
    </div>    
  </div>
</div>
<div id="aggiunteAmministratore" class="container-fluid">
	<c:if test="${permessiUtente == 3}">
		<div class="text-center">
    		<h2>Funzioni Amministratore</h2>
    		<h4>Se vuoi aggiungere delle nuove schede, puoi farlo da qui. Ricorda di inserire sempre prima l'esercitazione.</h4>
    		<br><br>
  		</div>
		<h3 style="text-align:center"><a href="aggiuntaEsercitazione">Esercitazione</a></h3>
		<h3 style="text-align:center"><a href="aggiuntaArgomento">Argomento</a></h3>
		<h3 style="text-align:center"><a href="aggiuntaRisposte">Risposte</a></h3>
	</c:if>
</div>
</body>

	<jsp:include page="./footer.jsp" /> 
</html>