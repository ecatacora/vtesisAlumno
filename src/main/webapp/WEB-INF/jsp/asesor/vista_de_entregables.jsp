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
    <%@include file = "/WEB-INF/jsp/comun/recursos.jsp" %>
    <title>Virtual Tesis! | </title>
 
    <%@include file = "/WEB-INF/jsp/comun/recursos.jsp" %>
    
    <script src="<spring:url value="js/nprogress.js"/>"></script>
    <script>
        NProgress.start();
    </script>
    


</head>


<body class="nav-md">

    <div class="container body">


        <div class="main_container">

            <div class="col-md-3 left_col">
                <div class="left_col scroll-view">
                
                    <div class="navbar nav_title" style="border: 0;"><a href="index.html" class="site_title"><em class="fa fa-paw"></em> V-Tesis!</a></div>
                    <div class="clearfix"></div>

                    <!-- menu prile quick info -->
                    <div class="profile">
                        <div class="profile_pic">
                            <img src="<c:url value="/images/vtesis-logo.jpg"/>" alt="..." class="img-circle profile_img">
                        </div>
                        <div class="profile_info">
                            <span>Bienvenido,</span>
                            <h2 id="username">${persona.nombres} ${persona.apellidos}</h2>
                        </div>
                    </div>
                    <!-- /menu prile quick info -->

                    <br />

                    <!-- sidebar menu -->
                    <div id="sidebar-menu" class="main_menu_side hidden-print main_menu">

                        <div class="menu_section">
                            <h3>General</h3>
                            <ul class="nav side-menu">
                                <li><a><i class="fa fa-home"></i> Home <span class="fa fa-chevron-down"></span></a>
                                    <ul class="nav child_menu" style="display: none">
                                        <li><a href="<c:url value="/home.do"/>">Perfil</a></li>
                                                                         
                                    </ul>
                                </li>
                                <li><a><i class="fa fa-calendar"></i> Acciones <span class="fa fa-chevron-down"></span></a>
                                    <ul class="nav child_menu" style="display: none">
                                        <li><a href="Asesor-llenar-calendario.html">Llenar calendario</a>
                                        </li>
                                        
                                    </ul>
                                </li>
                            </ul>
                        </div>
</div>
                    <!-- /sidebar menu -->

                    <!-- /menu footer buttons -->
                    <div class="sidebar-footer hidden-small">                    
                        <a href="<c:url value="/logout.do"/>" data-toggle="tooltip" data-placement="top" title="Logout">
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
                                    <img src="<c:url value="images/img.jpg"/>" alt="">${persona.nombres} ${persona.apellidos}
                                    <span class=" fa fa-angle-down"></span>
                                </a>
                                <ul class="dropdown-menu dropdown-usermenu animated fadeInDown pull-right">
                                    <li><a href="<c:url value= "/asesor/profile"/>">  Profile</a>
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
                                    <li><a href="<c:url value= "/logout.do"/>"><i class="fa fa-sign-out pull-right"></i> Log Out</a>
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

                <!-- top tiles -->
                
                <!-- /top tiles -->

                <div class="row">
                    <div class="col-md-12 col-sm-12 col-xs-12">
                        <div class="dashboard_graph">
                            <div class="row x_title">
                                    <div class="col-md-12">
                                       <h3>Alumno: </h3>
                                       <h3 id="alumno"><small>${codigo} ${nombre} ${apellido}</small></h3>
                                    </div>
                            </div>
                            <div class="dashboard_graph">
                                    <h4>Lista de entregables: </h4><br>
                                    <form id="entregables">                                
                                        <div class="x_content">
                                            <table class="table table-bordered">
                                                <thead>
                                                <tr>
                                                    
                                                    <th>Nombre de Entregable</th> 
                                                    <th>Fecha l&iacute;mite</th>
                                                    <!--<th>*****</th>-->
                                                    <th>Estado</th>
                                                </tr>
                                                </thead>
                                                <tbody>
                                                    <c:forEach items="${lstAvances}" var="a">
                                                        <tr>
                                                            
                                                            <td>${a.nombre}</td> 
                                                            <td>${a.fecha_fin}</td> 
                                                            <!--<td><a href="#ver ">tema 1</a></td>-->
                                                            <c:choose>
                                                                <c:when test="${a.estado.id == 2 && a.estado.id == 3}">                                       
                                                                    <td><a href="<spring:url value='/asesor/entrega_avance?id=${a.idAvances}'/>"> ${a.estado.descripcion} </a></td>
                                                                </c:when>
                                                                <c:otherwise>
                                                                    <td><a href="<spring:url value='/asesor/entrega_avance_asesor?id=${a.idAvances}'/>"> ${a.estado.descripcion} </a></td>
                                                                </c:otherwise>
                                                            </c:choose>
                                                            
                                                        </tr>
                                                    </c:forEach>
                                                </tbody>
                                            </table>	
                                        </div>
                                                                                
                                    </form> 
                                    <div class="col-md-6 col-sm-6 col-xs-6">
                                        
                                    </div>
                                           
                                   
                                            
                                    <div class="col-md-6 col-sm-6 col-xs-6" align="right">
                                        <label for="registrar">&nbsp;</label><br>
                                        <a class="btn btn-primary" href="<spring:url value='/asesor/listar_alumnos?ciclo=${ciclo}'/>">
                                        Regresar
                                        </a>
                                    </div>
                                            
                            </div>
                            
                        </div>
                    </div>

              </div>
                
