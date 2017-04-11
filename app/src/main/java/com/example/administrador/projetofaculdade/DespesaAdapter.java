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


    //@Override
    public View getview(int position, View contentView, ViewGroup parent) {
        View localView = contentView;
        if (localView == null) {
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            localView = inflater.inflate(layout, null);

        }

        Despesa despesa = despesas.get(position);
        if (despesa != null) {
            TextView textID = (TextView) localView.findViewById(R.id.textID);
            TextView textNome = (TextView) localView.findViewById(R.id.textNome);
            TextView textTotal_fatura = (TextView) localView.findViewById(R.id.textTotal_fatura);
            TextView textValor_pagar = (TextView) localView.findViewById(R.id.textValor_pagar);
            TextView textData_vencer = (TextView) localView.findViewById(R.id.textData_vencer);
            if (textID != null) {
                textID.setText(String.valueOf(despesa.getID()));
            }
            if (textNome != null) {
                textNome.setText(despesa.getNome());
            }
            if (textTotal_fatura != null) {
                textTotal_fatura.setText(String.valueOf(despesa.getTotal_fatura()));
            }
            if (textValor_pagar != null) {
                textValor_pagar.setText(String.valueOf(despesa.getValor_pagar()));
            }
            if (textData_vencer != null) {
                textData_vencer.setText(String.valueOf(despesa.getData_vencer()));
            }
        }

    return localView;
    }
}