package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Student;

import java.io.IOException;

import dao.AdminDao;
import dao.StudentDao;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/Login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/login.jsp");
		String role = request.getParameter("role");
		request.setAttribute("role", role);
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String role = request.getParameter("role");
		int id = Integer.parseInt(request.getParameter("id"));
		String password = request.getParameter("password");
		if(role.equals("admin")) {
			AdminDao admin = new AdminDao();
			admin.validateAdmin(id, password);
			
			if(admin != null) {
				HttpSession session = request.getSession();
				session.setAttribute("admin", admin);
				
				response.sendRedirect("AdminDashboard");
			}
		
		}else{
			StudentDao studao = new StudentDao();
			Student student = studao.validateStudent(id, password);
			
			if(student != null) {
				HttpSession session = request.getSession();
				
				session.setAttribute("student", student);
				
				response.sendRedirect("StudentDashboard");
			}
		}
	}

}
