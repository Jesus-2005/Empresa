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
 private Connection connection;
 private PreparedStatement statement;
 private boolean estadoOperacion;
 
 
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
 
 
 public Integer obtenerSueldo(int dni) throws SQLException {
	  ResultSet resultSet = null;
	 
	  String sql = null;
	  estadoOperacion = false;
	  connection = obtenerConexion();
	  int sueldo = 0;
	  try {
	   sql = "SELECT sueldo FROM nomina WHERE id =?";
	   statement.setInt(1, dni);
	   statement = connection.prepareStatement(sql);
	   resultSet = statement.executeQuery(sql);
	   while (resultSet.next()) {
	  
		sueldo = resultSet.getInt("sueldo");
	   }
	 
	  } catch (SQLException e) {
	   e.printStackTrace();
	  }
	 
	  return sueldo;
	 }
 
 // obtener conexion pool
 private Connection obtenerConexion() throws SQLException {
  return Conexion.getConnection();
 }
 
}
