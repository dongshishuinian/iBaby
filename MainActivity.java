package com.example.parentalassistant;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);
    }
    public void button_inMain(View button){
        if(button.getId()==R.id.button_notification){
            Intent intent =new Intent(this,SettingsActivity.class);
            startActivity(intent);
        }
        if(button.getId()==R.id.Button_del){
            Intent signinintent = new Intent(this,signin.class);
            startActivity(signinintent);
        }

    }

    public void switchinMain(View Myswitch) {
        if(Myswitch.getId()==R.id.video_switch){
            TextView text=findViewById(R.id.video_text);
            if(text.isEnabled()){
                text.setText("已断开连接");
                text.setEnabled(false);
            }
            else{
                text.setText("设备未连接");
                text.setEnabled(true);
            }

        }
    }
}
