package com.example.alice.filestoreinfo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.example.alice.service.LoginService;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private EditText etUser;
    private EditText etPass;
    private CheckBox cbSave;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etUser = findViewById(R.id.etUser);
        etPass = findViewById(R.id.etPass);
        cbSave = findViewById(R.id.cbSave);
    }
    public void loginClick(View view) {
        String user = etUser.getText().toString().trim();
        String pass = etPass.getText().toString().trim();
        if (TextUtils.isEmpty(user) || TextUtils.isEmpty(pass)) {
            Toast.makeText(this, "用户名或密码不能为空！", Toast.LENGTH_SHORT).show();
            return;
        } else {
            if (cbSave.isChecked()) {
                Log.i(TAG, "需要保存用户名和密码");
                boolean result = LoginService.saveUserInfo(user, pass);
                if (result) {
                    Toast.makeText(this,
                            "保存用户信息成功...", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "保存用户信息失败...", Toast.LENGTH_SHORT).show();
                }
            }
            if ("aaa".equals(user) && "123".equals(pass)) {
                Toast.makeText(this, "登录成功...", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "登录失败...", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
