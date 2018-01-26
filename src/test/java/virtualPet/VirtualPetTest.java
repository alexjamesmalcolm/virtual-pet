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
		Assert.assertEquals(20, waste);;
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
}
