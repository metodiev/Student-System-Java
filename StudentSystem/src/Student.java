import java.util.Scanner;
import java.io.*;
 
public class Student {
	public static String nameOfStudent;
	public static String studentAge;
	public static String studentCourse;
	public static String studentGroup;
	public static String studentFakNumber;
	public static  File file = new File("Student.txt");
	
	//Method print menu of program
	public static void switchMenu(){
		
		System.out.println("\t1.Enter new student");
		System.out.println("\t2.Read data from file");
		System.out.println("\t3.Search in file");
		System.out.println("\t4.Exit of program");
	}
	//Method to enter student name
	public static void enterNameOfStudent(){
		
		System.out.println("\t Enter name of student");
		Scanner input = new Scanner(System.in);
		nameOfStudent = input.nextLine();
	}
	//Entering data for student
	public static void enterDataForStudent(){
		
		System.out.println("Enter age of student");
		Scanner input = new Scanner(System.in);
		 studentAge = input.nextLine();
		
		System.out.println("Enter the course of student");
		studentCourse = input.nextLine();
		
		System.out.println("Enter the group of student");
		studentGroup = input.nextLine();
		
		System.out.println("Enter the Fak number of student");
		studentFakNumber = input.nextLine();

		writeDataToTxt(nameOfStudent, studentAge, studentCourse, studentGroup, studentFakNumber);
	}
	//Enter Marks
	public static void enterMarksOfStudent(){
		
		System.out.println("Enter marks of student");
		System.out.println("How many marks you wish to enter");
		Scanner studentMark = new Scanner(System.in);
		int numberOfMarks = studentMark.nextInt();
		
		int [] studentMarks = new int [25];
		for( int i=0; i < numberOfMarks; i++ ){
			studentMarks[i] = studentMark.nextInt();
		}
		
		System.out.println("Do you want to see entered marks y/n");
		Scanner input = new Scanner(System.in);
		String key = input.nextLine();
		String agree = "y";
		if (( (key.equalsIgnoreCase(agree)))){
			for(int i =0; i < numberOfMarks ; i++ ){
				System.out.println(studentMarks[i]);
			}
		}
		else{
			System.out.println("OK");
		}
		
		PrintStream fileOutput = null;
		try {
			fileOutput = new PrintStream("Marks.txt");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		for (int num = 0; num <= numberOfMarks; num++) {
			fileOutput.println(studentMarks[num]);
		}
		fileOutput.close();
		}
	
	public static void writeDataToTxt(String name, String age, String course, String group, String fakNumber){
		// Write text file 
	   PrintStream fileWriter = null;
	try {
		try {
			fileWriter = new PrintStream("Student.txt","windows-1251");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	}
		fileWriter.println("Student name:" + name);
		fileWriter.println("Student age:" + age);
		fileWriter.println("Student course:" + course);
		fileWriter.println("Student group:" + group);
		fileWriter.println("Student fakNumber:" + fakNumber);
		fileWriter.close();
		//Read text file
		Scanner fileReader = null;
		try {
			fileReader = new Scanner(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		int lineNumber = 0;
		
		while (fileReader.hasNextLine()) {
			lineNumber++;
			System.out.printf("Line %d: %s%n",
			lineNumber, fileReader.nextLine());
			}
		fileReader.close();
	}
}



