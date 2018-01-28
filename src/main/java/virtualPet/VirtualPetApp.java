package virtualPet;

import java.util.Scanner;

public class VirtualPetApp {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		VirtualPet myPet = new VirtualPet();

		boolean isAlive = true;

		displayPetStats(myPet);

		// while (!isAlive) {
		// }

		input.close();
	}

	static void displayPetStats(VirtualPet pet) {
		int hunger = pet.getHunger();
		int thirst = pet.getThirst();
		int waste = pet.getWaste();
		int boredom = pet.getBoredom();

		System.out.println("Hunger: " + hunger);
		System.out.println("Thirst: " + thirst);
		System.out.println("Waste: " + waste);
		System.out.println("Boredom: " + boredom);
	}

}
