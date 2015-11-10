
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!-- Meta, title, CSS, favicons, etc. -->
        <%@include file = "/WEB-INF/jsp/comun/recursos.jsp" %>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <title>Virtual Tesis</title>

        <!-- Bootstrap core CSS -->

        <%@include file = "/WEB-INF/jsp/comun/recursos.jsp" %>
        <script src="<spring:url value="/js/nprogress.js"/>"></script>
        <script>
            NProgress.start();
        </script>


    </head>


    <body class="nav-md">

    <div class="container body">


        <div class="main_container">

            <div class="col-md-3 left_col">
                <div class="left_col scroll-view">
                
                    <div class="navbar nav_title" style="border: 0;"><a href="<c:url value="/home.do"/>" class="site_title"><em class="fa fa-paw"></em> V-Tesis!</a></div>
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
                                        <li><a href="<c:url value= "/home.do"/>">Perfil</a></li>
                                                                         
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
                                    <img src="<c:url value="/images/${persona.foto}"/>" alt="">${persona.nombres} ${persona.apellidos} - ALUMNO
                                    <span class=" fa fa-angle-down"></span>
                                </a>
                                <ul class="dropdown-menu dropdown-usermenu animated fadeInDown pull-right">
                                    <li><a href="<c:url value= "/alumno/profile"/>">  Perfil</a>
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

                    <div class="">

                        <div class="clearfix"></div>

                        <div class="row">
                            <div class="col-md-12 col-sm-12 col-xs-12">
                                <div class="x_panel">
                                    <div class="x_title">
                                        <h2>Alumno</h2>
                                        <ul class="nav navbar-right panel_toolbox">

                                            <li class="dropdown">

                                                <ul class="dropdown-menu" role="menu">
                                                    <li><a href="#">Settings 1</a>
                                                    </li>
                                                    <li><a href="#">Settings 2</a>
                                                    </li>
                                                </ul>
                                            </li>

                                        </ul>
                                        <div class="clearfix"></div>
                                    </div>
                                    <div class="x_content">

                                        <div class="col-md-3 col-sm-3 col-xs-12 profile_left">

                                            <div class="profile_img">

                                                <!-- end of image cropping -->
                                                <div id="crop-avatar">
                                                    <!-- Current avatar -->
                                                    <div class="avatar-view" title="Change the avatar">
                                                        <img src="<c:url value="/images/${persona.foto}"/> " alt="Avatar">
                                                    </div>

                                                    <!-- Cropping modal -->
                                                    <div class="modal fade" id="avatar-modal" aria-hidden="true" aria-labelledby="avatar-modal-label" role="dialog" tabindex="-1">
                                                        <div class="modal-dialog modal-lg">
                                                            <div class="modal-content">
                                                                <form class="avatar-form" action="crop.php" enctype="multipart/form-data" method="post">
                                                                    <div class="modal-header">
                                                                        <button class="close" data-dismiss="modal" type="button">&times;</button>
                                                                        <h4 class="modal-title" id="avatar-modal-label">Change Avatar</h4>
                                                                    </div>
                                                                    <div class="modal-body">
                                                                        <div class="avatar-body">

                                                                            <!-- Upload image and data -->
                                                                            <div class="avatar-upload">
                                                                                <input class="avatar-src" name="avatar_src" type="hidden">
                                                                                <input class="avatar-data" name="avatar_data" type="hidden">
                                                                                <label for="avatarInput">Local upload</label>
                                                                                <input class="avatar-input" id="avatarInput" name="avatar_file" type="file">
                                                                            </div>

                                                                            <!-- Crop and preview -->
                                                                            <div class="row">
                                                                                <div class="col-md-9">
                                                                                    <div class="avatar-wrapper"></div>
                                                                                </div>
                                                                                <div class="col-md-3">
                                                                                    <div class="avatar-preview preview-lg"></div>
                                                                                    <div class="avatar-preview preview-md"></div>
                                                                                    <div class="avatar-preview preview-sm"></div>
                                                                                </div>
                                                                            </div>

                                                                            <div class="row avatar-btns">
                                                                                <div class="col-md-9">
                                                                                    <div class="btn-group">
                                                                                        <button class="btn btn-primary" data-method="rotate" data-option="-90" type="button" title="Rotate -90 degrees">Rotate Left</button>
                                                                                        <button class="btn btn-primary" data-method="rotate" data-option="-15" type="button">-15deg</button>
                                                                                        <button class="btn btn-primary" data-method="rotate" data-option="-30" type="button">-30deg</button>
                                                                                        <button class="btn btn-primary" data-method="rotate" data-option="-45" type="button">-45deg</button>
                                                                                    </div>
                                                                                    <div class="btn-group">
                                                                                        <button class="btn btn-primary" data-method="rotate" data-option="90" type="button" title="Rotate 90 degrees">Rotate Right</button>
                                                                                        <button class="btn btn-primary" data-method="rotate" data-option="15" type="button">15deg</button>
                                                                                        <button class="btn btn-primary" data-method="rotate" data-option="30" type="button">30deg</button>
                                                                                        <button class="btn btn-primary" data-method="rotate" data-option="45" type="button">45deg</button>
                                                                                    </div>
                                                                                </div>
                                                                                <div class="col-md-3">
                                                                                    <button class="btn btn-primary btn-block avatar-save" type="submit">Done</button>
                                                                                </div>
                                                                            </div>
                                                                        </div>
                                                                    </div>
                                                                    <!-- <div class="modal-footer">
                                                      <button class="btn btn-default" data-dismiss="modal" type="button">Close</button>
                                                    </div> -->
                                                                </form>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <!-- /.modal -->

                                                    <!-- Loading state -->
                                                    <div class="loading" aria-label="Loading" role="img" tabindex="-1"></div>
                                                </div>
                                                <!-- end of image cropping -->

                                            </div>
                                            <h4>${persona.apellidos}, ${persona.nombres}  </h4>

                                            <ul class="list-unstyled user_data">
                                                <li>${persona.correo} 
                                                </li>

                                                <li>
                                                    ${persona.codigo} 
                                                </li>                                            
                                            </ul>


                                            <br />

                                            <!-- start skills -->

                                            <!-- end of skills -->

                                        </div>
                                        <div class="col-md-9 col-sm-9 col-xs-12">

                                            <div class="profile_title">
                                                <div class="col-md-5">
                                                </div>
                                                <div class="col-md-3">
                                                    <h2>Busqueda:</h2>
                                                    <form:form modelAttribute="busquedaFiltro" action="l_entrega" role="form" class="form-horizontal" method="POST">

                                                        <div class="form-group">
                                                            <label class="control-label col-sm-2"><h3>Ciclo</h3></label>
                                                            <br>
                                                            <br>
                                                            <div class="col-sm-12">
                                                                <form:select path="ciclo" class="form-control">
                                                                    <option value="">Seleccione</option>
                                                                    <c:forEach items="${historial}" var="h">
                                                                        <c:forEach items="${ListaCiclos}" var="p"> <!-- Consultar el generar el combo a partir del curso dado -->
                                                                            <c:if test="${h.ciclo.equals(p.ciclo)}">
                                                                                <option  value="${p.ciclo}" ${p.ciclo==busquedaFiltro.ciclo?"selected":""}>${p.ciclo} </option>
                                                                            </c:if>
                                                                        </c:forEach>
                                                                    </c:forEach>
                                                                </form:select>
                                                            </div>
                                                        </div>

                                                        <div class="form-group">
                                                            <label class="control-label col-sm-2"><h3>Cursos</h3></label>
                                                            <br>
                                                            <br>
                                                            <div class="col-sm-12">
                                                                <form:select path="idCurso" class="form-control">
                                                                    <option value="">Seleccione</option>
                                                                    <c:forEach items="${ListaCursos}" var="p">
                                                                        <option  value="${p.idCurso}" ${p.idCurso==busquedaFiltro.idCurso?"selected":""}>${p.nombre} </option>
                                                                    </c:forEach>
                                                                </form:select>
                                                            </div>
                                                        </div>  


                                                        <div class="form-group">
                                                            <div class="col-sm-12">
                                                                <button type="submit" class="btn btn-primary">Avances</button>

                                                            </div>
                                                        </div>    
                                                    </form:form>
                                                </div>
                                            </div>

                                        </div>                                                                               
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

    <script src="<c:url value="/js/bootstrap.min.js"/>"></script>

    <!-- chart js -->
    <script src="<c:url value="/js/chartjs/chart.min.js"/>"></script>
    <!-- bootstrap progress js -->
    <script src="<c:url value="/js/progressbar/bootstrap-progressbar.min.js"/>"></script>
    <script src="<c:url value="/js/nicescroll/jquery.nicescroll.min.js"/>"></script>
    <!-- icheck -->
    <script src="<c:url value="/js/icheck/icheck.min.js"/>"></script>

    <script src="<c:url value="/js/custom.js"/>"></script>

    <!-- image cropping -->
    <script src="<c:url value="/js/cropping/cropper.min.js"/>"></script>
    <script src="<c:url value="/js/cropping/main.js"/>"></script>


    <!-- daterangepicker -->
    <script type="text/javascript" src="<c:url value="/js/moment.min.js"/>"></script>
    <script type="text/javascript" src="<c:url value="/js/datepicker/daterangepicker.js"/>"></script>
    <!-- moris js -->
    <script src="<c:url value="/js/moris/raphael-min.js"/>"></script>
    <script src="<c:url value="/js/moris/morris.js"/>"></script>
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
    <script>
        NProgress.done();
    </script>
    <!-- /datepicker -->
    <!-- /footer content -->
</body>

</html>