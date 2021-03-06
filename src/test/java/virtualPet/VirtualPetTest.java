package virtualPet;

import org.junit.Assert;
import org.junit.Test;

public class VirtualPetTest {

	private static final int THIRST_PER_TICK = VirtualPet.THIRST_PER_TICK;
	private static final int HUNGER_PER_TICK = VirtualPet.HUNGER_PER_TICK;
	private static final int BOREDOM_PER_TICK = VirtualPet.BOREDOM_PER_TICK;
	private static final int HUNGER_TO_THIRST = VirtualPet.HUNGER_TO_THIRST;
	private static final int HUNGER_TO_WASTE = VirtualPet.HUNGER_TO_WASTE;
	private static final int THIRST_TO_WASTE = VirtualPet.THIRST_TO_WASTE;

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
	public void shouldHaveBathroomReturnFalseWhenDisagreeablenessIsHighAndPriorityIsNotWaste() {
		int inputWaste = 50;
		int inputHunger = 90;
		VirtualPet underTest = new VirtualPet(null, inputHunger, 0, inputWaste, 0);
		boolean status = underTest.bathroom();
		Assert.assertFalse(status);
	}

	@Test
	public void shouldHaveBathroomReturnTrueWhenDisagreeablenessIsHighButPriorityIsWaste() {
		int inputWaste = 90;
		int inputHunger = 50;
		VirtualPet underTest = new VirtualPet(null, inputHunger, 0, inputWaste, 0);
		boolean status = underTest.bathroom();
		Assert.assertEquals(true, status);
	}

	@Test
	public void shouldHaveBathroomReturnTrueWhenDisagreeablenessIsLow() {
		int inputWaste = 50;
		int inputHunger = 10;
		VirtualPet underTest = new VirtualPet(null, inputHunger, 0, inputWaste, 0);
		boolean status = underTest.bathroom();
		Assert.assertTrue(status);
	}

	@Test
	public void shouldHaveDisagreeablenessHigh() {
		int inputThirst = 90;
		VirtualPet underTest = new VirtualPet(null, 0, inputThirst, 0, 0);
		int disagreeableness = underTest.getStubbornness();
		Assert.assertEquals(inputThirst, disagreeableness);
	}

	@Test
	public void shouldHaveFeedCallBathroom() {
		int inputWaste = 90;
		int inputHunger = 91;
		VirtualPet underTest = new VirtualPet(null, inputHunger, 0, inputWaste, 0);
		underTest.feed();
		int waste = underTest.getWaste();
		Assert.assertEquals(55, waste);
	}

	@Test
	public void shouldHaveFeedDecreaseHunger() {
		VirtualPet underTest = new VirtualPet();
		underTest.feed();
		int hunger = underTest.getHunger();
		Assert.assertEquals(0, hunger);
	}

	@Test
	public void shouldHaveFeedDisfunctionWhenFalseIsReturned() {
		int inputThirst = 90;
		int inputHunger = 50;
		VirtualPet underTest = new VirtualPet(null, inputHunger, inputThirst, 0, 0);
		boolean status = underTest.feed();
		int hunger = underTest.getHunger();
		Assert.assertFalse(status);
		Assert.assertEquals(inputHunger, hunger);
	}

	@Test
	public void shouldHaveFeedIncreaseThirstWhenHungerIs100() {
		int inputHunger = 100;
		int inputThirst = 0;
		VirtualPet underTest = new VirtualPet(null, inputHunger, inputThirst, 0, 0);
		underTest.feed();
		int thirst = underTest.getThirst();
		int hunger = underTest.getHunger();
		Assert.assertEquals(inputHunger / HUNGER_TO_THIRST, thirst);
		Assert.assertEquals(20, hunger);
	}

	@Test
	public void shouldHaveFeedIncreaseThirstWhenHungerIs30() {
		int inputHunger = 30;
		int inputThirst = 0;
		VirtualPet underTest = new VirtualPet(null, inputHunger, inputThirst, 0, 0);
		underTest.feed();
		int thirst = underTest.getThirst();
		Assert.assertEquals(inputHunger / HUNGER_TO_THIRST, thirst);
	}

	@Test
	public void shouldHaveFeedIncreaseThirstWhenHungerIs80() {
		int inputHunger = 80;
		int inputThirst = 0;
		VirtualPet underTest = new VirtualPet(null, inputHunger, inputThirst, 0, 0);
		underTest.feed();
		int thirst = underTest.getThirst();
		Assert.assertEquals(inputHunger / HUNGER_TO_THIRST, thirst);
	}

