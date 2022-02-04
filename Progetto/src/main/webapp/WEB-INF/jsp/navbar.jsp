<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

	<!-- aggiunta icona -->
	<link rel="shortcut icon" href="images/icona.ico" type="image/x-icon" />

	<title>Find a Dodo</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">  	
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
  	<script src='https://kit.fontawesome.com/a076d05399.js'></script>

  	<link rel="preconnect" href="https://fonts.gstatic.com">
  	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link href="https://fonts.googleapis.com/css2?family=Montserrat:ital,wght@1,800&display=swap" rel="stylesheet">
	<link href="https://fonts.googleapis.com/css2?family=Kaushan+Script&display=swap" rel="stylesheet">  <!-- font-family: 'Kaushan Script', cursive; -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css"> <!-- icone bootstrap -->
  	
  	<link rel="stylesheet" href="css/navbar.css" type="text/css"/>

	<!-- accesso tramite Google -->
	<meta name="google-signin-client_id" content="382911730077-uq2rvq3d9948ongfmkt9k8v6cvl4i2l3.apps.googleusercontent.com">
    <script src="https://apis.google.com/js/platform.js" async defer></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script src="./js/apiSocial.js"></script>
  	
  	
  	<script src="/js/login.js"></script>  
  	<script src="./js/tornaSu.js"></script>

