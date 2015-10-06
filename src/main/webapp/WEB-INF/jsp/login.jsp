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
                        <form:form >
                            <h1>V-Tesis</h1>
                            <div>
                                <input type="text" path="" id="username" name="username" class="form-control" placeholder="Usuario" />
                            </div>
                            <div>
                                <input type="password" path="" id="password" name="password" class="form-control" placeholder="Contraseña"/>
                            </div>
                            <div>         
                                <button type="submit" class="btn btn-default">Acceder</button>
                                <a class="reset_pass" href="#">¿Olvidó su contraseña?</a>
                            </div>
                            <div class="clearfix"></div>

                        </form:form>
                        <!-- form -->
                    </section>
                    <!-- content -->
                </div>

            </div>
        </div>

    </body>
</html>
