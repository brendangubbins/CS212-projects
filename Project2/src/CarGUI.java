/**
 * Brendan Gubbins
 * CSCI 212 Lab Section 11C
 * Updated 3/27/2019
 *
*/ 

import javax.swing.*;
import java.awt.GridLayout;

public class CarGUI extends JFrame{ // CarGUI needs properties of the JFrame to function
	
	private JTextArea leftText;
	private JTextArea rightText;
	protected StringBuilder leftStringBuilder;
	protected StringBuilder rightStringBuilder;
		
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

        this.leftText = new JTextArea("", Car.count(), 1); 
        this.rightText = new JTextArea("", Car.count(), 1);

        this.getContentPane().add(this.leftText); 
        this.getContentPane().add(this.rightText); 
    }
	
	public void showGUI(){
		this.setVisible(true);
	}
	
	public void displayLists(CarList list1, CarList list2){
		this.leftText.setText(list1.toString());
		this.rightText.setText(list2.toString());
	}
}