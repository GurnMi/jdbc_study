package jdbc_study.dto;

public class Department {
	private int deptno;
	private String deptname;
	private int floor;

	public Department(int deptno) {
		this.deptno = deptno;
	}

	public Department(int deptno, String deptname, int floor) {
		this.deptno = deptno;
		this.deptname = deptname;
		this.floor = floor;
	}

	public int getDeptno() {
		return deptno;
	}

	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}

	public String getDeptname() {
		return deptname;
	}

	public void setDeptname(String deptname) {
		this.deptname = deptname;
	}

	public int getFloor() {
		return floor;
	}

	public void setFloor(int floor) {
		this.floor = floor;
	}

	/*@Override
	public String toString() {
		return String.format("Department [deptno=%s, deptname=%s, floor=%s]", deptno, deptname, floor);
	}
*/
	@Override
	public String toString() {
		return String.format("%s,%s, %s", deptno, deptname, floor);
	}
	
	public Object[] toArray(){
		return new Object[]{deptno, deptname, floor};
	}
}
