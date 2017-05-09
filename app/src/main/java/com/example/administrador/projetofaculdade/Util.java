package com.example.administrador.projetofaculdade;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.io.Writer;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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

        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

        List<Despesa> despesas = new ArrayList<>();
        try {
            JSONArray mainObject = new JSONArray(jsonFile);

            for(int i = 0; i < mainObject.length(); i++){

                Despesa novoDespesa = new Despesa();

                JSONObject localObj = mainObject.getJSONObject(i);

                int IdDespesa = localObj.getInt("IdDespesa");

                String nomeDespesa = localObj.getString("nomeDespesa");

                float valor = Float.parseFloat(localObj.getString("valor"));

                Date dataPagamento = formato.parse("descontoPagamento");

                float desconto = Float.parseFloat(localObj.getString("desconto"));

                int IdTipoDespesa = localObj.getInt("IdTipoDespesa");

                int IdPessoa = localObj.getInt("IdPessoa");

                novoDespesa.setIdDespesa(IdDespesa);

                novoDespesa.setNomeDespesa(nomeDespesa);

                novoDespesa.setValor(valor);

                novoDespesa.setDataPagamento(dataPagamento);

                novoDespesa.setDesconto(desconto);

                novoDespesa.setIdTipoDespesa(IdTipoDespesa);

                novoDespesa.setIDPessoa(IdDespsesa);

                despesas.add(novoDespesa);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return despesas;
    }
}