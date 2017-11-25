package com.example.administrator.cnpm.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

import com.example.administrator.cnpm.R;

public class LoginActivity extends AppCompatActivity {
    CheckBox cbIsCustomer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login);
        cbIsCustomer = (CheckBox) findViewById(R.id.cbIsCustomer);
        Button btn =(Button) findViewById(R.id.btnLogin);
        btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this,MainActivity.class);
                intent.putExtra("isCustomer",cbIsCustomer.isChecked() );
                startActivity(intent);
                finish();
            }
        });
    }
}
