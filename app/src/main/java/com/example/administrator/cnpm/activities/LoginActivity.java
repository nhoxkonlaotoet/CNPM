package com.example.administrator.cnpm.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.administrator.cnpm.BL.BLLogin;
import com.example.administrator.cnpm.R;

public class LoginActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_login);

        Button btn =(Button) findViewById(R.id.btnLogin);




        btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                BLLogin db = new BLLogin();
                String userid = ((EditText)findViewById(R.id.txtUser)).getText().toString();
                String password =((EditText)findViewById(R.id.txtPassword)).getText().toString();
                Boolean kq = db.Login(userid,password);
               Toast.makeText(LoginActivity.this,kq?"Đăng nhập thành công":"Đăng nhập thất bại", Toast.LENGTH_SHORT).show();
                if(!kq) return;


                Intent intent = new Intent(LoginActivity.this,MainActivity.class);
                intent.putExtra("user",userid );
                startActivity(intent);
                finish();
            }
        });
    }

}
