package map.pesquisa;

import java.util.HashMap;
import java.util.Map;

public class ContagemPalavras {
    private Map<String, Integer> contagemPalavrasMap;

    public ContagemPalavras() {
        this.contagemPalavrasMap = new HashMap<>();
    }

    public void adicionarPalavra(String palavra, Integer contagem) {
        contagemPalavrasMap.put(palavra, contagem);
    }

    public void removerPalavra(String palavra) {
        if (!contagemPalavrasMap.isEmpty()) {
            contagemPalavrasMap.remove(palavra);
        } else {
            System.out.println("O Map está vazio!");
        }
    }

    public int exibirContagemPalavras() {
        int contagemTotal = 0;
        for (int contagem : contagemPalavrasMap.values()) {
            contagemTotal += contagem;
        }
        return contagemTotal;
    }

    public String encontrarPalavrasMaisFrequente() {
        String linguagemMaisFrequente = null;
        int maiorContagem = 0;
        for (Map.Entry<String, Integer> entry : contagemPalavrasMap.entrySet()) {
            if (entry.getValue() > maiorContagem) {
                maiorContagem = entry.getValue();
                linguagemMaisFrequente = entry.getKey();
            }
        }
        return linguagemMaisFrequente;
    }

    public static void main(String[] args) {
        ContagemPalavras contagemPalavras = new ContagemPalavras();

        contagemPalavras.adicionarPalavra("cachorro", 10);
        contagemPalavras.adicionarPalavra("Gato", 3);
        contagemPalavras.adicionarPalavra("Peixe", 4);

        System.out.println(contagemPalavras.exibirContagemPalavras());
        contagemPalavras.removerPalavra("Gato");
        System.out.println(contagemPalavras.exibirContagemPalavras());
        System.out.println(contagemPalavras.encontrarPalavrasMaisFrequente());

    }
}
