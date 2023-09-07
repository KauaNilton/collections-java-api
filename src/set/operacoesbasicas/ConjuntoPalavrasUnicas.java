package set.operacoesbasicas;

import java.util.HashSet;
import java.util.Set;

public class ConjuntoPalavrasUnicas {
    private Set<String> palavrasUnicasSet;

    public ConjuntoPalavrasUnicas() {
        this.palavrasUnicasSet = new HashSet<>();
    }

    public void adicionarPalavra(String palavra) {
        palavrasUnicasSet.add(palavra);
    }

    public void removerPalavra(String palavra) {
        if (!palavrasUnicasSet.isEmpty()) {
            if (palavrasUnicasSet.contains(palavra)) {
                palavrasUnicasSet.remove(palavra);
            } else {
                System.out.println("Palavra não encotrada!");
            }
        } else {
            System.out.println("O conjunto está vazio!");
        }
    }

    public void verificarPalavra(String palavra) {
        if (!palavrasUnicasSet.isEmpty()) {
            if (palavrasUnicasSet.contains(palavra)) {
                System.out.println("'" + palavra + "'" + " É uma Palavra presente no conjunto!");
            } else {
                System.out.println("'" + palavra + "'" + " Não é uma palavra existente no conjunto!");
            }
        } else {
            System.out.println("O conjunto está vazio!");
        }
    }

    public void exibirPalavras() {
        System.out.println(palavrasUnicasSet);
    }

    public static void main(String[] args) {
        ConjuntoPalavrasUnicas conjuntoPalavrasUnicas = new ConjuntoPalavrasUnicas();

        conjuntoPalavrasUnicas.adicionarPalavra("kauã");
        conjuntoPalavrasUnicas.adicionarPalavra("pedro");
        conjuntoPalavrasUnicas.adicionarPalavra("joão");
        conjuntoPalavrasUnicas.adicionarPalavra("kauã");
        conjuntoPalavrasUnicas.exibirPalavras();

        conjuntoPalavrasUnicas.removerPalavra("maria");
        conjuntoPalavrasUnicas.exibirPalavras();

        conjuntoPalavrasUnicas.verificarPalavra("teste");
    }
}
