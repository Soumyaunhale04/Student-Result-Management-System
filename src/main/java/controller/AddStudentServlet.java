package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Student;

import java.io.IOException;

import dao.StudentDao;

/**
 * Servlet implementation class AddStudentServlet
 */
@WebServlet("/AddStudent")
public class AddStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddStudentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/addStudent.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			int rollno = Integer.parseInt(request.getParameter("rollno"));
			String name = request.getParameter("name");
			String branch = request.getParameter("branch");
			int semester = Integer.parseInt(request.getParameter("semester"));
			String password = request.getParameter("password");
			
			Student student = new Student();
			student.setRollno(rollno);
			student.setName(name);
			student.setBranch(branch);
			student.setSemester(semester);
			student.setPassword(password);
			
			StudentDao studao = new StudentDao();
			boolean success = studao.addStudent(student);
				if(success) {
				    response.sendRedirect(request.getContextPath() + "/AdminDashboard");
				} else {
				    response.sendRedirect(request.getContextPath() + "/AddStudent");
				}
	}

}
