package virtualPet;

import org.junit.Assert;
import org.junit.Test;

public class VirtualPetTest {

	private static final int _HUNGER_TO_THIRST_ = VirtualPet._HUNGER_TO_THIRST_;
	private static final int _HUNGER_TO_WASTE_ = VirtualPet._HUNGER_TO_WASTE_;
	private static final int _THIRST_TO_WASTE_ = VirtualPet._THIRST_TO_WASTE_;

	@Test
	public void shouldAcceptCustomAttributes() {
		int inputThirst = 80;
		int inputHunger = 60;
		int inputBoredom = 70;
		int inputWaste = 30;

		VirtualPet underTest = new VirtualPet(null, inputHunger, inputThirst, inputWaste, inputBoredom);

		Assert.assertEquals(inputThirst, underTest.getThirst());
		Assert.assertEquals(inputHunger, underTest.getHunger());
		Assert.assertEquals(inputBoredom, underTest.getBoredom());
		Assert.assertEquals(inputWaste, underTest.getWaste());
	}

	@Test
	public void shouldHaveAliveReturnFalseWhenHungerIs100() {
		int inputHunger = 100;
		VirtualPet underTest = new VirtualPet(null, inputHunger, 0, 0, 0);
		boolean alive = underTest.alive();
		Assert.assertFalse(alive);
	}

	@Test
	public void shouldHaveAliveReturnFalseWhenThirstIs100() {
		int inputThirst = 100;
		VirtualPet underTest = new VirtualPet(null, 0, inputThirst, 0, 0);
		boolean alive = underTest.alive();
		Assert.assertFalse(alive);
	}

	@Test
	public void shouldHaveAliveReturnTrue() {
		VirtualPet underTest = new VirtualPet();
		boolean alive = underTest.alive();
		Assert.assertTrue(alive);
	}

	@Test
	public void shouldHaveBathroomDecreaseWasteWhen10() {
		int inputWaste = 10;
		VirtualPet underTest = new VirtualPet(null, 0, 0, inputWaste, 0);
		underTest.bathroom();
		int waste = underTest.getWaste();
		Assert.assertEquals(0, waste);
	}

	@Test
	public void shouldHaveBathroomDecreaseWasteWhen100() {
		int inputWaste = 100;
		VirtualPet underTest = new VirtualPet(null, 0, 0, inputWaste, 0);
		underTest.bathroom();
		int waste = underTest.getWaste();
		Assert.assertEquals(20, waste);
	}

	@Test
	public void shouldHaveBathroomDecreaseWasteWhen90() {
		int inputWaste = 90;
		VirtualPet underTest = new VirtualPet(null, 0, 0, inputWaste, 0);
		underTest.bathroom();
		int waste = underTest.getWaste();
		Assert.assertEquals(10, waste);
	}

	@Test
	public void shouldHaveFeedDecreaseHunger() {
		VirtualPet underTest = new VirtualPet();
		underTest.feed();
		int hunger = underTest.getHunger();
		Assert.assertEquals(0, hunger);
	}

	@Test
	public void shouldHaveFeedIncreaseThirstWhenHungerIs100() {
		int inputHunger = 100;
		int inputThirst = 0;
		VirtualPet underTest = new VirtualPet(null, inputHunger, inputThirst, 0, 0);
		underTest.feed();
		int thirst = underTest.getThirst();
		int hunger = underTest.getHunger();
		Assert.assertEquals(inputHunger / _HUNGER_TO_THIRST_, thirst);
		Assert.assertEquals(20, hunger);
	}

	@Test
	public void shouldHaveFeedIncreaseThirstWhenHungerIs30() {
		int inputHunger = 30;
		int inputThirst = 0;
		VirtualPet underTest = new VirtualPet(null, inputHunger, inputThirst, 0, 0);
		underTest.feed();
		int thirst = underTest.getThirst();
		Assert.assertEquals(inputHunger / _HUNGER_TO_THIRST_, thirst);
	}

	@Test
	public void shouldHaveFeedIncreaseThirstWhenHungerIs80() {
		int inputHunger = 80;
		int inputThirst = 0;
		VirtualPet underTest = new VirtualPet(null, inputHunger, inputThirst, 0, 0);
		underTest.feed();
		int thirst = underTest.getThirst();
		Assert.assertEquals(inputHunger / _HUNGER_TO_THIRST_, thirst);
	}

