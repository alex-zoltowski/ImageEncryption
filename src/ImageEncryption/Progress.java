package ImageEncryption;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class Progress extends JFrame {

	private JPanel contentPane;
	private JButton btnClose = new JButton("Close");
	JLabel lblNewLabel = new JLabel("", SwingConstants.CENTER);
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Progress frame = new Progress();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Progress() {
		
		setType(Type.UTILITY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 296, 173);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel.setBounds(12, 25, 264, 33);
		contentPane.add(lblNewLabel);
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				dispose();
			}
		});
		
		
		btnClose.setVisible(false);
		btnClose.setBounds(96, 98, 97, 25);
		contentPane.add(btnClose);
		setVisible(true);
	}
	
	public void setBtnVisibility(boolean bool)
	{
		btnClose.setVisible(bool);
	}
	
	public void setLabelTxt(String text)
	{
		lblNewLabel.setText(text);
	}
}
