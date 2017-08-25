package br.com.alura.mathematics;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import br.com.alura.mathematics.CrazyMathematics;

public class CrazyMathematicsTest {

	@Test
	public void shouldMultiplyBy2() {
		CrazyMathematics value = new CrazyMathematics();
		assertEquals(1 * 2, value.crazyAccount(1));
	}

	@Test
	public void shouldMutiplyBy3() {
		CrazyMathematics value = new CrazyMathematics();
		assertEquals(11 * 3, value.crazyAccount(11));
	}

	@Test
	public void shouldMultiplyBy4() {
		CrazyMathematics value = new CrazyMathematics();
		assertEquals(31 * 4, value.crazyAccount(31));
	}

}
