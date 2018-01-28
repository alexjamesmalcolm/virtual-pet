package virtualPet;

public class VirtualPet {

	public static final int _THIRST_PER_TICK_ = 15;
	public static final int _HUNGER_PER_TICK_ = 10;
	public static final int _BOREDOM_PER_TICK_ = 15;
	public static final int _HUNGER_TO_THIRST_ = 8;
	public static final int _HUNGER_TO_WASTE_ = 2;
	public static final int _THIRST_TO_WASTE_ = 2;
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
	}

	public VirtualPet() {
		thirst = 20;
		hunger = 20;
		waste = 20;
		boredom = 20;
		name = "Ramanujan";
	}

	public void tick() {
		boredom += _BOREDOM_PER_TICK_;
		hunger += _HUNGER_PER_TICK_;
		thirst += _THIRST_PER_TICK_;
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

	public void feed() {
		if (thirst + hunger / _HUNGER_TO_THIRST_ <= 100) {
			thirst += hunger / _HUNGER_TO_THIRST_;
		} else {
			thirst = 100;
		}

		if (waste + hunger / _HUNGER_TO_WASTE_ >= 100) {
			bathroom();
		}
		waste += hunger / _HUNGER_TO_WASTE_;

		if (hunger < 80) {
			hunger = 0;
		} else {
			hunger -= 80;
		}
	}

	public void water() {
		if (waste + thirst / _THIRST_TO_WASTE_ >= 100) {
			bathroom();
		}
		waste += thirst / _THIRST_TO_WASTE_;

		if (thirst < 80) {
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
		if (hunger >= 100) {
			return false;
		}

		if (thirst >= 100) {
			return false;
		}

		return true;
	}

	public boolean hasEscaped() {
		if(boredom >= 100) {
			return true;
		}
		return false;
	}

}
