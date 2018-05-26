package br.com.alura.palindrome;

public class Palindrome {

    public boolean isPalindrome(String phrase) {
        String filteredPhrase = phrase.toUpperCase().replace(" ", "").replace("-", "");

        for (int i = 0; i < filteredPhrase.length(); i++) {
            int otherSide = filteredPhrase.length() - 1 - i;

            if (filteredPhrase.charAt(i) != filteredPhrase.charAt(otherSide)) {
                return false;
            }
        }

        return true;
    }
}