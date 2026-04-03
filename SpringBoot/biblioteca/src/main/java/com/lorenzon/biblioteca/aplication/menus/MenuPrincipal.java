package com.lorenzon.biblioteca.menus;

import java.util.ArrayList;
import com.lorenzon.biblioteca.utilitarios.*; //corrigido

public class MenuPrincipal {

    public static int exibir() {
        ArrayList<String> opcoes = new ArrayList<String>();
        opcoes.add("Listar acervo");
        opcoes.add("Emprestimo");
        opcoes.add("Devolucao");
        opcoes.add("Localizar livro");
        opcoes.add("Localizar aluno");
        opcoes.add("Cadastrar livro");
        opcoes.add("Cadastrar aluno");
        opcoes.add("Listar emprestimos");
        opcoes.add("Listar alunos");
        opcoes.add("Sair");

        Menu menu = new Menu("Menu de opcoes", opcoes);
        return menu.exibir();
    }
}
