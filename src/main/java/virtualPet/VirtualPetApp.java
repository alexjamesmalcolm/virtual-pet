package virtualPet;

import java.util.Scanner;

public class VirtualPetApp {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		boolean isPlaying = true;
		while (isPlaying) {
			boolean enteredCorrectly = false;
			VirtualPet myPet = null;
			String choice;
			while (!enteredCorrectly) {
				System.out.println("Would you like to name your pet? (y/n)");
				choice = input.next();
				if (choice.substring(0, 1).contains("y")) {
					System.out.println("What would you like to name your pet?");
					String inputName = input.next();
					myPet = new VirtualPet(inputName);
					enteredCorrectly = true;
				} else if (choice.substring(0, 1).contains("n")) {
					myPet = new VirtualPet();
					enteredCorrectly = true;
				} else {
					System.out.println("Could you please enter that again.");
				}
			}

			while (myPet.alive() && !myPet.hasEscaped()) {
				gameLoop(input, myPet);
			}

			if (!myPet.alive()) {
				System.out.println(myPet.getName() + " has died.");
			}

			if (myPet.hasEscaped()) {
				System.out.println(myPet.getName() + " has left.");
			}

			enteredCorrectly = false;
			while (!enteredCorrectly) {
				System.out.println("Would you like to try taking car of a pet again? (y/n)");
				choice = input.next();
				if (choice.substring(0, 1).equals("n")) {
					isPlaying = false;
					enteredCorrectly = true;
				} else if (choice.substring(0, 1).equals("y")) {
					isPlaying = true;
					enteredCorrectly = true;
				} else {
					System.out.println("Could you please enter that again.");
				}
			}
		}

		input.close();
	}

	private static void gameLoop(Scanner input, VirtualPet myPet) {
		displayStats(myPet);

		System.out.println();

		int option = requestAction(input, myPet);

		myPet.tick();
		if (option == 1) {
			myPet.feed();
		} else if (option == 2) {
			myPet.water();
		} else if (option == 3) {
			myPet.bathroom();
		} else if (option == 4) {
			myPet.play();
		} else if (option == 6) {
			input.close();
			System.exit(0);
		}
	}

	private static int requestAction(Scanner input, VirtualPet myPet) {
		String name = myPet.getName();
		System.out.println("1. Feed " + name);
		System.out.println("2. Refill " + name + "'s water");
		System.out.println("3. Let " + name + " go to the bathroom");
		System.out.println("4. Play with " + name);
		System.out.println("5. Do nothing");
		System.out.println("6. Exit");
		int option = input.nextInt();
		return option;
	}

	private static void displayStats(VirtualPet myPet) {
		int hunger = myPet.getHunger();
		int thirst = myPet.getThirst();
		int waste = myPet.getWaste();
		int boredom = myPet.getBoredom();
		String name = myPet.getName();

		System.out.println(name);
		System.out.println("Hunger:  " + progressBar(hunger));
		System.out.println("Thirst:  " + progressBar(thirst));
		System.out.println("Waste:   " + progressBar(waste));
		System.out.println("Boredom: " + progressBar(boredom));
	}

	public static String progressBar(int percentage) {
		String full = "█";
		String empty = "░";
		String result = "";
		int numberOfFull = percentage / 5;
		int numberOfEmpty = 20 - numberOfFull;
		for (int i = 0; i < numberOfFull; i++) {
			result += full;
		}
		for (int i = 0; i < numberOfEmpty; i++) {
			result += empty;
		}
		return result;
	}

}
