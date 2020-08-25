package com.musicoariel4.formularioactividades;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.textfield.TextInputEditText;
import java.util.Calendar;


public class MainActivity extends AppCompatActivity {
    public static final int TEXT_REQUEST = 1; // código de solicitud
    private TextInputEditText tvNombre;
    private TextInputEditText tvEmail;
    private TextInputEditText tvTelefono;
    private TextInputEditText tvDescripcion;
    private DatePicker picker;
    private String rtaFecha;
    private Button btnGet;
    private Button miboton1;
    private String tvNombreConta;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvNombre = (TextInputEditText) findViewById(R.id.tvNombre);
        tvEmail = (TextInputEditText) findViewById(R.id.tvEmail);
        tvTelefono = (TextInputEditText) findViewById(R.id.tvTelefono);
        tvDescripcion = (TextInputEditText) findViewById(R.id.tvDescripcion);
        picker = (DatePicker) findViewById(R.id.datePicker1);
        Button miBoton1 = (Button) findViewById(R.id.miboton1);
        Button btnGet = (Button) findViewById(R.id.btnget);
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == TEXT_REQUEST) {
            if (resultCode == RESULT_OK) {
                String replynombre = data.getStringExtra(DatosIngresados.EXTRA_REPLY);
                String replyfecha = data.getStringExtra(DatosIngresados.EXTRA_REPLY2);
                String replytelefono = data.getStringExtra(DatosIngresados.EXTRA_REPLY3);
                String replyEmail = data.getStringExtra(DatosIngresados.EXTRA_REPLY4);
                String replyDescription = data.getStringExtra(DatosIngresados.EXTRA_REPLY5);
                tvNombre.setText(replynombre);
                tvTelefono.setText(replytelefono);
                tvEmail.setText(replyEmail);
                tvDescripcion.setText(replyDescription);
            }
        }
    }


    public void siguiente(View view) {
        Intent intent = new Intent(MainActivity.this, DatosIngresados.class);
        // Log.d(LOG_TAG, "Button clicked!");
        String mesNombre = tvNombre.getText().toString();
        String mesEmail = tvEmail.getText().toString();
        String mesTelefono = tvTelefono.getText().toString();
        String mesDescripcion = tvDescripcion.getText().toString();
        intent.putExtra(getResources().getString(R.string.pnombre), mesNombre);
        intent.putExtra("fechaContacto", rtaFecha);
        intent.putExtra("telefonoContacto", mesTelefono);
        intent.putExtra("emailContacto", mesEmail);
        intent.putExtra("descripContacto", mesDescripcion);
        startActivityForResult(intent, TEXT_REQUEST); //envio de intent con codigo de solicitud

    }

    public void btnGetPicker(View v) {
        rtaFecha = " " + picker.getDayOfMonth() + "/" + (picker.getMonth() + 1) + "/" + picker.getYear();

    }

    public void resetDate(View v){

        Calendar now = Calendar.getInstance();
        this.picker.updateDate(now.get(now.YEAR), now.get(now.MONTH), now.get(now.DAY_OF_MONTH));
    }

}