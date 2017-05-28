package com.example.administrador.projetofaculdade;

import java.util.Date;

public class Despesa {
    private int IdDespesa;
    private String nomeDespesa;
    private float valor;
    private Date dataPagamento;
    private Float desconto;
    public int idTipoDespesa;
    public int idPessoa;

    public Despesa() {
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

    public Float getDesconto() {
        return desconto;
    }

    public int getIdTipoDespesa() {
        return idTipoDespesa;
    }

    public void setIdTipoDespesa(int idTipoDespesa) {
        this.idTipoDespesa = idTipoDespesa;
    }

    public int getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(int idPessoa) {
        this.idPessoa = idPessoa;
    }

    public void setDesconto(float desconto) {
        this.desconto = desconto;
    }


    public Despesa(int IdDespesa, String nomeDespesa, float valor, Date dataPagamento, Float desconto, int idTipoDespesa, int idPessoa) {
        this.IdDespesa = IdDespesa;
        this.nomeDespesa = nomeDespesa;
        this.valor = valor;
        this.dataPagamento = dataPagamento;
        this.desconto = desconto;
        this.idTipoDespesa = idTipoDespesa;
        this.idPessoa = idPessoa;

    }


}

