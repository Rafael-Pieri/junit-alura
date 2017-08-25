package br.com.alura.leapyear;

public class LeapYear {
	
	public boolean isLeapYear(int leapYear){
		
		if (leapYear % 400 == 0){
			return true;
		}
		
		if (leapYear % 100 == 0){
			return false;
		}
		
		if (leapYear % 4 == 0){
			return true;
		}
		
		return false;
	}

}
