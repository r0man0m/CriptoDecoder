package org.mudrud.classes;

import org.mudrud.interfaces.FileServiceInterface;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class FileService implements FileServiceInterface {
    @Override
    public List<String> read(String filename) {
        Path path = Paths.get(filename);
        List<String> symbols = new ArrayList<>();
        try(Stream<String> stream = Files.lines(path)) {
            stream.forEach(symbols::add);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return symbols;
    }

    @Override
    public void write(String filename, List<String> symbols, Mode mode) {
        switch (mode) {
            case WRITE ->  {
                Path path = Paths.get(filename);
                try {
                    Files.write(path, symbols, StandardOpenOption.APPEND);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            case REWRITE ->   {
                Path path = Paths.get(filename);
                try {
                    Files.write(path,symbols);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }

    }
}
