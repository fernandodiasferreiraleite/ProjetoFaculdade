package com.example.administrador.projetofaculdade;

import java.util.Date;

/**
 * Created by Lab. Desenvolvimento on 20/04/2017.
 */

public class Pessoa {
    public int idPessoa;
    public String nome;
    public Date data_nascimento;
    public char sexo;


    public Pessoa(){}

    public int getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(int idPessoa) {
        this.idPessoa = idPessoa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getData_nascimento() {
        return data_nascimento;
    }

    public void setData_nascimento(Date data_nascimento) {
        this.data_nascimento = data_nascimento;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public Pessoa(int idPessoa, String nome, Date data_nascimento, char sexo){
        this.data_nascimento=data_nascimento;
        this.idPessoa=idPessoa;
        this.nome=nome;
        this.sexo=sexo;
    }






}
