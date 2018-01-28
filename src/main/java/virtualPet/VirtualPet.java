package virtualPet;

public class VirtualPet {

	public static final int _HUNGER_TO_THIRST_ = 8;
	public static final int _HUNGER_TO_WASTE_ = 2;
	public static final int _THIRST_TO_WASTE_ = 2;
	private int hunger, thirst, waste, boredom;

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
		thirst = 20;
		hunger = 20;
		waste = 20;
		boredom = 20;
	}

	public void tick() {
		boredom += 1;
		hunger += 1;
		thirst += 1;
	}

	public void feed() {
		if (thirst + hunger / _HUNGER_TO_THIRST_ <= 100) {
			thirst += hunger / _HUNGER_TO_THIRST_;
		} else {
			thirst = 100;
		}
		if (waste + hunger / _HUNGER_TO_WASTE_ <= 100) {
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
			boredom -= 80;
		}
	}

	public void bathroom() {
		if (waste - 80 < 0) {
			waste = 0;
		} else {
			waste -= 80;
		}
	}

	public boolean alive() {
		if(hunger >= 100) {
			return false;
		}
		return true;
	}

}
