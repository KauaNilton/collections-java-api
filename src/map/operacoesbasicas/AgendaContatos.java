package map.operacoesbasicas;

import java.util.HashMap;
import java.util.Map;

public class AgendaContatos {
    private Map<String, Integer> agendaContatoMap;

    public AgendaContatos() {
        agendaContatoMap = new HashMap<>();
    }
    public void adicionarContato(String nome, Integer telefone) {
        agendaContatoMap.put(nome, telefone);
    }
    public void removerContato(String nome) {
        if(!agendaContatoMap.isEmpty()) {
            agendaContatoMap.remove(nome);
        }
    }

    public void exibirContatos() {
        System.out.println(agendaContatoMap);
    }

    public Integer pesquisarPorNome(String nome) {
        Integer numeroPorNome = null;
        if(!agendaContatoMap.isEmpty()) {
            numeroPorNome = agendaContatoMap.get(nome);

        }
        return numeroPorNome;
    }

    public static void main(String[] args) {
        AgendaContatos agendaContatos = new AgendaContatos();

        agendaContatos.adicionarContato("Kauã", 123456);
        agendaContatos.adicionarContato("Pedro", 1234567);
        agendaContatos.adicionarContato("Pedro", 12345678);
        agendaContatos.adicionarContato("Gustavo", 12345678);

        agendaContatos.exibirContatos();
        System.out.println("O número é: " + agendaContatos.pesquisarPorNome("Kauã"));
        agendaContatos.removerContato("Gustavo");
        agendaContatos.exibirContatos();
    }
}
