package com.musicoariel4.formularioactividades;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
public class DatosIngresados extends AppCompatActivity {
    public static final String EXTRA_REPLY = "com.musicoariel4.identidadpersonalizada.DatosIngredos.extra.REPLY";
    public static final String EXTRA_REPLY2 = "com.musicoariel4.identidadpersonalizada.DatosIngredos.extra.REPLY2";
    public static final String EXTRA_REPLY3 = "com.musicoariel4.identidadpersonalizada.DatosIngredos.extra.REPLY3";
    public static final String EXTRA_REPLY4 = "com.musicoariel4.identidadpersonalizada.DatosIngredos.extra.REPLY4";
    public static final String EXTRA_REPLY5 = "com.musicoariel4.identidadpersonalizada.DatosIngredos.extra.REPLY5";
    private TextView txtNombre;
    private TextView txtFecha;
    private TextView txtTelefono;
    private TextView txtEmail;
    private TextView txtDescrip;

    private String tvNombreConta;
    private String tvFechaConta;
    private String tvTelefConta;
    private String tvEmailConta;
    private String tvDescripConta;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos_ingresados);

        TextView txtNombre = findViewById(R.id.txtNombre);
        TextView txtFecha = findViewById(R.id.txtFecha);
        TextView txtTelefono = findViewById(R.id.txtTelefono);
        TextView txtEmail = findViewById(R.id.txtEmail);
        TextView txtDescrip = findViewById(R.id.txtDescrip);

        Bundle bundle = getIntent().getExtras();
        tvNombreConta = bundle.getString(getResources().getString(R.string.pnombre));
        tvFechaConta = bundle.getString("fechaContacto");
        tvTelefConta = bundle.getString("telefonoContacto");
        tvEmailConta = bundle.getString("emailContacto");
        tvDescripConta = bundle.getString("descripContacto");

        txtNombre.setText(tvNombreConta);
        txtFecha.setText(tvFechaConta);
        txtTelefono.setText(tvTelefConta);
        txtEmail.setText(tvEmailConta);
        txtDescrip.setText(tvDescripConta);

    }

    public void replycar(View view) {


        String replynombre = tvNombreConta;
        String replyfecha = tvFechaConta;
        String replytele = tvTelefConta;
        String replyEmail = tvEmailConta;
        String replyDescrip = tvDescripConta;
        Intent replyIntent = new Intent();
        replyIntent.putExtra(EXTRA_REPLY, replynombre);
        replyIntent.putExtra(EXTRA_REPLY2, replyfecha);
        replyIntent.putExtra(EXTRA_REPLY3, replytele);
        replyIntent.putExtra(EXTRA_REPLY4, replyEmail);
        replyIntent.putExtra(EXTRA_REPLY5, replyDescrip);
        setResult(RESULT_OK, replyIntent);
        finish();
    }

    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            Intent intent = new Intent(DatosIngresados.this, MainActivity.class);
            startActivity(intent);
        }

        return super.onKeyDown(keyCode, event);
    }

}