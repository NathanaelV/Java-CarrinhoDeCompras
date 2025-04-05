package br.com.improving.carrinho;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        // Criar os produtos
        Produto firstProduct = new Produto(1001L, "Pasta de dente");
        Produto secondProduct = new Produto(2002L, "Creme   dental");
        Produto thirdProduct = new Produto(3003L, "Batatas fritas");
        Produto fourthProduct = new Produto(4004L, "Coca-cola Zero");
        Produto fifthProduct = new Produto(5005L, "Fora da lista");


        // Criar o carrinho de compras:
        CarrinhoCompras carrinho = new CarrinhoCompras();


        // Adicionar itens na lista:
        BigDecimal firstPrice = new BigDecimal("12.54");
        carrinho.adicionarItem(firstProduct, firstPrice, 5);

        BigDecimal secondPrice = new BigDecimal("10.50");
        carrinho.adicionarItem(secondProduct, secondPrice, 5);

        BigDecimal thirdPrice = new BigDecimal("59.99");
        carrinho.adicionarItem(thirdProduct, thirdPrice, 5);

        BigDecimal fourthPrice = new BigDecimal("12.54");
        carrinho.adicionarItem(fourthProduct, fourthPrice, 5);

        System.out.println("\nMostrar a lista:");
        for (Item item : carrinho.getItens()) {
            System.out.println(item);
        }

        // Adicionar item e alterar o valor unitário
        BigDecimal newSecondPrice = new BigDecimal("15.00");
        carrinho.adicionarItem(secondProduct, newSecondPrice, 3);

        System.out.println("\nAdicionar item e alterar o valor unitário do Segundo Produto:");
        for (Item item : carrinho.getItens()) {
            System.out.println(item);
        }

        // Remover item da lista:
        carrinho.removerItem(2);

        System.out.println("\nRemove o Item na posição 2:");
        for (Item item : carrinho.getItens()) {
            System.out.println(item);
        }

        carrinho.removerItem(secondProduct);
        System.out.println("\nRemove o produto Creme Dental:");
        for (Item item : carrinho.getItens()) {
            System.out.println(item);
        }

        // Remove item que não existe:
        System.out.println("\nTenta remove produtos que não estão na lista:");
        System.out.println(carrinho.removerItem(7));
        System.out.println(carrinho.removerItem(fifthProduct));


        // Valor total da compra:
        System.out.println("\nValor total da compra:");
        System.out.println("R$ " + carrinho.getValorTotal());
    }
}
