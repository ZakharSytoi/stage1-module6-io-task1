package com.epam.mjc.io;

import java.io.File;
import java.io.IOException;


public class FileReader {

    public Profile getDataFromFile(File file) {
        java.io.FileReader inputStream;
        StringBuilder tmpText = new StringBuilder();
        Profile result = new Profile();
        try {
            inputStream = new java.io.FileReader(file);
            int c;
            while ((c = inputStream.read()) != -1) {
                tmpText.append((char) c);
            }
            String textFinal = String.valueOf(tmpText);
            result.setName(textFinal.split("\n")[0].split(": ")[1]);
            result.setAge(Integer.parseInt(textFinal.split("\n")[1].split(": ")[1]));
            result.setEmail(textFinal.split("\n")[2].split(": ")[1]);
            result.setPhone(Long.parseLong(textFinal.split("\n")[3].split(": ")[1]));

            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}
