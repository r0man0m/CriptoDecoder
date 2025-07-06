package org.mudrud.classes;

public class Application {
    public static void main(String[] args) {

        char[] symbols = Alphabet.getAlphabet().getSymbols();
        for (char symbol : symbols) {
            System.out.print(symbol);

        }

    }
}