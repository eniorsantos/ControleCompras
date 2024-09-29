package br.alura.modelo;

public class CartaoCredito {
    public double saldo;

    public CartaoCredito(double saldo) {
        this.saldo = saldo;
    }

    public double getSaldo() {
        return saldo;
    }

    public void  controleCredito(double credito){
        this.saldo -= credito;
    }
}
