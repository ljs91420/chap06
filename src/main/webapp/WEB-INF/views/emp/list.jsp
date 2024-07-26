<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="chap06.dto.Employee, java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사원 목록 페이지</title>
</head>
<body>
	<h3>사원 목록</h3>
	
	<table border="1">
		<tr>
			<th>사원번호</th>
			<th>이름</th>
			<th>성</th>
			<th>직책ID</th>
			<th>월급</th>
			<th>커미션</th>
			<th>부서번호</th>
		</tr>
		
		<% 
			List<Employee> empList = (List) request.getAttribute("empList");
			
			for (Employee emp : empList) {
		%>
			<tr onclick="emp_detail(<%=emp.getEmployee_id() %>);">
				<td><%=emp.getEmployee_id() %></td>
				<td><%=emp.getFirst_name() %></td>
				<td><%=emp.getLast_name() %></td>
				<td><%=emp.getJob_id() %></td>
				<td><%=emp.getSalary() %></td>
				<td><%=emp.getCommission_pct() %></td>
				<td><%=emp.getDepartment_id() %></td>
			</tr>
		<% } %>
	</table>
	
	<script>
		function emp_detail(emp_id) {
			console.log("emp_id", emp_id);
			location.href = '/emp/detail?employee_id=' + emp_id;
		}
	</script>
</body>
</html>