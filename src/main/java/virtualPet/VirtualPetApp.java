package virtualPet;

import java.util.Scanner;

public class VirtualPetApp {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		VirtualPet myPet = new VirtualPet();

		while (myPet.alive() && !myPet.hasEscaped()) {
			int hunger = myPet.getHunger();
			int thirst = myPet.getThirst();
			int waste = myPet.getWaste();
			int boredom = myPet.getBoredom();
			String name = myPet.getName();

			System.out.println(name);
			System.out.println("Hunger:  " + progressBar(hunger));
			System.out.println("Thirst:  " + thirst);
			System.out.println("Waste:   " + waste);
			System.out.println("Boredom: " + boredom);
			System.out.println();
			System.out.println("Menu");
			System.out.println("1. Feed " + name);
			System.out.println("2. Water " + name);
			System.out.println("3. Bathroom " + name);
			System.out.println("4. Play " + name);
			System.out.println("5. Do nothing");
			int option = input.nextInt();
			// feed, water, play, bathroom
			myPet.tick();
			if (option == 1) {
				myPet.feed();
			} else if (option == 2) {
				myPet.water();
			} else if (option == 3) {
				myPet.bathroom();
			} else if (option == 4) {
				myPet.play();
			}
		}

		if (!myPet.alive()) {
			System.out.println(myPet.getName() + " has died.");
		}
		
		if(myPet.hasEscaped()) {
			System.out.println(myPet.getName() + " has left.");
		}
		
		input.close();
	}

	public static String progressBar(int hunger) {
		String full = "█";
		String empty = "░";
		return "░░░░░░░░░░░░░░░░░░░░";
	}

}
