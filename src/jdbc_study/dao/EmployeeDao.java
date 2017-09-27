package jdbc_study.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import jdbc_study.dto.Employee;
import jdbc_study.jdbc.DBCon;
import jdbc_study.jdbc.jdbcUtill;

public class EmployeeDao {
	private static final EmployeeDao instance = new EmployeeDao();
	
	private String sql;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private Connection con;
	
	private EmployeeDao(){}

	public static EmployeeDao getInstance() {
		return instance;
	}
	
	
	
	public void selectEmployeeByNo(Employee emp){
		
		sql = "select empno, empname, title, manager, salary, dno from employee where empno=?";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, emp.getEmpno());
			
			ResultSet res = pstmt.executeQuery();
			res.next();
			
			emp =  new Employee(res.getInt("empno"), res.getString(2), res.getString(3), res.getInt(4), res.getInt(5), res.getInt(6));
			
			System.out.println("검색결과 = " +emp);
			
		}catch (SQLException e) {
			System.out.println(e.getErrorCode());
			System.out.println(e.getMessage());
			e.printStackTrace();
		}finally{
			jdbcUtill.close(pstmt);
		}
	}
	
	
	
	public void deleteEmplyee(Employee emp){
		sql = "delete from employee where empno=?";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, emp.getEmpno());
			
			int res = pstmt.executeUpdate();
			if(res<0){
				System.out.println("삭제실패");
				return;
			}
			JOptionPane.showMessageDialog(null, emp+"삭제하였습니다.");		
		} catch (SQLException e) {
			System.out.println(e.getErrorCode());
			System.out.println(e.getMessage());
			e.printStackTrace();
		}finally{
			jdbcUtill.close(pstmt);
		}
	}
	
	public void insertEmployee(Employee emp){
		sql = "insert into employee values(?,?,?,?,?,?)";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, emp.getEmpno());
			pstmt.setString(2, emp.getEmpname());
			pstmt.setString(3, emp.getTitle());
			pstmt.setInt(4, emp.getManager());
			pstmt.setInt(5, emp.getSalary());
			pstmt.setInt(6, emp.getDno());
			
			
			int res = pstmt.executeUpdate();
			if(res<0){
				System.out.println("추가실패");
				return;
			}
			JOptionPane.showMessageDialog(null, emp+"추가");
		} catch (SQLException e) {
			System.out.println(e.getErrorCode());
			System.out.println(e.getMessage());
			e.printStackTrace();
		}finally{
			jdbcUtill.close(pstmt);
		}
		
		
	}
	
	
	public void updateEmployee(Employee emp){
		List<Employee> lists = new ArrayList<>();
		
		sql = "update employee set empname=?, title=?, manager=?, salary=?, dno=? where empno=?";
		con = DBCon.getInstance().getConn();
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, emp.getEmpname());
			pstmt.setString(2, emp.getTitle());
			pstmt.setInt(3, emp.getManager());
			pstmt.setInt(4, emp.getSalary());
			pstmt.setInt(5, emp.getDno());
			pstmt.setInt(6, emp.getEmpno());
			
			int res = pstmt.executeUpdate();
			if(res<0){
				System.out.println("수정실패");
				return;
			}
			JOptionPane.showMessageDialog(null, emp+"수정");
		} catch (SQLException e) {
			System.out.println(e.getErrorCode());
			System.out.println(e.getMessage());
			e.printStackTrace();
		}finally{
			jdbcUtill.close(pstmt);
		}
	}
		
		
	
	
	
	public List<Employee> selectEmployeeByAll(){
		List<Employee> lists = new ArrayList<>();
		
		sql = "select empno, empname, title, manager, salary, dno from employee";
		con = DBCon.getInstance().getConn();
		
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()){
				int empno = rs.getInt("empno");
				String empname = rs.getString("empname");
				String title = rs.getString("title");
				int manager = rs.getInt("manager");
				int salary = rs.getInt("salary");
				int dno = rs.getInt("dno");
				lists.add(new Employee(empno, empname, title, manager, salary, dno));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			jdbcUtill.close(rs);
			jdbcUtill.close(pstmt);
		}
		return lists;		
	}
		
	
	
}
