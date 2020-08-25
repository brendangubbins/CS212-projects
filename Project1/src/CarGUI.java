/**
 * Brendan Gubbins
 * CSCI 212 Lab Section 11C
 * Written 3/14/2019
 *
*/ 

import javax.swing.*;
import java.awt.GridLayout;

public class CarGUI extends JFrame{ // CarGUI needs properties of the JFrame to function
	
		private JTextArea leftText;
		private JTextArea rightText;
		private StringBuilder leftStringBuilder;
		private StringBuilder rightStringBuilder;
		
	public CarGUI(){
        this("No title");
    }

    public CarGUI (String title){
        super(title);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(100, 100);
        this.setLocation(200, 200);
        this.setLayout(new GridLayout(1,2));
		
		this.leftStringBuilder = new StringBuilder("Unsorted Cars:\n"); 
        this.rightStringBuilder = new StringBuilder("Sorted Cars:\n");

        this.leftText = new JTextArea(this.leftStringBuilder.toString(), Car.count(), 1); 
        this.rightText = new JTextArea(this.rightStringBuilder.toString(), Car.count(), 1);

        this.getContentPane().add(this.leftText); 
        this.getContentPane().add(this.rightText); 
    }
	
	public void showGUI(){
		this.setVisible(true);
	}
	
	public void arrayDisplay(Car[] array, Car[] arraySorted){
		for (int i = 0; i < Car.count(); i++){
			this.leftStringBuilder.append(array[i] + "\n"); // adding info of a Car and then skipping a line for a neat output
			this.rightStringBuilder.append(arraySorted[i] + "\n");	
		}
		this.leftText.setText(this.leftStringBuilder.toString()); // setting the texts of the StringBuilders to String formatted...
		this.rightText.setText(this.rightStringBuilder.toString()); //...info of the Cars
		
	}
	
	
}