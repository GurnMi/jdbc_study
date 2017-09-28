package DepartmentUI;

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
import java.awt.BorderLayout;

public class Ui1 extends JFrame {

	private JPanel contentPane;
	private static List<Department> listDepartment;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	public Ui1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 451, 601);
		
		JMenuBar menuBar_1 = new JMenuBar();
		setJMenuBar(menuBar_1);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1);
		panel_1.setLayout(new GridLayout(0, 1, 0, 0));
		
		JMenuBar menuBar = new JMenuBar();
		panel_1.add(menuBar);
		
		JPanel panel = new JPanel();
		panel_1.add(panel);
		panel.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel label = new JLabel("부서번호");
		panel.add(label);
		
		textField = new JTextField();
		textField.setColumns(10);
		panel.add(textField);
		
		JLabel label_1 = new JLabel("부서명");
		panel.add(label_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		panel.add(textField_1);
		
		JLabel label_2 = new JLabel("부서위치");
		panel.add(label_2);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		panel.add(textField_2);
		
		JButton button = new JButton("추가");
		panel.add(button);
		
		JButton button_1 = new JButton("취소");
		panel.add(button_1);
		
		JScrollPane scrollPane = new JScrollPane();
		panel_1.add(scrollPane);
		loadData();
	}
	
	public void loadData(){
		DefaultTableModel model = new DefaultTableModel(getDatas(), getColumnNames());
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
					Ui1 frame = new Ui1();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
