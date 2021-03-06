package com.example.administrador.projetofaculdade;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import java.io.DataOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class InsertDespesa extends Activity {
    private EditText editNomeDespesa;
    private EditText editValor;
    private EditText editDataPagamento;
    private EditText editDesconto;
    private EditText editIdTipoDespesa;
    private EditText editIdPessoa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_despesa);

        editNomeDespesa = (EditText) findViewById(R.id.editNomeDespesa);
        editValor = (EditText) findViewById(R.id.editValor);
        editDataPagamento = (EditText) findViewById(R.id.editDataPagamento);
        editDesconto = (EditText) findViewById(R.id.editDesconto);
        editIdTipoDespesa = (EditText) findViewById(R.id.IdTipoDespesa);
        editIdPessoa = (EditText) findViewById(R.id.IdPessoa);

    }


    public void cadastrarDespesa(View v) {
        Despesa despesa = new Despesa();
        despesa.setNomeDespesa(editNomeDespesa.getText().toString());
        despesa.setValor(Integer.parseInt(editValor.getText().toString()));
        despesa.setDataPagamento(editDataPagamento.getText().toString());
        despesa.setDesconto(Integer.parseInt(editDesconto.getText().toString()));
        despesa.setIdPessoa(Integer.parseInt(editIdPessoa.getText().toString()));
        despesa.setIdTipoDespesa(Integer.parseInt(editIdTipoDespesa.getText().toString()));

        if (isConnected())
            new UploadToMyAPI().execute(despesa);
        else
            Toast.makeText(this, "Verifique a conexão com a internet...", Toast.LENGTH_SHORT).show();
    }

    private boolean isConnected() {
        ConnectivityManager cm =
                (ConnectivityManager) getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        return activeNetwork != null &&
                activeNetwork.isConnectedOrConnecting();
    }

    private class UploadToMyAPI extends AsyncTask<Despesa, Void, String> {


        ProgressDialog progress;
        int serverResponseCode;
        String serverResponseMessage;

        @Override
        protected String doInBackground(Despesa... params) {
            HttpURLConnection urlConnection = null;
            try {
                URL url = new URL("http://gerenciamentofinanceiro.esy.es/insert.php");
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
            } finally {
                if (urlConnection != null) {
                    urlConnection.disconnect();
                }
            }
        }


        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            Intent listaDespesa=null;

            if (Util.getStatusFromJSOM(serverResponseMessage).equals("1")) {
                Toast.makeText(InsertDespesa.this, "Despesa registrado no Sistema!", Toast.LENGTH_SHORT).show();
                listaDespesa = new Intent(InsertDespesa.this, ListDespesaActivity.class);
                startActivity(listaDespesa);
            } else {
                Toast.makeText(InsertDespesa.this, "Falha ao cadastrar o despesa.", Toast.LENGTH_SHORT).show();
            }
        }

    }
}








