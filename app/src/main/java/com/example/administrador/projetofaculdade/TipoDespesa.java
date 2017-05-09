package com.example.administrador.projetofaculdade;

/**
 * Created by Lab. Desenvolvimento on 20/04/2017.
 */

public class TipoDespesa {

    public int             idTipoDespesa;
    private String          nmTipoDespesa;



    public TipoDespesa(int idTipoDespesa, String nmTipoDespesa) {
        this.idTipoDespesa = idTipoDespesa;
        this.nmTipoDespesa = nmTipoDespesa;


    }



    public TipoDespesa(){

    }

    public int getIdTipoDespesa() {
        return idTipoDespesa;
    }

    public void setIDTipoDespesa(int idTipoDespesa) {
        this.idTipoDespesa = idTipoDespesa;
    }

    public String getNmTipoDespesa() {
        return nmTipoDespesa;
    }

    public void setNmTipoDespesa(String nmTipoDespesa) {
        this.nmTipoDespesa = nmTipoDespesa;
    }


}
