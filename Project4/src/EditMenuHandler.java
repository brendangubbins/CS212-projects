import javax.swing.JOptionPane;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener; 

public class EditMenuHandler implements ActionListener{
	private CarGUI carGui;
	
	public EditMenuHandler(CarGUI carGui){
		this.carGui = carGui;
	}
	
	public void actionPerformed(ActionEvent event){
		String menuName = event.getActionCommand();
		
		if (menuName.equals("Search")){
			String input = JOptionPane.showInputDialog("Enter a car make");
			this.carGui.searchMakes(input);
		}
	}
}