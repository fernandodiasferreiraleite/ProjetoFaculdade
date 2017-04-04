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
import java.util.Date;
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

    public static List<Despesa> convertJSONtoDespesa(String jsonFile){
        List<Despesa> despesas = new ArrayList<>();
        try {
            JSONArray mainObject = new JSONArray(jsonFile);

            for(int i = 0; i < mainObject.length(); i++){
                Despesa novoDespesa = new Despesa();
                JSONObject localObj = mainObject.getJSONObject(i);
                long id = localObj.getLong("id_despesa");
                String nome = localObj.getString("nome_despesa");
                Double total_fatura = localObj.getDouble("total_fatura");
                Double valor_pagar = localObj.getDouble("valor_pagar");
                Date data_vencer = localObj.getDate("data_vencer");
                novoDespesa.setID(id);
                novoDespesa.setNome(nome);
                novoDespesa.setData_vencer(data_vencer);
                novoDespesa.setValor_pagar(valor_pagar);
                novoDespesa.setTotal_fatura(total_fatura);
                despesas.add(novoDespesa);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return despesas;
    }
}
