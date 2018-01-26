package virtualPet;

public class VirtualPet {

	public static final int _FOOD_TO_THIRST_ = 8;
	public static final int _FOOD_TO_WASTE_ = 2;
	public static final int _WATER_TO_WASTE_ = 2;
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

	public void feed() {
		thirst = hunger / _FOOD_TO_THIRST_;
		waste = hunger / _FOOD_TO_WASTE_;
		if (hunger < 80) {
			hunger = 0;
		} else {
			hunger -= 80;
		}
	}

	public void water() {
		waste = thirst / _WATER_TO_WASTE_;
		if (thirst < 80) {
			thirst = 0;
		} else {
			thirst -= 80;
		}
	}

}
