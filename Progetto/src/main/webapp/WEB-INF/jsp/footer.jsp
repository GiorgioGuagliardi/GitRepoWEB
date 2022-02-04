<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>

 <meta charset="ISO-8859-1">
 <link rel="stylesheet" href="css/footer.css" type="text/css"/>
 

 
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
		  <style>
		    #map{
		      height:220px;
		      width: 100 px;
		    }
		  </style>
 
 <script src="./js/api.js"></script>
 
</head>
<body>

<!-- Footer inizio -->
    <footer class="footer-section">
        <div class="container">
            <div class="row">
                <div class="col-lg-4">
                    <div class="footer-left">
                        <div align="center" class="footer-logo">
                            <a href=""><img style="margin:0px" src="images/dodo6.png" alt=""></a>
                        </div>
                        <div align="center" class="footer-social">
	                        
	                            <a href="#"><i class="fa fa-facebook"></i></a>
	                            <a href="#"><i class="fa fa-instagram"></i></a>	                        	   
	                   </div>
                    </div>
                </div>
                   
                <div class="col-lg-5" style="padding-right: 15px">
                	<div align="left" class="footer-widget">
	                	<ul>
                            <h5>Fondatore dell'Azienda:</h5>
                            <a href="https://www.instagram.com/djedjoo_/"><h5>- Guagliardi Giorgio</h5></a>
                            <li>Sedi fisiche situate in:</li>
                            <li><a href="https://it.wikipedia.org/wiki/Zumpano"> - Zumpano</a></li>
                            <li><a href="https://it.wikipedia.org/wiki/Universit%C3%A0_della_Calabria"> - Unical(Cosenza) </a></li>	                           
	                    </ul>
	               </div>
                </div>
 
         <div id="map" class="col-lg-3" style="padding-left: 15px" >
		 <script>
		  function initMap(){
		      // Map options
		      var options = {
		        zoom:12,
		        center:{lat:39.35800,lng:16.22714}
		      }
		
		      // New map
		      var map = new google.maps.Map(document.getElementById('map'), options);
		
		      // Listen for click on map
		      google.maps.event.addListener(map, 'click', function(event){
		        // Add marker
		        addMarker({coords:event.latLng});
		      });
		
		
		      // Array of markers
		      var markers = [
		        {
		          coords:{lat:39.35800,lng:16.22714},
		          iconImage:'https://developers.google.com/maps/documentation/javascript/examples/full/images/beachflag.png',
		          content:'<h2>UNICAL</h2>'
		        },
		
		      ];
		
		      // Loop through markers
		      for(var i = 0;i < markers.length;i++){
		        // Add marker
		        addMarker(markers[i]);
		      }
		
		      // Add Marker Function
		      function addMarker(props){
		        var marker = new google.maps.Marker({
		          position:props.coords,
		          map:map,
		          //icon:props.iconImage
		        });
		
		        // Check for customicon
		        if(props.iconImage){
		          // Set icon image
		          marker.setIcon(props.iconImage);
		        }
		
		        // Check content
		        if(props.content){
		          var infoWindow = new google.maps.InfoWindow({
		            content:props.content
		          });
		
		          marker.addListener('click', function(){
		            infoWindow.open(map, marker);
		          });
		        }
		      }
		    }
		  </script>
			<!--  script con key per api google maps -->
	
  <script async defer
   		 src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDXCycDoQhkrPR2ESJ8NkUcnvekAWR26V8&callback=initMap">
	</script>
  


</footer>      <!-- Footer fine -->



</body>
</html>