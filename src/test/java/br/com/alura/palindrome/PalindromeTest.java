package br.com.alura.palindrome;

import static org.junit.Assert.assertTrue;
import org.junit.Test;

import br.com.alura.palindrome.Palindrome;

public class PalindromeTest {
	
	@Test
	public void verifyIfItsPalindrome(){
		
		Palindrome phrase = new Palindrome();
		
		boolean result = phrase.isPalindrome("Socorram-me subi no onibus em Marrocos");
		
		assertTrue(result);
	}

}
