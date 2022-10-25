package com.basejava.webapp;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class MainFile {
    public static void main(String[] args) {
        String filePath = ".\\.gitignore";

        File file = new File(filePath);
        try {
            System.out.println(file.getCanonicalPath());
        } catch (IOException e) {
            throw new RuntimeException("Error", e);
        }

        readFiles("./src/com/basejava/webapp");
        readFiles("./src/com/basejava/webapp/exception");
        readFiles("./src/com/basejava/webapp/model");
        readFiles("./src/com/basejava/webapp/storage");
        readFiles("./src/com/basejava/webapp/util");

        try (FileInputStream fis = new FileInputStream(filePath)) {
            System.out.println(fis.read());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println("----========----");
        getAllFiles("./src/com");
    }

    public static void readFiles(String path){
        File dir = new File(path);
        System.out.println("----" + dir.getName() + "----");
        String[] list = dir.list();
        if (list != null) {
            for (String name : list) {
                System.out.println(name);
            }
        }
    }

    public static void getAllFiles (String path){
        File new_file = new File(path);
        File[] array = new_file.listFiles();
        if (array != null) {
            for (File name : array) {
                if(name.isDirectory()){
                    System.out.println("+++" + name.getName() + "+++");
                    getAllFiles(name.getPath());
                } else {
                    System.out.println(name.getName());
                }
            }
        }
    }
}
