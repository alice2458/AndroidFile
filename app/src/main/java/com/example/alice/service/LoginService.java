package com.example.alice.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FilterOutputStream;

public class LoginService {
    public static boolean saveUserInfo(String username, String password){
        try{
            File f = new File("data/data/com.example.alice.filestoreinfo/info.txt");
            FileOutputStream fos = new FileOutputStream(f);
            fos.write((username + "##" + password).getBytes());
            fos.close();
            return true;
        }
        catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }
}
