package com.freeman.intents.intents;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class FormActivity extends AppCompatActivity implements View.OnClickListener {

    private static final int REQUEST_CODE_FORM_ACTIVITY_SECOND = 2;
    private static final int REQUEST_CODE_MAIN_ACTIVITY = 1;
    private EditText inputName;
    private Button nextBtn, backBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);
        inputName = (EditText) findViewById(R.id.user_name);
        nextBtn = (Button) findViewById(R.id.next_btn);
        nextBtn.setOnClickListener(this);
        backBtn = (Button) findViewById(R.id.back_btn);
        backBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.next_btn){
            Intent intent = new Intent(this, FormActivitySecond.class);
            intent.putExtra("NAME", String.valueOf(inputName.getText()));
            startActivityForResult(intent,REQUEST_CODE_FORM_ACTIVITY_SECOND);
        }
        else if (v.getId() == R.id.back_btn){
            finish();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK && requestCode == REQUEST_CODE_FORM_ACTIVITY_SECOND){
            if (data != null){
                setResult(RESULT_OK, data);
                finish();
            }
        }
    }
}
