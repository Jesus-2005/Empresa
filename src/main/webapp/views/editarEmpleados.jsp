<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Editar Producto</title>
<link rel="stylesheet" href="./style/style.css">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
 <div class="header-container">
 <h1>Editar Producto</h1>
 <a href="empleados?opcion=volver">
        <button class="btn-custom" type="button">Volver</button>
    </a>
</div>
 <form action="empleados" method="post">
  <c:set var="empleado" value="${empleado}"></c:set>
  <input type="hidden" name="opcion" value="editar">
  <input type="hidden" name="dniOriginal" value="${empleado.dni}">
  <table class="table table-info table-striped-columns" border="1">
   <tr>
    <th>Nombre:</th>
    <td><input type="text" name="nombre" size="50" value="${empleado.nombre}"></td>
   </tr>
   <tr>
    <th>Dni:</th>
    <td><input type="text" name="dni" size="50" value="${empleado.dni}"></td>
   </tr>
   <tr>
    <th>Sexo:</th>
    <td><input type="text" name="sexo" size="50" value="${empleado.sexo}"></td>
   </tr>
   <tr>
    <th>Categoria:</th>
    <td><input type="text" name="categoria" size="50" value="${empleado.categoria}"></td>
   </tr>
   <tr>
    <th>Anyos:</th>
    <td><input type="text" name="anyos" size="50" value="${empleado.anyos}"></td>
   </tr>
  </table>
  <input type="submit" class="btn-custom" value="Guardar">
 </form>
</body>
</html>