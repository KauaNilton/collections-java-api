package list.operacoesbasicas;

import java.util.ArrayList;
import java.util.List;

public class CarrinhoDeCompras {
    private List<Item> itemList;

    public CarrinhoDeCompras() {
        this.itemList = new ArrayList<>();
    }

    public void adicionaritem(String nome, double preco, int quantidade) {
        Item item = new Item(nome, quantidade, preco);
        this.itemList.add(item);
    }

    public void removerItem(String nome) {
        List<Item> itemParaRemover = new ArrayList<>();
        if (!itemList.isEmpty()) {
            for (Item i : itemList) {
                if (i.getNome().equalsIgnoreCase(nome)) {
                    itemParaRemover.add(i);
                }
            }
            itemList.removeAll(itemParaRemover);
        } else {
            System.out.println("A lista está vazia!");
        }
    }

    public double calcularValorTotal() {
        double valorTotal = 0d;
        if (!itemList.isEmpty()) {
            for (Item item : itemList) {
                double valorItem = item.getPreco() * item.getQuantidade();
                valorTotal += valorItem;
            }
            return valorTotal;
        } else {
            throw new RuntimeException("A lista está vazia!");
        }
    }

    public void exibirItens() {
        if (!itemList.isEmpty()) {
            System.out.println(this.itemList);
        } else {
            System.out.println("A lista está vazia!");
        }
    }

    @Override
    public String toString() {
        return "CarrinhoDeCompras{" +
                "itemList = " + itemList +
                '}';
    }
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
