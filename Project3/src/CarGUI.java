/**
 * Brendan Gubbins
 * CSCI 212 Lab Section 11C
 * Updated 4/21/2019
 *
*/ 

import javax.swing.*;
import java.io.File;
import java.awt.GridLayout;
import java.util.StringTokenizer;

public class CarGUI extends JFrame{ // CarGUI needs properties of the JFrame to function
	
	protected JTextArea leftText;
	protected JTextArea rightText;
	protected StringBuilder leftStringBuilder;
	protected StringBuilder rightStringBuilder;
	protected UnsortedCarList unSorted;
	protected SortedCarList sorted;
		
	public CarGUI(){
        this("No title");
    }

    public CarGUI (String title){
        super(title);
		unSorted = new UnsortedCarList(); //lists in constructor because lists are made based on file clicked
		sorted = new SortedCarList(); //...rather than one created from the main function (input)

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(400, 400);
        this.setLocation(200, 200);
        this.setLayout(new GridLayout(1,2));
		
		JMenuItem open = new JMenuItem("Open");
		JMenuItem quit = new JMenuItem("Quit");
		JMenuBar menuBar = new JMenuBar();
		JMenu fileMenu = new JMenu("File");
		FileMenuHandler fmh = new FileMenuHandler(this);
		
		open.addActionListener(fmh);
		quit.addActionListener(fmh);
		
		fileMenu.add(open);
		fileMenu.addSeparator();
		fileMenu.add(quit);
		
		menuBar.add(fileMenu);
		this.setJMenuBar(menuBar);
		
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
		
	public void readFile(String file){
		TextFileInput input = new TextFileInput(file);
		String line = input.readLine();
		String delim = ",";
		StringTokenizer tokenizer = new StringTokenizer(line, delim);
		String make = "";
		String model = "";
		int year;
		int mileage;
		Car c = new Car("","",0,0);
			
		while (line != null){
			try{
				tokenizer = new StringTokenizer(line, delim);
				while (tokenizer.hasMoreTokens()){
					if (tokenizer.countTokens() != 4){
						System.out.println(line);
						break;
					}
					else{
						make = tokenizer.nextToken();
						model = tokenizer.nextToken();
						year = Integer.parseInt(tokenizer.nextToken());
						mileage = Integer.parseInt(tokenizer.nextToken());
						c = new Car(make, model, year, mileage);
						unSorted.append(c); 
						sorted.add(c);
					}
				}
			}		
			catch (Exception e){
				System.out.println(line);
			}
			finally{
				line = input.readLine();
			}
		}
		this.leftText.setText(unSorted.toString());
		this.rightText.setText(sorted.toString());
	}
}