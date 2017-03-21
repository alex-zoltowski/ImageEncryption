package ImageEncryption;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JFileChooser;
import java.awt.BorderLayout;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class ChooseText {

	private JFrame frmChooseTextFile;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChooseText window = new ChooseText();
					window.frmChooseTextFile.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ChooseText() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmChooseTextFile = new JFrame();
		frmChooseTextFile.setTitle("Choose Text File");
		frmChooseTextFile.setBounds(100, 100, 500, 420);
		frmChooseTextFile.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				
				String dirPath = fileChooser.getSelectedFile().getAbsolutePath();
				dirPath = dirPath.substring(0, dirPath.length() - 4);
				File check = new File(dirPath);
				if(!check.exists())
				{	
					try {
							frmChooseTextFile.dispose();
							new Decrypt(fileChooser.getSelectedFile());
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				else
				{
					JFrame frame = new JFrame("Error");
					
					JOptionPane.showMessageDialog(frame, "Image is all ready decrypted.");
				}
			}
		});
		fileChooser.setAcceptAllFileFilterUsed(false);
		fileChooser.addChoosableFileFilter(new FileNameExtensionFilter(".txt", "txt"));
		frmChooseTextFile.getContentPane().add(fileChooser, BorderLayout.CENTER);
		frmChooseTextFile.setVisible(true);
	}

}
