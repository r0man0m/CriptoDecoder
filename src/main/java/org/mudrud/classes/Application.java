package org.mudrud.classes;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        FileService fileService = new FileService();
        List<String> list = fileService.read("src/main/resources/text.txt");
        System.out.println(list);
        fileService.write("src/main/resources/decoding_text.txt", list, Mode.WRITE);
        }

}