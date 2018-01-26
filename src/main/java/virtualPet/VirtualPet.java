package virtualPet;

public class VirtualPet {

	public int hunger = 20;
	public int thirst = 20;
	public int waste = 20;
	public int boredom = 20;

	public void tick() {
		boredom += 1;
		hunger += 1;
	}

}
