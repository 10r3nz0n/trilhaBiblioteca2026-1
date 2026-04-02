package com.lorenzon.biblioteca; //informar pacote

import java.io.Serializable;
import com.lorenzon.biblioteca.utilitarios.*; //corrigido

public class Pessoa implements Serializable {

    private static final long serialVersionUID = 1L;

    private String matricula;
    private String nome;

    public Pessoa(String nome, String matricula) {
        setNome(nome);
        setMatricula(matricula);
    }

    public void setMatricula(String matricula) {
        if (matricula.isEmpty()) {
            Video.println("Matrícula inválida!");
            System.exit(1);
        } else {
            this.matricula = matricula;
        }
    }

    public void setNome(String nome) {
        if (nome.isEmpty()) {
            Video.println("Nome inválido!");
            System.exit(11);
        } else {
            this.nome = nome;
        }
    }

    public String getMatricula() {
        return matricula;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public String toString() {
        return "Matrícula: " + getMatricula() + " : " + getNome();
    }
}
