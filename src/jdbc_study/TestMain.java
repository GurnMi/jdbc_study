package jdbc_study;

import java.util.List;

import jdbc_study.dao.DepartmentDao;
import jdbc_study.dao.EmployeeDao;
import jdbc_study.dto.Department;
import jdbc_study.dto.Employee;
import jdbc_study.jdbc.DBCon;

public class TestMain {

	public static void main(String[] args) {
/*		DBCon dbCon = DBCon.getInstance();			//getInstance로 바꿔줘야 연결한번만해서 계속 활용
		System.out.println(dbCon);
		System.out.println(dbCon.getConn());
		
		
		
		DBCon dbCon1 = DBCon.getInstance();
		System.out.println(dbCon1);
		System.out.println(dbCon1.getConn());
		
		
		dbCon.connClose();*/
		
		
		
		
		
		DepartmentDao dao = DepartmentDao.getInstance();
		showDepartmentList(dao);
		
		/*Department dept = new Department(6, "마케팅", 10);
		dao.insertDepartment(dept);
		
		showDepartmentList(dao);
		
		
		Department deldept = new Department(6);
		dao.deleteDepartment(deldept);
		
		showDepartmentList(dao);
		
		Department updept = new Department(2, "연구", 1);
		dao.updateDepartment(updept);
		
		Department seldept = new Department(1);
		dao.selectDepartmentByNo(seldept);*/
		
		//////////////////////////////////
		
		
		EmployeeDao daoE = EmployeeDao.getInstance();
		showEmployeeList(daoE);
		
		
		/*	Employee upemp = new Employee(1003, "서현진", "사원", 1365, 1500000, 2);
		daoE.updateEmployee(upemp);
		showEmployeeList(daoE);
		
		Employee insertemp = new Employee(1004, "공유", "사원", 1365, 1500000, 2);
		daoE.insertEmployee(insertemp);
		showEmployeeList(daoE);
		
		
		Employee delemp = new Employee(1004);
		daoE.deleteEmplyee(delemp);
		showEmployeeList(daoE);
		
		daoE.selectEmployeeByNo(new Employee(2106));*/
		
		
	}

	private static void showDepartmentList(DepartmentDao dao) {
		System.out.println("===================================");
		List<Department> lists = dao.selectDepartmentByAll();
		for(Department dept:lists){
			System.out.println(dept);
		}		
	}
	
	
	private static void showEmployeeList(EmployeeDao daoE) {
		System.out.println("===================================");
		List<Employee> lists = daoE.selectEmployeeByAll();
		for(Employee emp:lists){
			System.out.println(emp);
		}		
	}

}
