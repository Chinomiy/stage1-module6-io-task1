package com.epam.mjc.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;


public class FileReader {

    public static Profile getDataFromFile(File file) {
        String nameLine = "";
        String ageLine = "";
        String emailLine = "";
        String phoneLine = "";
        try (BufferedReader bufferedReader = new BufferedReader(new java.io.FileReader(file))) {
            nameLine = bufferedReader.readLine();
            ageLine = bufferedReader.readLine();
            emailLine = bufferedReader.readLine();
            phoneLine = bufferedReader.readLine();
        } catch (IndexOutOfBoundsException | IOException e) {
            throw new RuntimeException(e);
        }
        return new Profile(getProfileValue(nameLine), Integer.parseInt(getProfileValue(ageLine)), getProfileValue(emailLine), Long.parseLong(getProfileValue(phoneLine)));
    }

    public static String getProfileValue(String profileValue) {
        String[] data = profileValue.split(":");
        return data[data.length - 1].trim();
    }
}
