package virtualPet;

public class VirtualPet {

	public static final int THIRST_PER_TICK = 12;
	public static final int HUNGER_PER_TICK = 6;
	public static final int BOREDOM_PER_TICK = 12;
	public static final int HUNGER_TO_THIRST = 8;
	public static final int HUNGER_TO_WASTE = 2;
	public static final int THIRST_TO_WASTE = 2;
	private int hunger;
	private int thirst;
	private int waste;
	private int boredom;
	private String name;
	private String priority;
	private int stubbornness;

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

	public String getName() {
		return name;
	}

	public String getPriority() {
		return priority;
	}

	public int getStubbornness() {
		return stubbornness;
	}

	public VirtualPet(String name, int hunger, int thirst, int waste, int boredom) {
		this.thirst = thirst;
		this.hunger = hunger;
		this.waste = waste;
		this.boredom = boredom;
		this.name = name;
		decidePriority();
		decideStubbornness();
	}

	public VirtualPet() {
		thirst = 20;
		hunger = 20;
		waste = 20;
		boredom = 20;
		name = "Ramanujan";
		decidePriority();
		decideStubbornness();
	}

	public VirtualPet(String name) {
		thirst = 20;
		hunger = 20;
		waste = 20;
		boredom = 20;
		this.name = name;
		decidePriority();
		decideStubbornness();
	}

	public void tick() {
		boredom += BOREDOM_PER_TICK;
		hunger += HUNGER_PER_TICK;
		thirst += THIRST_PER_TICK;
		if (waste >= 100) {
			bathroom();
		}

		decidePriority();

		decideStubbornness();
	}

	// shouldHaveTickDeterminePriorityIsWasteNotBoredom
	private void decidePriority() {
		if (thirst > hunger && thirst > boredom) {
			priority = "thirst";
		} else if (hunger > boredom && hunger > waste) {
			priority = "hunger";
		} else if (boredom > waste) {
			priority = "boredom";
		} else {
			priority = "waste";
		}
	}

	private void decideStubbornness() {
		if (boredom > thirst && boredom > waste && boredom > hunger) {
			stubbornness = boredom;
		} else if (waste > thirst && waste > hunger) {
			stubbornness = waste;
		} else if (thirst > hunger) {
			stubbornness = thirst;
		} else {
			stubbornness = hunger;
		}
	}

	public boolean feed() {
		if (stubbornness >= 80 && !priority.equals("hunger")) {
			return false;
		}

		if (thirst + hunger / HUNGER_TO_THIRST <= 100) {
			thirst += hunger / HUNGER_TO_THIRST;
		} else {
			thirst = 100;
		}

		if (waste + hunger / HUNGER_TO_WASTE >= 100) {
			bathroom();
		}
		waste += hunger / HUNGER_TO_WASTE;

		if (hunger < 80) {
			hunger = 0;
		} else {
			hunger -= 80;
		}

		return true;
	}

	public boolean water() {
		if (stubbornness >= 80 && !priority.equals("thirst")) {
			return false;
		}

		if (waste + thirst / THIRST_TO_WASTE >= 100) {
			bathroom();
		}
		waste += thirst / THIRST_TO_WASTE;

		if (thirst < 80) {
			thirst = 0;
		} else {
			thirst -= 80;
		}

		return true;
	}

	public boolean play() {
		if (stubbornness >= 80 && !priority.equals("boredom")) {
			return false;
		}

		if (boredom < 80) {
			boredom = 0;
		} else {
			boredom -= 80;
		}

		return true;
	}

	public boolean bathroom() {
		if (waste - 80 < 0) {
			waste = 0;
		} else {
			waste -= 80;
		}

		if (stubbornness >= 80 && !priority.equals("waste")) {
			return false;
		}

		return true;
	}

	public boolean alive() {
		if (hunger >= 100) {
			return false;
		}

		if (thirst >= 100) {
			return false;
		}

		return true;
	}

	public boolean hasEscaped() {
		if (boredom >= 100) {
			return true;
		}
		return false;
	}

	@Override
	public String toString() {
		return "Name: " + name + ", Hunger: " + hunger + ", Thirst: " + thirst + ", Waste: " + waste + ", Boredom: "
				+ boredom + ", Priority: " + priority + ", Disagreeableness: " + stubbornness;
	}

}
