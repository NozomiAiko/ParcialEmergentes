<%-- 
    Document   : frmEst
    Created on : 15 may. de 2024, 07:19:31
    Author     : 999ma
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>
        NUEVO REGISTRO
        </h1>
        <form action="EstudianteCobtrolador" method="post">
            <input  type="hidden" name="id" value="${estudiante.id}">
            <table>
                
                <tr>
                    <td>NOMBRES:</td>
                    <td><input type="text" name="nombres" value="${estudiante.nombres}"> </td>
                </tr>
                <tr>
                    <td>APELLIDOS:</td>
                    <td><input type="text" name="apellidos" value="${estudiante.apellidos}"> </td>
                </tr>
                <tr>
                    <td>SEMINARIO:</td>
                    <td><input type="text" name="seminario" value="${estudiante.seminario}"> </td>
                </tr>
                <tr>
                    <td>CONFIRMADO:</td>
                    <td><input type="checkbox" name="confirmado" value="${estudiante.confirmado}"> </td>
                    <td><input type="checkbox" name="confirmado" value="${estudiante.confirmado}"> </td>
                </tr>
                <tr>
                    <td>FECHA INSCRIPCION:</td>
                    <td><input type="date" name="fecha_ins" value="${estudiante.fecha_ins}"> </td>
                </tr>
                <tr>
                    <td><input type="submit"></td>
                </tr>
            </table>    
                    <c:if test="a" var="a">
                    </c:if>
        </form>
                
        
            
        
    </body>
</html>
