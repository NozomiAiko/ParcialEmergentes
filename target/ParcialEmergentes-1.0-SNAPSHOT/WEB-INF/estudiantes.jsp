<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="com.emergentes.controlador.Estudiante"%>
<%@page import="java.util.List"%>
<%
    //aqui igual esta en plural
List<Estudiante> estudiantes= (List<Estudiante> )request.getAttribute("estudiantes");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <p>
            PRIMER PARCIAL TEM-742<br><!-- comment -->
            Nombre:Katherine Alejandra Santos Quiñones<br>
            Carnet:11078438 LP<br>
        </p>
        <h1>REGISTRO DIA DEL INTERNET</h1>
        <a href="EstudianteCobtrolador?action=add">Nuevo</a>
        <table border="1">

            <th>
            <td>ID</td>
            <td>NOMBRES</td>
            <td>APELLIDOS</td>
            <td>SEMINARIO</td>
            <td>CONFIRMADO</td>
            <td>FECHA INSCRIPCION</td>
            <td></td>
            <td></td>
        </th>
        <c:forEach var="item" items="${estudiantes}">
            <tr>
                <td>${item.id}</td>
                <td>${item.nombres}</td>
                <td>${item.apellidos}</td>
                <td>${item.seminario}</td>
                <td>${item.confirmado}</td>
                <td>${item.fecha_ins}</td>
                <td><a href="EstudianteCobtrolador?action=edit&id=${item.id}">EDITAR</a></td>
                <td><a href="EstudianteCobtrolador?action=delete&id=${item.id}">ELIMINAR</a></td>
            </tr>
        </c:forEach>
            
    </table>
</body>
</html>
