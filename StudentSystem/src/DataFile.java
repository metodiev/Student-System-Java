import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.lang.String;


public class DataFile {
	public static String whichFileToOpen;
	public static File fileNameStudent = new File("Student.txt");
	public static  File fileNameMarks = new File("Marks.txt");
	public static void openFile(){ 
		
		System.out.println("Which file you want to open Marks or Student");
		String firstWord = "marks";
		String secondWord = "student";
		do{
		System.out.println("To open Student enter student to open Marks enter marks");
		Scanner input = new Scanner(System.in);
		whichFileToOpen = input.nextLine();
		}while(!((firstWord.equalsIgnoreCase(whichFileToOpen)) || (secondWord.equalsIgnoreCase(whichFileToOpen))));
		
		File fileName;
		boolean temp;
		temp = (firstWord.equalsIgnoreCase(whichFileToOpen));
			 
		if ((temp)){
			fileName = fileNameMarks;
		}
		else{
			fileName = fileNameStudent;
		}
		Scanner fileReader = null;
		try {
			fileReader = new Scanner(fileName);
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
