package com.prajan.peertechz.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.prajan.peertechz.R;

public class SignupActivity extends AppCompatActivity {
    LinearLayout ll_arrowicon;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        ll_arrowicon=(LinearLayout)findViewById(R.id.arrowicon_ll);

        ll_arrowicon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(SignupActivity.this,OTPActivity.class);
                startActivity(intent);
            }
        });
    }
}
