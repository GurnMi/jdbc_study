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

public class DepartmentUI2 extends JFrame {

	private JPanel contentPane;
	private JTextField tfdeptno;
	private JTextField tfdeptname;
	private JTextField tffloor;
	private static List<Department> listDepartment;
	private JTable table;

	public DepartmentUI2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 451, 601);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 1, 0, 0));
		
		JMenuBar menuBar = new JMenuBar();
		contentPane.add(menuBar);
		
		JMenu mnNewMenu = new JMenu("New menu");
		menuBar.add(mnNewMenu);
		
		JMenu menu = new JMenu("New menu");
		menuBar.add(menu);

		JPanel panel = new JPanel();
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

		JButton btnAdd = new JButton("추가");
		panel.add(btnAdd);

		JButton btnCancel = new JButton("취소");
		panel.add(btnCancel);

		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);
		loadData();
	}
	
	public void loadData(){
		DefaultTableModel model = new DefaultTableModel(getDatas(), getColumnNames());
		table.setModel(model);
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
					DepartmentUI2 frame = new DepartmentUI2();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
