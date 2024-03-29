package com.prajan.peertechz.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.prajan.peertechz.R;

public class MainActivity extends AppCompatActivity {
LinearLayout ll_arrowicon;
TextView signuptxt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ll_arrowicon=(LinearLayout)findViewById(R.id.arrowicon_ll);
        signuptxt=(TextView) findViewById(R.id.signuptxt);
        ll_arrowicon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,OTPActivity.class);
                startActivity(intent);
            }
        });
        signuptxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,SignupActivity.class);
                startActivity(intent);
            }
        });
    }
}
