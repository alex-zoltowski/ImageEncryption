package ImageEncryption;

import java.awt.EventQueue;
import java.io.File;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JFileChooser;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ChooseImage {

	private JFrame frmChooseImage;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChooseImage window = new ChooseImage();
					window.frmChooseImage.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ChooseImage() {
		initialize();
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmChooseImage = new JFrame();
		frmChooseImage.setTitle("Choose Image");
		frmChooseImage.setBounds(100, 100, 500, 420);
		frmChooseImage.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				File check = new File(fileChooser.getSelectedFile().getAbsolutePath() + ".txt");
				if(!check.exists())
				{
					try {
						frmChooseImage.dispose();
						new Encrypt(fileChooser.getSelectedFile());
					} catch (IOException e2){
						e2.printStackTrace();
					}
				}
				else
				{
					JFrame frame = new JFrame("Error");
					
					JOptionPane.showMessageDialog(frame, "Image is all ready encrypted.");
				}
				
				
			}
		});
		fileChooser.setAcceptAllFileFilterUsed(false);
		fileChooser.addChoosableFileFilter(new FileNameExtensionFilter(".jpg", "jpg"));
		frmChooseImage.getContentPane().add(fileChooser, BorderLayout.CENTER);
		frmChooseImage.setVisible(true);
	}

}
