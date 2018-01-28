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
	private int disagreeableness;

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

	public int getDisagreeableness() {
		return disagreeableness;
	}

	public VirtualPet(String name, int hunger, int thirst, int waste, int boredom) {
		this.thirst = thirst;
		this.hunger = hunger;
		this.waste = waste;
		this.boredom = boredom;
		this.name = name;
		determinePriority();
		determineDisagreeableness();
	}

	public VirtualPet() {
		thirst = 20;
		hunger = 20;
		waste = 20;
		boredom = 20;
		name = "Ramanujan";
		determinePriority();
		determineDisagreeableness();
	}

	public VirtualPet(String name) {
		thirst = 20;
		hunger = 20;
		waste = 20;
		boredom = 20;
		this.name = name;
		determinePriority();
		determineDisagreeableness();
	}

	public void tick() {
		boredom += BOREDOM_PER_TICK;
		hunger += HUNGER_PER_TICK;
		thirst += THIRST_PER_TICK;
		if (waste >= 100) {
			bathroom();
		}

		determinePriority();

		determineDisagreeableness();
	}

	private void determinePriority() {
		if (thirst > hunger && thirst > boredom) {
			priority = "thirst";
		} else if (hunger > boredom) {
			priority = "hunger";
		} else {
			priority = "boredom";
		}
	}

	private void determineDisagreeableness() {
		if (boredom > thirst && boredom > waste && boredom > hunger) {
			disagreeableness = boredom;
		} else if (waste > thirst && waste > hunger) {
			disagreeableness = waste;
		} else if (thirst > hunger) {
			disagreeableness = thirst;
		} else {
			disagreeableness = hunger;
		}
	}

	public boolean feed() {
		if (disagreeableness >= 80 && !priority.equals("hunger")) {
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

}
