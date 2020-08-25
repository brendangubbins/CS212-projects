/**
 * Brendan Gubbins
 * CSCI 212 Lab Section 11C
 * Written 3/27/2019
 *
*/ 

import java.util.StringTokenizer;

public class Project2{
	public static void main(String[] args){	
		UnsortedCarList unSorted = new UnsortedCarList();
		SortedCarList sorted = new SortedCarList();
		
		makeLists(args[0], unSorted, sorted);
		
		CarGUI carGui = new CarGUI("Unsorted vs Sorted Cars");
		carGui.showGUI();	
		carGui.displayLists(unSorted, sorted);
	}
	
	private static void makeLists(String file, UnsortedCarList list1, SortedCarList list2){
		TextFileInput input = new TextFileInput(file);
		String line = input.readLine();
		String delim = ",";
		StringTokenizer tokenizer = new StringTokenizer(line, delim);
			
		while (line != null){
			try{
				tokenizer = new StringTokenizer(line, delim);
				while (tokenizer.hasMoreTokens()){
					if (tokenizer.countTokens() != 4){
						System.out.println(line);
						break;
					}
					else{
						String make = tokenizer.nextToken();
						String model = tokenizer.nextToken();
						int year = Integer.parseInt(tokenizer.nextToken());
						int mileage = Integer.parseInt(tokenizer.nextToken());
						Car c = new Car(make, model, year, mileage);
						list1.append(c);
						list2.add(c);
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
	}
}