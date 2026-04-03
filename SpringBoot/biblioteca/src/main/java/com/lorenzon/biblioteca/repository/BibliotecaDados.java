package com.lorenzon.biblioteca;

import java.io.Serializable;
import java.util.ArrayList;

public class BibliotecaDados implements Serializable {
    private static final long serialVersionUID = 1L;

    private ArrayList<Livro> acervoLivros;
    private ArrayList<Pessoa> alunos;
    private ArrayList<Emprestimo> emprestimos;

    public BibliotecaDados() {
        this.acervoLivros = new ArrayList<Livro>();
        this.alunos = new ArrayList<Pessoa>();
        this.emprestimos = new ArrayList<Emprestimo>();
    }

    public ArrayList<Livro> getAcervoLivros() {
        return acervoLivros;
    }

    public void setAcervoLivros(ArrayList<Livro> acervoLivros) {
        this.acervoLivros = acervoLivros;
    }

    public ArrayList<Pessoa> getAlunos() {
        return alunos;
    }

    public void setAlunos(ArrayList<Pessoa> alunos) {
        this.alunos = alunos;
    }

    public ArrayList<Emprestimo> getEmprestimos() {
        return emprestimos;
    }

    public void setEmprestimos(ArrayList<Emprestimo> emprestimos) {
        this.emprestimos = emprestimos;
    }
}
