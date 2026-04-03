package com.lorenzon.biblioteca;

import java.util.ArrayList;
import com.lorenzon.biblioteca.utilitarios.*; //corrigido

public class BibliotecaSingleton {

    private static BibliotecaSingleton unicaInstancia;
    private static ArrayList<Livro> acervoLivros;
    private static ArrayList<Pessoa> alunos;
    private static ArrayList<Emprestimo> emprestimos;

    // Forçando o construtor privado, para garantir o padrão Singleton e nenhuma
    // nova instância
    private BibliotecaSingleton() {
        acervoLivros = new ArrayList<Livro>();
        alunos = new ArrayList<Pessoa>();
        emprestimos = new ArrayList<Emprestimo>();
    }

    public static BibliotecaSingleton getInstanciaSingleton() {
        if (unicaInstancia == null) {
            unicaInstancia = new BibliotecaSingleton();
        }
        return unicaInstancia;
    }

    public static boolean inserirNovoLivro(String EAN, String titulo, String autor) {

        Livro livro = new Livro(EAN, titulo, autor);
        acervoLivros.add(livro);

        return true; // deu tupo certo

    }

    public static boolean inserirNovoLivro(Livro livro) {

        acervoLivros.add(livro);
        return true; // deu tupo certo

    }

    public static void cadastrarPessoa(Pessoa aluno) {
        alunos.add(aluno);
    }

    public static Pessoa localizarAluno(String matricula) {
        for (Pessoa a : alunos) {
            if (a.getMatricula().equals(matricula)) {
                return a;
            }
        }
        return null;
    }

    public static void listarAcervo() {

        if (acervoLivros != null) {
            Video.println("");
            for (Livro livro : acervoLivros) {
                Video.println(livro.toString());
            }
        } else {
            Video.println("Acervo vazio.");
        }
    }

    public static void listarEmprestimos() {

        if (emprestimos != null) {
            Video.println("");
            for (Emprestimo emprestimo : emprestimos) {
                Video.println(emprestimo.toString());
            }
        } else {
            Video.println("Não há empréstimos!");
        }
    }

    public static void listarAlunos() {

        if (alunos != null) {
            Video.println("");
            for (Pessoa aluno : alunos) {
                Video.println(aluno.toString());
            }
        } else {
            Video.println("Não há alunos cadastrados!");
        }
    }

    public Livro localizarLivro(String isbn) {

        Livro achei = null;

        if (acervoLivros == null) {
            return null;
        }

        for (Livro livro : acervoLivros) {
            if (livro.getIsbn().equals(isbn)) {
                achei = livro;
                break;
            }
        }

        if (achei != null) {
            return achei;
        }

        return null;
    }

    public void realizarEmprestimo(Pessoa aluno, Livro livro) {
        if (livro.isDisponivel()) {
            emprestimos.add(new Emprestimo(aluno, livro));
            livro.setDisponivel(false);
            Video.println("Empréstimo realizado com sucesso!");
        } else {
            Video.exibirMensagemErro("Livro indisponível para empréstimo!");
        }
    }

    public void realizarDevolucao(Livro livro) {
        for (Emprestimo e : emprestimos) {
            if (e.getLivro().equals(livro) && e.estaAtivo()) {
                e.devolver();
                livro.setDisponivel(true);
                Video.println("Devolução concluída!");
                return;
            }
        }
        Video.exibirMensagemErro("Nenhum empréstimo ativo encontrado para este livro!");
    }

    public ArrayList<Livro> getAcervoLivros() {
        return acervoLivros;
    }

    public ArrayList<Pessoa> getAlunos() {
        return alunos;
    }

    public ArrayList<Emprestimo> getEmprestimos() {
        return emprestimos;
    }

    public void carregarDados(BibliotecaDados dados) {
        acervoLivros = dados.getAcervoLivros();
        alunos = dados.getAlunos();
        emprestimos = dados.getEmprestimos();

        if (acervoLivros == null) {
            acervoLivros = new ArrayList<Livro>();
        }
        if (alunos == null) {
            alunos = new ArrayList<Pessoa>();
        }
        if (emprestimos == null) {
            emprestimos = new ArrayList<Emprestimo>();
        }
    }
}
