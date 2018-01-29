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

	private static void gameLoop(Scanner input, VirtualPet pet) {
		displayStats(pet);

		System.out.println();

		int option = requestAction(input, pet);
		boolean status = true;

		pet.tick();

		String name = pet.getName();
		if (option == 1) {
			status = pet.feed();
			if (status)
				System.out.println("You feed " + name + ".");
		} else if (option == 2) {
			status = pet.water();
			if (status)
				System.out.println("You refill " + name + "'s water.");
		} else if (option == 3) {
			status = pet.bathroom();
			if (status)
				System.out.println("You let " + name + " out to go to the bathroom.");
		} else if (option == 4) {
			status = pet.play();
			if (status)
				System.out.println("You play with " + name + ".");
		} else if (option == 5) {
			System.out.println("You do nothing.");
		} else if (option == 6) {
			System.out.println("Have a nice day!\n\n\n\n\n\n\n\n\n\n\n\n");
			input.close();
			System.exit(0);
		}

		if (!status) {
			System.out.println(pet.getName() + " is not cooperating.");
		}
	}

	private static int requestAction(Scanner input, VirtualPet pet) {
		String name = pet.getName();
		System.out.println("1. Feed " + name);
		System.out.println("2. Refill " + name + "'s water");
		System.out.println("3. Let " + name + " go to the bathroom");
		System.out.println("4. Play with " + name);
		System.out.println("5. Do nothing");
		System.out.println("6. Exit");
		int option = input.nextInt();
		return option;
	}

	private static void displayStats(VirtualPet pet) {
		int hunger = pet.getHunger();
		int thirst = pet.getThirst();
		int waste = pet.getWaste();
		int boredom = pet.getBoredom();
		String name = pet.getName();

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