<br />
<!-- footer content -->

                <footer>
                    <div class="">
                      <p class="pull-right"><font color="#5a738e">Virtual Tesis - plataforma virtual de entrega de tesis - PUCP</font>. | <span class="lead"> V - Tesis</span></p>
                    </div>
                    <div class="clearfix"></div>
              </footer>
                <!-- /footer content -->
          </div>
            <!-- /page content -->

        </div>

    </div>
    <script src="<c:url value="/js/bootstrap.min.js"/>"></script>

    <!-- gauge js -->
    <script type="text/javascript" src="<c:url value="/js/gauge/gauge.min.js"/>"></script>
    <script type="text/javascript" src="<c:url value="/js/gauge/gauge_demo.js"/>"></script>
    <!-- chart js -->
    <script src="<c:url value="/js/chartjs/chart.min.js"/>"></script>
    <!-- bootstrap progress js -->
    <script src="<c:url value="/js/progressbar/bootstrap-progressbar.min.js"/>"></script>
    <script src="<c:url value="/js/nicescroll/jquery.nicescroll.min.js"/>"></script>
    <!-- icheck -->
    <script src="<c:url value="/js/icheck/icheck.min.js"/>"></script>
    <!-- daterangepicker -->
    <script type="text/javascript" src="<c:url value="/js/moment.min.js"/>"></script>
    <script type="text/javascript" src="<c:url value="/js/datepicker/daterangepicker.js"/>"></script>

    <script src="<c:url value="/js/custom.js"/>"></script>

    <!-- flot js -->
    <!--[if lte IE 8]><script type="text/javascript" src="js/excanvas.min.js"></script><![endif]-->
    <script type="text/javascript" src="<c:url value="/js/flot/jquery.flot.js"/>"></script>
    <script type="text/javascript" src="<c:url value="/js/flot/jquery.flot.pie.js"/>"></script>
    <script type="text/javascript" src="<c:url value="/js/flot/jquery.flot.orderBars.js"/>"></script>
    <script type="text/javascript" src="<c:url value="/js/flot/jquery.flot.time.min.js"/>"></script>
    <script type="text/javascript" src="<c:url value="/js/flot/date.js"/>"></script>
    <script type="text/javascript" src="<c:url value="/js/flot/jquery.flot.spline.js"/>"></script>
    <script type="text/javascript" src="<c:url value="/js/flot/jquery.flot.stack.js"/>"></script>
    <script type="text/javascript" src="<c:url value="/js/flot/curvedLines.js"/>"></script>
    <script type="text/javascript" src="<c:url value="/js/flot/jquery.flot.resize.js"/>"></script>
    <script>
        $(document).ready(function () {
            // [17, 74, 6, 39, 20, 85, 7]
            //[82, 23, 66, 9, 99, 6, 2]
            var data1 = [[gd(2012, 1, 1), 17], [gd(2012, 1, 2), 74], [gd(2012, 1, 3), 6], [gd(2012, 1, 4), 39], [gd(2012, 1, 5), 20], [gd(2012, 1, 6), 85], [gd(2012, 1, 7), 7]];

            var data2 = [[gd(2012, 1, 1), 82], [gd(2012, 1, 2), 23], [gd(2012, 1, 3), 66], [gd(2012, 1, 4), 9], [gd(2012, 1, 5), 119], [gd(2012, 1, 6), 6], [gd(2012, 1, 7), 9]];
            $("#canvas_dahs").length && $.plot($("#canvas_dahs"), [
                data1, data2
            ], {
                series: {
                    lines: {
                        show: false,
                        fill: true
                    },
                    splines: {
                        show: true,
                        tension: 0.4,
                        lineWidth: 1,
                        fill: 0.4
                    },
                    points: {
                        radius: 0,
                        show: true
                    },
                    shadowSize: 2
                },
                grid: {
                    verticalLines: true,
                    hoverable: true,
                    clickable: true,
                    tickColor: "#d5d5d5",
                    borderWidth: 1,
                    color: '#fff'
                },
                colors: ["rgba(38, 185, 154, 0.38)", "rgba(3, 88, 106, 0.38)"],
                xaxis: {
                    tickColor: "rgba(51, 51, 51, 0.06)",
                    mode: "time",
                    tickSize: [1, "day"],
                    //tickLength: 10,
                    axisLabel: "Date",
                    axisLabelUseCanvas: true,
                    axisLabelFontSizePixels: 12,
                    axisLabelFontFamily: 'Verdana, Arial',
                    axisLabelPadding: 10
                        //mode: "time", timeformat: "%m/%d/%y", minTickSize: [1, "day"]
                },
                yaxis: {
                    ticks: 8,
                    tickColor: "rgba(51, 51, 51, 0.06)",
                },
                tooltip: false
            });

            function gd(year, month, day) {
                return new Date(year, month - 1, day).getTime();
            }
        });
    </script>

    <!-- worldmap -->
    <script type="text/javascript" src="<c:url value="/js/maps/jquery-jvectormap-2.0.1.min.js"/>"></script>
    <script type="text/javascript" src="<c:url value="/js/maps/gdp-data.js"/>"></script>
    <script type="text/javascript" src="<c:url value="/js/maps/jquery-jvectormap-world-mill-en.js"/>"></script>
    <script type="text/javascript" src="<c:url value="/js/maps/jquery-jvectormap-us-aea-en.js"/>"></script>
    <script>
        $(function () {
            $('#world-map-gdp').vectorMap({
                map: 'world_mill_en',
                backgroundColor: 'transparent',
                zoomOnScroll: false,
                series: {
                    regions: [{
                        values: gdpData,
                        scale: ['#E6F2F0', '#149B7E'],
                        normalizeFunction: 'polynomial'
                    }]
                },
                onRegionTipShow: function (e, el, code) {
                    el.html(el.html() + ' (GDP - ' + gdpData[code] + ')');
                }
            });
        });
    </script>
    <!-- skycons -->
    <script src="<c:url value="/js/skycons/skycons.js"/>"></script>
    <script>
        var icons = new Skycons({
                "color": "#73879C"
            }),
            list = [
                "clear-day", "clear-night", "partly-cloudy-day",
                "partly-cloudy-night", "cloudy", "rain", "sleet", "snow", "wind",
                "fog"
            ],
            i;

        for (i = list.length; i--;)
            icons.set(list[i], list[i]);

        icons.play();
    </script>

    <!-- dashbord linegraph -->
    <script>
        var doughnutData = [
            {
                value: 30,
                color: "#455C73"
            },
            {
                value: 30,
                color: "#9B59B6"
            },
            {
                value: 60,
                color: "#BDC3C7"
            },
            {
                value: 100,
                color: "#26B99A"
            },
            {
                value: 120,
                color: "#3498DB"
            }
    ];
        var myDoughnut = new Chart(document.getElementById("canvas1").getContext("2d")).Doughnut(doughnutData);
    </script>
    <!-- /dashbord linegraph -->
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
    <script>
        NProgress.done();
    </script>
    <!-- /datepicker -->
    <!-- /footer content -->
</body>

</html>
