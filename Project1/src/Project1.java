/**
 * Brendan Gubbins
 * CSCI 212 Lab Section 11C
 * Written 3/14/2019
 *
*/ 


import java.util.StringTokenizer;
import java.lang.NumberFormatException;
import javax.swing.*;

public class Project1{
	public static void main(String[] args){
		Car[] array = new Car[listSize(args[0])]; // Car array size is related to the list size of input file
		Car[] arraySort = new Car[listSize(args[0])]; //listSize method will determine rows in the input file
		
		fillArray(array, args[0]);
		fillArraySort(array, arraySort);
		selectionSort(arraySort);
		
		CarGUI carGui = new CarGUI("Unsorted vs Sorted Cars");
		carGui.showGUI();
		carGui.arrayDisplay(array, arraySort);
	}
	
	private static int listSize(String file){ 
		TextFileInput input = new TextFileInput(file);
		int count = 0;
		String line = input.readLine(); 
		while (line != null){ // When line is not null (no more lines in text) the loop stops to return the rows in the txt file
			line = input.readLine(); 
			count++;
		}
		return count;
	}
	
	public static void fillArray(Car[] array, String file){
		TextFileInput input = new TextFileInput(file); 
		String line = input.readLine();
		String delimiter = ",";
		
		StringTokenizer tokenizer = new StringTokenizer(line, delimiter);
		int i = 0;
		while (line != null){ // loop keeps going as long as there is more information to acquire (not null)
			try{ // try is used here incase our input data contains errors that will later be catched
				tokenizer = new StringTokenizer(line,delimiter);
				while (tokenizer.hasMoreTokens()){ // cycles through the tokens in the line in order to identify and add them to Car array
					tokenizer = new StringTokenizer(line,delimiter);
					
					if (tokenizer.countTokens() != 4){ // this is needed as a failsafe incase a line does not meet necessary amount of info (4 instance variables) for a Car object
						System.out.println(line);
						line = input.readLine(); // jumps to next line, this needs to be at the end of an execution of code in order to scan the next line
					}
					else{ // the else{} is important here to continue filling the array if it makes it past the countTokens failsafe...
						String make = tokenizer.nextToken(); //...the bracket has to contain all the necessary info for a Car, otherwise else would only include String make=...
						String model = tokenizer.nextToken();
						int year = Integer.parseInt(tokenizer.nextToken());
						int mileage = Integer.parseInt(tokenizer.nextToken());
						array[i++] = new Car(make, model, year, mileage);
					
						line = input.readLine();
					}
				}
			}
			catch (Exception e){ // if something goes wrong such as an String is placed in the line where an Int is expected, it'll...
				System.out.println(line); //...catch the line and print it, then move on with the loop
				line = input.readLine();
			}
		}
	}
	
	public static void fillArraySort(Car[] array, Car[] arraySort){ 
		for (int i = 0; i < Car.count(); i++)
			arraySort[i] = array[i];
	}
	
	public static void selectionSort(Car[] array){
		for (int i = 0; i < Car.count() - 1; i++){
			int min = i;
			for (int j = i + 1; j < Car.count(); j++){
				if (0 > array[j].compareTo(array[min]))
					min = j;
			}
			Car temp = array[min];
			array[min] = array[i];
			array[i] = temp;
		}
	}	
}