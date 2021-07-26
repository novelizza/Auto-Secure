package com.example.user.auto_secure;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.PowerManager;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import static android.content.Intent.FLAG_ACTIVITY_NEW_TASK;

public class RegisterActivity extends AppCompatActivity {

    private TextView t;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        final EditText no1 = (EditText) findViewById(R.id.et_no1);
        final EditText no2 = (EditText) findViewById(R.id.et_no2);
        final EditText no3 = (EditText) findViewById(R.id.et_no3);
        t = (TextView) findViewById(R.id.test);


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            String packageName = this.getPackageName();
            PowerManager pm = (PowerManager) this.getSystemService(Context.POWER_SERVICE);
            if (!pm.isIgnoringBatteryOptimizations(packageName)) {
                Intent intent = new Intent();
                intent.setAction(android.provider.Settings.ACTION_REQUEST_IGNORE_BATTERY_OPTIMIZATIONS);
                intent.setFlags(FLAG_ACTIVITY_NEW_TASK);
                intent.setData(Uri.parse("package:" + packageName));
                this.startActivity(intent);
            }
        }

        if (Preferences.getLoggedInStatus(getBaseContext())){
            startActivity(new Intent(getBaseContext(),MainActivity.class));
            finish();
        }

        findViewById(R.id.button_save).setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                String nomor1, nomor2, nomor3;
                //String rep1, rep2, rep3;
                nomor1 = no1.getText().toString();
                nomor2 = no2.getText().toString();
                nomor3 = no3.getText().toString();
                //-------------------------
                Preferences.setRegisteredUser1(getBaseContext(),nomor1);
                Preferences.setRegisteredUser2(getBaseContext(),nomor2);
                Preferences.setRegisteredUser3(getBaseContext(),nomor3);
                //-------------------------
                Preferences.setLoggedInUser1(getBaseContext(), Preferences.getRegisteredUser1(getBaseContext()));
                Preferences.setLoggedInUser2(getBaseContext(), Preferences.getRegisteredUser2(getBaseContext()));
                Preferences.setLoggedInUser3(getBaseContext(), Preferences.getRegisteredUser3(getBaseContext()));
                //-------------------------
                Preferences.setLoggedInStatus(getBaseContext(),true);
                startActivity(new Intent(getBaseContext(),MainActivity.class));finish();
            }
        });
    }
}
