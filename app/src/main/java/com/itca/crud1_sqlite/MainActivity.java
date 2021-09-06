package com.itca.crud1_sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
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

        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "administracion", null, 1);
        ContentValues registro = new ContentValues();
        String cod, descri, pre;
        int cant;
        SQLiteDatabase bd = admin.getWritableDatabase();
        Cursor fila;

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

                cod = etcodigo.getText().toString();
                descri = etdescripcion.getText().toString();
                pre = etPrecio.getText().toString();

                registro.put("codigo", cod);
                registro.put("descripcion", descri);
                registro.put("precio", pre);

                bd.insert("articulos", null, registro);
                bd.close();

                etcodigo.setText("");;
                etdescripcion.setText("");
                etPrecio.setText("");

                Toast.makeText(this, "Se cargaron los datos del articulo", Toast.LENGTH_SHORT).show();


            break;

            case R.id.btnConsultarCodigo:
                //Toast.makeText(this, "Has hecho clic en el boton alta", Toast.LENGTH_SHORT).show();


                cod = etcodigo.toString();
                fila = bd.rawQuery("select descripcion, precio from articulos where codigo=" + cod, null);
                if(fila.moveToFirst()){
                    etdescripcion.setText(fila.getString(0));
                    etPrecio.setText(fila.getString(1));
                }else{
                    Toast.makeText(this, "No existe un archivo con dicho código", Toast.LENGTH_SHORT).show();
                }

                break;

            case R.id.btnConsultaDescripcion:
                //Toast.makeText(this, "Has hecho clic en el boton alta", Toast.LENGTH_SHORT).show();

                descri = etdescripcion.getText().toString();
                fila = bd.rawQuery("select codigo, precio from articulos where descripcion='" + descri +"'", null);
                if (fila.moveToFirst()) {
                    etcodigo.setText(fila.getString(0));
                    etPrecio.setText(fila.getString(1));

                }else{
                    Toast.makeText(this, "No existe un articulo con dicha descripcion", Toast.LENGTH_SHORT).show();
                    bd.close();
                }

                break;

            case R.id.btnEliminar:
                //Toast.makeText(this, "Has hecho clic en el boton alta", Toast.LENGTH_SHORT).show();

                cod = etcodigo.getText().toString();
                cant = bd.delete("articulos", "codigo=" + cod, null);
                bd.close();
                etcodigo.setText("");;
                etdescripcion.setText("");
                etPrecio.setText("");

                if(cant == 1){
                    Toast.makeText(this, "Se borro el articulo con dicho código", Toast.LENGTH_SHORT).show();

                }else{
                    Toast.makeText(this, "No existe un articulo con dicho código", Toast.LENGTH_SHORT).show();
                }

                break;


            case R.id.btnModificar:
                //Toast.makeText(this, "Has hecho clic en el boton alta", Toast.LENGTH_SHORT).show();

                cod = etcodigo.getText().toString();
                descri = etdescripcion.getText().toString();
                pre = etPrecio.getText().toString();

                registro.put("codigo", cod);
                registro.put("descripcion", descri);
                registro.put("precio", pre);

                cant = bd.update("articulos", registro, "codigo=" + cod, null);
                bd.close();

                if(cant == 1){
                    Toast.makeText(this, "se modificaron los datos", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(this, "No existe un articulo con el código ingresado", Toast.LENGTH_SHORT).show();
                }

                break;

            case R.id.btnSalir:
                Toast.makeText(this, "Has hecho clic en el boton salir", Toast.LENGTH_SHORT).show();
                break;


            case R.id.btnNuevo:
                Toast.makeText(this, "Has hecho clic en el boton nuevo", Toast.LENGTH_SHORT).show();
                break;


        }
    }
}