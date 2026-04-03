package com.lorenzon.biblioteca;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import com.lorenzon.biblioteca.utilitarios.*;

public class BibliotecaPersistencia {

    private static final String NOME_ARQUIVO = "biblioteca.dat";

    public static void salvar(BibliotecaSingleton biblioteca) {
        BibliotecaDados dados = new BibliotecaDados();
        dados.setAcervoLivros(biblioteca.getAcervoLivros());
        dados.setAlunos(biblioteca.getAlunos());
        dados.setEmprestimos(biblioteca.getEmprestimos());

        try {
            FileOutputStream arquivo = new FileOutputStream(NOME_ARQUIVO);
            ObjectOutputStream gravador = new ObjectOutputStream(arquivo);
            gravador.writeObject(dados);
            gravador.close();
            arquivo.close();
        } catch (Exception e) {
            Video.exibirMensagemErro("Falha ao salvar os dados da biblioteca!");
        }
    }

    public static boolean carregar(BibliotecaSingleton biblioteca) {
        try {
            FileInputStream arquivo = new FileInputStream(NOME_ARQUIVO);
            ObjectInputStream leitor = new ObjectInputStream(arquivo);
            BibliotecaDados dados = (BibliotecaDados) leitor.readObject();
            leitor.close();
            arquivo.close();

            biblioteca.carregarDados(dados);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
