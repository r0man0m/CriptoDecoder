package org.mudrud.classes;

public  class Alphabet {
    private final static char[] symbols = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm',
    'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
    private static Alphabet alphabet;

    private Alphabet(){
    }
    public static Alphabet getAlphabet(){
        if(alphabet == null){
            alphabet = new Alphabet();
        }
        return  alphabet;
    }
    public char[] getSymbols(){
        return symbols;
    }

}