	@Test
	public void shouldHaveFeedIncreaseThirstWhenThirstIs20() {
		int inputHunger = 50;
		int inputThirst = 20;
		VirtualPet underTest = new VirtualPet(null, inputHunger, inputThirst, 0, 0);
		underTest.feed();
		int thirst = underTest.getThirst();
		Assert.assertEquals(inputThirst + inputHunger / HUNGER_TO_THIRST, thirst);
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
		Assert.assertEquals(inputHunger / HUNGER_TO_WASTE, waste);
	}

	@Test
	public void shouldHaveFeedIncreaseWasteWhenHungerIs60AndWasteIs30() {
		int inputHunger = 60;
		int inputWaste = 30;
		VirtualPet underTest = new VirtualPet(null, inputHunger, 0, inputWaste, 0);
		underTest.feed();
		int waste = underTest.getWaste();
		Assert.assertEquals(inputWaste + inputHunger / HUNGER_TO_WASTE, waste);
	}

	@Test
	public void shouldHaveFeedReturnFalseWhenDisagreeablenessIsHighAndPriorityIsThirst() {
		int inputThirst = 90;
		int inputHunger = 50;
		VirtualPet underTest = new VirtualPet(null, inputHunger, inputThirst, 0, 0);
		underTest.tick();
		boolean status = underTest.feed();
		Assert.assertFalse(status);
	}

	@Test
	public void shouldHaveFeedReturnTrueWhenDisagreeablenessIsHighButPriorityIsHunger() {
		int inputHunger = 90;
		VirtualPet underTest = new VirtualPet(null, inputHunger, 0, 0, 0);
		underTest.tick();
		boolean status = underTest.feed();
		Assert.assertTrue(status);
	}

