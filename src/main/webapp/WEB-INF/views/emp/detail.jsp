<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="chap06.dto.Employee" %>
<% 
	Employee emp = (Employee) request.getAttribute("emp");
	String full_name = emp.getFirst_name() + " " + emp.getLast_name();
	int emp_id = emp.getEmployee_id();
	int next_id = emp.getEmployee_id() + 1;
	int prev_id = emp.getEmployee_id() - 1;
	int max_id = (int)request.getAttribute("max_id");
	int min_id = (int)request.getAttribute("min_id");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><%=full_name %></title>
</head>
<body>
	<h3>'<%=full_name %>'의 상세 정보</h3>
	
	사원번호 : <%=emp_id %> <button id="deleteBtn">삭제</button> <br>
	직책 : <%=emp.getJob_id() %> <br>
	부서번호 : <%=emp.getDepartment_id() %> <br>
	월급 : <%=emp.getSalary() %> <br>
	
	<% if (min_id != emp_id) { %>
		<button id="prevBtn">이전</button>
	<% } %>
	
	<% if (max_id != emp_id) { %>
		<button id="nextBtn">다음</button>
	<% } %>
	
	<button id="updateBtn">수정하기</button>
	
	<button id="backToListBtn">목록으로</button>
	
	<script>
		const prevBtn = document.getElementById("prevBtn");

		// prevBtn에 값이 없으면 .을 진행하지 않는다.
		prevBtn?.addEventListener("click", (e) => {
			location.href = "./detail?employee_id=<%=prev_id %>";
		});
		
		const nextBtn = document.getElementById("nextBtn");
		
		// nextBtn에 값이 없으면 .을 진행하지 않는다.
		nextBtn?.addEventListener("click", (e) => {
			location.href = "./detail?employee_id=<%=next_id %>";
		});
		
		const backToListBtn = document.getElementById("backToListBtn");
		
		backToListBtn.addEventListener("click", (e) =>{
			location.href = "./list";
		});
		
		const deleteBtn = document.getElementById("deleteBtn");
		
		deleteBtn.addEventListener("click", (e) => {
			location.href = "./delete?employee_id=<%=emp_id %>";
		});
		
		const updateBtn = document.getElementById("updateBtn");
		
		updateBtn.addEventListener("click", (e) =>{
			location.href = "./update?employee_id=<%=emp_id %>";
		});
	</script>
</body>
</html>