package org.mudrud.classes;

import org.mudrud.interfaces.EncoderInterface;
import org.mudrud.interfaces.FileServiceInterface;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Application {
    private static final FileServiceInterface fileService =  new FileService();
    public static void main(String[] args) {
        runner();
        }
        private static void encode(String fileName){
            List<String> firstText = new ArrayList<>(Application.fileService.read("src/main/resources/" + fileName));
            EncoderInterface encoder = new CeaserCipher();
            List<String> secondText = new ArrayList<>();
            firstText.forEach(s -> secondText.add(encoder.encode(s, 36)));
            Application.fileService.write("src/main/resources/decoding_text.txt", secondText, Mode.REWRITE);
        }
        private static void decode(){
            List<String> firstText = new ArrayList<>(Application.fileService.read("src/main/resources/decoding_text.txt"));
            EncoderInterface encoder = new CeaserCipher();
            List<String> secondText = new ArrayList<>();
            firstText.forEach(s -> secondText.add(encoder.decode(s, 36)));
            Application.fileService.write("src/main/resources/decoding_text.txt", secondText, Mode.REWRITE);
        }

        private static void runner(){
            System.out.println("Running Application");
            System.out.println("Enter your choice: encode or decode");
            Scanner scanner = new Scanner(System.in);
            String choice = scanner.nextLine();
            switch (choice){
                case "encode":{
                    System.out.println("Enter the file name");
                    String fileName = scanner.nextLine();
                    encode(fileName);
                    System.out.println("File successfully encoded");
                    break;
                }
                case "decode":{
                    decode();
                    System.out.println("File successfully decoded");
                    break;
                }
                default:{
                    System.out.println("Invalid choice");
                }
            }
        }

}