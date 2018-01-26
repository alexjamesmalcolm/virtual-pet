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
}
