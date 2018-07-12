<%@ page import="dto.PaseadorDTO"%>
<%@ page import="dto.CalificacionDTO"%>
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
        <li class="breadcrumb-item active">DATOS DEL PASEADOR</li>
      </ol>
      
            <div class="card mb-3">
            <div class="card-header">
              <i class="fa fa-bar-chart"></i> Datos generales</div>
            <div class="card-body">
              <div class="row">
             <table class="table table-borderd" id="dataTable" cellspacing="0">
                <tr>
                <%PaseadorDTO paseador = (PaseadorDTO) request.getAttribute("paseador"); %> 
				
                  <th><table class="table table-borered" id="dataTable"  cellspacing="0"><th><img src="http://localhost:8080/ClienteWeb/avatar1.png"/></th><tr><td align="center"><a class="btn btn-primary" href="#"><%=paseador.getNombre() %></a></td></tr><tr><td align="center"><a class="btn btn-primary"  href="#"> Reputacion: <%=paseador.getReputacion() %></a></td></tr></table></th>
                  <th><table class="table table-borered" id="dataTable"  cellspacing="0">
                  <tr><td>Nombre   <input class="form-control" id="exampleInputName" type="text" aria-describedby="nameHelp" placeholder=<%=paseador.getNombre() %> readonly></td></tr>
                  <tr><td>Apellido  <input class="form-control" id="exampleInputName" type="text" aria-describedby="nameHelp" placeholder=<%=paseador.getApellido() %> readonly></td> </tr>
                  <tr><td><div class="dropdown-message small" width = 50% ><%=paseador.getPerfil() %></div></td></tr>
                  
                  </table>
                  </th>
                </tr>
                </table>
               
              </div>
            </div> 
            
      	</div>
      	
      	<div class="card mb-3">
            <div class="card-header">
              <i class="fa fa-bar-chart"></i> Reviews</div>
            <div class="card-body">
              <div class="table-responsive">
              <%List<CalificacionDTO> calificaciones = paseador.getCalificaciones(); %>
              <% for(CalificacionDTO calificacion : calificaciones){%>
              <table class="table table-nobordered" id="dataTable" cellspacing="0">
              
                  <tr>
    <td rowspan="2"><img src="http://localhost:8080/ClienteWeb/avatar1.png"/></td>
    <td>Fecha   <input class="form-control" id="exampleInputName" type="text" aria-describedby="nameHelp" placeholder=<%=calificacion.getFecha() %> readonly></td>
    <td witdh="100" rowspan="3"><%=calificacion.getComentarios() %> </td>
  </tr>
  <tr>
    <td>Puntaje  <input class="form-control" id="exampleInputName" type="text" aria-describedby="nameHelp" placeholder=<%=calificacion.getPuntaje() %> readonly></td>
  </tr>
  <tr>
    <td><a class="btn btn-primary" align=center href="login.html"><%=paseador.getNombre() %></a></td>
    <td>lalala</td>
  </tr>
                 
                  <%} %> 
                
                </table>
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

