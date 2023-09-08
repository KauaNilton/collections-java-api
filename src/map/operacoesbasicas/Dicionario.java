package map.operacoesbasicas;

import java.util.HashMap;
import java.util.Map;

public class Dicionario {
    private Map<String, String> dicionarioMap;

    public Dicionario() {
        this.dicionarioMap = new HashMap<>();
    }

    public void adicionarPalavra(String palavra, String definicao) {
        dicionarioMap.put(palavra, definicao);
    }

    public void removerPalavra(String palavra) {
        if (!dicionarioMap.isEmpty()) {
            if (dicionarioMap.containsKey(palavra)) {
                dicionarioMap.remove(palavra);
                System.out.println("A palavra '" + palavra + "' junto com a sua definção foram removidos do dicionário!");
            } else {
                System.out.println("A palavra '" + palavra + "' não foi encontrada para ser removida!");
            }
        } else {
            System.out.println("O dicionário está vazio!");
        }
    }

    public void exibirPalavras() {
        System.out.println(dicionarioMap);
    }

    public String pesquisarPorPalavra(String palavra) {
        String definicao;
            if (dicionarioMap.containsKey(palavra)) {
                definicao = dicionarioMap.get(palavra);
                return palavra +" = " + definicao;
            } else {
               return "A palavra '" + palavra + "' não foi encontrada!";
            }
        }

    public static void main(String[] args) {
        Dicionario dicionario = new Dicionario();

        dicionario.adicionarPalavra("Vey", "Pessoa");
        dicionario.adicionarPalavra("Cavalo", "Animal");
        dicionario.adicionarPalavra("Chave", "Objeto");

        dicionario.exibirPalavras();

        System.out.println(dicionario.pesquisarPorPalavra("Vey"));

        dicionario.removerPalavra("Cavalo");
        dicionario.exibirPalavras();
    }
}
