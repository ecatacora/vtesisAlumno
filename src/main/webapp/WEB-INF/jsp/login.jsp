<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!-- Meta, title, CSS, favicons, etc. -->
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <title>V-Tesis</title>

        <%@include file = "/WEB-INF/jsp/comun/recursos.jsp" %>

    </head>

    <body style="background:#F7F7F7;">

        <div class="">
            <a class="hiddenanchor" id="toregister"></a>
            <a class="hiddenanchor" id="tologin"></a>

            <div id="wrapper">
                <div id="login" class="animate form">
                    <section class="login_content">
                        <form:form modelAttribute="userLogin" method="POST" action="login">
                            <h1>V-Tesis</h1>
                           <div class="modal-body">
                        <spring:url value="/dologin.do" var="url" />
                        <form class="well form-inline" role="form" action="${url}" method="POST">
                            <% if (request.getParameter("error") != null) {%><div class="alert alert-error">Los datos ingresados son incorrectos</div> <% }%>
                            <div class="control-group">
                                <label class="control-label">Código</label>
                                <div class="controls">
                                    <input type="text" name="codigo" placeholder="coodigo">
                                </div>
                            </div>
                            <div class="control-group">
                                <label class="control-label">Password</label>
                                <div class="controls">
                                    <input type="password" name="password">
                                </div>
                            </div>
                            <div class="control-group">
                                <div class="controls">
                                    <label class="checkbox">
                                        <input type="checkbox"> Recordar cuenta
                                    </label>
                                    &nbsp;&nbsp;&nbsp;<button type="submit" class="btn btn-success">Ingresar</button>
                                </div>
                            </div>

                        </form> 

                    </div>
                    <div class="modal-footer">
                        <a href="#">Registrarse en Northwind</a><br>
                        <a href="#">Recuperar Contraseña</a><br>
                        <a href="#">Reenviar Código de Activación</a>
                    </div>
                </div>


            </div>

        </div>

                        </form:form>
                        <!-- form -->
                    </section>
                    <!-- content -->
                </div>

            </div>
        </div>

    </body>
</html>
