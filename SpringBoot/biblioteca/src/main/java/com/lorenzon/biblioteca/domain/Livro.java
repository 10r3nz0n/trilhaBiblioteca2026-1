package com.lorenzon.biblioteca;

import java.io.Serializable;

public class Livro implements Serializable {

    private static final long serialVersionUID = 1L;

    // private final int ESTOQUE = 1;
    private String isbn;
    private String titulo;
    private String autor;
    private boolean disponivel;

    public Livro(String isbn, String titulo, String autor) {
        // PREENCER: Ajustar a classe com métodos get e set e arrumar o construtor
        setIsbn(isbn);
        setTitulo(titulo);
        setAutor(autor);
        setDisponivel(true); // Livro criado inicia disponível
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public String getIsbn() {
        return isbn;
    }

    private void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    private void setAutor(String autor) {
        this.autor = autor;
    }

    private void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    // PREENCER: Fazer override de toString para ter um retorno válido de dados como
    // String do livro

    /*
     * @Override
     * public Livro clone() {
     * try {
     * return (Livro) super.clone();
     * } catch (CloneNotSupportedException e) {
     * return new Livro(this.isbn, this.titulo, this.autor);
     * }
     * }
     */
    // Ainda cedo pra fazer assim

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    public Livro clonarLivro() {

        Livro clone;
        clone = new Livro(this.getIsbn(), this.getTitulo() + "- Clone", this.getAutor());
        return (clone);
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    @Override
    public String toString() {
        return "ISBN: " + isbn + " | Título: " + titulo + " | Autor: " + autor +
                " | " + (disponivel ? "Disponível" : "Emprestado");
    }

}