package com.aprendec.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aprendec.dao.EmpresaDAO;
import com.aprendec.model.Empleado;

/**
 * Servlet implementation class ProductoController
 */
@WebServlet(description = "administra peticiones para la tabla productos", urlPatterns = { "/empleados" })
public class EmpresaController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EmpresaController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		String opcion = request.getParameter("opcion");

		if (opcion.equals("listar")) {

			EmpresaDAO empresaDAO = new EmpresaDAO();
			List<Empleado> lista = new ArrayList<>();
			try {
				lista = empresaDAO.obtenerEmpleado();
				for (Empleado empleado : lista) {
					empleado.imprime();
				}

				request.setAttribute("lista", lista);
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/listar.jsp");
				requestDispatcher.forward(request, response);

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			System.out.println("Usted a presionado la opcion listar");
		} else if (opcion.equals("listarSueldo")) {
			Empleado empleado = new Empleado();
			EmpresaDAO empresaDAO = new EmpresaDAO();
			String sueldo = null;
			try {
				sueldo = empresaDAO.obtenerSueldo(empleado.getDni());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			request.setAttribute("sueldo", sueldo);
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/buscarDni.jsp");
			requestDispatcher.forward(request, response);
			
			

		} else if (opcion.equals("modificarEmpleados")) {

			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/buscarEmpleados.jsp");
			requestDispatcher.forward(request, response);

		} else if (opcion.equals("meditar")) {
			String dni = request.getParameter("dni");
			System.out.println("Editar dni: " + dni);
			EmpresaDAO empresaDAO = new EmpresaDAO();
			Empleado empleado = new Empleado();
			try {
				empleado = empresaDAO.obtenerEmpleadoEditar(dni);
				System.out.println(empleado);
				request.setAttribute("empleado", empleado);
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/editarEmpleados.jsp");
				requestDispatcher.forward(request, response);

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else if(opcion.equals("volver")) {
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/index.jsp");
			requestDispatcher.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
// TODO Auto-generated method stub
		String opcion = request.getParameter("opcion");

		if (opcion.equals("buscar")) {
			Empleado empleado = new Empleado();
			EmpresaDAO empresaDAO = new EmpresaDAO();
			empleado.setDni(request.getParameter("dni"));

			try {
				String sueldo = empresaDAO.obtenerSueldo(empleado.getDni());
				System.out.println(sueldo);
				request.setAttribute("dni", empleado.getDni());
				request.setAttribute("sueldo", sueldo);
				
				if(sueldo == null) {
					RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/Error.jsp");
					requestDispatcher.forward(request, response);
				}
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/listarSueldo.jsp");
				requestDispatcher.forward(request, response);

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (opcion.equals("buscarEmpleado")) {
			List<Empleado> lista = new ArrayList<>();
			EmpresaDAO empresaDAO = new EmpresaDAO();
			String campo = request.getParameter("campo");
			try {
				lista = empresaDAO.obtenerEmpleado(campo);
				for (Empleado empleado : lista) {
					empleado.imprime();
				}
				request.setAttribute("listar", lista);
				if(lista.isEmpty()) {
					RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/Error.jsp");
					requestDispatcher.forward(request, response);
				}
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/modificarEmpleados.jsp");
				requestDispatcher.forward(request, response);

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (opcion.equals("editar")) {
			Empleado empleado = new Empleado();
			EmpresaDAO empresaDAO = new EmpresaDAO();
			
			empleado.setNombre(request.getParameter("nombre"));
			empleado.setDni(request.getParameter("dni"));
			empleado.setSexo((request.getParameter("sexo").charAt(0)));
			empleado.setCategoria(Integer.parseInt(request.getParameter("categoria")));
			empleado.setAnyos(Integer.parseInt(request.getParameter("anyos")));
			String dniOriginal = request.getParameter("dniOriginal");

			try {
				empresaDAO.editar(empleado,dniOriginal);
				System.out.println("Registro editado satisfactoriamente...");
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("/index.jsp");
				requestDispatcher.forward(request, response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
			}
		}

// doGet(request, response);
	}

}
