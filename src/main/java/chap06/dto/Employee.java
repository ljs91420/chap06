package chap06.dto;

public class Employee {
	int employee_id;
	String first_name;
	String last_name;
	String job_id;
	Double salary;
	Double commission_pct;
	Integer department_id;
	
	public Employee(int employee_id, String first_name, String last_name, String job_id, Double salary,
			Double commission_pct, Integer department_id) {
		super();
		this.employee_id = employee_id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.job_id = job_id;
		this.salary = salary;
		this.commission_pct = commission_pct;
		this.department_id = department_id;
	}

	public int getEmployee_id() {
		return employee_id;
	}
	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getJob_id() {
		return job_id;
	}
	public void setJob_id(String job_id) {
		this.job_id = job_id;
	}
	public Double getSalary() {
		return salary;
	}
	public void setSalary(Double salary) {
		this.salary = salary;
	}
	public Double getCommission_pct() {
		return commission_pct;
	}
	public void setCommission_pct(Double commission_pct) {
		this.commission_pct = commission_pct;
	}
	public Integer getDepartment_id() {
		return department_id;
	}
	public void setDepartment_id(Integer department_id) {
		this.department_id = department_id;
	}
	
	@Override
	public String toString() {
		return "Employee [employee_id=" + employee_id + ", first_name=" + first_name + ", last_name=" + last_name
				+ ", job_id=" + job_id + ", salary=" + salary + ", commission_pct=" + commission_pct
				+ ", department_id=" + department_id + "]";
	}
}
