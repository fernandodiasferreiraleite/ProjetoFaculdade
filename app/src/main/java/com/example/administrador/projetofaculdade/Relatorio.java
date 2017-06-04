package com.example.administrador.projetofaculdade;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Environment;

public class Relatorio extends AsyncTask<String, String, String> {

    Context ctx;
    ProgressDialog loadingDialog;

    public Relatorio(Context ctx) {
        this.ctx = ctx;
    }

    @Override
    protected void onPreExecute() {
        loadingDialog = new ProgressDialog(ctx);
        loadingDialog.setTitle("Sistema");
        loadingDialog.setMessage("Baixando arquivo");
        loadingDialog.setCancelable(false);
        loadingDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        loadingDialog.setMax(100);
        loadingDialog.show();
    }

    @Override
    protected String doInBackground(String... params) {
        String PATH = Environment.getExternalStorageDirectory().getAbsolutePath() + "/Pdfs/";
        String SITE = "http://www.site.com.br";
        String arquivoNome = params[0];

        try{
            URL url = new URL(SITE + "/" + arquivoNome);
            URLConnection connection = url.openConnection();
            connection.connect();
            int fileLength = connection.getContentLength();

            InputStream input = new BufferedInputStream(url.openStream());

            String FilePath = PATH + "/" + arquivoNome;

            File file = new File(PATH);
            file.mkdirs();

            OutputStream output = new FileOutputStream(FilePath);

            byte data[] = new byte[1024];
            long total = 0;
            int count;

            while ((count = input.read(data)) != -1) {
                total += count;
                loadingDialog.setProgress((int)total * 100 / fileLength);
                output.write(data, 0, count);
            }

            output.flush();
            output.close();
            input.close();

            return FilePath;
        }
        catch(Exception e){ }

        return "";
    }
    @Override
    protected void onPostExecute(String result) {

        //RESULT CONTEM O CAMINHO LOCAL DO ARQUIVO
        super.onPostExecute(result);
        loadingDialog.dismiss();
    }
}
