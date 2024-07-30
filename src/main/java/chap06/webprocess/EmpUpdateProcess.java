package chap06.webprocess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import chap06.dao.OjdbcConnection;
import chap06.dto.Employee;
import chap06.web.WebProcess;

public class EmpUpdateProcess implements WebProcess {
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		// ex) 정규표현식 등을 활용해 값 체크를 하고.. 문제가 있으면 리다이렉트..
		
		// 생략..
		
		Employee emp = new Employee(request);
		
		// DB에 update
		OjdbcConnection ojdbc = (OjdbcConnection) request.getServletContext().getAttribute("ojdbc");
		String sql = "UPDATE employee2 SET first_name=?, last_name=?, job_id=?, salary=?, commission_pct=?, department_id=? WHERE employee_id=?";
		
		try (
			Connection conn = ojdbc.getConnection(); 
			PreparedStatement pstmt = conn.prepareStatement(sql);
		) {
			pstmt.setInt(1, emp.getEmployee_id());
			pstmt.setString(2, emp.getFirst_name());
			pstmt.setString(3, emp.getLast_name());
			pstmt.setString(4, emp.getJob_id());
			pstmt.setDouble(5, emp.getSalary());
			pstmt.setDouble(6, emp.getCommission_pct());
			pstmt.setInt(7, emp.getDepartment_id());
			
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return "redirect:/emp/detail?employee_id=" + emp.getEmployee_id();
	}
}
