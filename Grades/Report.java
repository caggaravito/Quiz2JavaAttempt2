package Grades;

import java.util.ArrayList;
import java.util.*;
import java.util.Scanner;

public class Report {

	public static void main(String[] args) {

		String input ="Yes";
		Scanner customerInput = new Scanner(System.in);  //To receive the answer if the customer wants to enter another grade
		Scanner grade = new Scanner(System.in);  //To receive the grade the customer is entering
		List<Integer> list=new ArrayList<Integer>(); //to save the Scores 
		
		float sum = 0; // To store the summ of all the grades
		boolean isNumber=false;
		int aStudent =0; //To Store how many students have an A grade
		int bStudent =0; //To Store how many students have an B grade
		int cStudent =0; //To Store how many students have an C grade
		int fStudent =0; //To Store how many students have an F grade
		
		
		while(!input.equals("no")) {
			do {
				System.out.print("Hello! Please enter a Grade :  ");
					if (grade.hasNextInt()) {
						int choice = grade.nextInt();
						if ((choice>=0)&& (choice<=100)) {
							list.add(choice);
							isNumber = true;
						}else {
							System.out.println("Please enter a number between 0 and 100");
							isNumber = false;
						}
				}else {
					System.out.print("Hello! Please enter a number between 0 and 100: ");
					isNumber = false;
					grade.next();					
				}			
			} while (!(isNumber));
					
			boolean selectYN =false;//To store if customer select yes or no to continue
			
			while (!(selectYN)) {
				System.out.print("Do you want to enter another grade? (Yes/No): ");
				String answer = customerInput.next().toLowerCase(); 
					
				switch (answer) {
					case "yes":
						input = answer;
						selectYN = true;
						break;
					case "no":
						input = answer;
						selectYN = true;
						break;
					default : 
						selectYN = false;
						break;	
				}
			}
		}	
			
	 System.out.println("The Grades are : " + list); // To Display the Scored entered. 
		
	//To display the Lowest and Highst Score
		Collections.sort(list);
		System.out.println("The Lowest score is: "+list.get(0)); 
		System.out.println("The Higest score is: "+ list.get(list.size()-1)); 
		
	//To show the number of students that scored A, B, C and F.			
		for(int i=0; i < list.size();i++) {
			sum=sum+list.get(i);
			if (list.get(i)>=90)
				aStudent++;
			else if (list.get(i)>=80)
				bStudent++;
			else if (list.get(i)>=70)
				cStudent++;
			else
				fStudent++;
		}
		System.out.printf("The Average Score for the Class is --> %.2f", sum/list.size());  //Display with 2 decimals the average score for the class
		System.out.println();
		System.out.println("Number Students of Students with A Scores --> " + aStudent);
		System.out.println("Number Students of Students with B Scores --> " + bStudent);
		System.out.println("Number Students of Students with C Scores --> " + cStudent);
		System.out.println("Number Students of Students with F Scores --> " + fStudent);		
	}
	}
