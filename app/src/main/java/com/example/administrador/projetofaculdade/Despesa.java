package com.example.administrador.projetofaculdade;

import java.util.Date;

/**
 * Created by Lab. Desenvolvimento on 03/04/2017.
 */

public class Despesa {
    private Long ID;
    private String nome;
    private Double total_fatura;
    private Double valor_pagar;
    private Date data_vencer ;



public Despesa(Long ID,String nome, double total_fatura, double valor_pagar,Date data_vencer ){
    this.ID = ID;
    this.nome = nome;
    this.total_fatura = total_fatura;
    this.valor_pagar = valor_pagar;
    this.data_vencer = data_vencer;

    }

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getValor_pagar() {
        return valor_pagar;
    }

    public void setValor_pagar(double valor_pagar) {
        this.valor_pagar = valor_pagar;
    }

    public double getTotal_fatura() {
        return total_fatura;
    }

    public void setTotal_fatura(double total_fatura) {
        this.total_fatura = total_fatura;
    }

    public Date getData_vencer() {
        return data_vencer;
    }

    public void setData_vencer(Date data_vencer) {
        this.data_vencer = data_vencer;
    }
}
