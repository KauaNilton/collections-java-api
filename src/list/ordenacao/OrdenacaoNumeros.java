package list.ordenacao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OrdenacaoNumeros {
    private List<Integer> numeroList;

    public OrdenacaoNumeros() {
        this.numeroList = new ArrayList<>();
    }

    public void adicionarNumero(int numero) {
       this.numeroList.add(numero);
    }

    public List<Integer> ordenarAscendente() {
        List<Integer> numerosAscendentes = new ArrayList<>(this.numeroList);
        if(!numeroList.isEmpty()) {
            Collections.sort(numerosAscendentes);
            return numerosAscendentes;
        } else {
            throw new RuntimeException("A lista es´ta vazia!");
        }
    }

    public List<Integer> ordenarDescendente() {
        List<Integer> numerosAscendentes = new ArrayList<>(numeroList);
        if(!numeroList.isEmpty()) {
            numerosAscendentes.sort(Collections.reverseOrder());
            return numerosAscendentes;
        } else {
            throw new RuntimeException("A lista está vazia!");
        }
    }
    public void exibirList() {
        if(!numeroList.isEmpty()) {
            System.out.println(this.numeroList);
        } else {
            System.out.println("A lista está vazia!");
        }
    }

    public static void main(String[] args) {
        OrdenacaoNumeros ordenacaoNumeros = new OrdenacaoNumeros();

        ordenacaoNumeros.adicionarNumero(1);
        ordenacaoNumeros.adicionarNumero(2);
        ordenacaoNumeros.adicionarNumero(0);
        ordenacaoNumeros.adicionarNumero(10);
        ordenacaoNumeros.adicionarNumero(17);
        ordenacaoNumeros.adicionarNumero(11);

        ordenacaoNumeros.exibirList();
        System.out.println(ordenacaoNumeros.ordenarAscendente());
        System.out.println(ordenacaoNumeros.ordenarDescendente());
    }
}

