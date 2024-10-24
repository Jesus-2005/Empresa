<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Modifica Empleados</title>
</head>
<body>
	<h1>Modifica Empleados</h1>
	<table border="1">
		<tr>
			<td>Nombre</td>
			<td>Dni</td>
			<td>Sexo</td>
			<td>Categoria</td>
			<td>Anyos</td>
		</tr>
		<c:forEach var="EmpleadoModificar" items="${listar}">
			<tr>
				<td><c:out value="${ EmpleadoModificar.nombre}"></c:out></td>
				<td><c:out value="${ EmpleadoModificar.dni}"></c:out></td>
				<td><c:out value="${ EmpleadoModificar.sexo}"></c:out></td>
				<td><c:out value="${ EmpleadoModificar.categoria}"></c:out></td>
				<td><c:out value="${ EmpleadoModificar.anyos}"></c:out></td>
				<td>
				<a
					href="empleados?opcion=meditar&dni=<c:out value="${  EmpleadoModificar.dni}"></c:out>">
						Editar
				</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>