package chap06.webprocess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import chap06.dao.OjdbcConnection;
import chap06.dto.Employee;
import chap06.web.WebProcess;

public class EmpDetailProcess implements WebProcess {
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		OjdbcConnection ojdbc = (OjdbcConnection) request.getServletContext().getAttribute("ojdbc");
		String sql = "SELECT * FROM employees2 WHERE employee_id = ?";
		String sql2 = "SELECT max(employee_id) AS max_id, min(employee_id) AS min_id FROM employees2";
		try (
			Connection conn = ojdbc.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			PreparedStatement pstmt2 = conn.prepareStatement(sql2);
		) {
			pstmt.setInt(1, Integer.parseInt(request.getParameter("employee_id")));
			
			try (ResultSet rs = pstmt.executeQuery()) {
				rs.next();
				
				request.setAttribute("emp", new Employee(
					rs.getInt("employee_id"),
					rs.getString("first_name"),
					rs.getString("last_name"),
					rs.getString("job_id"),
					rs.getDouble("salary"),
					rs.getDouble("commission_pct"),
					rs.getInt("department_id")
				));
			}
			
			// 이전, 다음 버튼이 있는지 없는지 체크하기 위해 값들이 필요하다.
			try (ResultSet rs = pstmt2.executeQuery()) {
				rs.next();
				request.setAttribute("max_id", rs.getInt("max_id"));
				request.setAttribute("min_id", rs.getInt("min_id"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "/emp/detail";
	}
}
