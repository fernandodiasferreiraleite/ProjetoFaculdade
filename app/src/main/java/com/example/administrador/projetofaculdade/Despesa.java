package com.example.administrador.projetofaculdade;

import java.util.Date;

public class Despesa {
    private int idDespesa;
    private int idTipoDespesa;
    private String nomeDespesa;
    private String dataPagamento;
    private float desconto;
    private float valor;
    private int idPessoa;

    public Despesa(){

    }


    public Despesa(int idDespesa,int idTipoDespesa,String nomeDespesa,String dataPagamento,float desconto,float valor,int idPessoa){

        this.idDespesa=idDespesa;
        this.idTipoDespesa=idTipoDespesa;
        this.nomeDespesa=nomeDespesa;
        this.dataPagamento=dataPagamento;
        this.desconto=desconto;
        this.valor=valor;
        this.idPessoa=idPessoa;


    }

    public int getIdDespesa() {
        return idDespesa;
    }

    public void setIdDespesa(int idDespesa) {
        this.idDespesa = idDespesa;
    }

    public int getIdTipoDespesa() {
        return idTipoDespesa;
    }

    public void setIdTipoDespesa(int idTipoDespesa) {
        this.idTipoDespesa = idTipoDespesa;
    }

    public String getNomeDespesa() {
        return nomeDespesa;
    }

    public void setNomeDespesa(String nomeDespesa) {
        this.nomeDespesa = nomeDespesa;
    }

    public String getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(String dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public float getDesconto() {
        return desconto;
    }

    public void setDesconto(float desconto) {
        this.desconto = desconto;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public int getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(int idPessoa) {
        this.idPessoa = idPessoa;
    }
}