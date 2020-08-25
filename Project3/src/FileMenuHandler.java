import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener; 

import java.io.File;

public class FileMenuHandler implements ActionListener{
	private CarGUI carGui;
	
	public FileMenuHandler(CarGUI carGui){
		this.carGui = carGui;
	}
	
	public void actionPerformed(ActionEvent event){
		String menuName = event.getActionCommand();
		
		if (menuName.equals("Open")){
			JFileChooser fc = new JFileChooser();
			
			int returnVal = fc.showOpenDialog(null);
			
			if (returnVal == JFileChooser.APPROVE_OPTION){
				File file = fc.getSelectedFile();
				this.carGui.readFile(file.getPath()); //.getPath() used to give TextFileInput string access rather than file
			}
			else if (returnVal == JFileChooser.CANCEL_OPTION){
				System.out.println("Open command cancelled");
			}
		}
		else if (menuName.equals("Quit")){
			System.exit(1);
		}
	}
}