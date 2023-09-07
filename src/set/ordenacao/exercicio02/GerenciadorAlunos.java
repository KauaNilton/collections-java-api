package set.ordenacao.exercicio02;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class GerenciadorAlunos {
    private Set<Aluno> alunoSet;

    public GerenciadorAlunos() {
        this.alunoSet = new HashSet<>();
    }

    public void adicionarAluno(String nome, Long matricula, double media) {
        alunoSet.add(new Aluno(nome, matricula, media));
    }

    public void removerAluno(long matricula) {
        Aluno alunoParaRemover = null;
        if (!alunoSet.isEmpty()) {
            for (Aluno a : alunoSet) {
                if (a.getMatricula() == matricula) {
                    alunoParaRemover = a;
                    break;
                }
            }
            alunoSet.remove(alunoParaRemover);
        } else {
            System.out.println("A conjunto de alunos está vazio!");
        }
        if (alunoParaRemover == null) {
            System.out.println("A matricula do aluno não foi encontrada!");
        }
    }

    public void exibirAlunosPorNome() {
        if (!alunoSet.isEmpty()) {
            Set<Aluno> alunosPorNome = new TreeSet<>(alunoSet);
            System.out.println(alunosPorNome);
        } else {
            System.out.println("A conjunto de alunos está vazio!");
        }
    }

    public void exibirAlunosPorNota() {
        Set<Aluno> alunosPorNota = new TreeSet<>(new ComparatorPorNota());
        if (!alunoSet.isEmpty()) {
            alunosPorNota.addAll(alunoSet);
            System.out.println(alunosPorNota);
        } else {
            System.out.println("O conjunto está vazio!");
        }
    }

    public static void main(String[] args) {
        GerenciadorAlunos gerenciadorAlunos = new GerenciadorAlunos();
        gerenciadorAlunos.adicionarAluno("Kauã", 1234678l, 9.5);
        gerenciadorAlunos.adicionarAluno("João", 12346l, 7.5);
        gerenciadorAlunos.adicionarAluno("Pedro", 123456l, 7.6);
        gerenciadorAlunos.adicionarAluno("Ana", 12345656l, 7.8);
        gerenciadorAlunos.exibirAlunosPorNome();
         gerenciadorAlunos.removerAluno(1234516l);
        gerenciadorAlunos.exibirAlunosPorNome();
        gerenciadorAlunos.exibirAlunosPorNota();
    }
}