	@Test
	public void shouldHaveFeedIncreaseThirstWhenThirstIs20() {
		int inputHunger = 50;
		int inputThirst = 20;
		VirtualPet underTest = new VirtualPet(null, inputHunger, inputThirst, 0, 0);
		underTest.feed();
		int thirst = underTest.getThirst();
		Assert.assertEquals(inputThirst + inputHunger / _HUNGER_TO_THIRST_, thirst);
	}

	@Test
	public void shouldHaveFeedIncreaseThirstWhenThirstIs90() {
		int inputHunger = 100;
		int inputThirst = 90;
		VirtualPet underTest = new VirtualPet(null, inputHunger, inputThirst, 0, 0);
		underTest.feed();
		int thirst = underTest.getThirst();
		Assert.assertEquals(100, thirst);
	}

	@Test
	public void shouldHaveFeedIncreaseWasteWhenHungerIs100() {
		int inputHunger = 100;
		int inputWaste = 0;
		VirtualPet underTest = new VirtualPet(null, inputHunger, 0, inputWaste, 0);
		underTest.feed();
		int waste = underTest.getWaste();
		Assert.assertEquals(inputHunger / _HUNGER_TO_WASTE_, waste);
	}

	@Test
	public void shouldHaveFeedIncreaseWasteWhenHungerIs60AndWasteIs30() {
		int inputHunger = 60;
		int inputWaste = 30;
		VirtualPet underTest = new VirtualPet(null, inputHunger, 0, inputWaste, 0);
		underTest.feed();
		int waste = underTest.getWaste();
		Assert.assertEquals(inputWaste + inputHunger / _HUNGER_TO_WASTE_, waste);
	}

	@Test
	public void shouldHaveFeedNotIncreaseWasteOrDecreaseHungerWhenWasteIs90AndHungerIs90() {
		int inputHunger = 90;
		int inputWaste = 90;
		VirtualPet underTest = new VirtualPet(null, inputHunger, 0, inputWaste, 0);
		underTest.feed();
		int waste = underTest.getWaste();
		Assert.assertEquals(100, waste);
	}

	@Test
	public void shouldHaveGetBoredomReturnBoredom() {
		VirtualPet underTest = new VirtualPet();
		int boredom = underTest.getBoredom();
		Assert.assertEquals(20, boredom);
	}

	@Test
	public void shouldHaveGetHungerReturnHunger() {
		VirtualPet underTest = new VirtualPet();
		int hunger = underTest.getHunger();
		Assert.assertEquals(20, hunger);
	}

	@Test
	public void shouldHaveGetNameReturnGeorge() {
		String inputName = "George";
		VirtualPet underTest = new VirtualPet(inputName, 0, 0, 0, 0);
		String name = underTest.getName();
		Assert.assertEquals(inputName, name);
	}

	@Test
	public void shouldHaveGetNameReturnRamanujan() {
		VirtualPet underTest = new VirtualPet();
		String name = underTest.getName();
		Assert.assertEquals("Ramanujan", name);
	}

	@Test
	public void shouldHaveGetThirstReturnThirst() {
		VirtualPet underTest = new VirtualPet();
		int thirst = underTest.getThirst();
		Assert.assertEquals(20, thirst);
	}

	@Test
	public void shouldHaveGetWasteReturnWaste() {
		VirtualPet underTest = new VirtualPet();
		int waste = underTest.getWaste();
		Assert.assertEquals(20, waste);
		;
	}

	@Test
	public void shouldHavePlayDecreaseBoredomWhen10() {
		int inputBoredom = 10;
		VirtualPet underTest = new VirtualPet(null, 0, 0, 0, inputBoredom);
		underTest.play();
		int boredom = underTest.getBoredom();
		Assert.assertEquals(0, boredom);
	}

	@Test
	public void shouldHavePlayDecreaseBoredomWhen100() {
		int inputBoredom = 100;
		VirtualPet underTest = new VirtualPet(null, 0, 0, 0, inputBoredom);
		underTest.play();
		int boredom = underTest.getBoredom();
		Assert.assertEquals(inputBoredom - 80, boredom);
	}

	@Test
	public void shouldHavePlayDecreaseBoredomWhen90() {
		int inputBoredom = 90;
		VirtualPet underTest = new VirtualPet(null, 0, 0, 0, inputBoredom);
		underTest.play();
		int boredom = underTest.getBoredom();
		Assert.assertEquals(10, boredom);
	}

