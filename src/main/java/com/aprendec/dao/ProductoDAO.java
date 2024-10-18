package com.aprendec.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
 
import com.aprendec.conexion.Conexion;
import com.aprendec.model.Empleado;

 
public class ProductoDAO {
 private static Connection connection;
 private static PreparedStatement statement;
 private static boolean estadoOperacion;
 
 
 // obtener lista de productos
 public List<Empleado> obtenerEmpleado() throws SQLException {
  ResultSet resultSet = null;
  List<Empleado> listaEmpleados = new ArrayList<>();
 
  String sql = null;
  estadoOperacion = false;
  connection = obtenerConexion();
 
  try {
   sql = "SELECT * FROM empleado";
   statement = connection.prepareStatement(sql);
   resultSet = statement.executeQuery(sql);
   while (resultSet.next()) {
	Empleado p;
    String nombre = resultSet.getString("Nombre");
	String dni = resultSet.getString("Dni");
	char sexo = resultSet.getString("Sexo").charAt(0);
	int categoria = resultSet.getInt("Categoria");
	int anyo = resultSet.getInt("Anyos");
	p = new Empleado(nombre, dni, sexo, categoria, anyo);
    listaEmpleados.add(p);
   }
 
  } catch (SQLException e) {
   e.printStackTrace();
  }
 
  return listaEmpleados;
 }
 
 
 public String obtenerSueldo(String dni) throws SQLException {
	  ResultSet resultSet = null;
	 
	  String sql = null;
	  estadoOperacion = false;
	  connection = obtenerConexion();
	  String sueldo =null;
	  try {
	   sql = "SELECT sueldo FROM nomina WHERE dni ='"+dni+"'";
	   statement = connection.prepareStatement(sql);
	   resultSet = statement.executeQuery(sql);
	   while (resultSet.next()) {
	  
		sueldo = resultSet.getString(1);
	   }
	 
	  } catch (SQLException e) {
	   e.printStackTrace();
	  }
	 
	  return sueldo;
	 }
 
 // obtener conexion pool
 private static Connection obtenerConexion() throws SQLException {
  return Conexion.getConnection();
 }
 
}
