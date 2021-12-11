package com.example.sealizalo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class AcercaDe extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acerca_de);
        getSupportActionBar().setTitle("Acerca de");
    }
    //CREAMOS EL MENU
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.overflow,menu);
        return true;
    }
    //LOGICA DEL MENU
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();
        if(id == R.id.mn_inicio){
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }
        if (id == R.id.mn_acerca_de){
            Intent intent = new Intent(this, AcercaDe.class);
            startActivity(intent);
        }
        else if(id == R.id.mn_conoce_mas){
            Intent intent = new Intent(this, ConoceMas.class);
            startActivity(intent);
        }
        else if(id == R.id.mn_somos){
            Intent intent = new Intent(this, Somos.class);
            startActivity(intent);
        }
        else if(id == R.id.mn_donaciones){
            Intent intent = new Intent(this, Donaciones.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
}