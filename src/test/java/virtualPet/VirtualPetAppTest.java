package virtualPet;

import org.junit.Test;
import org.junit.Assert;

public class VirtualPetAppTest {

	@Test
	public void shouldHaveProgressBarReturnEmptyBar() {
		String result = VirtualPetApp.progressBar(0);
		String expected = "░░░░░░░░░░░░░░░░░░░░";
		Assert.assertEquals(expected, result);
	}
}
