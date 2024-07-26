<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="chap06.dto.Employee, java.util.List" %>
<% 
	Employee emp = (Employee) request.getAttribute("emp");
	List<String[]> jobs = (List<String[]>) request.getAttribute("jobs");
	String full_name = emp.getFirst_name() + " " + emp.getLast_name();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>수정 페이지</title>
</head>
<body>
	<h3>'<%=full_name %>' 사원 정보 수정하기</h3>
	
	<form action="">
		사원번호: <input type="number" name="employee_id" value="<%=emp.getEmployee_id() %>" readonly /> <br>
		이름: <input type="text" name="first_name" value="<%=emp.getFirst_name() %>" /> <br>
		성: <input type="text" name="last_name" value="<%=emp.getLast_name() %>" /> <br>
		직책: <select name="job_id">
			<% for (String[] job : jobs) { %>
				<option value="<%=job[0] %>"><%=job[1] %>(<%=job[0] %>)</option>
			<% } %>
		</select> <br>
		월급: <input type="number" name="salary" value="<%=emp.getSalary() %>" /> <br>
		커미션: <input type="number" name="commission_pct" value="<%=emp.getCommission_pct() %>" /> <br>
		부서번호: <input type="number" name="department_id" value="<%=emp.getDepartment_id() %>" /> <br>
	</form>
</body>
</html>