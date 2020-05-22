package com.example.parentalassistant;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.EditTextPreference;
import androidx.preference.ListPreference;
import androidx.preference.PreferenceFragmentCompat;

public class SettingsActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings_activity);
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.settings, new SettingsFragment())
                .commit();
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    public void button_insignin(View view) {
        if(view.getId()==R.id.save_setting){
            new SettingsFragment().loadParament();
            Intent mainintent = new Intent(this,MainActivity.class);
            startActivity(mainintent);
        }

    }

    public static class SettingsFragment extends PreferenceFragmentCompat {

        @Override
        public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
            setPreferencesFromResource(R.xml.root_preferences,rootKey);
            loadParament();

        }
        public void loadParament(){//开一个service来工作
            UserInformation information =UserInformation.getInstance_UserInformation();
            EditTextPreference userkey =findPreference("userpassword");
            EditTextPreference username =findPreference("username");
            ListPreference parentsex=findPreference("usersex");
            username.setText(information.username);
            userkey.setText(information.userkey);

        }
    }
    @Override
    public void onStop() {
        super.onStop();



    }
    public void creaTost(){
        AlertDialog.Builder builder = new AlertDialog.Builder(SettingsActivity.this);
        builder.setMessage("确认保存更改?");
        builder.setPositiveButton("确认", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
    }

}