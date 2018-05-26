package br.com.alura.mathematics;

public class CrazyMathematics {

    public int crazyAccount(int number) {
        if (number > 30) {
            return number * 4;
        } else if (number > 10) {
            return number * 3;
        } else {
            return number * 2;
        }
    }
}