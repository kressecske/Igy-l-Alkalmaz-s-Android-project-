package com.example.kress_000.bazsigeriapp;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

//TODO:
//FILE OLVASÁS + ÍRÁS
//VAGY BÁRMILYEN MÁSIK "ADATBÁZIS" használata.


public class PiaCalc extends ActionBarActivity{

    private static ArrayList<Pia> piak = new ArrayList<Pia>();
    private Spinner spinner1,spinner2;
    private TextView compareText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pia_calc);
        addListenerOnSpinnerItemSelection();
        Button b = (Button) findViewById(R.id.ment);
        compareText = (TextView) findViewById(R.id.compareText);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText nev = (EditText) findViewById(R.id.nevt);
                EditText ar = (EditText) findViewById(R.id.piaart);
                EditText menny = (EditText) findViewById(R.id.piamennyt);
                EditText tart = (EditText) findViewById(R.id.alkoholtartt);

                Pia hpia = Save(nev,ar,menny,tart);
                piak.add(hpia);

                addItemsOnSpinner();

            }
        });
    }
    public void addListenerOnSpinnerItemSelection() {
        spinner1 = (Spinner) findViewById(R.id.spinner1);
        spinner1.setOnItemSelectedListener(new  OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
                Toast.makeText(parent.getContext(),
                        "Pia hozzáadva : " + parent.getItemAtPosition(pos).toString(),
                        Toast.LENGTH_SHORT).show();
                compare();
            }
            public void onNothingSelected(AdapterView<?> parent){

            }

        });
        spinner2 = (Spinner) findViewById(R.id.spinner2);
        spinner2.setOnItemSelectedListener(new  OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
                Toast.makeText(parent.getContext(),
                        "Pia hozzáadva : " + parent.getItemAtPosition(pos).toString(),
                        Toast.LENGTH_SHORT).show();
                compare();
            }
            public void onNothingSelected(AdapterView<?> parent){

            }

        });
    }

    public void addItemsOnSpinner() {
        spinner1 = (Spinner) findViewById(R.id.spinner1);
        spinner2 = (Spinner) findViewById(R.id.spinner2);
        ArrayList<Pia> list = new ArrayList<Pia>();
        for(Pia p : piak){
            list.add(p);
        }
        ArrayAdapter<Pia> dataAdapter = new ArrayAdapter<Pia>(this,android.R.layout.simple_spinner_item, list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(dataAdapter);
        spinner2.setAdapter(dataAdapter);
    }


    public Pia Save(EditText nev, EditText ar, EditText menny, EditText tart){
        String pnev = nev.getText().toString();
        int arr = Integer.parseInt(ar.getText().toString());
        float mennyy = (float) Integer.parseInt(menny.getText().toString());
        float tartt = (float) Integer.parseInt(tart.getText().toString());
        Pia p = new Pia(pnev,arr,mennyy,tartt);
        return p;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_pia_calc, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void compare(){
        spinner1 = (Spinner) findViewById(R.id.spinner1);
        spinner2 = (Spinner) findViewById(R.id.spinner2);
        compareText = (TextView) findViewById(R.id.compareText);
        Pia pia1 = (Pia) spinner1.getSelectedItem();
        Pia pia2 = (Pia) spinner2.getSelectedItem();
        compareText.setText(
                "Pia1: " + pia1.toString() + ", tisztaszeszára: " + pia1.getTisztaszesz() + "\n" +
                "Pia2: " + pia2.toString() + ", tisztaszeszára: " + pia2.getTisztaszesz() + "\n"
        );
    }
}