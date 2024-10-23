package com.aprendec.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aprendec.dao.ProductoDAO;
import com.aprendec.model.Empleado;


/**
 * Servlet implementation class ProductoController
 */
@WebServlet(description = "administra peticiones para la tabla productos", urlPatterns = { "/empleados" })
public class ProductoController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ProductoController() {
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

			ProductoDAO productoDAO = new ProductoDAO();
			List<Empleado> lista = new ArrayList<>();
			try {
				lista = productoDAO.obtenerEmpleado();
				for (Empleado empleado : lista) {
					System.out.println(empleado);
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
			ProductoDAO productoDAO = new ProductoDAO();
			String sueldo = null;
			try {
				sueldo = productoDAO.obtenerSueldo(empleado.getDni());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.setAttribute("sueldo", sueldo);
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/buscarDni.jsp");
			requestDispatcher.forward(request, response);

		}else if (opcion.equals("modificarEmpleados")) {
//			ProductoDAO productoDAO = new ProductoDAO();
//			List<Empleado> lista = new ArrayList<>();
//			String campo = request.getParameter("campo");
//			try {
//				lista = productoDAO.obtenerEmpleado(campo);
//				for (Empleado empleado : lista) {
//					System.out.println(empleado);
//				}
//
//				request.setAttribute("listar", lista);
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/buscarEmpleados.jsp");
				requestDispatcher.forward(request, response);

//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
// TODO Auto-generated method stub
		String opcion = request.getParameter("opcion");

		if (opcion.equals("buscar")) {
			Empleado empleado = new Empleado();
			ProductoDAO productoDAO = new ProductoDAO();
			empleado.setDni(request.getParameter("dni"));

			try {
				String sueldo = productoDAO.obtenerSueldo(empleado.getDni());
				System.out.println(sueldo);
				request.setAttribute("dni", empleado.getDni());
				request.setAttribute("sueldo", sueldo);
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/listarSueldo.jsp");
				requestDispatcher.forward(request, response);

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if(opcion.equals("buscarEmpleado")) {
			List<Empleado> lista = new ArrayList<>();
			ProductoDAO productoDAO = new ProductoDAO();
			String campo = request.getParameter("campo");
			try {
				lista = productoDAO.obtenerEmpleado(campo);
				for (Empleado empleado : lista) {
					System.out.println(empleado);
				}
				request.setAttribute("listar", lista);
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/modificarEmpleados.jsp");
				requestDispatcher.forward(request, response);

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

// doGet(request, response);
	}

// else if (opcion.equals("meditar")) {
//   int id = Integer.parseInt(request.getParameter("id"));
//   System.out.println("Editar id: " + id);
//   ProductoDAO productoDAO = new ProductoDAO();
//   Producto p = new Producto();
//   try {
//    p = productoDAO.obtenerProducto(id);
//    System.out.println(p);
//    request.setAttribute("producto", p);
//    RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/editar.jsp");
//    requestDispatcher.forward(request, response);
// 
//   } catch (SQLException e) {
//    // TODO Auto-generated catch block
//    e.printStackTrace();
//   }
// 
//  } else if (opcion.equals("eliminar")) {
//   ProductoDAO productoDAO = new ProductoDAO();
//   int id = Integer.parseInt(request.getParameter("id"));
//   try {
//    productoDAO.eliminar(id);
//    System.out.println("Registro eliminado satisfactoriamente...");
//    RequestDispatcher requestDispatcher = request.getRequestDispatcher("/index.jsp");
//    requestDispatcher.forward(request, response);
//   } catch (SQLException e) {
//    // TODO Auto-generated catch block
//    e.printStackTrace();
//   }
// 
//  }
//   response.getWriter().append("Served at: ").append(request.getContextPath());
// }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
// protected void doPost(HttpServletRequest request, HttpServletResponse response)
//   throws ServletException, IOException {
//  // TODO Auto-generated method stub
//  String opcion = request.getParameter("opcion");
//  Date fechaActual = new Date();
// 
//  if (opcion.equals("guardar")) {
//   ProductoDAO productoDAO = new ProductoDAO();
//   Producto producto = new Producto();
//   producto.setNombre(request.getParameter("nombre"));
//   producto.setCantidad(Double.parseDouble(request.getParameter("cantidad")));
//   producto.setPrecio(Double.parseDouble(request.getParameter("precio")));
//   producto.setFechaCrear(new java.sql.Date(fechaActual.getTime()));
//   try {
//    productoDAO.guardar(producto);
//    System.out.println("Registro guardado satisfactoriamente...");
//    RequestDispatcher requestDispatcher = request.getRequestDispatcher("/index.jsp");
//    requestDispatcher.forward(request, response);
// 
//   } catch (SQLException e) {
//    // TODO Auto-generated catch block
//    e.printStackTrace();
//   }
//  } else if (opcion.equals("editar")) {
//   Producto producto = new Producto();
//   ProductoDAO productoDAO = new ProductoDAO();
// 
//   producto.setId(Integer.parseInt(request.getParameter("id")));
//   producto.setNombre(request.getParameter("nombre"));
//   producto.setCantidad(Double.parseDouble(request.getParameter("cantidad")));
//   producto.setPrecio(Double.parseDouble(request.getParameter("precio")));
//   producto.setFechaActualizar(new java.sql.Date(fechaActual.getTime()));
//   try {
//    productoDAO.editar(producto);
//    System.out.println("Registro editado satisfactoriamente...");
//    RequestDispatcher requestDispatcher = request.getRequestDispatcher("/index.jsp");
//    requestDispatcher.forward(request, response);
//   } catch (SQLException e) {
//    // TODO Auto-generated catch block
//    e.printStackTrace();
//   }
//  }
// 
//  // doGet(request, response);
// }

}
