import java.io.Serializable;
import java.util.Date;

public class Emprestimo implements Serializable {
    private static final long serialVersionUID = 1L;
    private Pessoa aluno;
    private Livro livro;
    private Date dataEmprestimo;
    private Date dataDevolucao;

    public Emprestimo(Pessoa aluno, Livro livro) {
        this.aluno = aluno;
        this.livro = livro;
        this.dataEmprestimo = new Date(); // hoje
    }

    public void devolver() {
        this.dataDevolucao = new Date();
    }

    public boolean estaAtivo() {
        return dataDevolucao == null;
    }

    public Pessoa getAluno() { 
        return aluno; 
    }
    
    public Livro getLivro() { 
        return livro; 
    }

    @Override
    public String toString() {
        return "Emprestimo: " + livro.getTitulo() + " para " + aluno.getNome() +
               " em " + dataEmprestimo + 
               (dataDevolucao == null ? " (EM ABERTO)" : " - Devolvido em " + dataDevolucao);
    }
}


