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
}
