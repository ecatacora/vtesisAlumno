<%-- 
    Document   : registro_persona
    Created on : 05/11/2015, 09:29:45 PM
    Author     : Hiroshi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <c:if test="${persona.idPersona != 0}">
        <title>Editar Usuario</title>
        </c:if>
        <c:if test="${persona.idPersona == 0}">
        <title>Nuevo Usuario</title>
        </c:if>
        <%@include file="/WEB-INF/jsp/comun/recursos.jsp" %>
    </head>
    <body>
        <div class="container">
            <c:if test="${persona.idPersona != 0}">
                <h2>Editar Usuario</h2>
            </c:if>
            <c:if test="${persona.idPersona == 0}">
                <h2>Nuevo Usuario</h2>
            </c:if>
            <div class="row">
                <div class="panel panel-default">
                    <div class="panel-heading">Registrar Persona</div>
                    <form:form modelAttribute="persona" action="save" role="form" class="form-horizontal" method="POST">
                        <form:hidden path="idPersona"/>
                        <div class="form-group">
                            <label class="control-label col-sm-2">Nombre</label>
                            <div class="col-sm-8">
                                <form:input path="nombres" class="form-control"/>
                                <form:errors path="nombres" cssStyle="color:red"/>
                            </div>
                        </div>
                        <!--p5-->    
                        <div class="form-group">
                            <label class="control-label col-sm-2">Apellidos</label>
                            <div class="col-sm-8">
                                <form:input path="apellidos" class="form-control"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-sm-2">Codigo</label>
                            <div class="col-sm-8">
                                <form:input path="codigo" class="form-control"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-sm-2">Contraseña</label>
                            <div class="col-sm-8">
                                <form:input path="contrasena" class="form-control"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-sm-2">Rol</label>
                            <div class="col-sm-6">
                                <form:select path="idRol" class="form-control">
                                    <option value="">Seleccione</option>
                                    <c:forEach items="${lstRol}" var="p">
                                        <option value="${p.getIdRol()}" ${p.getIdRol()==persona.getIdRol()?"selected":""}>${p.getTipo()} </option>
                                    </c:forEach>
                                </form:select>
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
