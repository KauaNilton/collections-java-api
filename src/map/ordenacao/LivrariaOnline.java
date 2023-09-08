package map.ordenacao;

import java.util.*;

public class LivrariaOnline {
    private Map<String, Livro> livrosMap;

    public LivrariaOnline() {
        this.livrosMap = new HashMap<>();
    }

    public void adicionarLivro(String link, String titulo, String autor, double preco) {
        livrosMap.put(link, new Livro(titulo, autor, preco));
    }

    public void removerLivro(String titulo) {
        List<String> chaveRemover = new ArrayList<>();
        for (Map.Entry<String, Livro> entry : livrosMap.entrySet()) {
            if (entry.getValue().getTitulo().equalsIgnoreCase(titulo)) {
                chaveRemover.add(entry.getKey());
            }
        }
        for (String chave : chaveRemover) {
            livrosMap.remove(chave);
        }
    }

    public Map<String, Livro> exibirLivrosOrdenadosPorPreco() {
        return new TreeMap<>(livrosMap);
    }

    public Map<String, Livro> pesquisarLivrosPorAutor(String autor) {
        Map<String, Livro> livrosPorAutor = new LinkedHashMap<>();
        for (Map.Entry<String, Livro> entry : livrosMap.entrySet()) {
            Livro livro = entry.getValue();
            if (livro.getAutor().equals(autor)) {
                livrosPorAutor.put(entry.getKey(), livro);
            }
        }
        return livrosPorAutor;
    }

    public List<Livro> obterLivroMaisCaro() {
        List<Livro> livrosMaisCaros = new ArrayList<>();
        double precoMaisAlto = Double.MIN_VALUE;
        if (!livrosMap.isEmpty()) {
            for (Livro livro : livrosMap.values()) {
                if (livro.getPreco() > precoMaisAlto) {
                    precoMaisAlto = livro.getPreco();
                }
            }
        } else {
            throw new NoSuchElementException("A livraria está vazia!");
        }
        for(Map.Entry<String, Livro> entry: livrosMap.entrySet()) {
            if(entry.getValue().getPreco() == precoMaisAlto) {
                Livro livroComPrecoMaisAlto = livrosMap.get(entry.getKey());
                livrosMaisCaros.add(livroComPrecoMaisAlto);
            }
        }
        return livrosMaisCaros;
    }
    public List<Livro> obterLivroMaisBarato() {
        List<Livro> livrosMaisBaratos = new ArrayList<>();
        double precoMaisBaixo = Double.MAX_VALUE;

        if (!livrosMap.isEmpty()) {
            for (Livro livro : livrosMap.values()) {
                if (livro.getPreco() < precoMaisBaixo) {
                    precoMaisBaixo = livro.getPreco();
                }
            }
        } else {
            throw new NoSuchElementException("A livraria está vazia!");
        }

        for(Map.Entry<String, Livro> entry: livrosMap.entrySet()) {
            if(entry.getValue().getPreco() == precoMaisBaixo) {
                Livro livroComPrecoMaisBaixo = livrosMap.get(entry.getKey());
                livrosMaisBaratos.add(livroComPrecoMaisBaixo);
            }
        }
        return livrosMaisBaratos;
    }
    public static void main(String[] args) {
        LivrariaOnline livrariaOnline = new LivrariaOnline();
        livrariaOnline.adicionarLivro("https://a.co/d/cr23Jyn", "Código limpo: Habilidades práticas do Agile Software", "Robert C. Martin", 75.90d);
        livrariaOnline.adicionarLivro("https://a.co/d/8dWhLtq","O codificador limpo: Um código de conduta para programadores profissionais", "Bob Martin", 73.63);
        livrariaOnline.adicionarLivro("https://a.co/d/dLMTMGj","O homem mais rico da Babilônia", "George S Clason", 26.49d);
        livrariaOnline.adicionarLivro("https://a.co/d/3CVeLnj","Arquitetura limpa: O guia do artesão para estrutura e design de software ", "Robert C. Martin", 67.29d);

        System.out.println(livrariaOnline.exibirLivrosOrdenadosPorPreco());

        System.out.println(livrariaOnline.pesquisarLivrosPorAutor("Robert C. Martin"));

        System.out.println("Livro mais caro: " + livrariaOnline.obterLivroMaisCaro());

        System.out.println("Livro mais barato: " + livrariaOnline.obterLivroMaisBarato());

        livrariaOnline.removerLivro("O homem mais rico da Babilônia");
        System.out.println(livrariaOnline.livrosMap);
    }
    }
