/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.model;

/**
 *
 * @author mac
 */


import java.io.Serializable;

import java.io.Serializable;

public class Aluno implements Comparable<Aluno>, Serializable{
    private String nome;
    private String telefone;


    public Aluno(String pNome, String pTelefone){
        this.nome = pNome;
        this.telefone = pTelefone;
    }


    public String getNome(){
        return this.nome;
    }

    public String getTelefone(){
        return this.telefone;
    }

    @Override
    public String toString() {
        return "" + this.nome
                + ","+ this.telefone;
    }

    public int compareTo(Aluno o) {
        return nome.compareTo(o.nome);
    }
}  
