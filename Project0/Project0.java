/**
 * Brendan Gubbins
 * CSCI 212 Lab Section 11C
 * Written 2/18/2019
 *
 * This program aims to repeatedly ask a user for a sentence/string. The methods UpperCount and LowerCount
 * tally and return the amount of upper and lowercase e's in the sentence. The program will end once the
 * user types "stop" as their sentence, regardless of capitalization.
*/
 
import javax.swing.JOptionPane; // Needed for use of JOptionPane (dialogue box) in the program

public class Project0
{
   public static void main(String args[])
   {
      String inputSentence, upper = "Number of upper case E's: ", lower = "Number of lower case e's: ";
      inputSentence = JOptionPane.showInputDialog("Please enter a sentence.");
      while (!inputSentence.equalsIgnoreCase("STOP")) /* This while loop is used to repeatedly ask
	                                                   * for new sentences. the ! before input sentence
													   * allows the loop to continue as long as "stop"
													   * is not entered. Without the !, it will ONLY
													   * loop if "stop" is entered.
                                                       */
	  {
         JOptionPane.showMessageDialog(null, upper + UpperCount(inputSentence)
			                          + "\n" + lower + LowerCount(inputSentence));
         inputSentence = JOptionPane.showInputDialog("Enter another sentence: ");
	  }
   }
		
		
   public static int UpperCount(String input)
   {
      int countUpper = 0;
      for (int i = 0; i < input.length(); i++)
      {
         if (input.charAt(i) == 'E') /* The UpperCount method needs to check the input string at each
		                              * character, in order to determine an "E" and raise countUpper total.
									  * Each time an "E" is spotted, countUpper tallies up.
									  */
            countUpper++;
	  }
		 return countUpper;
   }

   public static int LowerCount(String input)
   {
      int countLower = 0;
      for (int i = 0; i < input.length(); i++)
      {
	     if (input.charAt(i) == 'e') // Same as UpperCount, except for lower case numbers
		 countLower++;
	  }
	  return countLower;
   }
}