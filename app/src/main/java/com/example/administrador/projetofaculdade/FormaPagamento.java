package com.example.administrador.projetofaculdade;

/**
 * Created by Lab. Desenvolvimento on 20/04/2017.
 */

public class FormaPagamento {

    private int idFormaPagamento;
    private String descPagamento;

    public FormaPagamento(){}

    public FormaPagamento(int idFormaPagamento,String descPagamento){

        this.descPagamento=descPagamento;
        this.idFormaPagamento=idFormaPagamento;
    }



    public int getIdFormaPagamento() {
        return idFormaPagamento;
    }

    public void setIdFormaPagamento(int idFormaPagamento) {
        this.idFormaPagamento = idFormaPagamento;
    }

    public String getDescPagamento() {
        return descPagamento;
    }

    public void setDescPagamento(String descPagamento) {
        this.descPagamento = descPagamento;
    }





}
