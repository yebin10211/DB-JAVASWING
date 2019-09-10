import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class MainForm extends JFrame{
	private JTable table;

	public MainForm() {
		setTitle("MainForm");
		
		
		setLocation(400,200);
		
//		setLocationRelativeTo(null);
		setSize(487,305);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 79, 471, 188);
		panel.setBackground(new Color(0, 0, 153));
		
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("SelectMember");
		btnNewButton.setFont(new Font("궁서체", Font.BOLD, 17));
		btnNewButton.setBounds(300, 127, 159, 51);
		panel.add(btnNewButton);
		
		table = new JTable();
		DefaultTableModel dtm = (DefaultTableModel)table.getModel();
		dtm.setColumnCount(4);
		dtm.addColumn("잘되나");
		dtm.addColumn("잘되나");
		dtm.addColumn("잘되나");
		dtm.addColumn("잘되나");
		dtm.addRow(new Object[] {"111","222","333","444"});
		/*table.setModel(new DefaultTableModel(
			new Object[][] {
				{"1", "2", "3", "4"},
			},
			new String[] {
				"New column", "New column", "New column", "New column"
			}
		));*/
		
		table.setBounds(22, 10, 256, 153);
		panel.add(table);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 471, 88);
		panel_1.setBackground(new Color(51,51,204));
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("MainForm");
		lblNewLabel.setFont(new Font("궁서체", Font.BOLD, 30));
		lblNewLabel.setBounds(23, 10, 224, 58);
		panel_1.add(lblNewLabel);
		setVisible(true);
		
	}
}
