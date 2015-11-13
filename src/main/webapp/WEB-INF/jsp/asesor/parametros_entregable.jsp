<%-- 
    Document   : parametros_entregable
    Created on : 11/11/2015, 06:07:54 PM
    Author     : Henry
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        <c:if test="${avance.idAvance != 0}">
        <title>Editar Fecha</title>
        </c:if>
        <c:if test="${avance.idAvance == 0}">
        <title>Nuevo Fecha</title>
        </c:if>
        <%@include file="/WEB-INF/jsp/comun/recursos.jsp" %>
    </head>
    <body>
       <div class="container">
            <c:if test="${avance.idAvance != 0}">
                <h2>Editar Fecha</h2>
            </c:if>
            <c:if test="${avance.idAvance == 0}">
                <h2>Nueva Fecha</h2>
            </c:if>
            <div class="row">
                <div class="panel panel-default">
                    <div class="panel-heading">Registrar Fecha</div>
                    <form:form modelAttribute="avance" action="save" role="form" class="form-horizontal" method="POST">
                        <form:hidden path="idAvance"/>
                        <div class="form-group">
                            <label class="control-label col-sm-2">Nombre</label>
                            <div class="col-sm-8">
                                <form:input path="nombres" class="form-control"/>
                            </div>
                        </div>
                        <!--p5-->    
                        <div class="form-group">
                            <label class="control-label col-sm-2">Fecha de Inicio</label>
                            <div class="col-sm-8">
                                <form:input path="fecha_inicio" class="form-control"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-sm-2">Fecha de Finalizacion</label>
                            <div class="col-sm-8">
                                <form:input path="fecha_fin" class="form-control"/>
                            </div>
                        </div>
                        <!--p7-->   
                        <div class="form-group">
                            <div class="col-sm-offset-9">
                              <button type="submit" class="btn btn-primary">Grabar</button>
                              <button type="button" class="btn btn-primary cancelar" >Cancelar</button>
                            </div>
                        </div>    
                    </form:form>
                </div>
            </div>
        </div>
    </body>
</html>
