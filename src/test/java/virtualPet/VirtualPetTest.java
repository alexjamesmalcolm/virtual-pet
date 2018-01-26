package virtualPet;

import org.junit.Assert;
import org.junit.Test;

public class VirtualPetTest {

	public static final int _HUNGER_TO_THIRST_ = VirtualPet._HUNGER_TO_THIRST_;
	public static final int _HUNGER_TO_WASTE_ = VirtualPet._HUNGER_TO_WASTE_;
	private static final int _THIRST_TO_WASTE_ = VirtualPet._THIRST_TO_WASTE_;

	@Test
	public void shouldHaveHungerAttribute() {
		VirtualPet underTest = new VirtualPet();
		int hunger = underTest.hunger;
		Assert.assertEquals(20, hunger);
	}

	@Test
	public void shouldHaveThirstAttribute() {
		VirtualPet underTest = new VirtualPet();
		int thirst = underTest.thirst;
		Assert.assertEquals(20, thirst);
	}

	@Test
	public void shouldHaveWasteAttribute() {
		VirtualPet underTest = new VirtualPet();
		int waste = underTest.waste;
		Assert.assertEquals(20, waste);
		;
	}

	@Test
	public void shouldHaveBoredomAttribute() {
		VirtualPet underTest = new VirtualPet();
		int boredom = underTest.boredom;
		Assert.assertEquals(20, boredom);
	}

	@Test
	public void shouldHaveTickIncreaseBoredom() {
		VirtualPet underTest = new VirtualPet();
		underTest.tick();
		int boredom = underTest.boredom;
		Assert.assertEquals(21, boredom);
	}

	@Test
	public void shouldHaveTickIncreaseHunger() {
		VirtualPet underTest = new VirtualPet();
		underTest.tick();
		int hunger = underTest.hunger;
		Assert.assertEquals(21, hunger);
	}

	@Test
	public void shouldHaveTickIncreaseThirst() {
		VirtualPet underTest = new VirtualPet();
		underTest.tick();
		int thirst = underTest.thirst;
		Assert.assertEquals(21, thirst);
	}

	@Test
	public void shouldAcceptCustomAttributes() {
		int inputThirst = 80;
		int inputHunger = 60;
		int inputBoredom = 70;
		int inputWaste = 30;

		VirtualPet underTest = new VirtualPet(inputHunger, inputThirst, inputWaste, inputBoredom);

		Assert.assertEquals(inputThirst, underTest.thirst);
		Assert.assertEquals(inputHunger, underTest.hunger);
		Assert.assertEquals(inputBoredom, underTest.boredom);
		Assert.assertEquals(inputWaste, underTest.waste);
	}

	@Test
	public void shouldHaveFeedDecreaseHunger() {
		VirtualPet underTest = new VirtualPet();
		underTest.feed();
		int hunger = underTest.hunger;
		Assert.assertEquals(0, hunger);
	}

	@Test
	public void shouldHaveFeedIncreaseThirstWhenHungerIs80() {
		int inputHunger = 80;
		int inputThirst = 0;
		VirtualPet underTest = new VirtualPet(inputHunger, inputThirst, 0, 0);
		underTest.feed();
		int thirst = underTest.thirst;
		Assert.assertEquals(inputHunger / _HUNGER_TO_THIRST_, thirst);
	}

	@Test
	public void shouldHaveFeedIncreaseThirstWhenHungerIs100() {
		int inputHunger = 100;
		int inputThirst = 0;
		VirtualPet underTest = new VirtualPet(inputHunger, inputThirst, 0, 0);
		underTest.feed();
		int thirst = underTest.thirst;
		int hunger = underTest.hunger;
		Assert.assertEquals(inputHunger / _HUNGER_TO_THIRST_, thirst);
		Assert.assertEquals(20, hunger);
	}

	@Test
	public void shouldHaveFeedIncreaseThirstWhenHungerIs30() {
		int inputHunger = 30;
		int inputThirst = 0;
		VirtualPet underTest = new VirtualPet(inputHunger, inputThirst, 0, 0);
		underTest.feed();
		int thirst = underTest.thirst;
		Assert.assertEquals(inputHunger / _HUNGER_TO_THIRST_, thirst);
	}

	@Test
	public void shouldHaveWaterDecreaseThirst() {
		int inputThirst = 40;
		VirtualPet underTest = new VirtualPet(0, inputThirst, 0, 0);
		underTest.water();
		int thirst = underTest.thirst;
		Assert.assertEquals(0, thirst);
	}

	@Test
	public void shouldHaveWaterDecreaseThirstBy80() {
		int inputThirst = 100;
		VirtualPet underTest = new VirtualPet(0, inputThirst, 0, 0);
		underTest.water();
		int thirst = underTest.thirst;
		Assert.assertEquals(20, thirst);
	}

	@Test
	public void shouldHaveFeedIncreaseWasteWhenHungerIs100() {
		int inputHunger = 100;
		int inputWaste = 0;
		VirtualPet underTest = new VirtualPet(inputHunger, 0, inputWaste, 0);
		underTest.feed();
		int waste = underTest.waste;
		Assert.assertEquals(inputHunger / _HUNGER_TO_WASTE_, waste);
	}

	@Test
	public void shouldHaveWaterIncreaseWasteWhenThirstIs100() {
		int inputThirst = 100;
		int inputWaste = 0;
		VirtualPet underTest = new VirtualPet(0, inputThirst, inputWaste, 0);
		underTest.water();
		int waste = underTest.waste;
		Assert.assertEquals(inputThirst / _THIRST_TO_WASTE_, waste);
	}

	@Test
	public void shouldHaveWaterIncreaseWasteWhenThirstIs10() {
		int inputThirst = 10;
		int inputWaste = 0;
		VirtualPet underTest = new VirtualPet(0, inputThirst, inputWaste, 0);
		underTest.water();
		int waste = underTest.waste;
		Assert.assertEquals(inputThirst / _THIRST_TO_WASTE_, waste);
	}

	@Test
	public void shouldHaveWaterIncreaseWasteWhenThirstIs10AndWasteIs40() {
		int inputThirst = 10;
		int inputWaste = 40;
		VirtualPet underTest = new VirtualPet(0, inputThirst, inputWaste, 0);
		underTest.water();
		int waste = underTest.waste;
		Assert.assertEquals(inputWaste + inputThirst / _THIRST_TO_WASTE_, waste);
	}

	@Test
	public void shouldHaveFeedIncreaseWasteWhenHungerIs60AndWasteIs30() {
		int inputHunger = 60;
		int inputWaste = 30;
		VirtualPet underTest = new VirtualPet(inputHunger, 0, inputWaste, 0);
		underTest.feed();
		int waste = underTest.waste;
		Assert.assertEquals(inputWaste + inputHunger / _HUNGER_TO_WASTE_, waste);
	}
	
	// @Test
	// public void
	// shouldHaveFeedNotIncreaseWasteOrDecreaseHungerWhenWasteIs90AndHungerIs90() {
	// int inputHunger = 90;
	// int inputWaste = 90;
	// VirtualPet underTest = new VirtualPet(inputHunger,0,inputWaste,0);
	// }
}
