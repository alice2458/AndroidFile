package com.example.alice.service;

import android.content.Context;

import java.io.File;
import java.io.FileOutputStream;

public class LoginService {
    public static boolean saveUserInfo(Context context,String username, String password){
        try{
            File f = new File(context.getCacheDir(),"infor.txt");
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
