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
            TextView textIdDespesa = (TextView) localView.findViewById(R.id.textID_Despesa);
            TextView textnomeDespesa = (TextView) localView.findViewById(R.id.textNome_despesa);
            TextView textValor = (TextView) localView.findViewById(R.id.textValor);
            TextView textdataPagamento = (TextView) localView.findViewById(R.id.textData_pagamento);
            TextView textDesconto = (TextView) localView.findViewById(R.id.textDesconto);
            TextView textidTipoDespesa = (TextView) localView.findViewById(R.id.textID_Tipo_despesa);
            TextView textidPessoa = (TextView) localView.findViewById(R.id.textID_Usuario);
            if (textidTipoDespesa != null) {
                textidTipoDespesa.setText(String.valueOf(despesa.getIdDespesa()));
            }
            if (textnomeDespesa != null) {
                textnomeDespesa.setText(String.valueOf(despesa.getNomeDespesa()));          }
            if (textValor != null) {
                textValor.setText(String.valueOf(despesa.getValor()));
            }
            if (textdataPagamento != null) {
                textdataPagamento.setText(String.valueOf(despesa.getDataPagamento()));
            }
            if (textDesconto != null) {
                textDesconto.setText(String.valueOf(despesa.getDesconto()));
            }

            if (textidTipoDespesa != null) {
                textidTipoDespesa.setText(String.valueOf(despesa.getIdTipoDespesa()));
            }
            if (textidPessoa != null) {
                textidPessoa.setText(String.valueOf(despesa.getIdPessoa()));
            }


        }

    return localView;
    }
}