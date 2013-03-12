import java.util.Scanner;
import java.io.*;

public class SearchingInFile {
	public static String fileToSearch;
	public static File fileNameStudent = new File("Student.txt");
	public static  File fileNameMarks = new File("Marks.txt");
	
	public static void searchInFile(){
		
		System.out.println(
				"To search in Students enter student to search in Marks enter marks");
		
		String firstWord = "marks";
		String secondWord = "student";
		
		do{
			System.out.println("In which file you wanna search");
			Scanner input = new Scanner(System.in);
			fileToSearch = input.nextLine();
			}while(!((firstWord.equalsIgnoreCase(fileToSearch)) ||(secondWord.equalsIgnoreCase(fileToSearch))));
		
     String fileName;
		
	
	if ((firstWord.equalsIgnoreCase(fileToSearch)))
    {
        fileName = "Marks.txt";
    }
    else
    {
        fileName = "Student.txt";
    }
	System.out.println("Enter word you wanna search");
	String enterSearchWord;
	Scanner word = new Scanner(System.in);
	enterSearchWord = word.nextLine();
	
	Scanner fileReader = null;
	int occurrences = 0;
	try {
	fileReader = new Scanner(new File(fileName));
	System.out.println("File " + fileName + " opened.");
	while (fileReader.hasNextLine()) {
		String line = fileReader.nextLine();
		int index = line.indexOf(enterSearchWord);
		while (index != -1) {
		occurrences++;
		index = line.indexOf(enterSearchWord, (index + 1));
		}
		}
		} catch (FileNotFoundException fnf) {
		System.out.println("File " + fileName + " not found.");
		} catch (NullPointerException npe) {
		System.out.println("File " + fileName + " not found.");
		} finally {
		if (fileReader != null) {
		fileReader.close();
		}
		}
		System.out.printf("The word %s occurs %d times",
				enterSearchWord, occurrences);
	}
}
