package jdbc_study.UI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import jdbc_study.dao.DepartmentDao;
import jdbc_study.dao.EmployeeDao;
import jdbc_study.dto.Employee;

import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JSpinner;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EmployeeUi2 extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField tfempno;
	private JTextField tfempname;
	private JTextField tftitle;
	private EmployeeDao empdao;
	private JButton btn;
	private JButton btnCancel;
	private DepartmentDao deptdao;
//	private DepartmentUI deptUi;
	
	
	
	String[] getdno= {"영업","개발"};
	/*String[] getdno(){
		getdno = {"영업","개발"};
		
		return getdno();
	}*/
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmployeeUi2 frame = new EmployeeUi2();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public EmployeeUi2() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 522, 580);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblempno = new JLabel("사원번호");
		contentPane.add(lblempno);
		
		tfempno = new JTextField();
		contentPane.add(tfempno);
		tfempno.setColumns(10);
		
		JLabel lblempname = new JLabel("사원이름");
		contentPane.add(lblempname);
		
		tfempname = new JTextField();
		tfempname.setColumns(10);
		contentPane.add(tfempname);
		
		JLabel lbltiltle = new JLabel("직급");
		contentPane.add(lbltiltle);
		
		tftitle = new JTextField();
		contentPane.add(tftitle);
		tftitle.setColumns(10);
		
		JLabel lblmanager = new JLabel("관리자");
		contentPane.add(lblmanager);
		
		JComboBox commanager = new JComboBox();
		contentPane.add(commanager);
		
		JLabel lblsalary = new JLabel("월급");
		contentPane.add(lblsalary);
		
		JSpinner spinnersalary = new JSpinner();
		contentPane.add(spinnersalary);
		
		deptdao = DepartmentDao.getInstance();
		
		JLabel lbldno = new JLabel("부서명");
		contentPane.add(lbldno);
		
		JComboBox comdno = new JComboBox(deptdao.deptname());
		contentPane.add(comdno);
		
		btn = new JButton("실행");
		btn.addActionListener(this);
		contentPane.add(btn);
		
		btnCancel = new JButton("취소");
		btnCancel.addActionListener(this);
		contentPane.add(btnCancel);
	}


	public void setbtn(String btnTitle) {
		btn.setText(btnTitle);
	}



	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btn) {
			btnActionPerformed(e);
		}
		if (e.getSource() == btnCancel) {
			btnCancelActionPerformed(e);
		}
	}
	protected void btnCancelActionPerformed(ActionEvent e) {
		
		
	}
	protected void btnActionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("삭제")){
			System.out.println("삭제");
			//deletedata();
		}
		if(e.getActionCommand().equals("검색")){
			System.out.println("검색");
			//searchData();			
		}
		if(e.getActionCommand().equals("추가")){
			System.out.println("추가");
			addData();
		}
		
		if(e.getActionCommand().equals("수정")){
			System.out.println("수정");
			//changeData();
		}
		
		
	}


	private void addData() {
		empdao = EmployeeDao.getInstance();
		//dao.insertEmployee(new Employee(Integer.parseInt(tfdeptno.getText()), empname, title, manamer, salary, don));
		
		
	}
}
