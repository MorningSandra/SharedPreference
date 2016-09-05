package cn.edu.bistu.cs.se.sharedpreference;

import android.content.SharedPreferences;
import android.icu.text.SimpleDateFormat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.Date;

public class MainActivity extends AppCompatActivity {

    //SharedPreferences文件名
    private final static String SharedPreferencesFileName="config";

    //键
    private final static String Key_SNumber="SNumber";//用户名
    private final static String Key_SName="SName";//登录时间
    private final static String Key_SAge="SAge";

    SharedPreferences preferences;
    SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //获得SharedPreferences实例
        preferences=getSharedPreferences(SharedPreferencesFileName, MODE_PRIVATE);
        editor=preferences.edit();

        Button btnWrite=(Button)findViewById(R.id.ButtonWrite);
        Button btnRead=(Button)findViewById(R.id.ButtonRead);
        btnWrite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //写入键值对
                editor.putString(Key_SNumber, "2014011244");
                editor.putString(Key_SName, "张三");
                editor.putInt(Key_SAge, 20);

                //提交修改，此处换成commit()也可以
                editor.apply();
            }
        });

        btnRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String strUserName = preferences.getString(Key_SName, null);
                String strUserSNumber = preferences.getString(Key_SNumber, null);
                int UserSage = preferences.getInt(Key_SAge,0);
                if (strUserName != null)
                    Toast.makeText(MainActivity.this, "用户名:" + strUserName + "\n学号:" + strUserSNumber +"\n年龄:"+UserSage, Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(MainActivity.this, "无数据", Toast.LENGTH_LONG).show();
            }
        });
    }
}
