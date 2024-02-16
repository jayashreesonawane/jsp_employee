package jsp_employee;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/delete")
public class DeleteController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int id = Integer.parseInt(req.getParameter("id"));

		EmployeeCRUD crud = new EmployeeCRUD();

		try {

			int count = crud.delete(id);
			if (count != 0) {
				List<Employee> list = crud.getAllEmployees();
				req.setAttribute("list", list);
				RequestDispatcher dispatcher = req.getRequestDispatcher("Success.jsp");
				dispatcher.forward(req, resp);
			}
		} catch (ClassNotFoundException | SQLException e) {

			e.printStackTrace();
		}
	}
}
