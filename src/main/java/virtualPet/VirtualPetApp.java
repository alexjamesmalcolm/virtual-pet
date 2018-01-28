package virtualPet;

import java.util.Scanner;

public class VirtualPetApp {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		VirtualPet myPet = new VirtualPet();

		while (myPet.alive()) {
			int hunger = myPet.getHunger();
			int thirst = myPet.getThirst();
			int waste = myPet.getWaste();
			int boredom = myPet.getBoredom();
			
			System.out.println("1. ");
			System.out.println("2. ");
			System.out.println("3. ");
			System.out.println("4. ");
			System.out.println("5. Do nothing");
			
			System.out.println("Hunger: " + hunger);
			System.out.println("Thirst: " + thirst);
			System.out.println("Waste: " + waste);
			System.out.println("Boredom: " + boredom);
			System.out.println();
			myPet.tick();
		}

		input.close();
	}

}
