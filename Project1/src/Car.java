/**
 * Brendan Gubbins
 * CSCI 212 Lab Section 11C
 * Written 3/14/2019
 *
*/ 

public class Car{

	private static int numCars = 0;
	private String Make, Model;
	private int Year, Mileage;
	
	public Car(String Make, String Model, int Year, int Mileage){
		this.Make = Make;
		this.Model = Model;
		this.Year = Year;
		this.Mileage = Mileage;
		
		numCars++; // every time a car is made, it keeps track of the total cars to be called upon by a Car method count
	}
	
	public int compareTo(Car other){ // overriding compareTo in the String class that way selectionSort can use Car objects as a parameter
		return this.Make.compareTo(other.Make);
	}
	
	public static int count(){
		return numCars;
	}
	
	public String toString(){ // Later to be used for GUI, converts all Car info into a String, similar to how it was in the original txt file
		return this.Make+" "+this.Model+" "+this.Year+" "+this.Mileage;
	}
	public void setMake(String s){
		Make = s;
	}
	
	public String getMake(){
		return Make;
	}
	
	public void setModel(String s){
		Model = s;
	}
	
	public String getModel(){
		return Model;
	}
	
	public void setYear(int i){
		Year = i;
	}
	
	public int getYear(){
		return Year;
	}
	
	public void setMileage(int i){
		Mileage = i;
	}
	
	public int getMileage(){
		return Mileage;
	}
}