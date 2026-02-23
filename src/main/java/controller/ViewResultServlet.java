package controller;
import model.Result;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Student;

import java.io.IOException;

import dao.ResultDao;
import java.util.List;
/**
 * Servlet implementation class ViewResultServlet
 */
@WebServlet("/ViewResult")
public class ViewResultServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewResultServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		
		if(session == null || session.getAttribute("student") == null) {
			response.sendRedirect(request.getContextPath() + "/Login?role=student");
			return;
		}
		
		Student stu = (Student) session.getAttribute("student");
		int rollno = stu.getRollno();

			List<Result> results = ResultDao.getResultByRollNo(rollno);
		
			request.setAttribute("results", results);
			request.setAttribute("student", stu);
		
			RequestDispatcher disp = request.getRequestDispatcher("/WEB-INF/views/viewResult.jsp");
			disp.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
