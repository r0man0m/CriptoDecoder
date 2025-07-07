package org.mudrud.interfaces;

import org.mudrud.classes.Mode;

import java.util.List;

public interface FileServiceInterface {
    List<String> read(String filename);
    void write(String filename, List<String> symbols, Mode mode);
}
