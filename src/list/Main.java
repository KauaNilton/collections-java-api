package list;

import list.operacoesbasicas.exercicio02.CarrinhoDeCompras;

import java.sql.SQLOutput;

public class Main {
    public static void main(String[] args) {
        CarrinhoDeCompras pd = new CarrinhoDeCompras();

        pd.adicionaritem("nescau", 33.9, 2);
        pd.adicionaritem("feijao", 36.7, 4);
        pd.adicionaritem("Caneta", 2.99, 2);
        pd.adicionaritem("caderno", 26.67, 1);
        pd.exibirItens();

        //  pd.removerItem("nescau");
        // pd.exibirItens();
        System.out.printf("Total: %.2f", pd.calcularValorTotal());
    }
}