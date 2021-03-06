<%-- 
    Document   : Entrega_avance_comentario_asesor
    Created on : 11/11/2015, 05:08:26 PM
    Author     : Lisseth
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <!-- Meta, title, CSS, favicons, etc. -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Registro de Revisi&oacute;n</title>

    <%@include file = "/WEB-INF/jsp/comun/recursos.jsp" %>

</head>


<body class="nav-md">

    <div class="container body">


        <div class="main_container">

            <div class="col-md-3 left_col">
                <div class="left_col scroll-view">

                    <!--<div class="navbar nav_title" style="border: 0;">
                        <!-- <a href="index.html" class="site_title"><i class="fa fa-paw"></i> <span>Gentellela Alela!</span></a>
                    </div>-->
                    <div class="clearfix"></div>

                    <!-- menu prile quick info -->
                    <div class="profile">
                        <div class="profile_pic">
                            <img src="<c:url value="/images/vtesis-logo.jpg"/>" alt="..." class="img-circle profile_img">
                        </div>
                        <div class="profile_info">
                            <!--<span>Welcome,</span>
                            <h2>Asesor</h2>-->
                            <br>
                        </div>
                    </div>
                    <!-- /menu prile quick info -->

                    <br />

                    <!-- sidebar menu -->
                    <div id="sidebar-menu" class="main_menu_side hidden-print main_menu">

                        <div class="menu_section">
                            <h3>V-Tesis</h3>
                            <ul class="nav side-menu">
                                <li><a><i class="fa fa-home"></i> Home <span class="fa fa-chevron-down"></span></a>
                                    <ul class="nav child_menu" style="display: none">
                                        <li><a href="<c:url value="/home.do"/>">Perfil</a>
                                        </li>
                                        <!--<li><a href="index2.html">Dashboard2</a>
                                        </li>
                                        <li><a href="index3.html">Dashboard3</a>
                                        </li>-->
                                    </ul>
                                </li>
                                <li><a><i class="fa fa-calendar"></i> Acciones <span class="fa fa-chevron-down"></span></a>
                                    <ul class="nav child_menu" style="display: none">
                                        <li><a href="Asesor-llenar-calendario.html">Llenar calendario</a>
                                        </li>
                                        
                                    </ul>
                                </li>
                               <!--  <li><a><i class="fa fa-desktop"></i> UI Elements <span class="fa fa-chevron-down"></span></a>
                                    <ul class="nav child_menu" style="display: none">
                                        <li><a href="general_elements.html">General Elements</a>
                                        </li>
                                        <li><a href="media_gallery.html">Media Gallery</a>
                                        </li>
                                        <li><a href="typography.html">Typography</a>
                                        </li>
                                        <li><a href="icons.html">Icons</a>
                                        </li>
                                        <li><a href="glyphicons.html">Glyphicons</a>
                                        </li>
                                        <li><a href="widgets.html">Widgets</a>
                                        </li>
                                        <li><a href="invoice.html">Invoice</a>
                                        </li>
                                        <li><a href="inbox.html">Inbox</a>
                                        </li>
                                        <li><a href="calender.html">Calender</a>
                                        </li>
                                    </ul>
                                </li>
                                <li><a><i class="fa fa-table"></i> Tables <span class="fa fa-chevron-down"></span></a>
                                    <ul class="nav child_menu" style="display: none">
                                        <li><a href="tables.html">Tables</a>
                                        </li>
                                        <li><a href="tables_dynamic.html">Table Dynamic</a>
                                        </li>
                                    </ul>
                                </li>
                                <li><a><i class="fa fa-bar-chart-o"></i> Data Presentation <span class="fa fa-chevron-down"></span></a>
                                    <ul class="nav child_menu" style="display: none">
                                        <li><a href="chartjs.html">Chart JS</a>
                                        </li>
                                        <li><a href="chartjs2.html">Chart JS2</a>
                                        </li>
                                        <li><a href="morisjs.html">Moris JS</a>
                                        </li>
                                        <li><a href="echarts.html">ECharts </a>
                                        </li>
                                        <li><a href="other_charts.html">Other Charts </a>
                                        </li>
                                    </ul>
                                </li>-->
                            </ul>
                        </div>
                        <!--<div class="menu_section">
                            <h3>Live On</h3>
                            <ul class="nav side-menu">
                                <li><a><i class="fa fa-bug"></i> Additional Pages <span class="fa fa-chevron-down"></span></a>
                                    <ul class="nav child_menu" style="display: none">
                                        <li><a href="e_commerce.html">E-commerce</a>
                                        </li>
                                        <li><a href="projects.html">Projects</a>
                                        </li>
                                        <li><a href="project_detail.html">Project Detail</a>
                                        </li>
                                        <li><a href="contacts.html">Contacts</a>
                                        </li>
                                        <li><a href="profile.html">Profile</a>
                                        </li>
                                    </ul>
                                </li>
                                <li><a><i class="fa fa-windows"></i> Extras <span class="fa fa-chevron-down"></span></a>
                                    <ul class="nav child_menu" style="display: none">
                                        <li><a href="page_404.html">404 Error</a>
                                        </li>
                                        <li><a href="page_500.html">500 Error</a>
                                        </li>
                                        <li><a href="plain_page.html">Plain Page</a>
                                        </li>
                                        <li><a href="login.html">Login Page</a>
                                        </li>
                                        <li><a href="pricing_tables.html">Pricing Tables</a>
                                        </li>

                                    </ul>
                                </li>
                                <li><a><i class="fa fa-laptop"></i> Landing Page <span class="label label-success pull-right">Coming Soon</span></a>
                                </li>
                            </ul>
                        </div>-->

                    </div>
                    <!-- /sidebar menu -->

                    <!-- /menu footer buttons -->
                    <div class="sidebar-footer hidden-small">
                        <!--<a data-toggle="tooltip" data-placement="top" title="Settings">
                            <span class="glyphicon glyphicon-cog" aria-hidden="true"></span>
                        </a>
                        <a data-toggle="tooltip" data-placement="top" title="FullScreen">
                            <span class="glyphicon glyphicon-fullscreen" aria-hidden="true"></span>
                        </a>
                        <a data-toggle="tooltip" data-placement="top" title="Lock">
                            <span class="glyphicon glyphicon-eye-close" aria-hidden="true"></span>
                        </a>-->
                        <a data-toggle="tooltip" data-placement="top" title="Logout">
                            <span class="glyphicon glyphicon-off" aria-hidden="true"></span>
                        </a>
                    </div>
                    <!-- /menu footer buttons -->
                </div>
            </div>

            <!-- top navigation -->
            <div class="top_nav">

                <div class="nav_menu">
                    <nav class="" role="navigation">
                        <div class="nav toggle">
                            <a id="menu_toggle"><i class="fa fa-bars"></i></a>
                        </div>

                        <ul class="nav navbar-nav navbar-right">
                            <li class="">
                                <a href="javascript:;" class="user-profile dropdown-toggle" data-toggle="dropdown" aria-expanded="false">
                                    <img src="<c:url value="/images/img.jpg"/>" alt="">Juan Perez
                                    <span class=" fa fa-angle-down"></span>
                                </a>
                                <ul class="dropdown-menu dropdown-usermenu animated fadeInDown pull-right">
                                    <li><a href="<c:url value="/home.do"/>">  Profile</a>
                                    </li>
                                    <!-- <li>
                                        <a href="javascript:;">
                                            <span class="badge bg-red pull-right">50%</span>
                                            <span>Settings</span>
                                        </a>
                                    </li>
                                    <li>
                                        <a href="javascript:;">Help</a>
                                    </li> -->
                                    <li><a href="login.html"><i class="fa fa-sign-out pull-right"></i> Log Out</a>
                                    </li>
                                </ul>
                            </li>

                            <!--<li role="presentation" class="dropdown">
                                <a href="javascript:;" class="dropdown-toggle info-number" data-toggle="dropdown" aria-expanded="false">
                                    <i class="fa fa-envelope-o"></i>
                                    <span class="badge bg-green">6</span>
                                </a>
                                <ul id="menu1" class="dropdown-menu list-unstyled msg_list animated fadeInDown" role="menu">
                                    <li>
                                        <a>
                                            <span class="image">
                                        <img src="images/img.jpg" alt="Profile Image" />
                                    </span>
                                            <span>
                                        <span>John Smith</span>
                                            <span class="time">3 mins ago</span>
                                            </span>
                                            <span class="message">
                                        Film festivals used to be do-or-die moments for movie makers. They were where... 
                                    </span>
                                        </a>
                                    </li>
                                    <li>
                                        <a>
                                            <span class="image">
                                        <img src="images/img.jpg" alt="Profile Image" />
                                    </span>
                                            <span>
                                        <span>John Smith</span>
                                            <span class="time">3 mins ago</span>
                                            </span>
                                            <span class="message">
                                        Film festivals used to be do-or-die moments for movie makers. They were where... 
                                    </span>
                                        </a>
                                    </li>
                                    <li>
                                        <a>
                                            <span class="image">
                                        <img src="images/img.jpg" alt="Profile Image" />
                                    </span>
                                            <span>
                                        <span>John Smith</span>
                                            <span class="time">3 mins ago</span>
                                            </span>
                                            <span class="message">
                                        Film festivals used to be do-or-die moments for movie makers. They were where... 
                                    </span>
                                        </a>
                                    </li>
                                    <li>
                                        <a>
                                            <span class="image">
                                        <img src="images/img.jpg" alt="Profile Image" />
                                    </span>
                                            <span>
                                        <span>John Smith</span>
                                            <span class="time">3 mins ago</span>
                                            </span>
                                            <span class="message">
                                        Film festivals used to be do-or-die moments for movie makers. They were where... 
                                    </span>
                                        </a>
                                    </li>
                                    <li>
                                        <div class="text-center">
                                            <a>
                                                <strong>See All Alerts</strong>
                                                <i class="fa fa-angle-right"></i>
                                            </a>
                                        </div>
                                    </li>
                                </ul>
                            </li>-->

                        </ul>
                    </nav>
                </div>

            </div>
            <!-- /top navigation -->

            <!-- page content -->
            <div class="right_col" role="main">
                <div class="">

                    <!--<div class="page-title">
                        <div class="title_left">
                            <h3>
                    Inbox Design
                    <small>
                        Some examples to get you started
                    </small>
                </h3>
                        </div>

                        <div class="title_right">
                            <div class="col-md-5 col-sm-5 col-xs-12 form-group pull-right top_search">
                                <div class="input-group">
                                    <input type="text" class="form-control" placeholder="Search for...">
                                    <span class="input-group-btn">
                            <button class="btn btn-primary" type="button">Go!</button>
                        </span>
                                </div>
                            </div>
                        </div>
                    </div>-->
                    <div class="clearfix"></div>

                    <div class="row">

                        <div class="col-md-12">
                            <div class="x_panel">
                                <div class="x_title">
                                    <h2>Entrega de Avance</h2>
                                    <!--<ul class="nav navbar-right panel_toolbox">
                                        <li><a href="#"><i class="fa fa-chevron-up"></i></a>
                                        </li>
                                        <li class="dropdown">
                                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false"><i class="fa fa-wrench"></i></a>
                                            <ul class="dropdown-menu" role="menu">
                                                <li><a href="#">Settings 1</a>
                                                </li>
                                                <li><a href="#">Settings 2</a>
                                                </li>
                                            </ul>
                                        </li>
                                        <li><a href="#"><i class="fa fa-close"></i></a>
                                        </li>
                                    </ul>-->
                                    <div class="clearfix"></div>
                                </div>
                                <div class="x_content">


                                    <div class="row">

                                        <!--<div class="col-sm-3 mail_list_column">

                                            <div class="mail_list">
                                                <div class="left">
                                                    <i class="fa fa-circle"></i> <i class="fa fa-edit"></i>
                                                </div>
                                                <div class="right">
                                                    <h3>Dennis Mugo <small>3.00 PM</small></h3>
                                                    <p>Ut enim ad minim veniam, quis nostrud exercitation enim ad minim veniam, quis nostrud exercitation...</p>
                                                </div>
                                            </div>
                                            <div class="mail_list">
                                                <div class="left">
                                                    <i class="fa fa-star"></i>
                                                </div>
                                                <div class="right">
                                                    <h3>Jane Nobert <small>4.09 PM</small></h3>
                                                    <p><span class="badge">To</span> Ut enim ad minim veniam, quis nostrud exercitation enim ad minim veniam, quis nostrud exercitation...</p>
                                                </div>
                                            </div>
                                            <div class="mail_list">
                                                <div class="left">
                                                    <i class="fa fa-circle-o"></i><i class="fa fa-paperclip"></i>
                                                </div>
                                                <div class="right">
                                                    <h3>Musimbi Anne <small>4.09 PM</small></h3>
                                                    <p><span class="badge">CC</span> Ut enim ad minim veniam, quis nostrud exercitation enim ad minim veniam, quis nostrud exercitation...</p>
                                                </div>
                                            </div>
                                            <div class="mail_list">
                                                <div class="left">
                                                    <i class="fa fa-paperclip"></i>
                                                </div>
                                                <div class="right">
                                                    <h3>Jon Dibbs <small>4.09 PM</small></h3>
                                                    <p>Ut enim ad minim veniam, quis nostrud exercitation enim ad minim veniam, quis nostrud exercitation...</p>
                                                </div>
                                            </div>
                                            <div class="mail_list">
                                                <div class="left">
                                                    .
                                                </div>
                                                <div class="right">
                                                    <h3>Debbis & Raymond <small>4.09 PM</small></h3>
                                                    <p>Ut enim ad minim veniam, quis nostrud exercitation enim ad minim veniam, quis nostrud exercitation...</p>
                                                </div>
                                            </div>
                                            <div class="mail_list">
                                                <div class="left">
                                                    .
                                                </div>
                                                <div class="right">
                                                    <h3>Debbis & Raymond <small>4.09 PM</small></h3>
                                                    <p>Ut enim ad minim veniam, quis nostrud exercitation enim ad minim veniam, quis nostrud exercitation...</p>
                                                </div>
                                            </div>
                                            <div class="mail_list">
                                                <div class="left">
                                                    <i class="fa fa-circle"></i> <i class="fa fa-edit"></i>
                                                </div>
                                                <div class="right">
                                                    <h3>Dennis Mugo <small>3.00 PM</small></h3>
                                                    <p>Ut enim ad minim veniam, quis nostrud exercitation enim ad minim veniam, quis nostrud exercitation...</p>
                                                </div>
                                            </div>
                                            <div class="mail_list">
                                                <div class="left">
                                                    <i class="fa fa-star"></i>
                                                </div>
                                                <div class="right">
                                                    <h3>Jane Nobert <small>4.09 PM</small></h3>
                                                    <p>Ut enim ad minim veniam, quis nostrud exercitation enim ad minim veniam, quis nostrud exercitation...</p>
                                                </div>
                                            </div>



                                        </div>-->
                                        <!-- /MAIL LIST -->


                                        <!-- CONTENT MAIL -->
                                        <div class="col-sm-9 mail_view">
                                            <div class="inbox-body">
                                                <div class="mail_heading row">
                                                    <!--<div class="col-md-8">
                                                        <div class="compose-btn">
                                                            <a class="btn btn-sm btn-primary" href="mail_compose.html"><i class="fa fa-reply"></i> Reply</a>
                                                            <button title="" data-placement="top" data-toggle="tooltip" type="button" data-original-title="Print" class="btn  btn-sm tooltips"><i class="fa fa-print"></i> </button>
                                                            <button title="" data-placement="top" data-toggle="tooltip" data-original-title="Trash" class="btn btn-sm tooltips"><i class="fa fa-trash-o"></i>
                                                            </button>
                                                        </div>

                                                    </div>-->
                                                    <div class="col-md-3 ">
                                                        <h3>Avance:</h3>
                                                    </div>
                                                    <div class="col-md-3 ">
                                                        <h3>Tema 1</h3>
                                                    </div>
                                                    <div class="col-md-6 text-right">
                                                        <h3 class="date"> 20:37 PM 23 SET 2015</h3>
                                                    </div>
                                                    <br>
                                                    <h4> </h4>
                                                </div>
                                                <div class="sender-info">
                                                    <div class="row">
                                                        <div class="col-md-12">
                                                            <strong>Comentarios del alumno:</strong>
                                                            <!--<strong>me</strong>
                                                            <a class="sender-dropdown"><i class="fa fa-chevron-down"></i></a> -->
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="view-mail">
                                                    <p>He revisado lo que usted sugiriÃ³ para este avance.</p>
                                                       <p> Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum. </p>
                                                    <p>Riusmod tempor incididunt ut labor erem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>
                                                    <p>Modesed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>
                                                </div>
                                                
                                                <div class="sender-info">
                                                    <div class="row">
                                                        <div class="col-md-12">
                                                            <strong>Comentarios del asesor:</strong>
                                                            <!--<strong>me</strong>
                                                            <a class="sender-dropdown"><i class="fa fa-chevron-down"></i></a> -->
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="view-mail">
                                                    <p>Correcto</p>
                                                    
                                                </div>
                                                
                                                
                                                
                                                <div class="attachment">
                                                    <p>
                                                        <span><i ></i>Archivo opcional:</span>
                                                        <!--<a href="#">Download all attachments</a> |
                                                        <a href="#">View all images</a>-->
                                                    </p>
                                                    <ul>
                                                        <a href="#" class="fa fa-paperclip">Tema 1</a>
                                                        <!--<li>
                                                            <a href="#" class="atch-thumb">
                                                                <img src="images/1.png" alt="img" />
                                                            </a>

                                                            <div class="file-name">
                                                                image-name.jpg
                                                            </div>
                                                            <span>12KB</span>


                                                            <div class="links">
                                                                <a href="#">View</a> -
                                                                <a href="#">Download</a>
                                                            </div>
                                                        </li>

                                                        <li>
                                                            <a href="#" class="atch-thumb">
                                                                <img src="images/1.png" alt="img" />
                                                            </a>

                                                            <div class="file-name">
                                                                img_name.jpg
                                                            </div>
                                                            <span>40KB</span>

                                                            <div class="links">
                                                                <a href="#">View</a> -
                                                                <a href="#">Download</a>
                                                            </div>
                                                        </li>
                                                        <li>
                                                            <a href="#" class="atch-thumb">
                                                                <img src="images/1.png" alt="img" />
                                                            </a>

                                                            <div class="file-name">
                                                                img_name.jpg
                                                            </div>
                                                            <span>30KB</span>

                                                            <div class="links">
                                                                <a href="#">View</a> -
                                                                <a href="#">Download</a>
                                                            </div>
                                                        </li>-->
                                                        <br>
                                                        <a class="btn btn-sm btn-primary" href="mail_compose.html"><i class="fa fa-reply"></i> Descargar</a>
                                                    </ul>
                                                    
                                                </div>
                                                <div class="compose-btn pull-left">
                                                    <a class="btn btn-sm btn-primary" href="actualizar_obs"><i class=""></i>Editar Observaci&oacute;n</a>
                                                    
                                                    <!--<button title="" data-placement="top" data-toggle="tooltip" type="button" data-original-title="Print" class="btn  btn-sm tooltips"><i class="fa fa-print"></i> </button>
                                                    <button title="" data-placement="top" data-toggle="tooltip" data-original-title="Trash" class="btn btn-sm tooltips"><i class="fa fa-trash-o"></i>
                                                    </button>-->
                                                </div>
                                                
                                                <div class="col-md-9 col-sm-9 col-xs-9" align="right">
                                                    <label for="registrar">&nbsp;</label>
                                                    <a class="btn btn-primary" href="<spring:url value='/asesor/vista_de_entregables?codigo=${codigo}'/>">Regresar
                                                    </a>
                                                </div>
                                            </div>

                                        </div>
                                        <!-- /CONTENT MAIL -->
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

                <!-- footer content -->
                <!--<footer>
                    <div class="">
                        <p class="pull-right">Gentelella Alela! a Bootstrap 3 template by <a>Kimlabs</a>. |
                            <span class="lead"> <i class="fa fa-paw"></i> Gentelella Alela!</span>
                        </p>
                    </div>
                    <div class="clearfix"></div>
                </footer>-->
                <!-- /footer content -->

            </div>
            <!-- /page content -->
        </div>

    </div>

    <div id="custom_notifications" class="custom-notifications dsp_none">
        <ul class="list-unstyled notifications clearfix" data-tabbed_notifications="notif-group">
        </ul>
        <div class="clearfix"></div>
        <div id="notif-group" class="tabbed_notifications"></div>
    </div>

    <script src="<c:url value="/js/bootstrap.min.js"/>"></script>

    <!-- chart js -->
    <script src="<c:url value="/js/chartjs/chart.min.js"/>"></script>
    <!-- bootstrap progress js -->
    <script src="<c:url value="/js/progressbar/bootstrap-progressbar.min.js"/>"></script>
    <script src="<c:url value="/js/nicescroll/jquery.nicescroll.min.js"/>"></script>
    <!-- icheck -->
    <script src="<c:url value="/js/icheck/icheck.min.js"/>"></script>

    <script src="<c:url value="/js/custom.js"/>"></script>

</body>

</html>