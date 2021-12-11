package com.example.sealizalo;
//IMPORTANCION DE LIBRERIAS
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ProgressBar;
//LIBRERIA DE TERCERO PARA EL USO DE IMAGENES GIF DENTRO DE ANDROID STUDIO
import com.felipecsl.gifimageview.library.GifImageView;
import org.apache.commons.io.IOUtils;
import java.io.IOException;
import java.io.InputStream;

public class SplashSecreen extends AppCompatActivity {
    //DECLARACION DE VARIABLES
    private GifImageView gifImageView;
    private ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //ENLAZAMOS LAS VARIABLES CON NUESTRA VISTA XML
        setContentView(R.layout.activity_splash_secreen);
        gifImageView = (GifImageView)findViewById(R.id.img_splash);
        progressBar = (ProgressBar)findViewById(R.id.progressBar);
        progressBar.setVisibility(progressBar.VISIBLE);

        //CARGAMOS NUESTRA IMAGEN GIF
        //USAMOS UN TRY CATCH
        try{
            InputStream inputStream = getAssets().open("Hola_Splash.gif");
            byte[] bytes = IOUtils.toByteArray(inputStream);
            gifImageView.setBytes(bytes);
            gifImageView.startAnimation();
        }
        catch (IOException ex){

        }
        //CREAMOS UN METODO PARA QUE PERMITA CARGAR
        //LA SIGUIENTE ACTIVITY DESPUES DE 4 SEGUNDOS
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //CARGAMOS LA INTENCION INDICANDO QUE ABRA EL MAINACTIVITY
                SplashSecreen.this.startActivity(new Intent(SplashSecreen.this,MainActivity.class));
                //FINALIZAMOS ESTA ACTIVITY
                SplashSecreen.this.finish();
          //CONTABILIZADOR DE TIEMPO
            }
        },4000);
    }
}