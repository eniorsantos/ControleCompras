package br.alura.modelo;

public class Compra implements Comparable<Compra> {
    protected String produto;
    protected double preco;

    public Compra(String produto, double preco) {
        this.produto = produto;
        this.preco = preco;
    }

    public String getProduto() {
        return produto;
    }

    public double getPreco() {
        return preco;
    }

    @Override
    public String toString() {
        return "\tItem " + this.getProduto() + ", \tPreço R$" + this.getPreco();
                }


    @Override
    public int compareTo(Compra o) {
        return Double.compare(this.getPreco(),o.getPreco());

    }


}
