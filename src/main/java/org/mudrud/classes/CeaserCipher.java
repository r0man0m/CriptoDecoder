package org.mudrud.classes;

import org.mudrud.interfaces.EncoderInterface;

public class CeaserCipher implements EncoderInterface {
    private String encodedText = new String();
    @Override
    public String encode(String plainText, int key) {
        char[] charArray = plainText.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            charArray[i] = (char)(charArray[i] + key % 32);
        }
        for(char c : charArray) {
            encodedText += c;
        }
        return encodedText;
    }

    @Override
    public String decode(String cipherText, int key) {
        char[] charArray = cipherText.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            charArray[i] = (char)(charArray[i] - key % 32);
        }
        for(char c : charArray) {
            encodedText += c;
        }
        return encodedText;
    }
}
