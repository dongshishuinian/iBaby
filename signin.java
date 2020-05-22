package com.example.parentalassistant;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.parentalassistant.server.TcpClient;


public class signin extends AppCompatActivity {
    public TcpClient tcp =new TcpClient();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);
    }

    public void button_insignin(View view) {
        int viewid = view.getId();
        EditText signid =findViewById(R.id.useridin);
        EditText signkey =findViewById(R.id.userkeyin);
        UserInformation information = UserInformation.getInstance_UserInformation();
        information.username=signid.getText().toString();
        information.userkey=signkey.getText().toString();
        Bundle signinbundle =new Bundle();
        signinbundle.putString("username",information.username);
        signinbundle.putString("userkey",information.userkey);
        Intent mainintent = new Intent(this,MainActivity.class);
        if(viewid==R.id.butnregi){
            startActivity(mainintent);
        }
        else if(viewid==R.id.butnsignin){//登录
//            tcp.sendSrting("_signinfo:_"+"_username_"+signinbundle.getString("username")+"\0"+
     //               "_userkey_"+signinbundle.getString("userkey")+"\0");
            startActivity(mainintent);
        }
    }



}
