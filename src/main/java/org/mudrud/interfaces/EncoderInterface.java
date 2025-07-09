package org.mudrud.interfaces;

public interface EncoderInterface {
    String encode(String plainText, int key);
    String decode(String cipherText, int key);
}
