package jdbc_study.UI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

public class DepartmentMainUI extends JFrame {

	private JPanel contentPane;

	
	
	public DepartmentMainUI(JPanel contentPane) {
		this.contentPane = contentPane;
	}


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DepartmentMainUI frame = new DepartmentMainUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public DepartmentMainUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JButton btnAdd = new JButton("추가");
		contentPane.add(btnAdd, BorderLayout.CENTER);
	}

}
