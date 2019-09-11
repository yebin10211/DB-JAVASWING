import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Window.Type;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class LoginForm extends JFrame implements ActionListener{
	
	private JTextField textField;
	private JTextField textField_1;
	private JButton btnCancel = new JButton("Cancel");
	private JButton btnLogin = new JButton("Login");
	
	@Override
	public void actionPerformed(ActionEvent e) {
//		System.out.println("e.getSource() = "+e.getSource());
		
		if(e.getSource() == btnCancel) {
			System.exit(0);
		}else {
			// DB ���� �ذ����� ID PW �� ������
			/*
			 * 1. ojdbc6.jar ���� �����ͼ� ������Ʈ�� �����н� ����
			 * 2. class.forName �Լ��� class �߰� �Ǿ����� Ȯ��
			 * 3. Connection DriverManager.getConnection DB ����
			 * 4. PrepareStatement pstmt sql ���� ����
			 * 5. Resultset ���̺� ���� ���.
			 * 
			 * insert update delete -> executeUpdate(); ��ȯ���� 0,1
			 * select -> executeQuery(); ��ȯ���� ���̺�
			 */
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hr","1234");
				pstmt = conn.prepareStatement("select * from member where id=? and pw=?");
				pstmt.setString(1, textField.getText());
				pstmt.setString(2, textField_1.getText());
				rs = pstmt.executeQuery();
				
				if(rs.next()) {
//					System.out.println("id = "+rs.getString(1));
//					System.out.println("pw = "+rs.getString(2));
					setVisible(false);
					new MainForm();	
				}else {
					JOptionPane.showMessageDialog(null, "�α��� ������ Ȯ�� �ϼ���.");
				}
				
			}catch (Exception ex) {
				ex.printStackTrace();
			}finally {
				try {
					rs.close();
					pstmt.close();
					conn.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		}
	}
	
	LoginForm(){
		setLocation(400, 200);
//		setLocationRelativeTo(null);	// JFrame �߰����� ����
		
		setTitle("LoginForm");

		setSize(300,400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 0, 153));
		panel.setBounds(0, 0, 284, 86);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblLoginForm = new JLabel("Login Form");
		lblLoginForm.setForeground(Color.WHITE);
		lblLoginForm.setFont(new Font("�ü�ü", Font.BOLD, 25));
		lblLoginForm.setBounds(44, 10, 163, 66);
		panel.add(lblLoginForm);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(51,51,204));
		panel_1.setBounds(0, 84, 284, 278);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		btnCancel.setFont(new Font("�ü�ü", Font.BOLD, 14));
		btnCancel.setBounds(40, 185, 102, 58);
		panel_1.add(btnCancel);
		
		btnLogin.setFont(new Font("�ü�ü", Font.BOLD, 14));
		btnLogin.setBounds(154, 185, 102, 58);
		panel_1.add(btnLogin);
		
		JLabel lblId = new JLabel("ID");
		lblId.setFont(new Font("�ü�ü", Font.BOLD, 30));
		lblId.setForeground(Color.WHITE);
		lblId.setBounds(40, 10, 52, 76);
		panel_1.add(lblId);
		
		JLabel lblPw = new JLabel("PW");
		lblPw.setFont(new Font("�ü�ü", Font.BOLD, 30));
		lblPw.setForeground(Color.WHITE);
		lblPw.setBounds(40, 89, 52, 58);
		panel_1.add(lblPw);
		
		textField = new JTextField();
		textField.setFont(new Font("�ü�ü", Font.BOLD, 30));
		textField.setBounds(94, 29, 150, 48);
		panel_1.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("�ü�ü", Font.BOLD, 30));
		textField_1.setColumns(10);
		textField_1.setBounds(94, 96, 150, 48);
		panel_1.add(textField_1);
		
		setVisible(true);
		
		btnCancel.addActionListener(this);
		btnLogin.addActionListener(this);
	}
	
	public static void main(String[] args) {
		new LoginForm();
	}


}






