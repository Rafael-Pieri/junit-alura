package br.com.alura.leapyear;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import br.com.alura.leapyear.LeapYear;

public class LeapYearTest {

	@Test
	public void shouldBeLeapYearMultipleOf4() {
		LeapYear year = new LeapYear();
		assertEquals(true, year.isLeapYear(2016));
	}

	@Test
	public void shouldBeLeapYearMultipleOf400() {
		LeapYear year = new LeapYear();
		assertEquals(true, year.isLeapYear(2400));
	}

	@Test
	public void shouldNotBeLeapYear() {
		LeapYear year = new LeapYear();
		assertEquals(false, year.isLeapYear(2015));
	}

	@Test
	public void shouldNotBeLeapYearMultipleOf100() {
		LeapYear year = new LeapYear();
		assertEquals(false, year.isLeapYear(2200));
	}

}
