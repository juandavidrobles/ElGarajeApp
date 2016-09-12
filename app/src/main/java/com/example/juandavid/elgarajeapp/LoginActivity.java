package com.example.juandavid.elgarajeapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    Button bRegistrarse, bAceptar;
    EditText eUser, ePassword;
    String User="", Password="", Email;
    Bundle extras;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        /*if (getIntent().hasExtra("User") && getIntent().hasExtra("Email")){
            Bundle extras=getIntent().getExtras();

            User=extras.getString("User");
            Password=extras.getString("Password");
            Email=extras.getString("Email");
        }*/

        eUser=(EditText) findViewById(R.id.eUser);
        ePassword=(EditText) findViewById(R.id.ePassword);

        bRegistrarse=(Button) findViewById(R.id.bRegistrarse);

        bAceptar=(Button) findViewById(R.id.bAceptar);

        //bRegistrarse.setOnClickListener(this);
        //bAceptar.setOnClickListener(this);

        /*bRegistrarse.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent=new Intent(getApplicationContext(),RegistroActivity.class);
                startActivityForResult(intent,1234);
            }
        });

        bAceptar.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                if (getIntent().hasExtra("User") && getIntent().hasExtra("Password")){
                    if (User.equals(eUser.getText().toString()) && Password.equals(ePassword.getText().toString())){
                        Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                        intent.putExtra("User",User);
                        intent.putExtra("Email",Email);
                        startActivity(intent);
                    }

                } else {
                    Toast.makeText(getBaseContext(),"Usuario o contraseña incorrectos",Toast.LENGTH_LONG).show();
                }

            }
        });*/

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode==1234 && resultCode==RESULT_OK){
            extras=data.getExtras();

            User=extras.getString("User");
            Password=extras.getString("Password");
            Email=extras.getString("Email");
        }
    }

    public void clickAceptar(View view){
        //Si EditText user y password no están vacios
        //if (!eUser.getText().toString().equals("") && !ePassword.getText().toString().equals("")){
            //Si EditText user y password son iguales a los obtenidos por RegistroActivity
        if (User.equals("") || Password.equals("")){
            Toast.makeText(getBaseContext(),"Usuario o contraseña incorrectos",Toast.LENGTH_LONG).show();
        } else {
            if (User.equals(eUser.getText().toString()) && Password.equals(ePassword.getText().toString())){
                Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                intent.putExtra("User",User);
                //intent.putExtra("Password", Password);
                intent.putExtra("Email", Email);
                startActivity(intent);
                finish();
            } else {
                Toast.makeText(getBaseContext(),"Usuario o contraseña incorrectos",Toast.LENGTH_LONG).show();
            }
        }

            /*if (User.equals(eUser.getText().toString()) && Password.equals(ePassword.getText().toString())){
                //
                if (eUser.getText().toString().equals("") || ePassword.getText().toString().equals("")){
                    Toast.makeText(getBaseContext(),"Ingrese Usuario y Password para acceder",Toast.LENGTH_LONG).show();
                }else{
                    if (User.equals(eUser.getText().toString()) && Password.equals(ePassword.getText().toString())){
                        Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                        intent.putExtra("User",User);
                        intent.putExtra("Email",Email);
                        startActivity(intent);
                    }
                }

            } else {
                Toast.makeText(getBaseContext(),"Usuario o contraseña incorrectos",Toast.LENGTH_LONG).show();
            }*/
        /*} else {
            Toast.makeText(getBaseContext(),"Ingrese Usuario y Password para acceder",Toast.LENGTH_LONG).show();
        }*/

    }

    public void clickRegistrarse(View view){
        Intent intent=new Intent(getApplicationContext(),RegistroActivity.class);
        startActivityForResult(intent,1234);
    }

}
