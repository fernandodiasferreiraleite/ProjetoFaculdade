package com.example.administrador.projetofaculdade;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.io.Writer;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static android.R.attr.format;


/**
 * Created by Lab. Desenvolvimento on 03/04/2017.
 */

public class Util {
    public static String webToString(InputStream inputStream) {

        InputStream localStream = inputStream;
        String localString = "";
        Writer writer = new StringWriter();
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(localStream, "UTF-8"));
            String line = reader.readLine();
            while (line != null) {
                writer.write(line);
                line = reader.readLine();
            }
            localString = writer.toString();
            writer.close();
            reader.close();
            localStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return localString;
    }

    public static String convertDespesatoJSON(Despesa despesa) {
        JSONObject mainObject = new JSONObject();
        try {
            mainObject.put("nomeDespesa", despesa.getNomeDespesa());
            mainObject.put("dataPagamento", despesa.getDataPagamento());
            mainObject.put("desconto", despesa.getDesconto());
            mainObject.put("idDespesa", despesa.getIdDespesa());
            mainObject.put("idPessoa", despesa.getIdPessoa());
            mainObject.put("idTipoDespesa", despesa.getIdTipoDespesa());
            mainObject.put("valor", despesa.getValor());
            return mainObject.toString();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }


    public static List<Despesa> convertJSONtoDespesa(String jsonFile) {

        //SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

        List<Despesa> despesas = new ArrayList<>();
        try {
            JSONArray mainObject = new JSONArray(jsonFile);

            for (int i = 0; i < mainObject.length(); i++) {

                Despesa novoDespesa = new Despesa();
                JSONObject localObj = mainObject.getJSONObject(i);

                int id = localObj.getInt("idDespesa");

                String despesa = localObj.getString("nomeDespesa");

                float valor = Float.parseFloat(localObj.getString("valor"));

                String dataPagamento = localObj.getString("dataPagamento");

                float desconto = Float.parseFloat(localObj.getString("desconto"));

                int idTipoDespesa = localObj.getInt("idTipoDespesa");

                int idPessoa = localObj.getInt("idPessoa");

                novoDespesa.setIdDespesa(id);

                novoDespesa.setNomeDespesa(despesa);

                novoDespesa.setValor(valor);

                novoDespesa.setDataPagamento(dataPagamento);

                novoDespesa.setDesconto(desconto);

                novoDespesa.setIdTipoDespesa(idTipoDespesa);

                novoDespesa.setIdPessoa(idPessoa);

                despesas.add(novoDespesa);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return despesas;
    }

    public static String getStatusFromJSOM(String json) {
        try {
            return new JSONObject(json).getString("status");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }
}