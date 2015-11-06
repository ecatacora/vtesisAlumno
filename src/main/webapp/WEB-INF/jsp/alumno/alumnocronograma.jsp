<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!-- Meta, title, CSS, favicons, etc. -->
        <%@include file="/WEB-INF/jsp/comun/recursos.jsp" %>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <title>Virtual Tesis</title>
        <%@include file = "/WEB-INF/jsp/comun/recursos.jsp" %>


    </head>


    <body class="nav-md">

        <div class="container body">


            <div class="main_container">

                <div class="col-md-3 left_col">
                    <div class="left_col scroll-view">

                        <div class="navbar nav_title" style="border: 0;">
                            <a href="alumnoprofile.html" class="site_title"><img src="images/vtesis-logo.jpg" alt="Logo"><span>V-Tesis</span></a>
                        </div>
                        <div class="clearfix"></div>

                        <!-- menu prile quick info -->
                        <div class="profile">
                            <div class="profile_pic">
                                <img src="${persona.foto}" alt="${persona.nombre}"  class="img-circle profile_img">
                            </div>
                            <div class="profile_info">
                                <span>Bienvenido,</span>
                                <c:if test="${persona.id != null}">
                                    <h2>${persona.nombre}</h2> <!--   Cambio -->              
                                </c:if>

                            </div>
                        </div>
                        <!-- /menu prile quick info -->

                        <br />

                        <!-- sidebar menu -->
                        <div id="sidebar-menu" class="main_menu_side hidden-print main_menu">

                            <div class="menu_section">
                                <h3>Alumno</h3>   
                                <ul class="nav side-menu">
                                    <li><a><i class="fa fa-home"></i> Home <span class="fa fa-chevron-down"></span></a>
                                        <ul class="nav child_menu" style="display: none">                                    
                                            <li><a href="<c:url value="/alumnoperfil"/>">Perfil</a>
                                                </li>
                                            </ul>
                                        </li>
                                        <li><a><i class="fa fa-edit"></i> Avances <span class="fa fa-chevron-down"></span></a>
                                            <ul class="nav child_menu" style="display: none">
                                                <li><a href="<c:url value="/l_entrega"/>">Cronograma Avances</a>
                                                    </li>
                                                    <!--<li><a href="form_advanced.html">Advanced Components</a>
                                                     </li>
                                                     <li><a href="form_validation.html">Form Validation</a>
                                                     </li>
                                                     <li><a href="form_wizards.html">Form Wizard</a>
                                                     </li>
                                                     <li><a href="form_upload.html">Form Upload</a>
                                                     </li>
                                                     <li><a href="form_buttons.html">Form Buttons</a>
                                                     </li>-->
                                                </ul>
                                            </li>
                                        </ul>
                                    </div>
                                    <div class="menu_section">

                                    </div>

                                </div>
                                <!-- /sidebar menu -->

                                <!-- /menu footer buttons -->
                                <div class="sidebar-footer hidden-small">                        
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
                                                <img src="${persona.foto}" alt="">${persona.nombre}
                                                <span class=" fa fa-angle-down"></span>
                                            </a>
                                            <ul class="dropdown-menu dropdown-usermenu animated fadeInDown pull-right">
                                                <li><a href="javascript:;">  Profile</a>
                                                </li>                                   

                                                <li><a href="<c:url value="/logout.do"/>"><i class="fa fa-sign-out pull-right"></i> Log Out</a>
                                                    </li>
                                                </ul>
                                            </li>

                                            <li role="presentation" class="dropdown">
                                                <a href="javascript:;" class="dropdown-toggle info-number" data-toggle="dropdown" aria-expanded="false">
                                                    <i class="fa fa-envelope-o"></i>
                                                    <span class="badge bg-green">6</span>
                                                </a>
                                                <ul id="menu1" class="dropdown-menu list-unstyled msg_list animated fadeInDown" role="menu">
                                                    <li>
                                                        <a>
                                                            <span class="image">
                                                                <img src="${persona.foto}" alt="Profile Image" />
                                                            </span>
                                                            <span>
                                                                <c:if test="${persona.id != null}">
                                                                    <span>${persona.nombre}</span> <!--   Cambio -->              
                                                                </c:if>
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
                                                                <c:if test="${persona.id != null}">
                                                                    <span>${persona.nombre}</span> <!--   Cambio -->              
                                                                </c:if>
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
                                                                <c:if test="${persona.id != null}">
                                                                    <span>${persona.nombre}</span> <!--   Cambio -->              
                                                                </c:if>
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
                                                                <c:if test="${persona.id != null}">
                                                                    <span>${persona.nombre}</span> <!--   Cambio -->              
                                                                </c:if>
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
                                            </li>

                                        </ul>
                                    </nav>
                                </div>

                            </div>
                            <!-- /top navigation -->

                            <!-- page content -->
                            <div class="right_col" role="main">

                                <div class="">

                                    <div class="clearfix"></div>

                                    <div class="row">
                                        <div class="col-md-12 col-sm-12 col-xs-12">
                                            <div class="x_panel">
                                                <div class="x_title">
                                                    <h1>Cronograma de Entregas</h1>

                                                                                
                                                    <div class="clearfix"></div>
                                                </div>

                                                <div class="x_content">

                                                    <!--   Cambiar toda la tabla -->
                                                    <table class="table">
                                                        <thead>
                                                            <tr>
                                                                <th style="text-align:center;">Entregables</th>
                                                                <th style="text-align:center;">Fecha LÃ­mite</th>
                                                                <th style="text-align:center;">Avance</th>
                                                                <th style="text-align:center;">Estado</th>
                                                            </tr>
                                                        </thead>
                                                        <tbody>
                                                            

                                                            <c:forEach items="${lstProyectos}" var="p">
                                                                <%
                                                                    int contador = 0;
                                                                    contador++;
                                                                %>
                                                                <tr>
                                                                    <td scope="row" style="text-align:center;">Entregable <%=contador%></td>
                                                                    <td style="text-align:center;">${p.fecha}</td>
                                                                    <td style="text-align:center;">${p.nombre}</td>
                                                                    <td style="text-align:center;"> <!-- Cambiar Descargar archivo-->
                                                                        <a href="<c:url value='avance?idavance=${p.idavance}'/>">${p.estado}</a>
                                                                    </td>
                                                                </tr> 
                                                            </c:forEach>    

                                                        </tbody>
                                                    </table>
                                                    <div class="col-md-5 center-block">
                                                    </div>
                                                    <div class="col-md-3 center-block">
                                                        <a href="<c:url value='/alumnoperfil'/>"><button type="button" class="btn btn-primary">Regresar</button></a>
                                                    </div>
                                                </div>                                  


                                            </div>
                                        </div>
                                    </div>
                                </div>

                                <!-- footer content -->
                                <footer>
                                    <div class="">


                                    </div>
                                    <div class="clearfix"></div>
                                </footer>
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

                    <script src="js/bootstrap.min.js"></script>

                    <!-- chart js -->
                    <script src="js/chartjs/chart.min.js"></script>
                    <!-- bootstrap progress js -->
                    <script src="js/progressbar/bootstrap-progressbar.min.js"></script>
                    <script src="js/nicescroll/jquery.nicescroll.min.js"></script>
                    <!-- icheck -->
                    <script src="js/icheck/icheck.min.js"></script>

                    <script src="js/custom.js"></script>

                    <!-- image cropping -->
                    <script src="js/cropping/cropper.min.js"></script>
                    <script src="js/cropping/main.js"></script>


                    <!-- daterangepicker -->
                    <script type="text/javascript" src="js/moment.min.js"></script>
                    <script type="text/javascript" src="js/datepicker/daterangepicker.js"></script>
                    <!-- moris js -->
                    <script src="js/moris/raphael-min.js"></script>
                    <script src="js/moris/morris.js"></script>
                    <script>
                        $(function () {
                            var day_data = [
                                {
                                    "period": "Jan",
                                    "Hours worked": 80
                                },
                                {
                                    "period": "Feb",
                                    "Hours worked": 125
                                },
                                {
                                    "period": "Mar",
                                    "Hours worked": 176
                                },
                                {
                                    "period": "Apr",
                                    "Hours worked": 224
                                },
                                {
                                    "period": "May",
                                    "Hours worked": 265
                                },
                                {
                                    "period": "Jun",
                                    "Hours worked": 314
                                },
                                {
                                    "period": "Jul",
                                    "Hours worked": 347
                                },
                                {
                                    "period": "Aug",
                                    "Hours worked": 287
                                },
                                {
                                    "period": "Sep",
                                    "Hours worked": 240
                                },
                                {
                                    "period": "Oct",
                                    "Hours worked": 211
                                }
                            ];
                            Morris.Bar({
                                element: 'graph_bar',
                                data: day_data,
                                xkey: 'period',
                                hideHover: 'auto',
                                barColors: ['#26B99A', '#34495E', '#ACADAC', '#3498DB'],
                                ykeys: ['Hours worked', 'sorned'],
                                labels: ['Hours worked', 'SORN'],
                                xLabelAngle: 60
                            });
                        });
                    </script>
                    <!-- datepicker -->
                    <script type="text/javascript">
                        $(document).ready(function () {

                            var cb = function (start, end, label) {
                                console.log(start.toISOString(), end.toISOString(), label);
                                $('#reportrange span').html(start.format('MMMM D, YYYY') + ' - ' + end.format('MMMM D, YYYY'));
                                //alert("Callback has fired: [" + start.format('MMMM D, YYYY') + " to " + end.format('MMMM D, YYYY') + ", label = " + label + "]");
                            }

                            var optionSet1 = {
                                startDate: moment().subtract(29, 'days'),
                                endDate: moment(),
                                minDate: '01/01/2012',
                                maxDate: '12/31/2015',
                                dateLimit: {
                                    days: 60
                                },
                                showDropdowns: true,
                                showWeekNumbers: true,
                                timePicker: false,
                                timePickerIncrement: 1,
                                timePicker12Hour: true,
                                ranges: {
                                    'Today': [moment(), moment()],
                                    'Yesterday': [moment().subtract(1, 'days'), moment().subtract(1, 'days')],
                                    'Last 7 Days': [moment().subtract(6, 'days'), moment()],
                                    'Last 30 Days': [moment().subtract(29, 'days'), moment()],
                                    'This Month': [moment().startOf('month'), moment().endOf('month')],
                                    'Last Month': [moment().subtract(1, 'month').startOf('month'), moment().subtract(1, 'month').endOf('month')]
                                },
                                opens: 'left',
                                buttonClasses: ['btn btn-default'],
                                applyClass: 'btn-small btn-primary',
                                cancelClass: 'btn-small',
                                format: 'MM/DD/YYYY',
                                separator: ' to ',
                                locale: {
                                    applyLabel: 'Submit',
                                    cancelLabel: 'Clear',
                                    fromLabel: 'From',
                                    toLabel: 'To',
                                    customRangeLabel: 'Custom',
                                    daysOfWeek: ['Su', 'Mo', 'Tu', 'We', 'Th', 'Fr', 'Sa'],
                                    monthNames: ['January', 'February', 'March', 'April', 'May', 'June', 'July', 'August', 'September', 'October', 'November', 'December'],
                                    firstDay: 1
                                }
                            };
                            $('#reportrange span').html(moment().subtract(29, 'days').format('MMMM D, YYYY') + ' - ' + moment().format('MMMM D, YYYY'));
                            $('#reportrange').daterangepicker(optionSet1, cb);
                            $('#reportrange').on('show.daterangepicker', function () {
                                console.log("show event fired");
                            });
                            $('#reportrange').on('hide.daterangepicker', function () {
                                console.log("hide event fired");
                            });
                            $('#reportrange').on('apply.daterangepicker', function (ev, picker) {
                                console.log("apply event fired, start/end dates are " + picker.startDate.format('MMMM D, YYYY') + " to " + picker.endDate.format('MMMM D, YYYY'));
                            });
                            $('#reportrange').on('cancel.daterangepicker', function (ev, picker) {
                                console.log("cancel event fired");
                            });
                            $('#options1').click(function () {
                                $('#reportrange').data('daterangepicker').setOptions(optionSet1, cb);
                            });
                            $('#options2').click(function () {
                                $('#reportrange').data('daterangepicker').setOptions(optionSet2, cb);
                            });
                            $('#destroy').click(function () {
                                $('#reportrange').data('daterangepicker').remove();
                            });
                        });
                    </script>
                    <!-- /datepicker -->
                </body>

            </html>
