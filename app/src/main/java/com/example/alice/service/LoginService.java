package com.example.alice.service;

import android.content.Context;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class LoginService {
    public static boolean saveUserInfo(Context context,String username, String password){
        try{
            File f = new File(context.getFilesDir(),"infor.txt");
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
    public static Map<String, String> getSaveUserInfo(Context context){
        File file = new File(context.getFilesDir(),"info.txt");
        try {
            FileInputStream fis = new FileInputStream(file);
            BufferedReader br = new BufferedReader(new InputStreamReader(fis));
            String str = br.readLine();
            String[] info = str.split("##");
            Map<String, String> map = new HashMap<>();
            map.put("username", info[0]);
            return map;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
