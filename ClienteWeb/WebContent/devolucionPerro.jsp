<%@ page import="dto.ReservaDTO"%>

<%@ page import="dto.PaseoDTO"%>
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
        <li class="breadcrumb-item active">Confirm�s la devoluci�n al due�o?</li>
      </ol>
      
                <div class="card mb-3">
            <div class="card-header">
              <i class="fa fa-bar-chart"></i> C�mo abona?</div>
            <div class="card-body">
            <div class="table-responsive">
              <div class="row">
               <%ReservaDTO reserva = (ReservaDTO) request.getAttribute("reserva"); %> 
               
               <%PaseoDTO paseo = (PaseoDTO) request.getAttribute("paseo"); %>
              <table class="table table-borde1red" id="dataTable" align="center" cellspacing="0"><td align="center"><img src="<%=reserva.getPerro().getAvatar() %>" align="center"/></td><td align="center"><img src="<%=reserva.getCliente().getAvatar() %>"/></td><tr><td align="center"><a class="btn btn-primary" href="#"><%=reserva.getPerro().getNombre()%></a></td><td align="center"><a class="btn btn-primary" href="#"><%=reserva.getCliente().getNombre() %></a></td></tr></table>
             <table class="table table-borde1red" id="dataTable" cellspacing="0">
                 
                
                <tr>
               
				
                  <th></th>
                  <th><table class="table table-bordered" id="dataTable"  cellspacing="0">
                  <tr><td>Fecha</td><td><input class="form-control" id="exampleInputName" type="text" aria-describedby="nameHelp" placeholder=<%=reserva.getPaseo().getFecha()%> readonly></td></tr>
                  <tr><td>Importe a abonar: </td><td><input class="form-control" id="exampleInputName" type="text" aria-describedby="nameHelp" placeholder=<%=reserva.getPaseo().getTarifa() %> readonly></td></tr>
                  
                  <tr>
                  <td> 
                  <form action="http://localhost:8080/ClienteWeb/servlets/ServletModuloPaseos" method="post" id="devolucionPerro"">
                  <input type="hidden" name="idReserva" value="<%=reserva.getIdReserva() %>">
                  <input type="hidden" name="idPaseo" value="<%=paseo.getIdPaseo()%>">
                  <input type="hidden" name="action" value="confirmarDevolucionPago">
            	  <input type="submit" class="btn btn-primary" align=center name="loginUsuarios" value="Paga en efectivo"> 
            	  </form>
            	  </td>
            	  
            	   <td> 
                  <form action="http://localhost:8080/ClienteWeb/servlets/ServletModuloPaseos" method="post" id="devolucionPerro"">
                  <input type="hidden" name="idReserva" value="<%=reserva.getIdReserva() %>">
                  <input type="hidden" name="idPaseo" value="<%=paseo.getIdPaseo()%>">
                  <input type="hidden" name="action" value="confirmarDevolucion">
            	  <input type="submit" class="btn btn-primary" align=center name="loginUsuarios" value="Paga mas tarde"> 
                   </form>
                   </td>
                   
                   <td> 
                  <form action="http://localhost:8080/ClienteWeb/servlets/ServletModuloPaseos" method="post" id="devolucionPerro"">
                  
                  <input type="hidden" name="idPaseo" value="<%=paseo.getIdPaseo()%>">
                  <input type="hidden" name="action" value="paseoPaseador">
            	  <input type="submit" class="btn btn-primary" align=center name="loginUsuarios" value="Cancelar"> 
                   </form>
                   </td>
                   
                   </tr>
                   
                  </table>
                  </th>
                </tr>
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
              <span aria-hidden="true">�</span>
            </button>
          </div>
          <div class="modal-body">Click en logout para finalizar tu sesi�n!</div>
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
              <span aria-hidden="true">�</span>
            </button>
          </div>
          <div class="modal-body"><input accept="image/*"  type="file" capture/></div>
          <div class="modal-footer">
            <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancelar</button>
            
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