	@Test
	public void shouldHaveFeedReturnTrueWhenDisagreeablenessIsLow() {
		int inputThirst = 10;
		int inputHunger = 50;
		VirtualPet underTest = new VirtualPet(null, inputHunger, inputThirst, 0, 0);
		underTest.tick();
		boolean status = underTest.feed();
		Assert.assertTrue(status);
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
	public void shouldHaveHasEscapedReturnFalse() {
		VirtualPet underTest = new VirtualPet();
		boolean hasEscaped = underTest.hasEscaped();
		Assert.assertFalse(hasEscaped);
	}

	@Test
	public void shouldHaveHasEscapedReturnTrue() {
		VirtualPet underTest = new VirtualPet(null, 0, 0, 0, 110);
		boolean hasEscaped = underTest.hasEscaped();
		Assert.assertTrue(hasEscaped);
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
	public void shouldHavePlayDisfunctionWhenFalseIsReturned() {
		int inputBoredom = 50;
		int inputHunger = 90;
		VirtualPet underTest = new VirtualPet(null, inputHunger, 0, 0, inputBoredom);
		underTest.play();
		int boredom = underTest.getBoredom();
		Assert.assertEquals(inputBoredom, boredom);
	}

	@Test
	public void shouldHavePlayReturnFalseWhenDisagreeablenessIsHighAndPriorityIsNotBoredom() {
		int inputBoredom = 50;
		int inputHunger = 90;
		VirtualPet underTest = new VirtualPet(null, inputHunger, 0, 0, inputBoredom);
		boolean status = underTest.play();
		Assert.assertFalse(status);
	}

	@Test
	public void shouldHavePlayReturnTrueWhenDisagreeablenessIsHighButPriorityIsBoredom() {
		int inputBoredom = 90;
		int inputHunger = 50;
		VirtualPet underTest = new VirtualPet(null, inputHunger, 0, 0, inputBoredom);
		boolean status = underTest.play();
		Assert.assertTrue(status);
	}

	@Test
	public void shouldHavePlayReturnTrueWhenDisagreeablenessIsLow() {
		int inputBoredom = 50;
		int inputHunger = 10;
		VirtualPet underTest = new VirtualPet(null, inputHunger, 0, 0, inputBoredom);
		boolean status = underTest.play();
		Assert.assertTrue(status);
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
	public void shouldHaveTickDetermineDisagreeablenessByBoredomInsteadHunger() {
		VirtualPet underTest = new VirtualPet(null, 40, 0, 0, 80);
		underTest.tick();
		int disagreeableness = underTest.getStubbornness();
		Assert.assertEquals(80 + BOREDOM_PER_TICK, disagreeableness);
	}

	@Test
	public void shouldHaveTickDetermineDisagreeablenessByBoredomInsteadThirst() {
		VirtualPet underTest = new VirtualPet(null, 0, 40, 0, 80);
		underTest.tick();
		int disagreeableness = underTest.getStubbornness();
		Assert.assertEquals(80 + BOREDOM_PER_TICK, disagreeableness);
	}

	@Test
	public void shouldHaveTickDetermineDisagreeablenessByBoredomInsteadWaste() {
		VirtualPet underTest = new VirtualPet(null, 0, 0, 40, 80);
		underTest.tick();
		int disagreeableness = underTest.getStubbornness();
		Assert.assertEquals(80 + BOREDOM_PER_TICK, disagreeableness);
	}

	@Test
	public void shouldHaveTickDetermineDisagreeablenessByHungerInsteadBoredom() {
		VirtualPet underTest = new VirtualPet(null, 80, 0, 0, 40);
		underTest.tick();
		int disagreeableness = underTest.getStubbornness();
		Assert.assertEquals(80 + HUNGER_PER_TICK, disagreeableness);
	}

	@Test
	public void shouldHaveTickDetermineDisagreeablenessByHungerInsteadThirst() {
		VirtualPet underTest = new VirtualPet(null, 80, 40, 0, 0);
		underTest.tick();
		int disagreeableness = underTest.getStubbornness();
		Assert.assertEquals(80 + HUNGER_PER_TICK, disagreeableness);
	}

	@Test
	public void shouldHaveTickDetermineDisagreeablenessByHungerInsteadWaste() {
		VirtualPet underTest = new VirtualPet(null, 80, 0, 40, 0);
		underTest.tick();
		int disagreeableness = underTest.getStubbornness();
		Assert.assertEquals(80 + HUNGER_PER_TICK, disagreeableness);
	}

	@Test
	public void shouldHaveTickDetermineDisagreeablenessByThirstInsteadBoredom() {
		VirtualPet underTest = new VirtualPet(null, 0, 80, 0, 40);
		underTest.tick();
		int disagreeableness = underTest.getStubbornness();
		Assert.assertEquals(80 + THIRST_PER_TICK, disagreeableness);
	}

	@Test
	public void shouldHaveTickDetermineDisagreeablenessByThirstInsteadHunger() {
		VirtualPet underTest = new VirtualPet(null, 40, 80, 0, 0);
		underTest.tick();
		int disagreeableness = underTest.getStubbornness();
		Assert.assertEquals(80 + THIRST_PER_TICK, disagreeableness);
	}

	@Test
	public void shouldHaveTickDetermineDisagreeablenessByThirstInsteadWaste() {
		VirtualPet underTest = new VirtualPet(null, 0, 80, 40, 0);
		underTest.tick();
		int disagreeableness = underTest.getStubbornness();
		Assert.assertEquals(80 + THIRST_PER_TICK, disagreeableness);
	}

	@Test
	public void shouldHaveTickDetermineDisagreeablenessByWasteInsteadBoredom() {
		VirtualPet underTest = new VirtualPet(null, 0, 0, 80, 40);
		underTest.tick();
		int disagreeableness = underTest.getStubbornness();
		Assert.assertEquals(80, disagreeableness);
	}

	@Test
	public void shouldHaveTickDetermineDisagreeablenessByWasteInsteadHunger() {
		VirtualPet underTest = new VirtualPet(null, 40, 0, 80, 0);
		underTest.tick();
		int disagreeableness = underTest.getStubbornness();
		Assert.assertEquals(80, disagreeableness);
	}

	@Test
	public void shouldHaveTickDetermineDisagreeablenessByWasteInsteadThirst() {
		VirtualPet underTest = new VirtualPet(null, 0, 40, 80, 0);
		underTest.tick();
		int disagreeableness = underTest.getStubbornness();
		Assert.assertEquals(80, disagreeableness);
	}

	@Test
	public void shouldHaveTickDeterminePriorityByWasteInsteadHunger() {
		VirtualPet underTest = new VirtualPet(null, 40, 0, 80, 40);
		underTest.tick();
		String priority = underTest.getPriority();
		Assert.assertEquals("waste", priority);
	}

	@Test
	public void shouldHaveTickDeterminePriorityIsBoredomNotHunger() {
		VirtualPet underTest = new VirtualPet(null, 60, 0, 0, 80);
		underTest.tick();
		String priority = underTest.getPriority();
		Assert.assertEquals("boredom", priority);
	}

	@Test
	public void shouldHaveTickDeterminePriorityIsBoredomNotThirst() {
		VirtualPet underTest = new VirtualPet(null, 0, 60, 0, 80);
		underTest.tick();
		String priority = underTest.getPriority();
		Assert.assertEquals("boredom", priority);
	}

	@Test
	public void shouldHaveTickDeterminePriorityIsHungerNotBoredom() {
		VirtualPet underTest = new VirtualPet(null, 80, 0, 0, 60);
		underTest.tick();
		String priority = underTest.getPriority();
		Assert.assertEquals("hunger", priority);
	}

	@Test
	public void shouldHaveTickDeterminePriorityIsHungerNotThirst() {
		VirtualPet underTest = new VirtualPet(null, 80, 60, 0, 0);
		underTest.tick();
		String priority = underTest.getPriority();
		Assert.assertEquals("hunger", priority);
	}

	@Test
	public void shouldHaveTickDeterminePriorityIsThirstNotBoredom() {
		VirtualPet underTest = new VirtualPet(null, 0, 80, 0, 60);
		underTest.tick();
		String priority = underTest.getPriority();
		Assert.assertEquals("thirst", priority);
	}

	@Test
	public void shouldHaveTickDeterminePriorityIsThirstNotHunger() {
		VirtualPet underTest = new VirtualPet(null, 60, 80, 0, 0);
		underTest.tick();
		String priority = underTest.getPriority();
		Assert.assertEquals("thirst", priority);
	}

	@Test
	public void shouldHaveTickDeterminePriorityIsWasteNotBoredom() {
		VirtualPet underTest = new VirtualPet(null, 0, 0, 80, 60);
		underTest.tick();
		String priority = underTest.getPriority();
		Assert.assertEquals("waste", priority);
	}

	@Test
	public void shouldHaveTickIncreaseBoredom() {
		VirtualPet underTest = new VirtualPet();
		underTest.tick();
		int boredom = underTest.getBoredom();
		Assert.assertEquals(20 + BOREDOM_PER_TICK, boredom);
	}

	@Test
	public void shouldHaveTickIncreaseHunger() {
		VirtualPet underTest = new VirtualPet();
		underTest.tick();
		int hunger = underTest.getHunger();
		Assert.assertEquals(20 + HUNGER_PER_TICK, hunger);
	}

	@Test
	public void shouldHaveTickIncreaseThirst() {
		VirtualPet underTest = new VirtualPet();
		underTest.tick();
		int thirst = underTest.getThirst();
		Assert.assertEquals(20 + THIRST_PER_TICK, thirst);
	}

	@Test
	public void shouldHaveWaterCallBathroom() {
		int inputWaste = 90;
		int inputThirst = 80;
		VirtualPet underTest = new VirtualPet(null, 0, inputThirst, inputWaste, 0);
		underTest.water();
		int waste = underTest.getWaste();
		Assert.assertEquals(50, waste);
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
	public void shouldHaveWaterDisfunctionWhenFalseIsReturned() {
		int inputThirst = 50;
		int inputHunger = 90;
		VirtualPet underTest = new VirtualPet(null, inputHunger, inputThirst, 0, 0);
		boolean status = underTest.water();
		int thirst = underTest.getThirst();
		Assert.assertFalse(status);
		Assert.assertEquals(inputThirst, thirst);
	}

	@Test
	public void shouldHaveWaterIncreaseWasteWhenThirstIs10() {
		int inputThirst = 10;
		int inputWaste = 0;
		VirtualPet underTest = new VirtualPet(null, 0, inputThirst, inputWaste, 0);
		underTest.water();
		int waste = underTest.getWaste();
		Assert.assertEquals(inputThirst / THIRST_TO_WASTE, waste);
	}

	@Test
	public void shouldHaveWaterIncreaseWasteWhenThirstIs100() {
		int inputThirst = 100;
		int inputWaste = 0;
		VirtualPet underTest = new VirtualPet(null, 0, inputThirst, inputWaste, 0);
		underTest.water();
		int waste = underTest.getWaste();
		Assert.assertEquals(inputThirst / THIRST_TO_WASTE, waste);
	}

	@Test
	public void shouldHaveWaterIncreaseWasteWhenThirstIs10AndWasteIs40() {
		int inputThirst = 10;
		int inputWaste = 40;
		VirtualPet underTest = new VirtualPet(null, 0, inputThirst, inputWaste, 0);
		underTest.water();
		int waste = underTest.getWaste();
		Assert.assertEquals(inputWaste + inputThirst / THIRST_TO_WASTE, waste);
	}

	@Test
	public void shouldHaveWaterReturnFalseWhenDisagreeablenessIsHighAndPriorityIsNotThirst() {
		int inputHunger = 90;
		int inputThirst = 50;
		VirtualPet underTest = new VirtualPet(null, inputHunger, inputThirst, 0, 0);
		boolean status = underTest.water();
		Assert.assertFalse(status);
	}

	@Test
	public void shouldHaveWaterReturnTrueWhenDisagreeablenessIsHighButPriorityIsThirst() {
		int inputThirst = 90;
		int inputHunger = 50;
		VirtualPet underTest = new VirtualPet(null, inputHunger, inputThirst, 0, 0);
		boolean status = underTest.water();
		Assert.assertTrue(status);
	}

	@Test
	public void shouldHaveWaterReturnTrueWhenDisagreeablenessIsLow() {
		int inputThirst = 50;
		int inputHunger = 10;
		VirtualPet underTest = new VirtualPet(null, inputHunger, inputThirst, 0, 0);
		boolean status = underTest.water();
		Assert.assertTrue(status);
	}
}
