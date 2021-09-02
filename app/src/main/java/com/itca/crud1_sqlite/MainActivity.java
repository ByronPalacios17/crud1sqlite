package com.itca.crud1_sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText etcodigo, etdescripcion, etPrecio;
    private Button btnAlta, btnConsultarCodigo, btnConsultaDescripcion, btnEliminar, btnModificar, btnSalir, btnNuevo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etcodigo = (EditText) findViewById(R.id.etcodigo);
        etdescripcion = (EditText) findViewById(R.id.etdescripcion);
        etPrecio = (EditText) findViewById(R.id.etPrecio);

        btnAlta = (Button) findViewById(R.id.btnAlta);
        btnConsultarCodigo = (Button) findViewById(R.id.btnConsultaDescripcion);
        btnConsultaDescripcion = (Button) findViewById(R.id.btnConsultaDescripcion);
        btnEliminar = (Button) findViewById(R.id.btnEliminar);
        btnModificar = (Button) findViewById(R.id.btnModificar);
        btnSalir = (Button) findViewById(R.id.btnSalir);
        btnNuevo = (Button) findViewById(R.id.btnNuevo);

        btnAlta.setOnClickListener(this);
        btnConsultarCodigo.setOnClickListener(this);
        btnConsultaDescripcion.setOnClickListener(this);
        btnEliminar.setOnClickListener(this);
        btnModificar.setOnClickListener(this);
        btnSalir.setOnClickListener(this);
        btnNuevo.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {



        switch (view.getId()){
            case R.id.btnAlta:
            //Toast.makeText(this, "Has hecho clic en el boton alta", Toast.LENGTH_SHORT).show();

                String codigo = etcodigo.getText().toString();
                String descripcion = etdescripcion.getText().toString();
                String precio = etPrecio.getText().toString();

                if(codigo.isEmpty()){
                    etcodigo.setError("Campo Obligatorio");
                }else if (descripcion.isEmpty()){
                    etdescripcion.setError("Campo Obligatorio");
                }else if(precio.isEmpty()){
                    etPrecio.setError("Campo Obligatorio");
                }else{
                    Toast.makeText(this, "Has Superado la Validacion", Toast.LENGTH_SHORT).show();
                }

            break;

            case R.id.btnConsultarCodigo:
                Toast.makeText(this, "Has hecho clic en el boton alta", Toast.LENGTH_SHORT).show();
                break;

            case R.id.btnConsultaDescripcion:
                Toast.makeText(this, "Has hecho clic en el boton alta", Toast.LENGTH_SHORT).show();
                break;

            case R.id.btnEliminar:
                Toast.makeText(this, "Has hecho clic en el boton alta", Toast.LENGTH_SHORT).show();
                break;


            case R.id.btnModificar:
                Toast.makeText(this, "Has hecho clic en el boton alta", Toast.LENGTH_SHORT).show();
                break;

            case R.id.btnSalir:
                Toast.makeText(this, "Has hecho clic en el boton alta", Toast.LENGTH_SHORT).show();
                break;


            case R.id.btnNuevo:
                Toast.makeText(this, "Has hecho clic en el boton alta", Toast.LENGTH_SHORT).show();
                break;


        }
    }
}