package com.aprendec.dao;

import java.sql.SQLException;
import java.util.List;

import com.aprendec.model.Empleado;

public interface EmpleadoDAO {
	List<Empleado> obtenerEmpleado() throws SQLException;
	Empleado obtenerEmpleadoEditar(String dni) throws SQLException;
	String obtenerSueldo(String dni) throws SQLException;
	List<Empleado> obtenerEmpleado(String valor) throws SQLException;
	boolean editar(Empleado empleado, String dniOriginal) throws SQLException;
}