package com.example.administrador.projetofaculdade;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.widget.Toast;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import static com.example.administrador.projetofaculdade.R.styleable.FloatingActionButton;
import static com.example.administrador.projetofaculdade.R.styleable.Toolbar;


/**
 * Created by Lab. Desenvolvimento on 03/04/2017.
 */

public class ListDespesaActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_despesa);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent cadastroDespesa = new Intent (ListDespesaActivity.this,InsertDespesa.class);
                startActivity(cadastroDespesa);
              //  Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                       // .setAction("Action", null).show();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
loadDespesas();
    }

    public void loadDespesas(){
        if(isConnected())
            new DownloadFromMyAPI().execute();
        else
            Toast.makeText(this, "Verifique a conexão com a internet...", Toast.LENGTH_SHORT).show();
    }

    private boolean isConnected(){
        ConnectivityManager cm =
                (ConnectivityManager) getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        return activeNetwork != null &&
                activeNetwork.isConnectedOrConnecting();
    }

    private class DownloadFromMyAPI extends AsyncTask<Void, Void, String> {
        ProgressDialog progress;
        @Override
        protected void onPreExecute(){

            progress = new ProgressDialog(ListDespesaActivity.this);
            progress.setMessage("Aguarde o Download dos Dados");
            progress.setProgressStyle(ProgressDialog.STYLE_SPINNER);
            progress.setProgress(0);
            progress.show();

        }
        @Override
        protected String doInBackground(Void... params) {
            HttpURLConnection urlConnection = null;

            try {
                URL url = new URL("http://www.gerenciamentofinanceiro.esy.es/select.php");
                urlConnection = (HttpURLConnection) url.openConnection();
                urlConnection.setReadTimeout(20000);
                urlConnection.setConnectTimeout(25000);
                urlConnection.setRequestMethod("GET");
                urlConnection.setDoInput(true);
                urlConnection.setDoOutput(true);
                int test = urlConnection.getResponseCode();
                String result = Util.webToString(urlConnection.getInputStream());

                return result;
            } catch (Exception e) {
                Log.e("Error", "Error ", e);
                return null;
            } finally{
                if (urlConnection != null) {
                    urlConnection.disconnect();
                }
            }
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
                List<Despesa> despesas = Util.convertJSONtoDespesa(s);
                if(despesas != null){
                    ArrayAdapter<Despesa> despesaAdapter = new DespesaAdapter(ListDespesaActivity.this,R.layout.despesa_item,despesas);
                    ListView listaDespesa = (ListView) findViewById(R.id.listDespesas);
                    listaDespesa.setAdapter(despesaAdapter);
                }
                progress.dismiss();
            }

        }
    }


