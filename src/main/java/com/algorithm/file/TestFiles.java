package com.algorithm.file;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 * Files Paths工具类
 */
public class TestFiles {
    public static void main(String[] args) throws IOException {
        String filePath = "D:\\Code\\java\\Arithmetic\\algorithm\\src\\main\\java\\com\\algorithm\\file\\t.txt";
        List<String> list = Files.readAllLines(Paths.get(filePath));
        for (String line : list) {
            System.out.println(line);
        }
    }
}
