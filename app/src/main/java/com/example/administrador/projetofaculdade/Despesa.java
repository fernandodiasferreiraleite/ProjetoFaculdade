package com.example.administrador.projetofaculdade;

import java.util.Date;





public class Despesa {
    private int IdDespesa;
    private String nomeDespesa;
    private float valor;
    private Date dataPagamento;
    private float desconto;
    public TipoDespesa idTipoDespesa;
    public Pessoa idPessoa;


    public Despesa(int ID_Despesa, String nomeDespesa, float valor,Date dataPagamento, float desconto, TipoDespesa IdTipoDespesa, Pessoa idPessoa) {
        this.IdDespesa = IdDespesa;
        this.nomeDespesa = nomeDespesa;
        this.valor = valor;
        this.dataPagamento = dataPagamento;
        this.desconto = desconto;

        this.idTipoDespesa = idTipoDespesa;

        this.idPessoa = idPessoa;

    }

    public int getIdDespesa() {
        return IdDespesa;
    }

    public void setIdDespesa(int idDespesa) {
        IdDespesa = idDespesa;
    }

    public String getNomeDespesa() {
        return nomeDespesa;
    }

    public void setNomeDespesa(String nomeDespesa) {
        this.nomeDespesa = nomeDespesa;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public Date getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(Date dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public float getDesconto() {
        return desconto;
    }

    public void setDesconto(float desconto) {
        this.desconto = desconto;
    }

    public TipoDespesa getIdTipoDespesa() {
        return idTipoDespesa;
    }

    public void setIdTipoDespesa(TipoDespesa idTipoDespesa) {
        this.idTipoDespesa = idTipoDespesa;
    }

    public Pessoa getIdPessoa() {
        return idPessoa;
    }

    public void setIDPessoa(Pessoa idPessoa) {
        this.idPessoa = idPessoa;
    }

    public Despesa() {

    }


}

