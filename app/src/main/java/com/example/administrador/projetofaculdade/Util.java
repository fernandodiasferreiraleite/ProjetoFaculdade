package com.example.administrador.projetofaculdade;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;


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

    public static List<Despesa> convertJSONtoClube(String jsonFile){
        List<Despesa> despesas = new ArrayList<>();
        try {
            JSONArray mainObject = new JSONArray(jsonFile);

            for(int i = 0; i < mainObject.length(); i++){
                Despesa novoDespesa = new Despesa();
                JSONObject localObj = mainObject.getJSONObject(i);
                long id = localObj.getLong("id_despesa");
                String nome = localObj.getString("nome_despesa");
                double total_fatura = localObj.getDouble("total_fatura");
                double valor_pagar = localObj.getDouble("valor_pagar");
                String Data_vencer = localObj.getString("data_vencer");
                novoDespesa.setID(id);
                novoDespesa.setNome(nome);
                novoDespesa.setTotal_fatura(total_fatura);
                novoDespesa.setValor_pagar(valor_pagar);
                despesas.add(novoDespesa);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return despesas;
    }
}
