package com.freeman.intents.intents;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView nameTxt, phoneNumberTxt;
    private Button addBtn;
    public static final int REQUEST_CODE_FORM_ACTIVITY = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nameTxt = (TextView) findViewById(R.id.user_name_txt);
        phoneNumberTxt = (TextView) findViewById(R.id.user_phone_txt);
        addBtn = (Button) findViewById(R.id.add_btn);
        addBtn.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.add_btn){
            Intent intent = new Intent(this, FormActivity.class);
            startActivityForResult(intent,REQUEST_CODE_FORM_ACTIVITY);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        Log.d("MY_LOG","MainActivity onActivityResult(): requestCode = " + requestCode + "; resultCode = " + resultCode);
        if (resultCode == RESULT_OK && requestCode == REQUEST_CODE_FORM_ACTIVITY){
            if (data != null){
                nameTxt.setText(data.getExtras().getString("NAME","empty"));
                phoneNumberTxt.setText(data.getExtras().getString("PHONE_NUMBER","empty"));
            }
        }
    }
}