</head>
<body>
<!-- NAVBAR -->
	<script src="https://apis.google.com/js/platform.js" async defer></script>
	
    <nav class="navbar navbar-expand-sm navbar-dark bg-dark">   
        <!-- logo -->
       <a href="index" id="logo">Find A Dodo</a> 
       
        <button type="button" class="navbar-toggler" data-toggle="collapse" data-target="#navbarCollapse">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse justify-content-between" id="navbarCollapse">
            <div class="navbar-nav">             
				<a href="verbi" class="nav-item nav-link">Verbi </a> 
                <a href="vocabolario" class="nav-item nav-link">Vocabolario </a>
                <a href="grammatica" class="nav-item nav-link">Grammatica</a>                           
            </div>
            
            <form method="post" action="cerca">
             <div class="mx-auto order-0">	             			 
	   			 <div class="form-inline my-lg-0">
  					<div class="input-group "> 
  						<input class="form-control mr-sm-1" id="daCercare" name="daCercare" type="search" placeholder="Cerca" aria-label="Cerca" required>
      					<div class="input-group-append"> 
      						<button type="submit" class="btn btn-outline-warning">cerca</button>	
      					</div>
    				</div>
   			 	</div>	   			 
   			 </div>    		
   			</form>	 	 		       		
   			
   			
            <div id="modeAdmin" style="align:center; color:white">
	            <c:if test="${permessi == 2}">  <!--  se è loggato l'admin -->
		    			 Modalità Amministratore 
		    	</c:if>
            </div>	
   			
   			<div class="navbar-nav">   	
	   			<c:if test="${usernameLogged == null}">  <!--  se non c'è un username loggato mostrami il login -->
	    			<i class="loginIcon fa fa-user-circle" style="font-size:36px"  data-toggle="modal" data-target="#loginForm" ></i>  <!-- icona login  -->   
	    		</c:if>
	    		
	    		
	    		<c:if test="${usernameLogged != null}"> <!-- se c'è un username loggato -->
	    			<a class="navbar-brand" href="profilePage">
    					<i class='loginIcon fas fa-house-user' style='font-size:30px'></i>
  					</a>
	    		</c:if>   			   			                                                                                         
            </div>
            
            
        </div>
    </nav>
    
    <!-- LOGIN -->
	 <div class="modal fade" id="loginForm">
	    <div class="modal-dialog">
	      <div class="modal-content">
              
	        <!-- Modal body -->
	        <div class="modal-body">
	         	
	         	<div id="first">
					<div class="myform form ">
						 <div class="logo mb-3">
							 <div class="col-md-12 text-center">
								<button type="button" class="close" data-dismiss="modal">×</button>
								<h1 class="titolo-loginForm">Login</h1>
							 </div>
						</div>
	                   <form method="post" action="#" id="loginForm">           
	                           <div class="form-group ">
	                              <label for="exampleInputEmail1">Email</label>
	                              <input type="email" name="emailLogin"  class="form-control"  id="emailLogin" aria-describedby="emailHelp" placeholder="Inserisci email"  required>
	                           </div>
	                           <div class="form-group">
	                              <label for="exampleInputEmail1">Password</label>
	                              <input type="password" name="passwordLogin" id="passwordLogin"  class="form-control" aria-describedby="emailHelp" placeholder="Inserisci Password" required>
	                           </div>
	                           <div class="form-group">
	                              <p class="text-center">Registrandoti accetti i nostri<button style="box-shadow: none;" id="btnMostraTermini" type="button" class="btn btn-link" data-toggle="modal" data-target="#apriTermini">Termini e Condizioni d'uso</button></p>
	                           </div>
	                           <div class="col-md-12 text-center ">
	                              <button type="submit" id="btnLogin" class=" btn btn-block mybtn btn-primary tx-tfm">Login</button>
	                           </div>
	                           <div class="col-md-12 ">
	                              <div class="login-or">
	                                 <hr class="hr-or">
	                                 <span class="span-or">oppure</span>
	                              </div>
	                           </div>
	                           </form>	 
	                            <div class="row" >	
	                            	<div class="col-md-12 ">							
	                                 <div style="padding-left:35%" class="g-signin2" id="logginGoogle" data-onsuccess="accessoGoogle" onclick="ricarica()" ></div>
	                           		</div>
	                           </div>
	                           <br>
	                           <div class="form-group">
	                              <p class="text-center">Non hai un account? <a href="#" id="registrati">Registrati qui</a></p>
	                           </div>
           
					</div>
				</div>
				
			 	<div id="second">
			      <div class="myform form ">
                     <div class="logo mb-3">
                        <div class="col-md-12 text-center">
                           <button type="button" class="close" data-dismiss="modal">×</button>
                           <h1 class="titolo-loginForm">Registrati</h1>
                        </div>
                     </div>                        
                     <form method="post" action="#" id="formRegistrazione" >
                        <div class="form-group">
                           <label for="exampleInputEmail1">Nome</label>
                           <input type="text"  name="nome" class="form-control" id="nome" aria-describedby="emailHelp" placeholder="Inserisci Nome" required>
                        </div>
                        <div class="form-group">
                           <label for="exampleInputEmail1">Cognome</label>
                           <input type="text"  name="cognome" class="form-control" id="cognome" aria-describedby="emailHelp" placeholder="Inserisci Cognome" required>
                        </div>
                        <div class="form-group">
                           <label for="exampleInputEmail1">Username</label>
                           <input type="text"  name="username" class="form-control" id="username" aria-describedby="emailHelp" placeholder="Inserisci username" required>
                        </div>
                        <div class="form-group">
                           <label for="exampleInputEmail1">Email</label>
                           <input type="email" name="email"  class="form-control" id="email" aria-describedby="emailHelp" placeholder="Inserisci email" required>
                        </div>
                        <div class="form-group">
                           <label for="exampleInputEmail1">Password</label>                         
                        	<input type="password" name="password" id="password"  class="form-control" aria-describedby="emailHelp" placeholder="Inserisci Password" required pattern="^(?=.*[A-Za-z])(?=.*\d)[A-Za-z\d]{8,}$" >
                        	<p id="parametriPSW">Minimo otto caratteri, almeno una lettera maiuscola e un numero</p> 
                        </div>
						  <div class="form-group">
	                        <div class="form-check form-check-inline"> 
	                        	<label class="form-check-label" for="newsletter">Iscriviti alla newsletter</label>   						           
	        				    <input style="margin-left: 15px" type="checkbox" class="form-check-input" id="newsletter" name="newsletter" checked>
	   						 </div>
   						 </div>
                        <div class="col-md-12 text-center mb-3">
                           <button type="submit" id="btnIscriviti" class=" btn btn-block mybtn btn-primary tx-tfm">Iscriviti</button>                      
                        </div>                        
                        <div class="col-md-12 ">
                           <div class="form-group">
                              <p class="text-center"><a href="#" id="accedi">Hai gia' un account?</a></p>
                           </div>
                        </div>
                      </form>
           		   </div>
                </div>
			</div>
         </div>
      </div>
    </div>

	<button id="myBtn" title="Go to top">Top</button>
	 
	
	 <div class="modal fade" id="showErrorLogin">
	    <div class="modal-dialog">
	      <div class="modal-content">	            
	        <!-- Modal body -->
	        <div class="modal-body">	
				<div class="myform form ">
					<div class="logo mb-3">
						 <div class="col-md-12 text-center">
							<button type="button" class="close" data-dismiss="modal">×</button>
							 <br> <br>
							<h3>Password o Email errati</h3>
							 <br>
						 </div>
					</div>	                   	               
				</div>
			  </div>
			</div>
	     </div>
	 </div>  
	 
	 
	 <div class="modal fade" id="showErrorRegistrazione">
	    <div class="modal-dialog">
	      <div class="modal-content">	            
	        <!-- Modal body -->
	        <div class="modal-body">	
				<div class="myform form ">
					<div class="logo mb-3">
						 <div class="col-md-12 text-center">
							<button type="button" class="close" data-dismiss="modal">×</button>
							 <br> <br>
							<h3>email o username già in uso da un altro account</h3>
							 <br>
						 </div>
					</div>	                   	               
				</div>
			  </div>
			</div>
	     </div>
	 </div>  
	 
	 <div class="modal fade" id="showNonRegistrato">
	    <div class="modal-dialog">
	      <div class="modal-content">	            
	        <!-- Modal body -->
	        <div class="modal-body">	
				<div class="myform form ">
					<div class="logo mb-3">
						 <div class="col-md-12 text-center">
							<button type="button" class="close" data-dismiss="modal">×</button>
							 <br> <br>
							<h3>Non è stato trovato alcun utente con queste credenziali.</h3>
							 <br>
						 </div>
					</div>	                   	               
				</div>
			  </div>
			</div>
	     </div>
	 </div> 
	 
	 <div class="modal fade" id="apriTermini">
	    <div class="modal-dialog">
	      <div class="modal-content">
	             
			<!--  Modal body -->
	        <div class="modal-body">
	
				<div class="myform form ">
					<div class="logo mb-3">
						 <div class="col-md-12 text-center">
							<button type="button" class="close" data-dismiss="modal">×</button>
							 <br> <br>
							<h3 class="titolo-loginForm">Termini e Condizioni di utilizzo</h3>
							 <br>
						 </div>
					</div>
	                  <div class="row" style="padding: 10px 10px 10px">
		                  <p> Registrandoti al sito Find A Dodo decidi di accettare i termini e le condizioni di utilizzo.</p><br>
		                  <p> Gli amministratori del sito avranno accesso a dati sensibili riguardanti il tuo profilo (ad esclusione della password, inserita al momento della registrazione) e potranno decidere 
		                  		di disattivarlo nel caso si ritenesse che tu abbia violato le regole di utilizzo. 
		                  		In particolare, è SEVERAMENTE VIETATO:</p>
		                  		<ul> 
		                  			<li> Utilizzare e divulgare impropriamente il materiale presente sul sito web per scopi personali.</li>
		                  		</ul>
					   </div>   	               
				   </div>
			   </div>
		   </div>
	     </div>
	 </div>


<script src="https://smtpjs.com/v3/smtp.js"></script>
<script src="https://www.gstatic.com/firebasejs/7.17.1/firebase.js"></script>

<!-- addId Davide: 230165788590398 -->
<script>
   window.fbAsyncInit = function() {
     FB.init({
       appId            : '458096508697629',
       autoLogAppEvents : true,
       xfbml            : true,
       version          : 'v9.0'
     });
   };
</script>

<script async defer crossorigin="anonymous" src="https://connect.facebook.net/en_US/sdk.js"></script>
    

</body>
</html>