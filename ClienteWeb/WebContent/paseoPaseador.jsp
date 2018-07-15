<%@ page import="dto.PaseoDTO"%>
<%@ page import="dto.ReservaDTO"%>
<%@ page import="dto.FotoDTO"%>
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
  <title>DOGIFY!</title>
  <!-- Bootstrap core CSS-->
  <link href="http://localhost:8080/ClienteWeb/vendor/bootstrap/css/bootstrap.css" rel="stylesheet">
  <!-- Custom fonts for this template-->
  <link href="http://localhost:8080/ClienteWeb/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
  <!-- Page level plugin CSS-->
  <link href="http://localhost:8080/ClienteWeb/vendor/datatables/dataTables.bootstrap4.css" rel="stylesheet">
  <!-- Custom styles for this template-->
  <link href="http://localhost:8080/ClienteWeb/css/sb-admin.css" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="http://localhost:8080/ClienteWeb/css/stylesSlider.css" />
<style>
td.hiper {
 	a:visited {
	font-weight: bold;
	color:#49D658;
	}
	link {
	font-weight: bold;
	color:#49D658;
	}
	a:active {
	font-weight: bold;
	color:#49D658;
	}
	a:hover {
	font-weight: bold;
	font-size:20px;
	color:#49D658;
	}
}
</style>

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
            <div class="table-responsive">
             <table class="table table-bordered" id="datosPaseo"  width="100%" cellspacing="0">
                <tbody>
                <%PaseoDTO paseo = (PaseoDTO) request.getAttribute("paseo"); %> 
                <tr bgcolor="#49D658"><td align=center>
                <%if (paseo.getEstado().equals("PENDIENTE")){
                	%><a href="ServletModuloPaseos?action=iniciarPaseo&idPaseo=<%=paseo.getIdPaseo() %>"><img align="center" title="Iniciar paseo" src="http://localhost:8080/ClienteWeb/iniciar.png" witdh=32 height=32/></td>
                <%}else{
                %>
                	<img align="center" title="Iniciar paseo" src="http://localhost:8080/ClienteWeb/iniciarInhab.png" witdh=32 height=32/></td>
                <%}%>
                <td align=center>    
                <%if (paseo.getEstado().equals("EN CURSO")){ %>
                	<a href="ServletModuloPaseos?action=finalizarPaseo&idPaseo=<%=paseo.getIdPaseo() %>"><img align="center" title="Finalizar paseo" src="http://localhost:8080/ClienteWeb/finalizar.png" witdh=32 height=32/></td>
                <%}else{%>
                	<img align="center" title="Finalizar paseo" src="http://localhost:8080/ClienteWeb/finalizarInhab.png" witdh=32 height=32/></td>
                <%}%>
                <td align=center>
                <%if (paseo.getEstado().equals("EN CURSO")){ %>
                	<a href="#photos"><img align="center" title="Subir foto" src="http://localhost:8080/ClienteWeb/subirFoto.png" witdh=32 height=32/></td> <td align =center>    <a href="ServletModuloPaseos?action=compartirUbicacion&idPaseo=<%=paseo.getIdPaseo() %>"><img align="center" title="Compartir ubicacion" src="http://localhost:8080/ClienteWeb/compUbicacion.png" witdh=32 height=32/></tr>
                <%}else{%>
                	<img align="center" title="Subir foto" src="http://localhost:8080/ClienteWeb/subirFotoInhab.png" witdh=32 height=32/></td> <td align =center><img align="center" title="Compartir ubicacion" src="http://localhost:8080/ClienteWeb/compUbicacionInhab.png" witdh=32 height=32/></tr>
                <%}%>
                
                
                <tr>
                  <table class="table table-borered" id="dataTable"  cellspacing="0" align=center width="100%">
                  <tr><td>Fecha</td><td><input class="form-control" id="exampleInputName" type="text" aria-describedby="nameHelp" placeholder=<%=paseo.getFecha()%> readonly></td><td>Barrio</td><td><input class="form-control" id="exampleInptName" type="text"  placeholder="<%=paseo.getBarrio()%>" readonly></td></tr>
                  <tr><td>Inicio Estimado</td><td><input class="form-control" id="exampleInputName" type="text" aria-describedby="nameHelp" placeholder=<%=paseo.getHorarioInicio() %> readonly></td><td>Inicio</td><td><input class="form-control" id="exampleInputName" type="text" aria-describedby="nameHelp" placeholder=<%=paseo.getHoraInicio() %> readonly></td></tr>
                  <tr><td>Fin Estimado</td><td><input class="form-control" id="exampleInputName" type="text" aria-describedby="nameHelp" placeholder="<%=paseo.getHorarioFin() %>" readonly></td><td>Regreso</td><td><input class="form-control" id="exampleInputName" type="text" aria-describedby="nameHelp" placeholder=<%=paseo.getHoraFin() %> readonly></td></tr>
                  <tr><td>Estado</td><td><input class="form-control" id="exampleInputName" type="text" aria-describedby="nameHelp" placeholder="<%=paseo.getEstado() %>" readonly></td></tr>
                  </table>
                </tr>
                </tbody>
            </table>
               
              </div> 
           
            
      	</div>
      	
      	
      	   <div class="card mb-3" id="photos">
      	    <div class="card-header">
      	   <i class="fa fa-bar-chart"></i> Participantes</div>
          <div class="table-responsive">
            <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
              <thead>
                <tr>
                  <th>Nombre</th>
                  <th>Raza</th>
                  <th>Dueño</th>
                  <th>Direccion</th>
				  <th>Estado</th>
                  <th>Retiro</th>
                  <th>Devolucion</th>
                </tr>
              </thead>
              <tbody>
              <%
				List<ReservaDTO> reservas = paseo.getReservas();
				ReservaDTO reserva = null;
			
				if (reservas != null) {
					for (Iterator<ReservaDTO> i = reservas.iterator(); i.hasNext();) {
						reserva = i.next();
				%>
                <tr>
                  <td class="hiper"><a class="hiper" href="ServletModuloUsuarios?action=perfilPerro&idPerro=<%=reserva.getPerro().getIdPerro()%>"><%=reserva.getPerro().getNombre() %></td>
                  <td><%=reserva.getPerro().getRaza() %></td>
                  <td><%=reserva.getCliente().getNombre() %></td>
                  <td><%=reserva.getCliente().getDireccion().getDireccionFormateada() %></td>
                  <td><%=reserva.getEstado() %></td> 
				  <td><%=reserva.getHoraRetiro() %></td>
				  <td><%=reserva.getHoraDevolucion() %></td>
				  <td><table class="table table-"><th>
				  <%if (reserva.getEstado().equals("PENDIENTE") && paseo.getEstado().equals("EN CURSO")){ %>
				  	 <a href="ServletModuloPaseos?action=retirarPerro&idReserva=<%=reserva.getIdReserva()%>&idPaseo=<%=paseo.getIdPaseo()%>"><img align="center" title="Retirar perro" src="http://localhost:8080/ClienteWeb/retirar.png" witdh=30 height=30/></th>
				  <%}else{ %>
				  	 <img align="center" title="Retirar perro" src="http://localhost:8080/ClienteWeb/retirarInhab.png" witdh=30 height=30/></th>
				  <%}%>
				  <%if (reserva.getEstado().equals("RETIRADO")){ %>
				     <th><a href="ServletModuloPaseos?action=devolverPerro&idReserva=<%=reserva.getIdReserva()%>&idPaseo=<%=paseo.getIdPaseo()%>"><img align="center" title="Devolver perro" src="http://localhost:8080/ClienteWeb/devolver.png" witdh=30 height=30/></th></table></td>
				  <%}else{ %>
				     <th><img align="center" title="Devolver perro" src="http://localhost:8080/ClienteWeb/devolverInhab.png" witdh=30 height=30/></th></table></td>
				  <%}%>
                  </tr>
                <%
						}
						}
					%>
              </tbody>
            </table>
          </div>
        </div>

          <div class="card mb-3">
            <div class="card-header">
              <i class="fa fa-bar-chart"></i> Ubicacion Actual</div>
            <div class="card-body2" id="map" height="400"></div>
            
            <div class="table-responsive">
              
    <div id="map"></div>
    <script>

      function initMap() {
        var myLatLng = {lat: <%=Double.parseDouble(paseo.getUbicacionLatitud()) %>, lng: <%=Double.parseDouble(paseo.getUbicacionLongitud()) %>};

        var map = new google.maps.Map(document.getElementById('map'), {
          zoom: 15,
          center: myLatLng
        });

        var marker = new google.maps.Marker({
          position: myLatLng,
          map: map,
          title: '<%=paseo.getPaseador().getNombre() %>'
        });
      }
    </script>
    <script async defer
    src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDkBgIxRpAnjSJS4WeovRC4kiriTxrpD6A&callback=initMap">
    </script>
    </div>
            <div class="card-footer small text-muted"></div>
            </div>
            
            <div class="card mb-3" id="photos">
            <div class="card-header"id="photos">
              <i class="fa fa-bar-chart"></i> Fotos del paseo</div>
            <div class="card-body">
            <div class="table-responsive">
        
        <div class="slider-holder">
        <%
        int i = 0;
        String id = "";
        for(FotoDTO foto : paseo.getFotos()){ 
        	i+=1;
        	id = "slider-image-" + i;
        	
        %>
        	<span id="<%=id%>"></span>
        <%}
        if(i==0){ %>
        	<span id="slider-image-1"></span>
        <%}%>
        
        <div class="image-holder">
        <%for(FotoDTO foto : paseo.getFotos()){ %>
        	i +=1;
        	<img src="<%=foto.getImagen() %>" class="slider-image" />
        <%}
        if(i==0){ %>
    	<img src="http://localhost:8080/ClienteWeb/sinFotos.jpg" class="slider-image" />
    	<%}%>
        
        </div>
        <div class="button-holder">
                <%
        int j = 0;
        String id2 = "";
        for(FotoDTO foto : paseo.getFotos()){ 
        	j+=1;
        	id2 = "#slider-image-" + j;
        	
        %>
        	<a href="<%=id2%>" class="slider-change"></a>

        <%}%>
        </div>
    </div>
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
            <a class="btn btn-primary" href="ServletModuloUsuarios?action=logoutUsuarios">Logout</a>
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
          <form action="http://localhost:8080/ClienteWeb/servlets/ServletModuloPaseos" method="post" id="subirFoto" enctype="multipart/form-data">
          <div class="modal-body">
          <input accept="image/*" id="fileFoto" name="fileFoto" type="file" capture/></div>
          <div class="modal-footer">
            <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancelar</button>
            <input type="hidden" name="action" value="subirFoto">
            <input type="hidden" id="idPaseo" name ="idPaseo" value="<%=paseo.getIdPaseo() %>">
            <input type="submit" class="btn btn-primary" align=center name="subirFoto" value="Subir!">
          </div>
          </form>
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

