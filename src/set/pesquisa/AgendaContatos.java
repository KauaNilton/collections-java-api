package set.pesquisa;

import java.util.HashSet;
import java.util.Set;

public class AgendaContatos {
    private Set<Contato> contatoSet;

    public AgendaContatos() {
        this.contatoSet = new HashSet<>();
    }

    public void adicionarContato(String nome, int numero) {
        contatoSet.add(new Contato(nome, numero));
    }

    public void exibirContatos() {
        System.out.println(contatoSet);
    }

    public Set<Contato> pesquisarPorNome(String nome) {
        Set<Contato> contatosPorNome = new HashSet<>();
        for (Contato c : contatoSet) {
            if (c.getNome().startsWith(nome)) {
                contatosPorNome.add(c);
            }
        }
        return contatosPorNome;
    }

    public Contato atualizarNumeroContato(String nome, int novoNumero) {
        Contato contatoAtualizado = null;
        for (Contato c : contatoSet) {
            if (c.getNome().equalsIgnoreCase(nome)) {
                c.setNumero(novoNumero);
                contatoAtualizado = c;
                break;
            }
        }
        return contatoAtualizado;
    }

    public static void main(String[] args) {
        AgendaContatos agendaContatos = new AgendaContatos();

        agendaContatos.adicionarContato("Kauã", 719123456);
        agendaContatos.adicionarContato("Kauã", 235565432);
        agendaContatos.adicionarContato("Kauã Nilton", 7191234);
        agendaContatos.adicionarContato("Kauã Barbosa", 71234);
        agendaContatos.adicionarContato("Kauã G", 71234);
        agendaContatos.adicionarContato("Pedro", 719123457);
        agendaContatos.adicionarContato("maria", 719123458);
        agendaContatos.exibirContatos();

        System.out.println(agendaContatos.pesquisarPorNome("Kauã"));
        System.out.println(agendaContatos.atualizarNumeroContato("Kauã", 927022006));
        agendaContatos.exibirContatos();
    }
}
