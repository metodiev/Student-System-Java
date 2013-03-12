import java.util.Scanner;

public class StudentSystem {
	
	public static void main(String[] args){
		System.out.println("Menu:");
		System.out.println("To enter menu press 1.");
		
		int menuChoice;
		Scanner menu = new Scanner(System.in);
		menuChoice = menu.nextInt();
		if (menuChoice == 1){
			Student.switchMenu();
		}
		else{
			System.out.println("Exit of program"); return;
		}
		
		int switchChoice = menu.nextInt();
		switch(switchChoice){
		case 1: Student.enterNameOfStudent(); 
				Student.enterDataForStudent(); 
				Student.enterMarksOfStudent(); break;
		case 2: DataFile.openFile(); break;
		case 3:SearchingInFile.searchInFile(); break;
		default: System.out.println("To exit of program pres any key ..."); break;
		}
	}
}
