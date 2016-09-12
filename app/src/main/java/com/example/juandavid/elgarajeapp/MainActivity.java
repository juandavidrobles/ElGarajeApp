package com.example.juandavid.elgarajeapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    String User, Email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Bundle extras=getIntent().getExtras();
        User=extras.getString("User");
        Email=extras.getString("Email");

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        switch (id){
            case R.id.mMiPerfil:
                Intent intent=new Intent(this,MiPerfilActivity.class);
                //startActivityForResult(intent,1234);
                intent.putExtra("User",User);
                intent.putExtra("Email",Email);
                startActivity(intent);
                finish();
                break;
            case R.id.mPrincipal:
                break;
        }

        return super.onOptionsItemSelected(item);
    }

}
