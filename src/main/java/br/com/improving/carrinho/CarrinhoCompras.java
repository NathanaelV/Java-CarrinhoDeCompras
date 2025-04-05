package br.com.improving.carrinho;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Classe que representa o carrinho de compras de um cliente.
 */
public class CarrinhoCompras {

    private ArrayList<Item> itens;
    private String cliente;

    CarrinhoCompras() {
        this.itens = new ArrayList<>();
    }

    /**
     * Permite a adição de um novo item no carrinho de compras.
     *
     * Caso o item já exista no carrinho para este mesmo produto, as seguintes regras deverão ser seguidas:
     * - A quantidade do item deverá ser a soma da quantidade atual com a quantidade passada como parâmetro.
     * - Se o valor unitário informado for diferente do valor unitário atual do item, o novo valor unitário do item deverá ser
     * o passado como parâmetro.
     *
     * Devem ser lançadas subclasses de RuntimeException caso não seja possível adicionar o item ao carrinho de compras.
     *
     * @param produto
     * @param valorUnitario
     * @param quantidade
     */
    public void adicionarItem(Produto produto, BigDecimal valorUnitario, int quantidade) {
        if (produto == null || valorUnitario == null || quantidade < 0) {
            throw new IllegalArgumentException("Parâmetros inválidos para adicionar item.");
        }

        for (int i = 0; i < itens.size(); i++) {
            Item item = itens.get(i);

            if (item.getProduto().equals(produto)) {
                // Se já existe o item, atualiza quantidade e valorUnitario se for diferente
                int novaQuantidade = item.getQuantidade() + quantidade;
                BigDecimal novoValor = valorUnitario;

                // Atualiza o item na lista
                itens.set(i, new Item(produto, novoValor, novaQuantidade));
                return;
            }
        }

        // Se não encontrou, adiciona novo item
        itens.add(new Item(produto, valorUnitario, quantidade));
    }

    /**
     * Permite a remoção do item que representa este produto do carrinho de compras.
     *
     * @param produto
     * @return Retorna um boolean, tendo o valor true caso o produto exista no carrinho de compras e false
     * caso o produto não exista no carrinho.
     */
    public boolean removerItem(Produto produto) {
        return itens.removeIf(item -> item.getProduto().equals(produto));
    }

    /**
     * Permite a remoção do item de acordo com a posição.
     * Essa posição deve ser determinada pela ordem de inclusão do produto na
     * coleção, em que zero representa o primeiro item.
     *
     * @param posicaoItem
     * @return Retorna um boolean, tendo o valor true caso o produto exista no carrinho de compras e false
     * caso o produto não exista no carrinho.
     */
    public boolean removerItem(int posicaoItem) {
        if (posicaoItem < 0 || posicaoItem >= itens.size()) {
            return false;
        }

        itens.remove(posicaoItem);
        return true;
    }

    /**
     * Retorna o valor total do carrinho de compras, que deve ser a soma dos valores totais
     * de todos os itens que compõem o carrinho.
     *
     * @return BigDecimal
     */
    public BigDecimal getValorTotal() {
        BigDecimal total = BigDecimal.ZERO;

        for (Item item : itens) {
            total = total.add(item.getValorTotal());
        }

        return total;
    }

    /**
     * Retorna a lista de itens do carrinho de compras.
     *
     * @return itens
     */
    public Collection<Item> getItens() {
        return itens;
    }
}
