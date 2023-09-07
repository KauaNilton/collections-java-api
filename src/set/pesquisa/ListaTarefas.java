package set.pesquisa;

import java.util.HashSet;
import java.util.Set;

public class ListaTarefas {
    private Set<Tarefa> tarefaSet;

    public ListaTarefas() {
        this.tarefaSet = new HashSet<>();
    }

    public void adicionarTarefa(String descricao) {
        tarefaSet.add(new Tarefa(descricao));
    }

    public void removerTarefa(String descricao) {
        Tarefa tarefaParaRemover = null;
        if (!tarefaSet.isEmpty()) {
            for (Tarefa t : tarefaSet) {
                if (t.getDescricao().equalsIgnoreCase(descricao)) {
                    tarefaParaRemover = t;
                    break;
                }
            }
            tarefaSet.remove(tarefaParaRemover);
        } else {
            System.out.println("O conjunto de tarefa está vazio!");
        }
    }

    public void exibirTarefas() {
        System.out.println(tarefaSet);
    }

    public void contarTarefas() {
        System.out.println(tarefaSet.size());
    }

    public Set<Tarefa> obterTarefasConcluidas() {
        Set<Tarefa> tarefasConcluidas = new HashSet<>();
        for (Tarefa t : tarefaSet) {
            if (t.isCheck()) {
                tarefasConcluidas.add(t);
            }
        }
        return tarefasConcluidas;
    }

    public Set<Tarefa> obterTarefasPendentes() {
        Set<Tarefa> tarefasPendentes = new HashSet<>();
        for (Tarefa t : tarefaSet) {
            if (!t.isCheck()) {
                tarefasPendentes.add(t);
            }
        }
        return tarefasPendentes;
    }

    public void marcarTarefaConcluida(String descricao) {
        for (Tarefa t : tarefaSet) {
            if (t.getDescricao().equalsIgnoreCase(descricao)) {
                t.setCheck(true);
            }
        }
    }

    public void marcarTarefaPendentes(String descricao) {
        for (Tarefa t : tarefaSet) {
            if (t.getDescricao().equalsIgnoreCase(descricao)) {
                t.setCheck(false);
            }
        }
    }

    public void limparListaTarefas() {
        if (tarefaSet.isEmpty()) {
            System.out.println("O conjunto de tarefa está vazio!");
        } else {
            tarefaSet.clear();
        }
    }


    public static void main(String[] args) {
        ListaTarefas listaTarefas = new ListaTarefas();

        listaTarefas.adicionarTarefa("Teste01");
        listaTarefas.adicionarTarefa("Teste02");
        listaTarefas.adicionarTarefa("Teste03");
        listaTarefas.adicionarTarefa("Teste03");
        listaTarefas.exibirTarefas();
        listaTarefas.contarTarefas();
        listaTarefas.removerTarefa("Teste01");
        listaTarefas.exibirTarefas();

        listaTarefas.marcarTarefaConcluida("Teste02");
        System.out.println(listaTarefas.obterTarefasConcluidas());
        listaTarefas.exibirTarefas();

        System.out.println(listaTarefas.obterTarefasPendentes());
        listaTarefas.marcarTarefaPendentes("Teste02");
        listaTarefas.exibirTarefas();
        listaTarefas.limparListaTarefas();

        listaTarefas.exibirTarefas();

    }
}
