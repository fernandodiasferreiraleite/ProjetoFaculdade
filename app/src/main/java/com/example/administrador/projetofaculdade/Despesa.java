package com.example.administrador.projetofaculdade;

import java.util.Date;




public class Despesa {
    private Long ID_Despesa;
    private String nome_despesa;
    private String valor;
    private String data_pagamento;
    private String desconto;
    private int ID_Tipo_despesa;
    private int ID_Usuario;


    public Despesa(Long ID_Despesa, String nome_despesa, String valor, String data_pagamento, String desconto, int ID_Tipo_despesa, int ID_Usuario) {
        this.ID_Despesa = ID_Despesa;
        this.nome_despesa = nome_despesa;
        this.valor = valor;
        this.data_pagamento = data_pagamento;
        this.desconto = desconto;
        this.ID_Tipo_despesa = ID_Tipo_despesa;
        this.ID_Usuario = ID_Usuario;

    }

    public Despesa() {

    }

    public Long getID_Despesa() {
        return ID_Despesa;
    }

    public void setID_Despesa(Long ID_Despesa) {
        this.ID_Despesa = ID_Despesa;
    }







    public String getNome_despesa() {
        return nome_despesa;
    }

    public void setNome_despesa(String nome_despesa) {
        this.nome_despesa = nome_despesa;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getData_pagamento() {
        return data_pagamento;
    }

    public void setData_pagamento(String data_pagamento) {
        this.data_pagamento = data_pagamento;
    }

    public String getDesconto() {
        return desconto;
    }

    public void setDesconto(String desconto) {
        this.desconto = desconto;
    }

    public int getID_Tipo_despesa() {
        return ID_Tipo_despesa;
    }

    public void setID_Tipo_despesa(int ID_Tipo_despesa) {
        this.ID_Tipo_despesa = ID_Tipo_despesa;
    }

    public int getID_Usuario() {
        return ID_Usuario;
    }

    public void setID_Usuario(int ID_Usuario) {
        this.ID_Usuario = ID_Usuario;
    }
}

