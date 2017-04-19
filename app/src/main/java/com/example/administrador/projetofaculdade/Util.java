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

import static android.R.attr.id;


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
                long ID_Despesa = localObj.getLong("ID_Despesa");
                String nome_despesa = localObj.getString("Nome_despesa");
                String valor = localObj.getString("valor");
                String data_pagamento = localObj.getString("data_pagamento");
                String desconto = localObj.getString("desconto");
                int ID_Tipo_despesa = localObj.getInt("ID_Tipo_despesa");
                int ID_Usuario = localObj.getInt("ID_Usuario");

                novoDespesa.setID_Despesa(ID_Despesa);
                novoDespesa.setNome_despesa(nome_despesa);
                novoDespesa.setValor(valor);
                novoDespesa.setData_pagamento(data_pagamento);
                novoDespesa.setDesconto(desconto);
                novoDespesa.setID_Tipo_despesa(ID_Tipo_despesa);
                novoDespesa.setID_Usuario(ID_Usuario);
                despesas.add(novoDespesa);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return despesas;
    }
}