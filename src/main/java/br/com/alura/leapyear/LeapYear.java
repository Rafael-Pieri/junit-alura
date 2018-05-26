package br.com.alura.leapyear;

public class LeapYear {

    public boolean isLeapYear(int leapYear) {
        return leapYear % 400 == 0 || leapYear % 100 != 0 && leapYear % 4 == 0;
    }
}