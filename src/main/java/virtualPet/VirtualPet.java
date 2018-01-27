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

	public void setHunger(int hunger) {
		this.hunger = hunger;
	}

	public int getThirst() {
		return thirst;
	}

	public void setThirst(int thirst) {
		this.thirst = thirst;
	}

	public int getWaste() {
		return waste;
	}

	public void setWaste(int waste) {
		this.waste = waste;
	}

	public int getBoredom() {
		return boredom;
	}

	public void setBoredom(int boredom) {
		this.boredom = boredom;
	}

	public VirtualPet(int inputHunger, int inputThirst, int inputWaste, int inputBoredom) {
		this.setThirst(inputThirst);
		this.setHunger(inputHunger);
		this.setWaste(inputWaste);
		this.setBoredom(inputBoredom);
	}

	public VirtualPet() {
	}

	public void tick() {
		setBoredom(getBoredom() + 1);
		setHunger(getHunger() + 1);
		setThirst(getThirst() + 1);
	}

	public void feed() {
		setThirst(getThirst() + getHunger() / _HUNGER_TO_THIRST_);
		if (getWaste() + getHunger() / _HUNGER_TO_WASTE_ <= 100) {
			setWaste(getWaste() + getHunger() / _HUNGER_TO_WASTE_);
		} else {
			setWaste(100);
		}
		if (getHunger() < 80) {
			setHunger(0);
		} else {
			setHunger(getHunger() - 80);
		}
	}

	public void water() {
		setWaste(getWaste() + getThirst() / _THIRST_TO_WASTE_);
		if (getThirst() < 80) {
			setThirst(0);
		} else {
			setThirst(getThirst() - 80);
		}
	}

}
