package com.example.administrador.projetofaculdade;

/**
 * Created by Lab. Desenvolvimento on 20/04/2017.
 */

public class Renda extends  FormaPagamento {
    private String descPagamento;
    private double valor;
    private FormaPagamento idFormaPagamento;
    private Pessoa idPessoa;


    public Renda(){}

    public Renda(String descPagamento,double valor,FormaPagamento idFormaPagamento,Pessoa idPessoa){
        this.descPagamento=descPagamento;
        this.valor=valor;
        this.idFormaPagamento=idFormaPagamento;
        this.idPessoa=idPessoa;
    }


    public String getDescPagamento() {
        return descPagamento;
    }


    public void setDescPagamento(String descPagamento) {
        this.descPagamento = descPagamento;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public FormaPagamento getIFormaPagamento() {
        return idFormaPagamento;
    }

    public void setId(FormaPagamento idFormaPagamento) {
        this.idFormaPagamento = idFormaPagamento;
    }

    public Pessoa getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(Pessoa idPessoa) {
        this.idPessoa = idPessoa;
    }







   }
