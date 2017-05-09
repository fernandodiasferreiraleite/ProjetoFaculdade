package com.example.administrador.projetofaculdade;

import android.app.Activity;
import android.os.Bundle;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.DataOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;

public class InsertDespesa extends Activity {
        private EditText editNomeDespesa;
        private EditText editvalor;
        private EditText editdataPagamento;
        private EditText editdesconto;
        private EditText editidTipoDespesa;
        private EditText editidPessoa;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_insert_despesa);
            editNomeDespesa = (EditText) findViewById(R.id.editNomeClube);
            editvalor = (EditText) findViewById(R.id.editvalor);
            editdataPagamento = (EditText) findViewById(R.id.editdataPagamento);
            editdesconto=(EditText)findViewById(R.id.editdesconto);
            editidTipoDespesa=(EditText)findViewById(R.id.idTipoDespesa);
            editidPessoa=(EditText)findViewById(R.id.idPessoa);

        }

        public void cadastrarDespesa(View v){
            Despesa despesa= new Despesa();
            despesa.setNomeDespesa(editNomeDespesa.getText().toString());
            despesa.setValor(Integer.parseInt(editvalor.getText().toString()));



            despesa.setDataPagamento(editdataPagamento.getText().toString());








            despesa.setDesconto(Integer.parseInt(editdesconto.getText().toString()));
            despesa.setIdPessoa (Str(editidPessoa.getText().toString()));
            new UploadToMyAPI().execute(despesa);

        }

        private class UploadToMyAPI extends AsyncTask<Despesa, Void, String> {

            boolean isConnected = false;
            ProgressDialog progress;
            int serverResponseCode;
            String serverResponseMessage;
            @Override
            protected void onPreExecute(){

                ConnectivityManager cm =
                        (ConnectivityManager)InsertDespesa.this.getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);

                NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
                isConnected = activeNetwork != null &&
                        activeNetwork.isConnectedOrConnecting();

                if(!isConnected) {
                    Toast.makeText(InsertDespesa.this, "Verifique a conexão com a internet...", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            protected String doInBackground(Despesa... params) {
                HttpURLConnection urlConnection = null;
                try {//arrrumar urlm para conecçao
                    URL url = new URL("http://gerenciamentofinanceiro.esy.es/Insert.php");
                    urlConnection = (HttpURLConnection) url.openConnection();
                    urlConnection.setRequestMethod("POST");
                    urlConnection.setRequestProperty("Content-type", "application/json");
                    urlConnection.setDoInput(true);
                    urlConnection.setDoOutput(true);

                    DataOutputStream outputStream = new DataOutputStream(urlConnection.getOutputStream());

                    String result = Util.convertDespesatoJSON(params[0]);
                    outputStream.writeBytes(result);

                    serverResponseCode = urlConnection.getResponseCode();
                    serverResponseMessage = Util.webToString(urlConnection.getInputStream());

                    outputStream.flush();
                    outputStream.close();

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
                if(isConnected)
                {
                    Intent listaDespesa = null;
                    if(Util.getStatusFromJSOM(serverResponseMessage).equals("1")) {
                        Toast.makeText(InsertDespesa.this, "Despesa registrado no Sistema!", Toast.LENGTH_SHORT).show();
                        listaDespesa = new Intent(InsertDespesa.this, ListDespesaActivity.class);
                        startActivity(listaDespesa);
                    }else{
                        Toast.makeText(InsertDespesa.this, "Falha ao cadastrar o despesa.", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        }
    }