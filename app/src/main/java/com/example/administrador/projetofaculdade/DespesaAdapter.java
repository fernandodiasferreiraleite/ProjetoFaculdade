package com.example.administrador.projetofaculdade;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;



public class DespesaAdapter extends ArrayAdapter<Despesa>{
    private List<Despesa> despesas;

    private int layout;



    public DespesaAdapter(Context context, int resource, List<Despesa>despesas){
        super(context, resource,despesas);
        this.despesas=despesas;
        layout=resource;
    }


    @Override
    public View getView(int position, View contentView, ViewGroup parent) {
        View localView = contentView;
        if (localView == null) {
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            localView = inflater.inflate(layout, null);

        }

        Despesa despesa = despesas.get(position);

        if (despesa != null) {
            TextView textID_Despesa = (TextView) localView.findViewById(R.id.textID_Despesa);
            TextView textNome_despesa = (TextView) localView.findViewById(R.id.textNome_despesa);
            TextView textValor = (TextView) localView.findViewById(R.id.textValor);
            TextView textData_pagamento = (TextView) localView.findViewById(R.id.textData_pagamento);
            TextView textDesconto = (TextView) localView.findViewById(R.id.textDesconto);
            TextView textID_Tipo_despesa = (TextView) localView.findViewById(R.id.textID_Tipo_despesa);
            TextView textID_Usuario = (TextView) localView.findViewById(R.id.textID_Usuario);
            if (textID_Despesa != null) {
                textID_Despesa.setText(String.valueOf(despesa.getID_Despesa()));
            }
            if (textNome_despesa != null) {
                textNome_despesa.setText(String.valueOf(despesa.getNome_despesa()));          }
            if (textValor != null) {
                textValor.setText(String.valueOf(despesa.getValor()));
            }
            if (textData_pagamento != null) {
                textData_pagamento.setText(String.valueOf(despesa.getData_pagamento()));
            }
            if (textDesconto != null) {
                textDesconto.setText(String.valueOf(despesa.getDesconto()));
            }

            if (textID_Tipo_despesa != null) {
                textID_Tipo_despesa.setText(String.valueOf(despesa.getID_Tipo_despesa()));
            }
            if (textID_Usuario != null) {
                textID_Usuario.setText(String.valueOf(despesa.getID_Usuario()));
            }


        }

    return localView;
    }
}