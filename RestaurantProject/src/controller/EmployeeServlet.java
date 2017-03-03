package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EmployeeDAO;
import model.Employee;

/**
 * Servlet implementation class EmployeeServlet
 */
@WebServlet("/EmployeeServlet")
public class EmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		String action = request.getParameter("action");
		if(action.equals("insert")){
			String id = request.getParameter("id");
			String name = request.getParameter("name");
			int position = Integer.parseInt(request.getParameter("position"));
			
			String strSalary = request.getParameter("salary");
			int salary = 0;
			Employee employee = new Employee();
			employee.setId(id);
			employee.setName(name);
			employee.setPosition(position);
			
			if(strSalary.length() > 0){
				salary = Integer.parseInt(strSalary);
				
				employee.setSalary(salary);
			}
			
			EmployeeDAO dao = new  EmployeeDAO();
			if(dao.validId(id)){
				boolean result = dao.insert(employee);
							
				if(result){
					RequestDispatcher rd = request.getRequestDispatcher("main.jsp");
					request.setAttribute("message", "เพิ่มข้อมูลพนักงานสำเร็จ");
					rd.forward(request, response);
				}else{
					RequestDispatcher rd = request.getRequestDispatcher("insert.jsp");
					request.setAttribute("message", "เกิดข้อผิดพลาดในการเพิ่มข้อมูลพนักงาน");
					rd.forward(request, response);
				}
			}else{
				RequestDispatcher rd = request.getRequestDispatcher("insert.jsp");
				request.setAttribute("checkid", "รหัสพนักงานซ้ำ ให้ป้อนใหม่");
				request.setAttribute("employee", employee);
				rd.forward(request, response);
			}
			
			
			
		}
	}

}
