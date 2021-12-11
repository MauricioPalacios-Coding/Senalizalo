package com.example.sealizalo;
//IMPORTACION DE LIBRERIAS
import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //DECLARACION DE VARIABLES
    private EditText traducir;
    private Button boton;
    private ImageView LSM;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //VINCULACION DE VARIBLES CON LA VISTA XML
        traducir = (EditText) findViewById(R.id.entrada);
        boton = (Button) findViewById(R.id.boton);
        //LSM.setImageResource(R.drawable.);
        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //CREAMOS UN OBJETO DE TIPO EDIT TEXT
                traducir = (EditText) findViewById(R.id.entrada);
                //CREAMOS UN OBJETO IMAGE VIEW Y LO RELACIONAMOS A LA PANTALLA
                ImageView LSM = (ImageView) findViewById(R.id.imagen);
                //OBTENEMOS EL TEXTO QUE TIENE NUESTRA CAJA DE TEXTO
                String palabra = String.valueOf(traducir.getText());
                //PASAMOS TODAS LAS LETRAS A MINUSCULAS
                palabra = palabra.toLowerCase();
                //CAMBIAMOS LA IMAGEN SEGUN SEA LA PALABRA INGRESADA
                //POR EL USUARIO
                if (palabra.equals("bien")){
                    LSM.setImageResource(R.drawable.bien);
                }
                else if (palabra.equals("no")){
                    LSM.setImageResource(R.drawable.no);
                }
                else if (palabra.equals("gracias")){
                    LSM.setImageResource(R.drawable.gracias);
                }
                else if (palabra.equals("mal")){
                    LSM.setImageResource(R.drawable.mal);
                }
                else if (palabra.equals("no entiendo")){
                    LSM.setImageResource(R.drawable.no_entiendo);
                }
                else if (palabra.equals("nunca")){
                    LSM.setImageResource(R.drawable.nunca);
                }
                else if (palabra.equals("si")){
                    LSM.setImageResource(R.drawable.si);
                }
                else if (palabra.equals("puedo")){
                    LSM.setImageResource(R.drawable.puedo);
                }
                else if (palabra.equals("por favor")){
                    LSM.setImageResource(R.drawable.por_favor);
                }
                else if (palabra.equals("permiso")){
                    LSM.setImageResource(R.drawable.permiso);
                }
                else{
                    LSM.setImageResource(R.drawable.logo);
                    Toast.makeText(getApplicationContext(),"Aun no contamos con esa traducción", Toast.LENGTH_LONG).show();
                }
                cerrar_teclado();
            }
        });
    }
    //FUNCION QUE PERMITE CERRAR EL TECLADO
    //PARA PODER VISUALIZAR CORRECTAMENTE EL RESULTADO
    private void cerrar_teclado() {
        View view = this.getCurrentFocus();
        if (view != null) {
            InputMethodManager teclado = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
            teclado.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }
    //INFLAMOS NUESTRO MENU
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.overflow,menu);
        return true;
    }
    //LOGICA DEL MENU
    public boolean onOptionsItemSelected(MenuItem item){
        //OBTENEMOS EL ID DEL ITEM SELECCIONADO POR EL USUARIO
        int id = item.getItemId();
        //ABRIMOS LA ACTIVIDAD SEGUN EL ITEM SELECCIONADO
        if(id == R.id.mn_inicio){
            //ABRIMOS MAIN ACTIVITY
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }
        if (id == R.id.mn_acerca_de){
            //ABRIMOS ACERCA DE
            Intent intent = new Intent(this, AcercaDe.class);
            startActivity(intent);
        }
        else if(id == R.id.mn_conoce_mas){
            //ABRIMOS CONOCE MAS
            Intent intent = new Intent(this, ConoceMas.class);
            startActivity(intent);
        }
        else if(id == R.id.mn_somos){
            //ABRIMOS QUIENES SOMOS
            Intent intent = new Intent(this, Somos.class);
            startActivity(intent);
        }
        else if(id == R.id.mn_donaciones){
            //ABRIMOS DONACIONES
            Intent intent = new Intent(this, Donaciones.class);
            startActivity(intent);
        }
        //REGRESAMOS LA OPCCION SELECCIONADA
        return super.onOptionsItemSelected(item);
    }

}