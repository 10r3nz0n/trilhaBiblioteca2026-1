package com.lorenzon.biblioteca;

import com.lorenzon.biblioteca.menus.MenuPrincipal;
import com.lorenzon.biblioteca.utilitarios.*;

public class App {

    static BibliotecaSingleton nossaBiblioteca;

    private static void carregarBibliotecaPadrao() {

        Livro livro1, livro2, livro3;

        livro1 = new Livro("111111", "Apostila OO", "Valdemar Lorenzon Junior");
        livro2 = new Livro("112112", "Apostila de Exercícios OO", "José Carlos Toniazzo");

        livro3 = livro1.clonarLivro();

        BibliotecaSingleton.inserirNovoLivro(livro1);
        BibliotecaSingleton.inserirNovoLivro(livro2);
        BibliotecaSingleton.inserirNovoLivro(livro3);

        Pessoa teste = new Pessoa("Teste", "0");

        BibliotecaSingleton.cadastrarPessoa(teste);
    }

    private static void inicializarSistema() {

        nossaBiblioteca = BibliotecaSingleton.getInstanciaSingleton();

        boolean carregou = BibliotecaPersistencia.carregar(nossaBiblioteca);

        if (!carregou) {
            carregarBibliotecaPadrao();
        }
    }

    public static void limparTela() {
        Video.limparTela();
    }

    public static void main(String[] args) throws Exception {

        int opcaoMenu;

        limparTela();
        inicializarSistema();

        do {

            opcaoMenu = MenuPrincipal.exibir();

            switch (opcaoMenu) {

                case 1:
                    BibliotecaSingleton.listarAcervo();
                    break;

                case 2:
                    String matricula = Teclado.string("Informe a matrícula do aluno:");
                    Pessoa aluno = BibliotecaSingleton.localizarAluno(matricula);
                    if (aluno == null) {
                        Video.exibirMensagemErro("Aluno nao encontrado!");
                        break;
                    }
                    String isbn = Teclado.string("Informe o ISBN do livro:");
                    Livro livro = nossaBiblioteca.localizarLivro(isbn);
                    if (livro == null) {
                        Video.exibirMensagemErro("Livro nao encontrado!");
                        break;
                    }
                    nossaBiblioteca.realizarEmprestimo(aluno, livro);
                    break;

                case 3:
                    String isbnDev = Teclado.string("Informe o ISBN do livro a devolver:");
                    Livro livroDev = nossaBiblioteca.localizarLivro(isbnDev);
                    if (livroDev != null) {
                        nossaBiblioteca.realizarDevolucao(livroDev);
                    } else {
                        Video.exibirMensagemErro("Livro nao localizado!");
                    }
                    break;

                case 4:
                    Livro livroLocalizado;
                    livroLocalizado = nossaBiblioteca.localizarLivro(Teclado.string("Informe o isbn:"));
                    if (livroLocalizado == null) {
                        Video.exibirMensagemErro("Livro nao localizado no acervo!");
                    } else {
                        if (livroLocalizado.isDisponivel()) {
                            Video.println("Localizado: " + livroLocalizado);
                        }
                    }
                    break;

                case 5:
                    Video.println("Opcao em desenvolvimento!");
                    break;

                case 6:
                    String novoIsbn = Teclado.string("Informe ISBN:");
                    String titulo = Teclado.string("Informe Titulo:");
                    String autor = Teclado.string("Informe Autor:");
                    BibliotecaSingleton.inserirNovoLivro(novoIsbn, titulo, autor);
                    break;

                case 7:
                    String nome = Teclado.string("Informe Nome:");
                    String novaMatricula = Teclado.string("Informe Matricula:");
                    BibliotecaSingleton.cadastrarPessoa(new Pessoa(nome, novaMatricula));
                    break;

                case 8:
                    BibliotecaSingleton.listarEmprestimos();
                    break;

                case 9:
                    BibliotecaSingleton.listarAlunos();
                    break;

                case 10:
                    BibliotecaPersistencia.salvar(nossaBiblioteca);
                    Video.println("Fim de execucao!");
                    break;

                default:
                    break;
            }

            if (opcaoMenu != 10) {
                Video.pausarEnterContinuar();
            }

        } while (opcaoMenu != 10);

    }
}
