package new1;
/*Name: Puneet Kaur
Date: March 9, 2021
Purpose: This program (supplementary) creates a bill based on the items, costs and quantities given by the user; it also calculates the total cost before and after taxes
This program uses 1D, 2D arrays and class methods to do all these tasks  */
import java.util.Scanner;

public class U1U2Program2 {
	static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		//Call all methods in order
		String[]oneD=nameItems(itemNum);
		double[][]twoD=getInfo(oneD);
		double preTotal = preTaxTotal(twoD);
		double postTotal = postTaxTotal(preTotal);
		printArrays(oneD, twoD, preTotal, postTotal);
	}//main
	
	public static int itemNum = userItems();//the method userItems is called and its return value is assigned to the public integer variable itemNum
	
	public static int userItems() {
		//This method asks the user for the total number of items and returns the integer value given by the user
		System.out.println("Enter number of items : ");
		int numItems = input.nextInt();
		return numItems;
	}//userItems
	
	public static String[] nameItems(int numItems) {
		//This method gets the total # of items and asks users for the name of each item which it returns in a string 1D array
		String [] itemNames = new String [numItems];//initialize string array
		for (int count=0; count<numItems; count++) {//use for loop to get input and assign to 1D array at that index
			System.out.println("Enter name of item #" + (count+1) + ": ");
			itemNames[count]=input.next();
		}//for
		return itemNames;//return string 1D array
	}//nameItems
	
	public static double[][]getInfo (String[]oneD){
		//This method gets a string 1D array and uses it to get the cost and quantity of each item, 
		//determine the total cost using this info and return it in a 2D double array
		double[][]infoList=new double[oneD.length][3];//create a double 2d array with 3 columns and as many rows as the number of items
		for (int count=0; count<oneD.length; count++) {//use for loop to get input for each item and assign it in a 2D array
			System.out.println("Enter cost of " + oneD[count] + ": $");
			infoList[count][0]=input.nextDouble();//cost in column 1 of 2D array
			System.out.println("Enter quantity of " + oneD[count] + ": ");
			infoList[count][1]=input.nextDouble();//quantity in column 2 of 2D array
			infoList[count][2]=Math.round(100.0*(infoList[count][0]*infoList[count][1]))/100.0;//calculate final cost of item= cost x quantity and assign it in column 3 of 2D array
		}//for
		return infoList;//return double 2 array
	}//getInfo
	
	public static double preTaxTotal(double[][]infoList) {
		//This method gets a double 2D array and calculates the total before tax by adding all the elements in the final cost column - 3
		double beforeTax = 0.00;//initialize variable
		for (int count=0; count<infoList.length; count++) {//use for loop to go through each row - only one for loop as we only need a specific column - 3
			beforeTax+=infoList[count][2];//add value of element in column 3 to the total
		}//for
		beforeTax = Math.round(beforeTax*100.0)/100.0;
		return beforeTax;//return total before tax
	}//preTaxTotal
	
	public static double postTaxTotal(double beforeTax) {
		//This method gets the total before tax and asks user for tax amount to calculate and return total after tax
		System.out.println("Enter tax %: ");
		double taxPerc = input.nextDouble();//get user input
		double postTax = Math.round(beforeTax*(1+(taxPerc/100))*100.0)/100.0;//calculate total after tax
		return postTax;//return total after tax
		}//postTaxTotal

	public static void printArrays(String[]oneD, double[][]twoD, double beforeTax, double afterTax){
		//This method gets a string 1D array, a double 2D array, the total before and after tax and prints all information in proper format
		System.out.println();
		System.out.println("Item\tCost\tQuant\tTotal");//Print headings for each column
		for (int row = 0;row< twoD.length; row++){
			System.out.print(oneD[row]+"\t");//The first column should contain elements of the string 1d array but the 2d array should print beside it
			for (int col = 0;col<twoD[row].length; col++){
				System.out.print(twoD[row][col] +"\t");//print elements of the double 2D array
			}//for col
			System.out.println();
		} //for row
		System.out.println();
		System.out.println("Total before tax: $" + beforeTax);//print pre-tax total
		System.out.println("Total after tax: $" + afterTax);//print post-tax total
		}//printArrays
}//U1U2Program2
