<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Listar Sueldo</title>
</head>
<body>
 <h1>Listar Sueldo</h1>
 <form action="empleados" method="post">
  <input type="hidden" name="opcion" value="buscar">
  <table border="1">
   <tr>
    <td>DNI:</td>
    <td><input type="text" name="dni" size="50"></td>
   </tr>
  </table>
  <input type="submit" value="Buscar">
 </form>
</body>
</html>