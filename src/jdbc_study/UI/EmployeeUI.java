package jdbc_study.UI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import jdbc_study.dao.DepartmentDao;
import jdbc_study.dao.EmployeeDao;
import jdbc_study.dto.Employee;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EmployeeUI extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JButton btnDelete;
	private JButton btnSearch;
	private JButton btnAdd;
	private JButton btnList;
	private JButton btnChange;
	private List<Employee> emplist;
	private JScrollPane scrollPane;
	private JTable table;
	private EmployeeUi2 employeeUi2;
	private EmployeeDao empDao;
	
	
	public EmployeeUI() {
		//this.empDao = new empDao<>();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 707, 557);
		
		JMenuBar menuBar_1 = new JMenuBar();
		setJMenuBar(menuBar_1);
		
		btnAdd = new JButton("추가");
		btnAdd.addActionListener(this);
		menuBar_1.add(btnAdd);
		
		btnChange = new JButton("수정");
		btnChange.addActionListener(this);
		menuBar_1.add(btnChange);
		
		btnList = new JButton("목록");
		btnList.addActionListener(this);
		menuBar_1.add(btnList);
		
		btnDelete = new JButton("삭제");
		btnDelete.addActionListener(this);
		menuBar_1.add(btnDelete);
		
		btnSearch = new JButton("검색");
		btnSearch.addActionListener(this);
		menuBar_1.add(btnSearch);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		loadData();
		
		
		
		if(employeeUi2==null){
			employeeUi2=new EmployeeUi2();
		}

	}
	
	//empno, empname,title, manager, salary, dno
	
	public void loadData(){
		DefaultTableModel model = new DefaultTableModel(getDatas(), getColumnNames());
		table.setModel(model);
	}
	
	private Object[][] getDatas() {
		emplist = EmployeeDao.getInstance().selectEmployeeByAll();
		
		Object[][] objectds = new Object[emplist.size()][];
		for (int i = 0; i < emplist.size(); i++) {
			objectds[i] = emplist.get(i).toArray();
			
		}
		return objectds;
	}

	
	private String[] getColumnNames() {
		return new String[] {"사원번호","사원이름","직급","관리자","월급","부서번호"};
	}
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmployeeUI frame = new EmployeeUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnSearch) {
			btnSearchActionPerformed(e);
		}
		if (e.getSource() == btnChange) {
			btnChangeActionPerformed(e);
		}
		if (e.getSource() == btnList) {
			btnListActionPerformed(e);
		}
		if (e.getSource() == btnAdd) {
			btnAddActionPerformed(e);
		}
		if (e.getSource() == btnDelete) {
			btnDeleteActionPerformed(e);
		}
	}
	
	
	
	protected void btnDeleteActionPerformed(ActionEvent e) {
		employeeUi2.setVisible(true);
		employeeUi2.setbtn("삭제");
	}
	protected void btnAddActionPerformed(ActionEvent e) {
		employeeUi2.setVisible(true);
		employeeUi2.setbtn("추가");
	}
	protected void btnListActionPerformed(ActionEvent e) {
		loadData();
	}
	protected void btnChangeActionPerformed(ActionEvent e) {
		employeeUi2.setVisible(true);
		employeeUi2.setbtn("수정");
	}
	protected void btnSearchActionPerformed(ActionEvent e) {
		employeeUi2.setVisible(true);
		employeeUi2.setbtn("검색");
	}
}
