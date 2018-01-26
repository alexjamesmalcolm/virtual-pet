package virtualPet;

import org.junit.Assert;
import org.junit.Test;

public class VirtualPetTest {

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
		int inputSickness = 10;

		VirtualPet underTest = new VirtualPet(inputHunger, inputThirst, inputWaste, inputBoredom, inputSickness);

		Assert.assertEquals(inputThirst, underTest.thirst);
		Assert.assertEquals(inputHunger, underTest.hunger);
		Assert.assertEquals(inputBoredom, underTest.boredom);
		Assert.assertEquals(inputWaste, underTest.waste);
		Assert.assertEquals(inputSickness, underTest.sickness);
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
		VirtualPet underTest = new VirtualPet(inputHunger, inputThirst, 0, 0, 0);
		underTest.feed();
		int thirst = underTest.thirst;
		Assert.assertEquals(inputHunger / 3, thirst);
	}
	
	@Test
	public void shouldHaveFeedIncreaseThirstWhenHungerIs100() {
		int inputHunger = 100;
		int inputThirst = 0;
		VirtualPet underTest = new VirtualPet(inputHunger, inputThirst, 0, 0, 0);
		underTest.feed();
		int thirst = underTest.thirst;
		int hunger = underTest.hunger;
		Assert.assertEquals(inputHunger / 3, thirst);
		Assert.assertEquals(20, hunger);
	}
	
	@Test
	public void shouldHaveFeedIncreaseThirstWhenHungerIs30() {
		int inputHunger = 30;
		int inputThirst = 0;
		VirtualPet underTest = new VirtualPet(inputHunger, inputThirst, 0, 0, 0);
		underTest.feed();
		int thirst = underTest.thirst;
		Assert.assertEquals(inputHunger / 3, thirst);
	}
}
