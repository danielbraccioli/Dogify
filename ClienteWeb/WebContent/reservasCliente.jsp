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
  <title>DOGIFY!</title>
  <!-- Bootstrap core CSS-->
  <link href="http://localhost:8080/ClienteWeb/vendor/bootstrap/css/bootstrap.css" rel="stylesheet">
  <!-- Custom fonts for this template-->
  <link href="http://localhost:8080/ClienteWeb/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
  <!-- Page level plugin CSS-->
  <link href="http://localhost:8080/ClienteWeb/vendor/datatables/dataTables.bootstrap4.css" rel="stylesheet">
  <!-- Custom styles for this template-->
  <link href="http://localhost:8080/ClienteWeb/css/sb-admin.css" rel="stylesheet">

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
        
        <li class="nav-item" data-toggle="tooltip" data-placement="right" title="Example Pages">
          <a class="nav-link nav-link-collapse collapsed" data-toggle="collapse" href="#collapseReservas" data-parent="#exampleAccordion">
            <i class="fa fa-fw fa-file"></i>
            <span class="nav-link-text" >Reservas </span>
          </a>
            <ul class="sidenav-second-level collapse" id="collapseReservas">
            <li>
              <a href="ServletModuloPaseos?action=reservasCliente&idCliente=1">Ver mis reservas</a>
            </li>
          </ul>
    
        </li>
        <li class="nav-item" data-toggle="tooltip" data-placement="right" title="Menu Levels">
          <a class="nav-link nav-link-collapse collapsed" data-toggle="collapse" href="#collapsePaseos" data-parent="#exampleAccordion">
            <i class="fa fa-fw fa-sitemap"></i>
            <span class="nav-link-text">Buscar Paseo</span>
          </a>
          <ul class="sidenav-second-level collapse" id="collapsePaseos">
            <li>
              <a href="ServletModuloPaseos?action=disponibilidadPaseos">Ver paseos</a>
            </li>
          </ul>
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
        <li class="breadcrumb-item active">RESERVAS</li>
      </ol>
      
      <div class="card mb-3">
      	    <div class="card-header">
      	   <i class="fa fa-bar-chart"></i>Mis reservas</div>
        
          <div class="table-responsive">
            <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
              <thead>
                <tr>
                  <th>Fecha</th>
                  <th>Inicio</th>
                  <th>Fin</th>
                  <th>Paseador</th>
				  <th>Perro</th>
                  <th>Estado</th>
                </tr>
              </thead>
              <tbody>
              <%
				List<ReservaDTO> reservas = (List<ReservaDTO>) request.getAttribute("reservas");
				ReservaDTO reserva = null;
			
				if (reservas != null) {
					for (Iterator<ReservaDTO> i = reservas.iterator(); i.hasNext();) {
						reserva = i.next();
				%>
                <tr>
                  <td><%=reserva.getPaseo().getFechaPaseoFormateada() %></td>
                  <td><%=reserva.getPaseo().getHorarioInicio() %></td>
                  <td><%=reserva.getPaseo().getHorarioFin() %></td>
                  <td><%=reserva.getPaseo().getPaseador().getNombre() %></td>
                  <td><%=reserva.getPerro().getNombre() %></td>
				  <td><%=reserva.getEstado() %></td>
				  <td><table class="table table-bordered" ><td>
				  
				  <%if (!reserva.getEstado().equals("CANCELADA")){%>
				  <a href="ServletModuloPaseos?action=paseoCliente&idReserva=<%=reserva.getIdReserva() %>"><img align="center" src="http://localhost:8080/ClienteWeb/ver.png" witdh=30 height=30/></td>
				  <%}else{%>
				  <img align="center" src="http://localhost:8080/ClienteWeb/verInhab.png" witdh=30 height=30/></td>
				  <%}
				  if((!reserva.getEstado().equals("CANCELADA")) && (reserva.getPaseo().getEstado().equals("PENDIENTE"))){
				  %>
				  <td><a href="ServletModuloPaseos?action=reservasCliente&idCliente=1"><img align="center" src="http://localhost:8080/ClienteWeb/cancelar.png" witdh=30 height=30/></td>
				  <%}else{%>
				  <td><img align="center" src="http://localhost:8080/ClienteWeb/cancelarInhab.png" witdh=30 height=30/></td>
				  <%}
				  if(reserva.getEstado().equals("PAGADO")){ %>
				  <td><a href="ServletModuloUsuarios?action=calificarPaseador&idReserva=<%=reserva.getIdReserva() %>"><img align="center" src="http://localhost:8080/ClienteWeb/calificar.png" witdh=30 height=30/></td>
				  <%}else{%>
				  <td><img align="center" src="http://localhost:8080/ClienteWeb/calificarInhab.png" witdh=30 height=30/></td>
				  <%} 
				  if(reserva.getEstado().equals("DEVUELTO")){
				  %>
				  <td><a href="#photos"><img align="center" src="http://localhost:8080/ClienteWeb/pagar.png" witdh=30 height=30/></td></table></td>
                  <%}else{%>
                  <td><img align="center" src="http://localhost:8080/ClienteWeb/pagarInhab.png" witdh=30 height=30/></td></table></td>
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
      
      </div>
    </div>
    <!-- /.container-fluid-->
    <!-- /.content-wrapper-->
    <footer class="sticky-footer">
      <div class="container">
        <div class="text-center">
          <small></small>
        </div>
      </div>
    </footer>
    <!-- Scroll to Top Button-->
    <a class="scroll-to-top rounded" href="#page-top">
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
  </div>
</body>

</html>

