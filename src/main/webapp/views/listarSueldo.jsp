<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Listar empleados</title>
</head>
<body>
 <h1>Listar Empleados</h1>
 <table border="1">
  <tr>
   <td>Dni</td>
   <td>Salario</td>  
  </tr>
  <tr>
    <c><td>${ dni}</td></c>
    <c><td>${ sueldo}</td></c>
  </tr>
 </table>
</body>
</html>