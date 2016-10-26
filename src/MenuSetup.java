import java.util.Scanner;


public class MenuSetup {
private static  Scanner keyboard = new Scanner(System.in);

Xcom xcom = new Xcom();
Items items = new Items();
XcomClass xClass = new XcomClass();
public void innerMenu() {
	System.out.println("Lägga till i databasen 1");
	System.out.println("Ändra i databasen 2");
	System.out.println("Ta bort från databasen 3");
	System.out.println("Visa data 4");
	System.out.println("EXIT 5");
	
}

public void useXcom() {
	
	int innerChoice;
	innerMenu();
	do {
	innerChoice = keyboard.nextInt();
		switch (innerChoice) {
		case 1:
			System.out.println("Lägger till nu!");
			xcom.CreateXcom();
			break;
			
		case 2:
			System.out.println("Ändrar i databasen!");
			xcom.UpdateXcom();
			break;
			
		case 3:
			System.out.println("Ta bort nåt från databasen!");
			xcom.DeleteXcom();
			break;
			
		case 4:
		
			xcom.showDataOfXcom();
			break;

		default:
			break;
			
		}
	} while (innerChoice != 5);
	
}

public void useItems() {
	
	innerMenu();
	int innerChoice;
do {
	
	innerChoice = keyboard.nextInt();
		switch (innerChoice) {
		case 1:
			System.out.println("Lägger till nu!");
			items.CreateItems();
			break;
			
		case 2:
			System.out.println("Ändrar i items databas!");
			items.UpdateItems();
			break;
			
		case 3:
			System.out.println("Ta bort nåt från items databas!");
			items.DeleteItems();
			break;
			
		case 4:
		
			items.showDataOfItems();

		default:
			break;
		}

} while (innerChoice !=5);

}


public void useClass() {
	
	innerMenu();
	int innerChoice;

	do {
		

	
	innerChoice = keyboard.nextInt();
		switch (innerChoice) {
		case 1:
			System.out.println("Lägger till nu!");
			xClass.CreateClass();
			break;
			
		case 2:
			System.out.println("Ändrar i databasen!");
			xClass.UpdateClass();
			break;
			
		case 3:
			System.out.println("Ta bort nåt från databasen!");
			xClass.UpdateClass();
			break;
			
		case 4:
		
			xClass.showDataOfClass();

		default:
			break;
		}
	} while (innerChoice !=5);
	
}
}
