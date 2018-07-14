<%@ page import="java.util.Calendar"%>
<%@ page import="java.util.Date"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.Iterator"%>
<%@ page import="dto.PaseoDTO"%>
<%@ page import="java.text.SimpleDateFormat"%>
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
<style>
* {box-sizing: border-box;}
ul {list-style-type: none;}


.month {
    padding: 50px 10px;
    padding-top: 0px;
    width: 100%;
    height: 10px;
    background: #49D658;
    text-align: center;
}

.month ul {
    margin: 0;
    padding: 0;
}

.month ul li {
    color: white;
    font-size: 20px;
    text-transform: uppercase;
    letter-spacing: 10px;
    padding-top: 10px;
}

.month .prev {
    float: left;
    padding-top: 10px;
}

.month .next {
    float: right;
    padding-top: 10px;
}

.weekdays {
    margin: 0;
    padding: 10px 0;
    background-color: #ddd;
}

.weekdays li {
    display: inline-block;
    width: 13.6%;
    color: #666;
    text-align: center;
}

.days {
    padding: 10px 0;
    background: #eee;
    margin: 0;
}

.days li {
    list-style-type: none;
    display: inline-block;
    width: 13.6%;
    text-align: center;
    margin-bottom: 5px;
    font-size:12px;
    color: #777;
}

.days li .active {
    padding: 5px;
    background: #49D658;
    color: white !important

}

 	a:visited {
	
	color:#FFFFFF;
	}
	a:link {
	
	color:#FFFFFF;
	}
	a:active {
	
	color:#FFFFFF;
	}
	a:hover {
	font-size:20px;
	color:#FFFFFF;
	}

/* Add media queries for smaller screens */
@media screen and (max-width:720px) {
    .weekdays li, .days li {width: 13.1%;}
}

@media screen and (max-width: 420px) {
    .weekdays li, .days li {width: 12.5%;}
    .days li .active {padding: 2px;}
}

@media screen and (max-width: 290px) {
    .weekdays li, .days li {width: 12.2%;}
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
          <a class="nav-link nav-link-collapse collapsed" data-toggle="collapse" href="#collapseCuenta" data-parent="#exampleAccordion">
            <i class="fa fa-fw fa-wrench"></i>
            <span class="nav-link-text">Mi cuenta</span>
          </a>
          <ul class="sidenav-second-level collapse" id="collapseCuenta">
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
        <li class="breadcrumb-item active">RESERVAR UN PASEO</li>
      </ol>

        <div class="card-body">
          

<div class="card mb-3">
            <div class="card-header">
              <i class="fa fa-bar-chart"></i> Calendario de Disponibilidad</div>
            
<div class="month">      
  <ul>
  
    <li class="prev" >&#10094; </li>
    <li class="next">&#10095;</li>
    <li>
      Julio - 
      <span style="font-size:18px">2018</span>
    </li>
  </ul>
</div>

<ul class="weekdays">
  <li>Do </li>
  <li>Lu</li>
  <li>Ma</li>
  <li>Mi</li>
  <li>Ju</li>
  <li>Vi</li>
  <li>Sa</li>
  
</ul>

<ul class="days">  
	<%Calendar cal = Calendar.getInstance();
	// 1 de septiembre
//int mes = Integer.parseInt((String)request.getAttribute("mes"));
	//mes -=1;
	//int year = Integer.parseInt((String)request.getAttribute("anio"));
	cal.set(Calendar.DATE, 1);
	cal.set(Calendar.MONTH, 6);
	cal.set(Calendar.YEAR, 2018);
	%>
 <%if ((cal.get(Calendar.DAY_OF_WEEK) -1) == 0){ %>

 <%}else{%>
 	<%if ((cal.get(Calendar.DAY_OF_WEEK) -1) == 1){ %>
 		<li></li>
 	<%}else{%>
 		<%if ((cal.get(Calendar.DAY_OF_WEEK) -1) == 2){ %>
 			<li></li>
 			<li></li>
 		<%}else{%>
 			<%if ((cal.get(Calendar.DAY_OF_WEEK) -1) == 3){ %>
 				<li></li>
 				<li></li>
 				<li></li>
 			<%}else{%>
 				<%if ((cal.get(Calendar.DAY_OF_WEEK) -1) == 4){ %>
 					<li></li>
 					<li></li>
 					<li></li>
 					<li></li>
 				<%}else{%>
 					<%if ((cal.get(Calendar.DAY_OF_WEEK) -1) == 5){ %>
 						<li></li>
 						<li></li>
 						<li></li>
 						<li></li>
 						<li></li>
 					<%}else{%>
 						<%if ((cal.get(Calendar.DAY_OF_WEEK) -1) == 6){ %>
  							<li></li>
 							<li></li>
 							<li></li>
 							<li></li>
 							<li></li>
 							<li></li>
 						<%} %>
 					<%} %>
 				<%} %>
 			<%} %>
 		<%} %>
 	<%} %>
 <%} %>
 

 <%for(int i = 1; i <= cal.getActualMaximum(Calendar.DAY_OF_MONTH); i++){ 
 	boolean hay = false;
 	List<PaseoDTO> paseos = (List<PaseoDTO>) request.getAttribute("paseos");
 	PaseoDTO aux = null;
	 PaseoDTO paseo = null;
	 for (Iterator<PaseoDTO> j = paseos.iterator(); j.hasNext();) {
		paseo = j.next();
 		if(paseo.getFecha().getDate() == i){ 
 			hay = true;
 			aux = paseo;
 		}else{
 			
 		}
 	}
 	if (hay==true){ %>
 		<li><span class="active"><a href="ServletModuloPaseos?action=paseosFecha&fecha=<%=aux.getFecha() %>"><%=i%></a> </span></li>
 	<%}else{%>
 		<li><%=i%></li>
 	<%}
}%>

</ul>
        </div>
      </div>
    </div>
    </div>
    
    <!-- /.container-fluid-->
    <!-- /.content-wrapper-->
    <footer class="sticky-footer">
      <div class="container">
        <div class="text-center">
          <small>Copyright © Your Website 2018</small>
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

