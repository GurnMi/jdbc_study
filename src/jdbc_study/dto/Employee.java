package jdbc_study.dto;

public class Employee {
	private int empno;
	private String empname;
	private String title;
	private int manager;
	private int salary;
	private int dno;
	public Employee(int empno, String empname, String title, int manamer, int salary, int don) {
		this.empno = empno;
		this.empname = empname;
		this.title = title;
		this.manager = manamer;
		this.salary = salary;
		this.dno = don;
	}
	
	public Employee(){}
	
	public Employee(int empno) {
		this.empno = empno;
	}
	public int getEmpno() {
		return empno;
	}
	public void setEmpno(int empno) {
		this.empno = empno;
	}
	public String getEmpname() {
		return empname;
	}
	public void setEmpname(String empname) {
		this.empname = empname;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getManager() {
		return manager;
	}
	public void setManager(int manager) {
		this.manager = manager;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public int getDno() {
		return dno;
	}
	public void setDno(int don) {
		this.dno = don;
	}
	@Override
	public String toString() {
		return String.format("Employee [empno=%s, empname=%s, title=%s, manager=%s, salary=%s, dno=%s]", empno, empname,
				title, manager, salary, dno);
	}
	
	public Object[] toArray(){
		return new Object[]{ empno, empname,title, manager, salary, dno};
	}
	
	
	
}
