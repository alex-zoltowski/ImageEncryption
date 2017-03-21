package ImageEncryption;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EncryptDecrypt {

	private JFrame frmImageEncrypterdecrypter;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EncryptDecrypt window = new EncryptDecrypt();
					window.frmImageEncrypterdecrypter.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public EncryptDecrypt() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmImageEncrypterdecrypter = new JFrame();
		frmImageEncrypterdecrypter.setTitle("Image Encrypter/Decrypter");
		frmImageEncrypterdecrypter.setBounds(100, 100, 520, 191);
		frmImageEncrypterdecrypter.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmImageEncrypterdecrypter.getContentPane().setLayout(null);
		
		JLabel lblEncryptImage = new JLabel("Encrypt Image");
		lblEncryptImage.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblEncryptImage.setBounds(66, 31, 121, 27);
		frmImageEncrypterdecrypter.getContentPane().add(lblEncryptImage);
		
		JLabel lblDecryptImage = new JLabel("Decrypt Image");
		lblDecryptImage.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblDecryptImage.setBounds(319, 31, 121, 27);
		frmImageEncrypterdecrypter.getContentPane().add(lblDecryptImage);
		
		JButton btnChooseImgFile = new JButton("Choose Img");
		btnChooseImgFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
		
				new ChooseImage();

			}
		});
		btnChooseImgFile.setBounds(66, 98, 121, 25);
		frmImageEncrypterdecrypter.getContentPane().add(btnChooseImgFile);
		
		JButton btnChooseTxtFile = new JButton("Choose Txt");
		btnChooseTxtFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				new ChooseText();
			}
		});
		btnChooseTxtFile.setBounds(319, 98, 121, 25);
		frmImageEncrypterdecrypter.getContentPane().add(btnChooseTxtFile);
		
	}
}