	@Test
	public void shouldHaveTickCallBathroomWhenWasteIsHigh() {
		int inputWaste = 100;
		VirtualPet underTest = new VirtualPet(null, 0, 0, inputWaste, 0);
		underTest.tick();
		int waste = underTest.getWaste();
		Assert.assertEquals(20, waste);
	}

	@Test
	public void shouldHaveTickDeterminePriorityIsBoredomNotHunger() {
		VirtualPet underTest = new VirtualPet(null, 60, 0, 0, 80);
		underTest.tick();
		String priority = underTest.priority;
		Assert.assertEquals("boredom", priority);
	}
	
	@Test
	public void shouldHaveTickDeterminePriorityIsBoredomNotThirst() {
		VirtualPet underTest = new VirtualPet(null, 0, 60, 0, 80);
		underTest.tick();
		String priority = underTest.priority;
		Assert.assertEquals("boredom", priority);
	}

	@Test
	public void shouldHaveTickDeterminePriorityIsHungerNotThirst() {
		VirtualPet underTest = new VirtualPet(null, 80, 60, 0, 0);
		underTest.tick();
		String priority = underTest.priority;
		Assert.assertEquals("hunger", priority);
	}

	@Test
	public void shouldHaveTickDeterminePriorityIsThirstNotBoredom() {
		VirtualPet underTest = new VirtualPet(null, 0, 80, 0, 60);
		underTest.tick();
		String priority = underTest.priority;
		Assert.assertEquals("thirst", priority);
	}

	@Test
	public void shouldHaveTickDeterminePriorityIsThirstNotHunger() {
		VirtualPet underTest = new VirtualPet(null, 60, 80, 0, 0);
		underTest.tick();
		String priority = underTest.priority;
		Assert.assertEquals("thirst", priority);
	}

	@Test
	public void shouldHaveTickIncreaseBoredom() {
		VirtualPet underTest = new VirtualPet();
		underTest.tick();
		int boredom = underTest.getBoredom();
		Assert.assertEquals(21, boredom);
	}

	@Test
	public void shouldHaveTickIncreaseHunger() {
		VirtualPet underTest = new VirtualPet();
		underTest.tick();
		int hunger = underTest.getHunger();
		Assert.assertEquals(21, hunger);
	}

	@Test
	public void shouldHaveTickIncreaseThirst() {
		VirtualPet underTest = new VirtualPet();
		underTest.tick();
		int thirst = underTest.getThirst();
		Assert.assertEquals(21, thirst);
	}

	@Test
	public void shouldHaveWaterDecreaseThirst() {
		int inputThirst = 40;
		VirtualPet underTest = new VirtualPet(null, 0, inputThirst, 0, 0);
		underTest.water();
		int thirst = underTest.getThirst();
		Assert.assertEquals(0, thirst);
	}

	@Test
	public void shouldHaveWaterDecreaseThirstBy80() {
		int inputThirst = 100;
		VirtualPet underTest = new VirtualPet(null, 0, inputThirst, 0, 0);
		underTest.water();
		int thirst = underTest.getThirst();
		Assert.assertEquals(20, thirst);
	}

	@Test
	public void shouldHaveWaterIncreaseWasteWhenThirstIs10() {
		int inputThirst = 10;
		int inputWaste = 0;
		VirtualPet underTest = new VirtualPet(null, 0, inputThirst, inputWaste, 0);
		underTest.water();
		int waste = underTest.getWaste();
		Assert.assertEquals(inputThirst / _THIRST_TO_WASTE_, waste);
	}

	@Test
	public void shouldHaveWaterIncreaseWasteWhenThirstIs100() {
		int inputThirst = 100;
		int inputWaste = 0;
		VirtualPet underTest = new VirtualPet(null, 0, inputThirst, inputWaste, 0);
		underTest.water();
		int waste = underTest.getWaste();
		Assert.assertEquals(inputThirst / _THIRST_TO_WASTE_, waste);
	}

	@Test
	public void shouldHaveWaterIncreaseWasteWhenThirstIs10AndWasteIs40() {
		int inputThirst = 10;
		int inputWaste = 40;
		VirtualPet underTest = new VirtualPet(null, 0, inputThirst, inputWaste, 0);
		underTest.water();
		int waste = underTest.getWaste();
		Assert.assertEquals(inputWaste + inputThirst / _THIRST_TO_WASTE_, waste);
	}
}
