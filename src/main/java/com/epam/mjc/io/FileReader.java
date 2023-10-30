package com.epam.mjc.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;


public class FileReader {

    public static Profile getDataFromFile(File file) {
        Profile profile = new Profile();
        try (BufferedReader bufferedReader = new BufferedReader(new java.io.FileReader(file))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] data = line.split(":");
                switch (data[0]) {
                    case "Name":
                        profile.setName(getProfileValue(line));
                        break;
                    case "Age":
                        profile.setAge(Integer.parseInt(getProfileValue(line)));
                        break;
                    case "Email":
                        profile.setEmail(getProfileValue(line));
                        break;
                    case "Phone":
                        profile.setPhone((long) Integer.parseInt(getProfileValue(line)));
                        break;
                }
            }
        } catch (IOException e) {

        }
        return profile;
    }

    public static String getProfileValue(String profileValue) {
        String[] data = profileValue.split(":");
        return data[data.length - 1].trim();
    }
}
