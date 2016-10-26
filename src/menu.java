import java.util.*;


public class menu {

	private static  Scanner keyboard = new Scanner(System.in);
	public static void main(String[] args) {
		MenuSetup setup = new MenuSetup();
		// TODO Auto-generated method stub

		Queue<String> queue = new LinkedList<String>();

		queue.add("xcom");
		queue.add("items");
		queue.add("class");
		System.out.println(queue.peek());
		
		System.out.println("would you like to pick xcom tabell yes =1/ no = 2");
		
		
		int choice1 = keyboard.nextInt();
		
		if (choice1 ==1){
			System.out.println("pick xcom");
			queue.poll();
			setup.useXcom();
		}else if (choice1 ==2) {
			queue.remove("xcom");
			System.out.println(queue.peek());
			System.out.println("next tabell is items ");
		} 
		
		System.out.println("would you like to pick items tabell yes =1/ no = 2");
		int choice2 = keyboard.nextInt();
		if(choice2 == 1){
			System.out.println("pick items");
			queue.poll();
			setup.useItems();
		}else if (choice2 ==2) {
			queue.remove("items");
			System.out.println(queue.peek());
			System.out.println("next tabell class");
		}
		System.out.println("would you like to pick class tabell yes =1/ no = 2");
		int choice3 = keyboard.nextInt();
		if(choice3 == 1){
			System.out.println("pick class");
			queue.poll();
			setup.useClass();
		}else if (choice3 ==2) {
			queue.remove("class");
			System.out.println(queue.peek());
			System.out.println("the queue is empty");
		}
	}
}


