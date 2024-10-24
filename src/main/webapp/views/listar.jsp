<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Listar empleados</title>
<link rel="stylesheet" href="./style/style.css">
</head>
<body>
 <h1>Listar Empleados</h1>
 <table border=1>
  <tr>
   <td>Nombre</td>
   <td>Dni</td>
   <td>Sexo</td>  
   <td>Categoria</td>
   <td>Anyos</td>
  </tr>
  <c:forEach var="Empleado" items="${lista}">
  <tr>
    <td><c:out value="${ Empleado.nombre}"></c:out></td>
    <td><c:out value="${ Empleado.dni}"></c:out></td>
    <td><c:out value="${ Empleado.sexo}"></c:out></td>
    <td><c:out value="${ Empleado.categoria}"></c:out></td>
    <td><c:out value="${ Empleado.anyos}"></c:out></td>
  </tr>
  </c:forEach>
 </table>
</body>
</html>