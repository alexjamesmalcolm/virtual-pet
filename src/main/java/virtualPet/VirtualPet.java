package virtualPet;

public class VirtualPet {

	public static final int _HUNGER_TO_THIRST_ = 8;
	public static final int _HUNGER_TO_WASTE_ = 2;
	public static final int _THIRST_TO_WASTE_ = 2;
	private int hunger = 20;
	private int thirst = 20;
	private int waste = 20;
	private int boredom = 20;

	public int getHunger() {
		return hunger;
	}

	public int getThirst() {
		return thirst;
	}

	public int getWaste() {
		return waste;
	}

	public int getBoredom() {
		return boredom;
	}

	public VirtualPet(int inputHunger, int inputThirst, int inputWaste, int inputBoredom) {
		this.thirst = inputThirst;
		this.hunger = inputHunger;
		this.waste = inputWaste;
		this.boredom = inputBoredom;
	}

	public VirtualPet() {
	}

	public void tick() {
		boredom += 1;
		hunger += 1;
		thirst += 1;
	}

	public void feed() {
		thirst += hunger / _HUNGER_TO_THIRST_;
		if (getWaste() + getHunger() / _HUNGER_TO_WASTE_ <= 100) {
			waste += hunger / _HUNGER_TO_WASTE_;
		} else {
			waste = 100;
		}
		if (getHunger() < 80) {
			hunger = 0;
		} else {
			hunger -= 80;
		}
	}

	public void water() {
		waste += thirst / _THIRST_TO_WASTE_;
		if (getThirst() < 80) {
			thirst = 0;
		} else {
			thirst -= 80;
		}
	}

	public void play() {
		if (boredom < 80) {
			boredom = 0;
		} else {
			boredom = 20;
		}
	}

}
