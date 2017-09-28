package jdbc_study.UI;

import java.awt.EventQueue;
import java.awt.GridLayout;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import jdbc_study.dao.DepartmentDao;
import jdbc_study.dto.Department;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DepartmentUI extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField tfdeptno;
	private JTextField tfdeptname;
	private JTextField tffloor;
	private static List<Department> listDepartment;
	private JTable table;
	private JButton btnDelete;
	private JButton btnSearch;
	private JButton btnAdd;
	private JButton btnList;
	private JButton btnChange;
	private JButton btn;
	private JPanel panel;
	private JButton btnCancel;
	private DepartmentDao dao;

	public DepartmentUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 451, 601);
		
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
		contentPane.setLayout(new GridLayout(0, 1, 0, 0));

		panel = new JPanel();
		contentPane.add(panel);
		panel.setLayout(new GridLayout(0, 2, 0, 0));

		JLabel lbldeptno = new JLabel("부서번호");
		panel.add(lbldeptno);

		tfdeptno = new JTextField();
		panel.add(tfdeptno);
		tfdeptno.setColumns(10);

		JLabel lbldeptname = new JLabel("부서명");
		panel.add(lbldeptname);

		tfdeptname = new JTextField();
		tfdeptname.setColumns(10);
		panel.add(tfdeptname);

		JLabel lblfloor = new JLabel("부서위치");
		panel.add(lblfloor);

		tffloor = new JTextField();
		tffloor.setColumns(10);
		panel.add(tffloor);

		btn = new JButton("실행");
		btn.addActionListener(this);
		panel.add(btn);

		btnCancel = new JButton("취소");
		btnCancel.addActionListener(this);
		panel.add(btnCancel);

		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);
		loadData();
		
		dao = DepartmentDao.getInstance();
		//dao.deptname(new Department(1));
		dao.deptname();

		System.out.println();
		
	}
	
	public void loadData(){
		DefaultTableModel model = new DefaultTableModel(getDatas(), getColumnNames());
		table.setModel(model);
	}
	
	private void addData() {
		dao = DepartmentDao.getInstance();
		dao.insertDepartment(new Department(Integer.parseInt(tfdeptno.getText()), tfdeptname.getText(), Integer.parseInt(tffloor.getText())));

		loadData();
	}
	
	private void deletedata() {
		dao = DepartmentDao.getInstance();
		dao.deleteDepartment(new Department(Integer.parseInt(tfdeptno.getText())));
		loadData();
	}
	
	private void searchData() {
		dao = DepartmentDao.getInstance();
		Department searchD = dao.selectDepartmentByNo(new Department(Integer.parseInt(tfdeptno.getText())));
		System.out.println(searchD);
		tfdeptname.setText(searchD.getDeptname());
		tffloor.setText(searchD.getFloor()+"");
	}

	private void changeData() {
		dao = DepartmentDao.getInstance();
		dao.updateDepartment(new Department(Integer.parseInt(tfdeptno.getText()), tfdeptname.getText(), Integer.parseInt(tffloor.getText())));
		loadData();
	}


	
	
	
	private Object[][] getDatas() {
		listDepartment = DepartmentDao.getInstance().selectDepartmentByAll();
		
		Object[][] objectds = new Object[listDepartment.size()][];
		for (int i = 0; i < listDepartment.size(); i++) {
			objectds[i] = listDepartment.get(i).toArray();
			
		}
		return objectds;
	}

	private String[] getColumnNames() {
		return new String[] { "부서번호", "부서명", "부서위치" };
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DepartmentUI frame = new DepartmentUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCancel) {
			btnCancelActionPerformed(e);
		}
		if (e.getSource() == btn) {
			btnActionPerformed(e);
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
		if (e.getSource() == btnSearch) {
			btnSearchActionPerformed(e);
		}
		if (e.getSource() == btnDelete) {
			btnDeleteActionPerformed(e);
		}
	}
	protected void btnDeleteActionPerformed(ActionEvent e) {
		btn.setText("삭제");
		tfdeptno.setEnabled(true);
	}
	protected void btnSearchActionPerformed(ActionEvent e) {
		btn.setText("검색");
		tfdeptno.setEnabled(true);
	}
	protected void btnAddActionPerformed(ActionEvent e) {
		tfdeptno.setText(listDepartment.size()+1+"");
		tfdeptno.setEnabled(false);
		btn.setText("추가");
	}
	protected void btnListActionPerformed(ActionEvent e) {
		btn.setText("목록");
		tfdeptno.setEnabled(true);
	}
	protected void btnChangeActionPerformed(ActionEvent e) {
		btn.setText("수정");
		tfdeptno.setEnabled(true);
	}
	
	
	protected void btnActionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("삭제")){
			System.out.println("삭제");
			deletedata();
		}
		if(e.getActionCommand().equals("검색")){
			System.out.println("검색");
			searchData();			
		}
		if(e.getActionCommand().equals("추가")){
			System.out.println("추가");
			addData();
		}
		if(e.getActionCommand().equals("목록")){
			System.out.println("목록");
			loadData();
		}
		if(e.getActionCommand().equals("수정")){
			System.out.println("수정");
			changeData();
		}
		
	}
	


	protected void btnCancelActionPerformed(ActionEvent e) {
	}
}
