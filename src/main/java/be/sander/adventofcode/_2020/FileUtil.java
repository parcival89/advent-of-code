package be.sander.adventofcode._2020;

import be.sander.adventofcode._2020.day1.Puzzle1;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

public class FileUtil {

    public static List<String> readFile(String path){
        try {
            File input = new File(Puzzle1.class.getClassLoader().getResource(path).getFile());
            return Files.readAllLines(input.toPath());
        } catch (IOException e) {
            System.out.println("Could not read file");
            throw new RuntimeException(e);
        }
    }
}
