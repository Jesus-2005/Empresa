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
		String sueldo = null;
		try {
			sql = "SELECT sueldo FROM nomina WHERE dni ='" + dni + "'";
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

	public List<Empleado> obtenerEmpleado(String valor) throws SQLException {
		ResultSet resultSet = null;
		List<Empleado> listaEmpleados = new ArrayList<>();

		String sql = null;
		estadoOperacion = false;
		connection = obtenerConexion();

		try {
			int valorNumerico = Integer.valueOf(valor);
			sql = "SELECT * FROM empleado where Nombre ='" + valor + "' or Dni ='" + valor + "' or Sexo = '" + valor
					+ "' or categoria = " + valorNumerico + " or anyos =" + valorNumerico + ";";
		} catch (NumberFormatException e) {
			sql = "SELECT * FROM empleado where Nombre ='" + valor + "' or Dni ='" + valor + "' or Sexo = '" + valor
					+ "' ;";
		}
		// sql = "SELECT * FROM empleado where Nombre ='"+valor+"' or Dni ='"+valor+"'
		// or Sexo = '"+valor+"' or categoria = "+valor+" or anyos ="+valor+";";

		try {
//		  sql = "SELECT * FROM empleado WHERE Nombre = ? OR Dni = ? OR Sexo = ? OR Categoria = ? OR Anyos = ? ";

			statement = connection.prepareStatement(sql);
//	   statement.setString(1, valor);
//	   statement.setString(2, valor);
//	   statement.setString(3, String.valueOf(valor.charAt(0)));
//	   
//	   try {
//           int categoria = Integer.parseInt(valor);
//           int anyos = Integer.parseInt(valor);
//           statement.setInt(4, categoria);
//           statement.setInt(5, anyos);
//       } catch (NumberFormatException e) {
//          
//           statement.setInt(4, 0);
//           statement.setInt(5, 0); 
//       }

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

	// obtener conexion pool
	private static Connection obtenerConexion() throws SQLException {
		return Conexion.getConnection();
	}

}
