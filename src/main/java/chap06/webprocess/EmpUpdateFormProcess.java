package chap06.webprocess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import chap06.dao.OjdbcConnection;
import chap06.dto.Employee;
import chap06.web.WebProcess;

public class EmpUpdateFormProcess implements WebProcess {
	
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		OjdbcConnection ojdbc = (OjdbcConnection) request.getServletContext().getAttribute("ojdbc");
		String sql = "SELECT * FROM employees2 WHERE employee_id = ?";
		String sql2 = "SELECT job_id, job_title FROM jobs";
		String sql3 = "SELECT department_id, department_name FROM departments";
		
		try (
			Connection conn = ojdbc.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			PreparedStatement pstmt2 = conn.prepareStatement(sql2);
			PreparedStatement pstmt3 = conn.prepareStatement(sql3);
		) {
			pstmt.setInt(1, Integer.parseInt(request.getParameter("employee_id")));
			pstmt.setInt(2, Integer.parseInt(request.getParameter("job_id")));
			pstmt.setInt(3, Integer.parseInt(request.getParameter("department_id")));
			
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
			
			try (ResultSet rs = pstmt2.executeQuery()) {
				List<String[]> jobs = new ArrayList<>();
				while (rs.next()) {
					jobs.add(new String[] {rs.getString("job_id"), rs.getString("job_title")});
				}
				request.setAttribute("jobs", jobs);
			}
			
			try (ResultSet rs = pstmt3.executeQuery()) {
				List<String[]> departments = new ArrayList<>();
				while (rs.next()) {
					departments.add(new String[] {rs.getString("department_id"), rs.getString("deparment_name")});
				}
				request.setAttribute("departments", departments);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "/emp/update";
	}
}
