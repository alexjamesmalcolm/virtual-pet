package virtualPet;

public class VirtualPet {

	public int hunger = 20;
	public int thirst = 20;
	public int waste = 20;
	public int boredom = 20;
	public int sickness = 10;

	public VirtualPet(int inputHunger, int inputThirst, int inputWaste, int inputBoredom, int inputSickness) {
		this.thirst = inputThirst;
		this.hunger = inputHunger;
		this.waste = inputWaste;
		this.boredom = inputBoredom;
		this.sickness = inputSickness;
	}

	public VirtualPet() {
	}

	public void tick() {
		boredom += 1;
		hunger += 1;
		thirst += 1;
	}

}
