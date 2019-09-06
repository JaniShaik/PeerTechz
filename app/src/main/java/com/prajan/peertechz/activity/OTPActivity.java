package com.prajan.peertechz.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;

import com.alimuzaffar.lib.pin.PinEntryEditText;
import com.prajan.peertechz.R;

public class OTPActivity extends AppCompatActivity {
    SmsReceiver broadcastReceiver;
    PinEntryEditText pinEntry;
    Button btn_verify;
    String msg;
    ProgressBar progressBar;

    LinearLayout ll_arrowicon;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp);
        //this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
        broadcastReceiver = new SmsReceiver();
        //new ChangeStatusBarColor(VerificationOTP.this);

        pinEntry = findViewById(R.id.txt_pin_entry);
        InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.showSoftInput(pinEntry, InputMethodManager.SHOW_IMPLICIT);
        ll_arrowicon=(LinearLayout)findViewById(R.id.otparrowicon_ll);

        ll_arrowicon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(OTPActivity.this,Dashboard.class);
                startActivity(intent);
            }
        });
       /* btn_verify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               *//* Intent intent=new Intent(VerificationOTP.this,SubmitDetails.class);
                startActivity(intent);*//*
                if (pinEntry != null) {
                    pinEntry.setAnimateText(false);
                    //  pinEntry.setTypeface(ResourcesCompat.getFont(this, R.font.charmonman_regular));
                    pinEntry.setOnPinEnteredListener(new PinEntryEditText.OnPinEnteredListener() {
                        @Override
                        public void onPinEntered(CharSequence str) {
                            if (str.toString().equals("")) {
                               // OTPdata(pinEntry.getText().toString(),userid);
                               *//* Intent intent=new Intent(VerificationOTP.this,SubmitDetails.class);
                                startActivity(intent);
                                Toast.makeText(VerificationOTP.this, "SUCCESS", Toast.LENGTH_SHORT).show();*//*
                            } else {
                                pinEntry.setError(true);
                                *//*Intent intent=new Intent(VerificationOTP.this,SubmitDetails.class);
                                startActivity(intent);*//*
                                Toast.makeText(OTPActivity.this, "FAIL", Toast.LENGTH_SHORT).show();
                       *//* pinEntry.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                pinEntry.setText(null);
                            }
                        }, 1000);*//*
                            }
                        }
                    });
                }

            }
        });
*/
    }
   /* private void OTPdata(final String userid,final String otp_st) {
        progressBar = new ProgressBar(VerificationOTP.this);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, Config.VerifyOtp,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.e("Response", response);
                        progressBar.setVisibility(View.INVISIBLE);
                        try {

                            JSONObject json = new JSONObject(response);
                            Log.e("Json object ", " output--->" + json);
                            int aa = json.getInt("status");
                            String empid = json.getString("user_id");
                            if (aa == 1) {
                                msg = json.getString("otp-verified-success-message");
                                final Dialog dialog = new Dialog(VerificationOTP.this);
                                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                                dialog.setContentView(R.layout.alert_error);
                                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
                                TextView text = dialog.findViewById(R.id.alert_msg);
                                text.setText(msg);
                                Button dialogButton = dialog.findViewById(R.id.btn_ok);
                                dialogButton.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        // Toast.makeText(SignupActivity.this, msg, Toast.LENGTH_SHORT).show();

                                        Intent i = new Intent(VerificationOTP.this, VerificationOTP.class);
                                        startActivity(i);
                                    }
                                });
                                dialog.show();


                            }  else if (json.has("status")) {
                                int aa1 = json.getInt("status");

                                if (aa1 == 0) {
                                    if (json.has("error-message")) {
                                        msg = json.getString("error-message");
                                        final Dialog dialog = new Dialog(VerificationOTP.this);
                                        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                                        dialog.setContentView(R.layout.alert_error);
                                        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
                                        TextView text = dialog.findViewById(R.id.alert_msg);
                                        text.setText(msg);
                                        Button dialogButton = dialog.findViewById(R.id.btn_ok);
                                        dialogButton.setOnClickListener(new View.OnClickListener() {
                                            @Override
                                            public void onClick(View v) {

                                                Intent i = new Intent(VerificationOTP.this, SigninActivity.class);
                                                startActivity(i);
                                                //  Toast.makeText(SignupActivity.this, msg, Toast.LENGTH_SHORT).show();
                                                dialog.dismiss();
                                            }
                                        });
                                        dialog.show();
                                        Toast.makeText(VerificationOTP.this, msg, Toast.LENGTH_SHORT).show();

                                    }*//*else {
                                        msg = json.getString("error-10-digits");
                                        final Dialog dialog = new Dialog(SignupActivity.this);
                                        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                                        dialog.setContentView(R.layout.alert_error);
                                        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
                                        TextView text = dialog.findViewById(R.id.alert_msg);
                                        text.setText(msg);
                                        Button dialogButton = dialog.findViewById(R.id.btn_ok);
                                        dialogButton.setOnClickListener(new View.OnClickListener() {
                                            @Override
                                            public void onClick(View v) {
                                                dialog.dismiss();
                                            }
                                        });
                                        dialog.show();
                                        Toast.makeText(SignupActivity.this, msg, Toast.LENGTH_SHORT).show();

                                    }*//*

                                }
                            }
                        } catch (JSONException e) {

                            e.printStackTrace();
                            Toast.makeText(VerificationOTP.this, "error--->", Toast.LENGTH_SHORT).show();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                        Toast.makeText(VerificationOTP.this, "error", Toast.LENGTH_SHORT).show();
                        progressBar.setVisibility(View.INVISIBLE);
                    }
                }
        ) {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<String, String>();
                params.put("user_id", userid);
                params.put("otp_verification_token", otp_st);
                return params;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(VerificationOTP.this);
        requestQueue.add(stringRequest);
    }*/
    /*@Override
    protected void onStart() {
        super.onStart();
        IntentFilter intentFilter=new IntentFilter("android.provider.Telephony.SMS_RECEIVED");
        registerReceiver(broadcastReceiver,intentFilter);
        LocalBroadcastManager.getInstance(this).registerReceiver(receiver,new IntentFilter("otp"));
    }

    @Override
    protected void onStop() {
        super.onStop();
        unregisterReceiver(broadcastReceiver);
        LocalBroadcastManager.getInstance(this).unregisterReceiver(receiver);
    }
    private BroadcastReceiver receiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            if ("otp".equalsIgnoreCase(intent.getAction())){
                final String message = intent.getStringExtra("message");
                Pattern pattern = Pattern.compile("[0-9]{1,6}");
                Matcher matcher = pattern.matcher(message);
                if (matcher.find())
                {
                    pinEntry.setText(matcher.group(0));
                }
            }
        }
    };*/
}