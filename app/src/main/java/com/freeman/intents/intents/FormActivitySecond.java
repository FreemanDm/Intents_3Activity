package com.freeman.intents.intents;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class FormActivitySecond extends AppCompatActivity {

    private EditText inputPhoneNumber;
    private Button backBtn, saveBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_second);
        inputPhoneNumber = (EditText) findViewById(R.id.user_phone);
        backBtn = (Button) findViewById(R.id.back_btn_second);
        saveBtn = (Button) findViewById(R.id.save_btn);
        backBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View v){
                finish();
            }
        });
        saveBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent();
                intent.putExtra("NAME", getIntent().getExtras().getString("NAME", "empty"));
                intent.putExtra("PHONE_NUMBER", String.valueOf(inputPhoneNumber.getText()));
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
}





