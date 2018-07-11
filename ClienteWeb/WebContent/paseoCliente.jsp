<%@ page import="dto.ReservaDTO"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.Iterator"%>

<!DOCTYPE html>
<html lang="en">

<head>

  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">
  <title>DOGIFY! Testeo de Plantilla</title>
  <!-- Bootstrap core CSS-->
  <link href="http://localhost:8080/ClienteWeb/vendor/bootstrap/css/bootstrap.css" rel="stylesheet">
  <!-- Custom fonts for this template-->
  <link href="http://localhost:8080/ClienteWeb/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
  <!-- Page level plugin CSS-->
  <link href="http://localhost:8080/ClienteWeb/vendor/datatables/dataTables.bootstrap4.css" rel="stylesheet">
  <!-- Custom styles for this template-->
  <link href="http://localhost:8080/ClienteWeb/css/sb-admin.css" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="http://localhost:8080/ClienteWeb/css/styles.css" />
</head>

<body class="fixed-nav sticky-footer bg-dark" id="page-top">
  <!-- Navigation-->
  <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top" id="mainNav">
   <!-- <a class="navbar-brand" href="index.html">DOGIFY!</a>-->
	<!-- <img class="selector" src="wait-128.png" alt=""> -->
	<img src="http://localhost:8080/ClienteWeb/logochico.png" 
     srcset = "http://localhost:8080/ClienteWeb/logochico.png 2x, 
             http://localhost:8080/ClienteWeb/logochico.png 768w, 
             http://localhost:8080/ClienteWeb/logochico.png 768w 2x, 
             http://localhost:8080/ClienteWeb/logochico.png 1200w, 
             http://localhost:8080/ClienteWeb/logochico.png 1200w 2x" />
    <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarResponsive">
      <ul class="navbar-nav navbar-sidenav" id="exampleAccordion">
        <li class="nav-item" data-toggle="tooltip" data-placement="right" title="Components">
          <a class="nav-link nav-link-collapse collapsed" data-toggle="collapse" href="#collapseComponents" data-parent="#exampleAccordion">
            <i class="fa fa-fw fa-wrench"></i>
            <span class="nav-link-text">Mi cuenta</span>
          </a>
          <ul class="sidenav-second-level collapse" id="collapseComponents">
            <li>
              <a href="navbar.html">Mis datos</a>
            </li>
            <li>
              <a href="cards.html">Mis perros</a>
            </li>
			<li>
              <a href="cards.html">Facturación</a>
            </li>
          </ul>
        </li>
        <li class="nav-item" data-toggle="tooltip" data-placement="right" title="Example Pages">
          <a class="nav-link nav-link-collapse collapsed" data-toggle="collapse" href="#collapseExamplePages" data-parent="#exampleAccordion">
            <i class="fa fa-fw fa-file"></i>
            <span class="nav-link-text">Reservas</span>
          </a>
    
        </li>
        <li class="nav-item" data-toggle="tooltip" data-placement="right" title="Menu Levels">
          <a class="nav-link nav-link-collapse collapsed" data-toggle="collapse" href="#collapseMulti" data-parent="#exampleAccordion">
            <i class="fa fa-fw fa-sitemap"></i>
            <span class="nav-link-text">Buscar Paseo</span>
          </a>
            </li>
          </ul>
        </li>
      </ul>
      <ul class="navbar-nav sidenav-toggler">
        <li class="nav-item">
          <a class="nav-link text-center" id="sidenavToggler">
            <i class="fa fa-fw fa-angle-left"></i>
          </a>
        </li>
      </ul>
      <ul class="navbar-nav ml-auto">
        

          <a class="nav-link" data-toggle="modal" data-target="#exampleModal">
            <i class="fa fa-fw fa-sign-out"></i>Logout</a>
			
			<a class="nav-link" data-toggle="modal" data-target="#exampleModal2">
            <i class="fa fa-fw fa-sign-out"></i>SubirFoto</a>
        
      </ul>
    </div>
  </nav>
  <div class="content-wrapper">
    <div class="container-fluid">
      <!-- Breadcrumbs-->
      <ol class="breadcrumb">
        <li class="breadcrumb-item active">SEGUIDOR DE PASEO</li>
      </ol>
      
                <div class="card mb-3">
            <div class="card-header">
              <i class="fa fa-bar-chart"></i> Datos del paseo</div>
            <div class="card-body">
              <div class="row">
             <table class="table table-borderd" id="dataTable" cellspacing="0">
                <tr>
                <%ReservaDTO reserva = (ReservaDTO) request.getAttribute("reserva"); %> 
				
                  <th><table class="table table-borered" id="dataTable"  cellspacing="0"><th><img src="http://localhost:8080/ClienteWeb/perro1.png"/></th><th><img src="http://localhost:8080/ClienteWeb/avatar1.png"/></th><tr><td align="center"><a class="btn btn-primary" href="login.html"><%=reserva.getPerro().getNombre()%></a></td><td align="center"><a class="btn btn-primary" href="login.html"><%=reserva.getPaseo().getPaseador().getNombre() %></a></td></tr></table></th>
                  <th><table class="table table-borered" id="dataTable"  cellspacing="0">
                  <tr><td>Fecha</td><td><input class="form-control" id="exampleInputName" type="text" aria-describedby="nameHelp" placeholder=<%=reserva.getPaseo().getFecha()%> readonly></td><td>Barrio</td><td><input class="form-control" id="exampleInputName" type="text" aria-describedby="nameHelp" placeholder=<%=reserva.getPaseo().getBarrio() %> readonly></td></tr>
                  <tr><td>Horario Estimado</td><td><input class="form-control" id="exampleInputName" type="text" aria-describedby="nameHelp" placeholder=<%=reserva.getPaseo().getHorarioInicio() %> readonly></td><td>Retiro</td><td><input class="form-control" id="exampleInputName" type="text" aria-describedby="nameHelp" placeholder=<%=reserva.getHoraRetiro() %> readonly></td></tr>
                  <tr><td>Fin Estimado</td><td><input class="form-control" id="exampleInputName" type="text" aria-describedby="nameHelp" placeholder="<%=reserva.getPaseo().getHorarioFin() %>" readonly></td><td>Regreso</td><td><input class="form-control" id="exampleInputName" type="text" aria-describedby="nameHelp" placeholder=<%=reserva.getHoraDevolucion() %> readonly></td></tr>
                  <tr><td>Estado</td><td><input class="form-control" id="exampleInputName" type="text" aria-describedby="nameHelp" placeholder="<%=reserva.getEstado() %>" readonly></td><td></td><td><table class="table table-borered" id="dataTable"  cellspacing="0"><th><a href="#photos"><img align="center" src="http://localhost:8080/ClienteWeb/camara.png" witdh=50 height=50/></th> <th>    <a href="#map"><img align="center" src="http://localhost:8080/ClienteWeb/ubicacion.png" witdh=50 height=50/>    </th></table> </tr>
                  </table>
                  </th>
                </tr>
                </table>
               
              </div>
            </div>
            
      	</div>

          <div class="card mb-3">
            <div class="card-header">
              <i class="fa fa-bar-chart"></i> Ubicacion Actual</div>
            <div class="card-body2" id="map" width="100" height="400"></div>
                <script>
      // Note: This example requires that you consent to location sharing when
      // prompted by your browser. If you see the error "The Geolocation service
      // failed.", it means you probably did not give permission for the browser to
      // locate you.

      function initMap() {
        var map = new google.maps.Map(document.getElementById('map'), {
          center: {lat: -34.6036844, lng: -58.3815591},
          zoom: 16
		  
		  
        });
		var infoWindow = new google.maps.InfoWindow({map: map});

       
        // Try HTML5 geolocation.
        if (navigator.geolocation) {
          navigator.geolocation.getCurrentPosition(function(position) {
            var pos = {
              lat: position.coords.latitude,
              lng: position.coords.longitude
            };
			
            infoWindow.setPosition(pos);
            infoWindow.setContent('Esteban');
            map.setCenter(pos);
          }, function() {
            handleLocationError(true, infoWindow, map.getCenter());
          });
        } else {
          // Browser doesn't support Geolocation
          handleLocationError(false, infoWindow, map.getCenter());
        }
      }

      function handleLocationError(browserHasGeolocation, infoWindow, pos) {
        infoWindow.setPosition(pos);
        infoWindow.setContent(browserHasGeolocation ?
                              'Error: The Geolocation service failed.' :
                              'Error: Your browser doesn\'t support geolocation.');
							  
      }
    </script>
    <script async defer
    src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDkBgIxRpAnjSJS4WeovRC4kiriTxrpD6A&callback=initMap">
    </script>
            <div class="card-footer small text-muted">Updated yesterday at 11:59 PM</div>
            </div>
            
            <div class="card mb-3" id="photos">
            <div class="card-header"id="photos">
              <i class="fa fa-bar-chart"></i> Fotos del paseo</div>
            
        <div class="slider-holder">
        <span id="slider-image-1"></span>
        <span id="slider-image-2"></span>
        <span id="slider-image-3"></span>
        <div class="image-holder">
        	<%for(String foto : reserva.getPaseo().getFotos()) {%>
            <img src=<%=foto %> class="slider-image" />
            <%}%>
        </div>
        <div class="button-holder">
            <a href="#slider-image-1" class="slider-change"></a>
            <a href="#slider-image-2" class="slider-change"></a>
            <a href="#slider-image-3" class="slider-change"></a>
        </div>
    </div>

            


    </div>
    <!-- /.container-fluid-->
    <!-- /.content-wrapper-->
    <footer class="sticky-footer">
      <div class="container">
        <div class="text-center"> 
          <small>Copyright © Dogify! 2018</small>
        </div>
      </div>
    </footer>
    <!-- Scroll to Top Button-->
    <a class="scroll-to-top rounded" href="#dataTable">
      <i class="fa fa-angle-up"></i>
    </a>
    <!-- Logout Modal-->
    <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
      <div class="modal-dialog" role="document">
        <div class="modal-content">
          <div class="modal-header">
            <h5 class="modal-title" id="exampleModalLabel">Listo para irte?</h5>
            <button class="close" type="button" data-dismiss="modal" aria-label="Close">
              <span aria-hidden="true">×</span>
            </button>
          </div>
          <div class="modal-body">Click en logout para finalizar tu sesión!</div>
          <div class="modal-footer">
            <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancelar</button>
            <a class="btn btn-primary" href="login.html">Logout</a>
          </div>
        </div>
      </div>
    </div>
	
	    <div class="modal fade" id="exampleModal2" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
      <div class="modal-dialog" role="document">
        <div class="modal-content">
          <div class="modal-header">
            <h5 class="modal-title" id="exampleModalLabel">Foto?</h5>
            <button class="close" type="button" data-dismiss="modal" aria-label="Close">
              <span aria-hidden="true">×</span>
            </button>
          </div>
          <div class="modal-body"><input accept="image/*"  type="file" capture/></div>
          <div class="modal-footer">
            <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancelar</button>
            <a class="btn btn-primary" href="login.html">Subir!</a>
          </div>
        </div>
      </div>
    </div>
    <!-- Bootstrap core JavaScript-->
    <script src="http://localhost:8080/ClienteWeb/vendor/jquery/jquery.min.js"></script>
    <script src="http://localhost:8080/ClienteWeb/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
    <!-- Core plugin JavaScript-->
    <script src="http://localhost:8080/ClienteWeb/vendor/jquery-easing/jquery.easing.min.js"></script>
    <!-- Page level plugin JavaScript-->
    <script src="http://localhost:8080/ClienteWeb/vendor/chart.js/Chart.min.js"></script>
    <script src="http://localhost:8080/ClienteWeb/vendor/datatables/jquery.dataTables.js"></script>
    <script src="http://localhost:8080/ClienteWeb/vendor/datatables/dataTables.bootstrap4.js"></script>
    <!-- Custom scripts for all pages-->
    <script src="http://localhost:8080/ClienteWeb/js/sb-admin.min.js"></script>
    <!-- Custom scripts for this page-->
    <script src="http://localhost:8080/ClienteWeb/js/sb-admin-datatables.min.js"></script>
    <script src="http://localhost:8080/ClienteWeb/js/sb-admin-charts.min.js"></script>
    
	<script src="http://localhost:8080/ClienteWeb/script.js"></script>
	
  </div>
</body>

</html>

